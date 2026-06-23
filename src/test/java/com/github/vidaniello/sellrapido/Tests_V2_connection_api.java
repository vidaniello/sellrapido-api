package com.github.vidaniello.sellrapido;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Tests_V2_connection_api {
	
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
	
	private String username;
	private String password;
	
	
	@Before
	public void beforeActions() {
		username = System.getProperty("sellrapido.username");
		password = System.getProperty("sellrapido.password");
	}
	
	@Test 
	@Ignore
	public void testRequestOrders() {
		try {
			ApiClientSellrapidoV2 client = new ApiClientSellrapidoV2(username, password);
			
			OrderRequest getOrdReq = new OrderRequest();
						
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -20);
			getOrdReq.startDate(cal.getTime());
			
			OrderResponse orderResp = client.getOrders(getOrdReq);
			
			
			Assert.assertTrue(!orderResp.getOrders().isEmpty());
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new AssertionError(e);
		}
	}
	
}
