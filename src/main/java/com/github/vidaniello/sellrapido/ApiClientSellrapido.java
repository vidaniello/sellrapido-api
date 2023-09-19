package com.github.vidaniello.sellrapido;

import java.io.IOException;

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
	
	
	public Object getOrders(String jsonRequestBody) throws SellrapidoException, IOException {
		
		RequestBody body = RequestBody.create(jsonRequestBody, applicationJson);
		
		Request req = new Request.Builder()
				.url(baseUrl+orderUrl+getKey())
				.post(body)
				.build();
		
		Call call = getClient().newCall(req);
		
		try(Response resp = call.execute();){
			try(ResponseBody rb = resp.body();){
				
				if(resp.code()>=200 && resp.code()<=299) {
					
					if(!rb.contentType().equals(applicationJson))
						throw new SellrapidoException(rb.string());
					
					return rb.string();
					
				} else {
										
					if(!rb.contentType().equals(applicationJson))
						throw new SellrapidoException(rb.string());
					
					throw new SellrapidoException(GsonUtility.getDefault().fromJson(rb.string(), SellrapidoErrorResponse.class));
				}
				
			}
		}
	}

}
