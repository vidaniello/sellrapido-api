package com.github.vidaniello.sellrapido;

import java.io.Serializable;
import java.util.Date;

public class OrderUpdateRequest extends ReflectionUtilities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String status;
	
	private String tracking;
	private Integer courier;
	private String courier_code;
	private String shipping_note;
	
	private Date payment_date;
	
	public OrderUpdateRequest() {
		
	}

	public OrderUpdateRequest(Integer id, String status) {
		this.id = id;
		this.status = status;
	}
	
	public OrderUpdateRequest(Integer id, STATUS status) {
		this.id = id;
		this.status = status.name();
	}

	public Integer getId() {
		return id;
	}

	public OrderUpdateRequest id(Integer id) {
		this.id = id;
		return this;
	}

	public String getStatus() {
		return status;
	}
	
	public STATUS getStatusEnum() {
		return STATUS.parse(getStatus());
	}

	public OrderUpdateRequest status(String status) {
		this.status = status;
		return this;
	}
	
	public OrderUpdateRequest status(STATUS status) {
		status(status.toString());
		return this;
	}

	public String getTracking() {
		return tracking;
	}

	public OrderUpdateRequest tracking(String tracking) {
		this.tracking = tracking;
		return this;
	}

	public Integer getCourier() {
		return courier;
	}

	public OrderUpdateRequest courier(Integer courier) {
		this.courier = courier;
		return this;
	}

	public String getCourier_code() {
		return courier_code;
	}

	public OrderUpdateRequest courier_code(String courier_code) {
		this.courier_code = courier_code;
		return this;
	}

	public String getShipping_note() {
		return shipping_note;
	}

	public OrderUpdateRequest shipping_note(String shipping_note) {
		this.shipping_note = shipping_note;
		return this;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public OrderUpdateRequest payment_date(Date payment_date) {
		this.payment_date = payment_date;
		return this;
	}
	
	
	

}
