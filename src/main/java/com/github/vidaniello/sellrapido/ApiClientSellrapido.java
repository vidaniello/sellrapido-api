package com.github.vidaniello.sellrapido;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import com.google.gson.reflect.TypeToken;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ApiClientSellrapido {
	
	public static final String baseUrl = "https://app.sellrapido.com/sr_company_ws/api/";
	public static final String orderUrl = "order/";
	public static final String orderUpdateFinal = "/status";
	
	public static final MediaType applicationJson = MediaType.get("application/json");
	
	private OkHttpClient client;
	private String key;
	
	public ApiClientSellrapido() {
		
	}
	
	public ApiClientSellrapido(String key) {
		this();
		this.key = key;
	}

	private String getKey() {
		return key;
	}
		
	public synchronized OkHttpClient getClient() {
		if(client==null)
			client = new OkHttpClient();
		return client;
	}
	
	public synchronized void setClient(OkHttpClient client) {
		this.client = client;
	}
	
	
	
	
	public OrderResponse getOrders(OrderRequest orderRequest) throws SellrapidoException, IOException {
		return getOrders(GsonUtility.getDefault().toJson(orderRequest));
	}
	
	public OrderResponse getOrders(String orderRequestJson) throws SellrapidoException, IOException {
		
		RequestBody body = RequestBody.create(
				orderRequestJson, 
				applicationJson
			);
		
		Request req = new Request.Builder()
				.url(baseUrl+orderUrl+getKey())
				.post(body)
				.build();
		
		Call call = getClient().newCall(req);
		
		try(Response resp = call.execute();
			ResponseBody rb = resp.body();){
			
			return GsonUtility.getDefault().fromJson(checkResponseBody(resp, rb),OrderResponse.class);
		}
	}
	
	
	
	
	
	public Collection<OrderUpdateResponse> updateOrders(Collection<OrderUpdateRequest> ordersUpdateRequest) throws SellrapidoException, IOException {
		return updateOrders(GsonUtility.getDefault().toJson(ordersUpdateRequest));
	}
	
	public Collection<OrderUpdateResponse> updateOrders(String ordersUpdateJson) throws SellrapidoException, IOException {
		RequestBody body = RequestBody.create(
				ordersUpdateJson, 
				applicationJson
			);
		
		Request req = new Request.Builder()
				.url(baseUrl+orderUrl+getKey()+orderUpdateFinal)
				.post(body)
				.build();
		
		Call call = getClient().newCall(req);
		
		try(Response resp = call.execute();
				ResponseBody rb = resp.body();){
			
				Type listType = new TypeToken<Collection<OrderUpdateResponse>>(){}.getType();	
			
				return GsonUtility.getDefault().fromJson(checkResponseBody(resp, rb), listType);
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
