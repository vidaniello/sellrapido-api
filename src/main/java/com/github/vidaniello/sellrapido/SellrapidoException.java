package com.github.vidaniello.sellrapido;

public class SellrapidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SellrapidoErrorResponse errorObject;
	
	public SellrapidoException() {
		
	}
	
	public SellrapidoException(String message) {
		super(message);
	}
	
	public SellrapidoException(SellrapidoErrorResponse errorObject) {
		super(errorObject.getCode()+": "+errorObject.getRoot());
		this.errorObject = errorObject;
	}
	
	public SellrapidoErrorResponse getErrorObject() {
		return errorObject;
	}

}
