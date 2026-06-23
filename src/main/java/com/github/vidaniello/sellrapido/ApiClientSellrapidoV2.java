package com.github.vidaniello.sellrapido;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;

import com.google.gson.reflect.TypeToken;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class ApiClientSellrapidoV2 {
	
	public static final String baseUrlV2 = "https://app.sellrapido.com/sr_company_ws/api/v2/";
	public static final String authAuthorizeUrl = "auth/authorize";
	public static final String authTokenUrl = "auth/token";
	public static final String authRefreshUrl = "auth/refresh";
	
	public static final String orderUrl = "order";
	public static final String orderUpdateFinal = "/status";
	
	public static final MediaType applicationJson = MediaType.get("application/json");
	
	private OkHttpClient client;
	
	private String username;
	private String password;
	
	private TokenObject accessTokenObj;
	private TokenObject refreshTokenObj;
	
	public ApiClientSellrapidoV2(String username, String password) throws SellrapidoException, IOException {
		this.username = username;
		this.password = password;
		authorize();
	}

	public String getAccessToken() {
		return accessTokenObj != null ? accessTokenObj.getToken() : null;
	}

	public String getRefreshToken() {
		return refreshTokenObj != null ? refreshTokenObj.getToken() : null;
	}

	public synchronized OkHttpClient getClient() {
		if(client==null)
			client = new OkHttpClient();
		return client;
	}
	
	public synchronized void setClient(OkHttpClient client) {
		this.client = client;
	}
	
	private AuthResponse authorize() throws SellrapidoException, IOException {
		AuthorizeRequest reqObj = new AuthorizeRequest(username, password);
		AuthResponse response = executePost(authAuthorizeUrl, reqObj, AuthResponse.class, null);
		if(response != null) {
			if(response.getAccess_token() != null)
				this.accessTokenObj = response.getAccess_token();
			if(response.getRefresh_token() != null)
				this.refreshTokenObj = response.getRefresh_token();
		}
		return response;
	}
	
	private AuthResponse renewToken() throws SellrapidoException, IOException {
		RefreshTokenRequest reqObj = new RefreshTokenRequest(getRefreshToken());
		AuthResponse response = executePost(authTokenUrl, reqObj, AuthResponse.class, null);
		if(response != null && response.getAccess_token() != null) {
			this.accessTokenObj = response.getAccess_token();
		}
		return response;
	}
	
	private AuthResponse refreshToken() throws SellrapidoException, IOException {
		RefreshTokenRequest reqObj = new RefreshTokenRequest(getRefreshToken());
		AuthResponse response = executePost(authRefreshUrl, reqObj, AuthResponse.class, null);
		if(response != null) {
			if(response.getAccess_token() != null)
				this.accessTokenObj = response.getAccess_token();
			if(response.getRefresh_token() != null)
				this.refreshTokenObj = response.getRefresh_token();
		}
		return response;
	}
	
	private String getValidAccessToken() throws SellrapidoException, IOException {
		if (isExpired(accessTokenObj)) {
			// Access token scaduto, prova a rinnovare con il refresh token
			if (isExpiringSoon(refreshTokenObj)) {
				// Refresh token in scadenza o scaduto, ruota o riparti da authorize
				try {
					refreshToken();
				} catch (SellrapidoException e) {
					// Se il refresh fallisce (es. token scaduto), riparti da authorize
					authorize();
				}
			} else {
				try {
					renewToken();
				} catch (SellrapidoException e) {
					// Se il renew fallisce, prova a fare authorize
					authorize();
				}
			}
		} else if (isExpiringSoon(refreshTokenObj)) {
			// Access token valido, ma refresh token in scadenza, ruotalo
			try {
				refreshToken();
			} catch (SellrapidoException e) {
				// ignore, verrà gestito al prossimo rinnovo
			}
		}
		return getAccessToken();
	}
	
	private boolean isExpired(TokenObject token) {
		if (token == null || token.getExpires_at() == null) return true;
		try {
			Instant expiry = Instant.parse(token.getExpires_at());
			return expiry.isBefore(Instant.now());
		} catch (Exception e1) {
			try {
				long epoch = Long.parseLong(token.getExpires_at());
				if (epoch < 10000000000L) epoch *= 1000;
				return Instant.ofEpochMilli(epoch).isBefore(Instant.now());
			} catch (Exception e2) {
				return false;
			}
		}
	}
	
	private boolean isExpiringSoon(TokenObject token) {
		if (token == null || token.getExpires_at() == null) return true;
		try {
			Instant expiry = Instant.parse(token.getExpires_at());
			return expiry.isBefore(Instant.now().plus(1, ChronoUnit.DAYS));
		} catch (Exception e1) {
			try {
				long epoch = Long.parseLong(token.getExpires_at());
				if (epoch < 10000000000L) epoch *= 1000;
				return Instant.ofEpochMilli(epoch).isBefore(Instant.now().plus(1, ChronoUnit.DAYS));
			} catch (Exception e2) {
				return false;
			}
		}
	}
	
	public OrderResponse getOrders(OrderRequest orderRequest) throws SellrapidoException, IOException, ParseException {
		return executeGet(orderUrl, orderRequest, OrderResponse.class, getValidAccessToken());
	}

	public OrderResponse getOrders(String orderRequestJson) throws SellrapidoException, IOException, ParseException {
		// For backward compatibility, treat JSON as OrderRequest object
		OrderRequest req = GsonUtility.getDefault().fromJson(orderRequestJson, OrderRequest.class);
		return executeGet(orderUrl, req, OrderResponse.class, getValidAccessToken());
	}
	
	public Collection<OrderUpdateResponse> updateOrders(Collection<OrderUpdateRequest> ordersUpdateRequest) throws SellrapidoException, IOException {
		return updateOrders(GsonUtility.getDefault().toJson(ordersUpdateRequest));
	}
	
	public Collection<OrderUpdateResponse> updateOrders(String ordersUpdateJson) throws SellrapidoException, IOException {
		Request req = new Request.Builder()
				.url(baseUrlV2 + orderUrl + orderUpdateFinal)
				.post(RequestBody.create(ordersUpdateJson, applicationJson))
				.addHeader("Authorization", "Bearer " + getValidAccessToken())
				.build();
		
		Call call = getClient().newCall(req);
		
		try(Response resp = call.execute();
				ResponseBody rb = resp.body();){
			
				Type listType = new TypeToken<Collection<OrderUpdateResponse>>(){}.getType();	
			
				return GsonUtility.getDefault().fromJson(checkResponseBody(resp, rb), listType);
			}
	}
	
	private <T> T executePost(String urlPath, Object requestBodyObj, Class<T> responseClass, String bearerToken) throws SellrapidoException, IOException {
		return executePost(urlPath, GsonUtility.getDefault().toJson(requestBodyObj), responseClass, bearerToken);
	}
	
	private <T> T executePost(String urlPath, String json, Class<T> responseClass, String bearerToken) throws SellrapidoException, IOException {
		Request.Builder reqBuilder = new Request.Builder()
				.url(baseUrlV2 + urlPath)
				.post(RequestBody.create(json, applicationJson));
				
		if(bearerToken != null && !bearerToken.isEmpty()) {
			reqBuilder.addHeader("Authorization", "Bearer " + bearerToken);
		}
		
		Request req = reqBuilder.build();
		Call call = getClient().newCall(req);
		
		try(Response resp = call.execute();
			ResponseBody rb = resp.body();){
			return GsonUtility.getDefault().fromJson(checkResponseBody(resp, rb), responseClass);
		}
	}
	
	private String buildQueryString(OrderRequest request) throws UnsupportedEncodingException, ParseException {
		StringBuilder sb = new StringBuilder();
		appendIfNotNull(sb, "code", request.getCode());
		appendIfNotNull(sb, "status", request.getStatus());
		appendIfNotNull(sb, "start_date", request.getStartDate());
		appendIfNotNull(sb, "end_date", request.getEndDate());
		appendIfNotNull(sb, "start_modified", request.getStartModified());
		appendIfNotNull(sb, "end_modified", request.getEndModified());
		appendIfNotNull(sb, "format", request.getFormat());
		appendIfNotNull(sb, "column_separator", request.getColumnSeparator());
		appendIfNotNull(sb, "write_heading", request.getWriteHeading());
		appendIfNotNull(sb, "offset", request.getOffset());
		appendIfNotNull(sb, "limit", request.getLimit());
		appendIfNotNull(sb, "tags", request.getTags());
		return sb.toString();
	}

	private void appendIfNotNull(StringBuilder sb, String name, String value) throws UnsupportedEncodingException {
		if (value != null && !value.isEmpty()) {
			if (sb.length() > 0) sb.append('&');
			sb.append(name).append('=').append(URLEncoder.encode(value, StandardCharsets.UTF_8.name()));
		}
	}

	private void appendIfNotNull(StringBuilder sb, String name, Collection<String> collection) throws UnsupportedEncodingException {
		if (collection != null && !collection.isEmpty()) {
			String joined = String.join(",", collection);
			if (sb.length() > 0) sb.append('&');
			sb.append(name).append('=').append(URLEncoder.encode(joined, StandardCharsets.UTF_8.name()));
		}
	}

	private void appendIfNotNull(StringBuilder sb, String name, Boolean value) throws UnsupportedEncodingException {
		if (value != null) {
			if (sb.length() > 0) sb.append('&');
			sb.append(name).append('=').append(URLEncoder.encode(value.toString(), StandardCharsets.UTF_8.name()));
		}
	}

	private void appendIfNotNull(StringBuilder sb, String name, Integer value) throws UnsupportedEncodingException {
		if (value != null) {
			if (sb.length() > 0) sb.append('&');
			sb.append(name).append('=').append(URLEncoder.encode(value.toString(), StandardCharsets.UTF_8.name()));
		}
	}
	
	private void appendIfNotNull(StringBuilder sb, String name, Date value) throws UnsupportedEncodingException {
	    if (value != null) {
	        if (sb.length() > 0) sb.append('&');
	        sb.append(name).append('=').append(URLEncoder.encode(new SimpleDateFormat(OrderRequest.orderRequestDatePattern).format(value), StandardCharsets.UTF_8.name()));
	    }
	}

	private <T> T executeGet(String urlPath, OrderRequest requestObj, Class<T> responseClass, String bearerToken) throws SellrapidoException, IOException, ParseException {
		String query = buildQueryString(requestObj);
		StringBuilder urlBuilder = new StringBuilder(baseUrlV2 + urlPath);
		if (!query.isEmpty()) {
			urlBuilder.append('?').append(query);
		}
		Request.Builder reqBuilder = new Request.Builder()
				.url(urlBuilder.toString())
				.get();
		if (bearerToken != null && !bearerToken.isEmpty()) {
			reqBuilder.addHeader("Authorization", "Bearer " + bearerToken);
		}
		Request req = reqBuilder.build();
		Call call = getClient().newCall(req);
		try (Response resp = call.execute();
			 ResponseBody rb = resp.body();) {
			return GsonUtility.getDefault().fromJson(checkResponseBody(resp, rb), responseClass);
		}
	}
	
	
	
	
	
	
	
	
	
	private String checkResponseBody(Response resp, ResponseBody rb) throws SellrapidoException, IOException {
		MediaType mtype = rb.contentType();
		
		if(resp.code()>=200 && resp.code()<=299) {
			
			if(! (mtype.type().equals(applicationJson.type()) && mtype.subtype().equals(applicationJson.subtype())) )
				throw new SellrapidoException(rb.string());
			
			return rb.string();
			
		} else {
							
			if(! (mtype.type().equals(applicationJson.type()) && mtype.subtype().equals(applicationJson.subtype())) )
				throw new SellrapidoException(rb.string());
			
			throw new SellrapidoException(GsonUtility.getDefault().fromJson(rb.string(), SellrapidoErrorResponse.class));
		}
	}

}