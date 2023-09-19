package com.github.vidaniello.sellrapido;

import java.io.Serializable;
import java.util.Collection;

public class SellrapidoErrorResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean success;
	private String server;
	private String code;
	private String root;
	private Object pagination;
	private String hash;
	private Object exception;
	private String date;
	private Collection<Object> trace;
	private String traceAsString;
	
	public SellrapidoErrorResponse() {

	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public Object getPagination() {
		return pagination;
	}

	public void setPagination(Object pagination) {
		this.pagination = pagination;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Object getException() {
		return exception;
	}

	public void setException(Object exception) {
		this.exception = exception;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Collection<Object> getTrace() {
		return trace;
	}

	public void setTrace(Collection<Object> trace) {
		this.trace = trace;
	}

	public String getTraceAsString() {
		return traceAsString;
	}

	public void setTraceAsString(String traceAsString) {
		this.traceAsString = traceAsString;
	}
	
	

}
