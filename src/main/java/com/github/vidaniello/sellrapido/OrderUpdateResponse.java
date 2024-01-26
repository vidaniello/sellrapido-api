package com.github.vidaniello.sellrapido;

import java.io.Serializable;

public class OrderUpdateResponse extends ReflectionUtilities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer index;
	private String id;
	private String error_message;
	
	public OrderUpdateResponse() {
		
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	
	

}
