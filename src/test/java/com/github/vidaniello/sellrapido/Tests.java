package com.github.vidaniello.sellrapido;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
