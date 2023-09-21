package com.github.vidaniello.sellrapido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class OrderResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Collection<OrderSellrapido> orders;
	private Integer totalCount;
	private Integer offset;
	private Integer limit;
	
	public OrderResponse() {
		
	}

	public Collection<OrderSellrapido> getOrders() {
		if(orders==null)
			orders = new ArrayList<>();
		return orders;
	}

	public void setOrders(Collection<OrderSellrapido> orders) {
		this.orders = orders;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	

}
