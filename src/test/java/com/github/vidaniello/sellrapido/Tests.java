package com.github.vidaniello.sellrapido;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;

public class Tests {
	
	static {
		// Log4j from 2.17.>
		//System.setProperty("log4j2.Configuration.allowedProtocols", "http");

		// URL file di configurazione Log4j2
		System.setProperty("log4j.configurationFile", 
				"https://gist.github.com/vidaniello/c20e29cdffb407ec5d3c773fb92786b9/raw/92c8e809f51133ef56e4867a6cabb0744ee6b9b6/log4j2.xml");

		// Tips per java.util.logging
		System.setProperty("java.util.logging.manager", 
				"org.apache.logging.log4j.jul.LogManager");

		// private org.apache.logging.log4j.Logger log =
		// org.apache.logging.log4j.LogManager.getLogger();
	}
	
	private Logger log = LogManager.getLogger();
	
	private String apiKey;
	
	
	@Before
	public void beforeActions() {
		apiKey = System.getProperty("sellrapido.apiKey");
	}
	
	@Test
	public void testUpdateOrder() {
		try {
			
			ApiClientSellrapido client = new ApiClientSellrapido(apiKey);
			
			String orderCode = System.getProperty("sellrapido.orderCode");
			
			OrderRequest getOrdReq = new OrderRequest();
			getOrdReq.code().add(orderCode);
			
			log.debug("Getting the order id by the order code given...");
			
			OrderResponse orderResp = client.getOrders(getOrdReq);
			
			OrderSellrapido order = orderResp.getOrders().iterator().next();
			
			Integer orderId = order.getHead().getId();
			
			STATUS startingStatus = order.getHead().getStatusEnum();
			
			log.debug("The id of the order is: "+orderId);
			log.debug("Starting status is: "+startingStatus);
			log.debug("The status of the order is: "+order.getHead().getStatusEnum());
			
			log.debug("Try to change the status...");
			
			OrderUpdateRequest our = 
					new OrderUpdateRequest()
					.id(orderId)
					.status(STATUS.accepted.toString());
			
			Collection<OrderUpdateRequest> req = new ArrayList<>();
			req.add(our);
			
			Collection<OrderUpdateResponse> resp = client.updateOrders(req);
			
			Assert.assertTrue(resp.isEmpty());
			
			log.debug("Checking the now status...");
			
			orderResp = client.getOrders(getOrdReq);
			
			order = orderResp.getOrders().iterator().next();
			
			STATUS nowStatus = order.getHead().getStatusEnum();
			
			Assert.assertTrue(STATUS.accepted.equals(nowStatus));
			
			log.debug("New status is: "+nowStatus);
			
			log.debug("Update back to starting status: "+startingStatus);
			
			our.status(startingStatus);
			
			resp = client.updateOrders(req);
			
			Assert.assertTrue(resp.isEmpty());
			
			log.debug("Checking the now status...");
			
			orderResp = client.getOrders(getOrdReq);
			
			order = orderResp.getOrders().iterator().next();
			
			nowStatus = order.getHead().getStatusEnum();
			
			Assert.assertTrue(startingStatus.equals(nowStatus));
			
			log.debug("New status is: "+nowStatus);
			
			log.debug("Testing wrong updates...");
			
			req.clear();
			
			our = 	new OrderUpdateRequest()
					.id(-233214568)
					.status(STATUS.accepted.toString());
			
			req.add(our);
			
			our = 	new OrderUpdateRequest()
					.id(-233214569)
					.status(STATUS.accepted.toString());
			
			req.add(our);
			
			resp = client.updateOrders(req);
			
			Assert.assertTrue(resp.size()==2);
			
			log.debug("Testing wrong updates ok!");
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new AssertionError(e);
		}
	}
	
	@Test
	public void testRequestOrders() {
		try {
			ApiClientSellrapido client = new ApiClientSellrapido(apiKey);
			
			OrderRequest getOrdReq = new OrderRequest();
						
			OrderResponse orderResp = client.getOrders(getOrdReq);
			
			Assert.assertTrue(orderResp.getTotalCount().equals(orderResp.getOrders().size()));
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new AssertionError(e);
		}
	}
	
	@Test
	public void testErrorSimulation() {
		try {
			
			ApiClientSellrapido client = new ApiClientSellrapido(apiKey);
			
			try {
				client.getOrders("wrong body");
				throw new Exception("Expected exception");
			} catch (SellrapidoException sellExc) {
				Assert.assertTrue(sellExc.getErrorObject()!=null);
			}
			
			try {
				//wrong json request parameter
				client.getOrders("{\"limit\": \"100\"}");
				throw new Exception("Expected exception");
			} catch (SellrapidoException sellExc) {
				Assert.assertTrue(sellExc.getMessage().contains("wrong limit"));
			}
			
			try {
				//wrong api key
				ApiClientSellrapido client2 = new ApiClientSellrapido("badKey");
				client2.getOrders("{}");
				throw new Exception("Expected exception");
			} catch (SellrapidoException sellExc) {
				Assert.assertTrue(sellExc.getMessage().contains("wrong api"));
			}
			
			
			
			int i = 0;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new AssertionError(e);
		}
	}

}
