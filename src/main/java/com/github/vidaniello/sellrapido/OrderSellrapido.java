package com.github.vidaniello.sellrapido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class OrderSellrapido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Head head;
	private Collection<Row> rows;
	
	public OrderSellrapido() {
		
	}
	
	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Collection<Row> getRows() {
		if(rows==null)
			rows = new ArrayList<>();
		return rows;
	}

	public void setRows(Collection<Row> rows) {
		this.rows = rows;
	}



	public class Head implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private Integer id;
		private Integer shop;
		private Integer customer;
		private Integer courier;
		private String code;
		private Integer code_number;
		private String marketplace_code;
		private String channel_code;
		private String courier_code;
		private String shipping_code;
		private String insurance_code;
		private String payment_code;
		private String supplier_code;
		private Integer buyer_loc_place;
		private Integer buyer_loc_place_dd;
		private String merchant_id;
		private String fields_lock;
		private Date date_order;
		private String reference_1;
		private String reference_2;
		private String buyer_user_id;
		private String buyer_checkout_message;
		private String buyer_email;
		private String buyer_token;
		private Double shipping_price;
		private Double shipping_insurance_price;
		private Double marketplace_fee;
		private Double paypal_fee;
		private Integer shipped_by_marketplace;
		private Integer is_prime;
		private Integer cod_cash_only;
		private String cod_option;
		private Double cod_price;
		private Double price_discount_markup;
		private String buyer_name;
		private String buyer_address1;
		private String buyer_address2;
		private String buyer_zip;
		private String buyer_city;
		private String buyer_province;
		private String buyer_country;
		private Double buyer_latitude;
		private Double buyer_longitude;
		private String buyer_phone;
		private String buyer_fax;
		private String buyer_mobile;
		private String buyer_fiscal_code;
		private String buyer_vat;
		private String currency;
		private Double price;
		private String status;
		private String status_old;
		private String status_message;
		private Date date_payment;
		private Date date_shipping;
		private Double weight;
		private String tracking;
		private String note;
		private String payment_note;
		private String buyer_name_dd;
		private String buyer_address1_dd;
		private String buyer_address2_dd;
		private String buyer_zip_dd;
		private String buyer_city_dd;
		private String buyer_province_dd;
		private String buyer_country_dd;
		private Double buyer_latitude_dd;
		private Double buyer_longitude_dd;
		private String buyer_phone_dd;
		private String buyer_fax_dd;
		private String buyer_mobile_dd;
		private String shipping_note;
		private String paypal_transaction_id;
		private Integer billed;
		private String tags;
		private CourierInfo courier_info;
		private String problem_description;
		private MarketplacePaymentInfo marketplace_payment_info;
		private Object marketplace_payment_info_date;
		private Double shipping_cost;
		private Feedbacks feedbacks;
		private Object feedbacks_date;
		private String content_type;
		private Integer hidden;
		private Integer run_request;
		private DriverInfo driver_info;
		private String marketplace_country;
		private String agent;
		private String buyer_invoice_ecode;
		private String buyer_pec;
		private Object date_last_ship;
		private Object date_last_delivery;
		private Date created;
		private Date modified;
		private Integer is_b2b;
		private BillingInfo billing_info;
		private String force_profit_loss_calculation;
		private Double total_tax;
		private String tags_label;
		
		public Head() {
			
		}

		public STATUS getStatusEnum() {
			return STATUS.parse(getStatus());
		}
		
		public STATUS getStatusOldEnum() {
			return STATUS.parse(getStatus_old());					
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getShop() {
			return shop;
		}

		public void setShop(Integer shop) {
			this.shop = shop;
		}

		public Integer getCustomer() {
			return customer;
		}

		public void setCustomer(Integer customer) {
			this.customer = customer;
		}

		public Integer getCourier() {
			return courier;
		}

		public void setCourier(Integer courier) {
			this.courier = courier;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Integer getCode_number() {
			return code_number;
		}

		public void setCode_number(Integer code_number) {
			this.code_number = code_number;
		}

		public String getMarketplace_code() {
			return marketplace_code;
		}

		public void setMarketplace_code(String marketplace_code) {
			this.marketplace_code = marketplace_code;
		}

		public String getChannel_code() {
			return channel_code;
		}

		public void setChannel_code(String channel_code) {
			this.channel_code = channel_code;
		}

		public String getCourier_code() {
			return courier_code;
		}

		public void setCourier_code(String courier_code) {
			this.courier_code = courier_code;
		}

		public String getShipping_code() {
			return shipping_code;
		}

		public void setShipping_code(String shipping_code) {
			this.shipping_code = shipping_code;
		}

		public String getInsurance_code() {
			return insurance_code;
		}

		public void setInsurance_code(String insurance_code) {
			this.insurance_code = insurance_code;
		}

		public String getPayment_code() {
			return payment_code;
		}

		public void setPayment_code(String payment_code) {
			this.payment_code = payment_code;
		}

		public String getSupplier_code() {
			return supplier_code;
		}

		public void setSupplier_code(String supplier_code) {
			this.supplier_code = supplier_code;
		}

		public Integer getBuyer_loc_place() {
			return buyer_loc_place;
		}

		public void setBuyer_loc_place(Integer buyer_loc_place) {
			this.buyer_loc_place = buyer_loc_place;
		}

		public Integer getBuyer_loc_place_dd() {
			return buyer_loc_place_dd;
		}

		public void setBuyer_loc_place_dd(Integer buyer_loc_place_dd) {
			this.buyer_loc_place_dd = buyer_loc_place_dd;
		}

		public String getMerchant_id() {
			return merchant_id;
		}

		public void setMerchant_id(String merchant_id) {
			this.merchant_id = merchant_id;
		}

		public String getFields_lock() {
			return fields_lock;
		}

		public void setFields_lock(String fields_lock) {
			this.fields_lock = fields_lock;
		}

		public Date getDate_order() {
			return date_order;
		}

		public void setDate_order(Date date_order) {
			this.date_order = date_order;
		}

		public String getReference_1() {
			return reference_1;
		}

		public void setReference_1(String reference_1) {
			this.reference_1 = reference_1;
		}

		public String getReference_2() {
			return reference_2;
		}

		public void setReference_2(String reference_2) {
			this.reference_2 = reference_2;
		}

		public String getBuyer_user_id() {
			return buyer_user_id;
		}

		public void setBuyer_user_id(String buyer_user_id) {
			this.buyer_user_id = buyer_user_id;
		}

		public String getBuyer_checkout_message() {
			return buyer_checkout_message;
		}

		public void setBuyer_checkout_message(String buyer_checkout_message) {
			this.buyer_checkout_message = buyer_checkout_message;
		}

		public String getBuyer_email() {
			return buyer_email;
		}

		public void setBuyer_email(String buyer_email) {
			this.buyer_email = buyer_email;
		}

		public String getBuyer_token() {
			return buyer_token;
		}

		public void setBuyer_token(String buyer_token) {
			this.buyer_token = buyer_token;
		}

		public Double getShipping_price() {
			return shipping_price;
		}

		public void setShipping_price(Double shipping_price) {
			this.shipping_price = shipping_price;
		}

		public Double getShipping_insurance_price() {
			return shipping_insurance_price;
		}

		public void setShipping_insurance_price(Double shipping_insurance_price) {
			this.shipping_insurance_price = shipping_insurance_price;
		}

		public Double getMarketplace_fee() {
			return marketplace_fee;
		}

		public void setMarketplace_fee(Double marketplace_fee) {
			this.marketplace_fee = marketplace_fee;
		}

		public Double getPaypal_fee() {
			return paypal_fee;
		}

		public void setPaypal_fee(Double paypal_fee) {
			this.paypal_fee = paypal_fee;
		}

		public Integer getShipped_by_marketplace() {
			return shipped_by_marketplace;
		}

		public void setShipped_by_marketplace(Integer shipped_by_marketplace) {
			this.shipped_by_marketplace = shipped_by_marketplace;
		}

		public Integer getIs_prime() {
			return is_prime;
		}

		public void setIs_prime(Integer is_prime) {
			this.is_prime = is_prime;
		}

		public Integer getCod_cash_only() {
			return cod_cash_only;
		}

		public void setCod_cash_only(Integer cod_cash_only) {
			this.cod_cash_only = cod_cash_only;
		}

		public String getCod_option() {
			return cod_option;
		}

		public void setCod_option(String cod_option) {
			this.cod_option = cod_option;
		}

		public Double getCod_price() {
			return cod_price;
		}

		public void setCod_price(Double cod_price) {
			this.cod_price = cod_price;
		}

		public Double getPrice_discount_markup() {
			return price_discount_markup;
		}

		public void setPrice_discount_markup(Double price_discount_markup) {
			this.price_discount_markup = price_discount_markup;
		}

		public String getBuyer_name() {
			return buyer_name;
		}

		public void setBuyer_name(String buyer_name) {
			this.buyer_name = buyer_name;
		}

		public String getBuyer_address1() {
			return buyer_address1;
		}

		public void setBuyer_address1(String buyer_address1) {
			this.buyer_address1 = buyer_address1;
		}

		public String getBuyer_address2() {
			return buyer_address2;
		}

		public void setBuyer_address2(String buyer_address2) {
			this.buyer_address2 = buyer_address2;
		}

		public String getBuyer_zip() {
			return buyer_zip;
		}

		public void setBuyer_zip(String buyer_zip) {
			this.buyer_zip = buyer_zip;
		}

		public String getBuyer_city() {
			return buyer_city;
		}

		public void setBuyer_city(String buyer_city) {
			this.buyer_city = buyer_city;
		}

		public String getBuyer_province() {
			return buyer_province;
		}

		public void setBuyer_province(String buyer_province) {
			this.buyer_province = buyer_province;
		}

		public String getBuyer_country() {
			return buyer_country;
		}

		public void setBuyer_country(String buyer_country) {
			this.buyer_country = buyer_country;
		}

		public Double getBuyer_latitude() {
			return buyer_latitude;
		}

		public void setBuyer_latitude(Double buyer_latitude) {
			this.buyer_latitude = buyer_latitude;
		}

		public Double getBuyer_longitude() {
			return buyer_longitude;
		}

		public void setBuyer_longitude(Double buyer_longitude) {
			this.buyer_longitude = buyer_longitude;
		}

		public String getBuyer_phone() {
			return buyer_phone;
		}

		public void setBuyer_phone(String buyer_phone) {
			this.buyer_phone = buyer_phone;
		}

		public String getBuyer_fax() {
			return buyer_fax;
		}

		public void setBuyer_fax(String buyer_fax) {
			this.buyer_fax = buyer_fax;
		}

		public String getBuyer_mobile() {
			return buyer_mobile;
		}

		public void setBuyer_mobile(String buyer_mobile) {
			this.buyer_mobile = buyer_mobile;
		}

		public String getBuyer_fiscal_code() {
			return buyer_fiscal_code;
		}

		public void setBuyer_fiscal_code(String buyer_fiscal_code) {
			this.buyer_fiscal_code = buyer_fiscal_code;
		}

		public String getBuyer_vat() {
			return buyer_vat;
		}

		public void setBuyer_vat(String buyer_vat) {
			this.buyer_vat = buyer_vat;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getStatus_old() {
			return status_old;
		}

		public void setStatus_old(String status_old) {
			this.status_old = status_old;
		}

		public String getStatus_message() {
			return status_message;
		}

		public void setStatus_message(String status_message) {
			this.status_message = status_message;
		}

		public Date getDate_payment() {
			return date_payment;
		}

		public void setDate_payment(Date date_payment) {
			this.date_payment = date_payment;
		}

		public Date getDate_shipping() {
			return date_shipping;
		}

		public void setDate_shipping(Date date_shipping) {
			this.date_shipping = date_shipping;
		}

		public Double getWeight() {
			return weight;
		}

		public void setWeight(Double weight) {
			this.weight = weight;
		}

		public String getTracking() {
			return tracking;
		}

		public void setTracking(String tracking) {
			this.tracking = tracking;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

		public String getPayment_note() {
			return payment_note;
		}

		public void setPayment_note(String payment_note) {
			this.payment_note = payment_note;
		}

		public String getBuyer_name_dd() {
			return buyer_name_dd;
		}

		public void setBuyer_name_dd(String buyer_name_dd) {
			this.buyer_name_dd = buyer_name_dd;
		}

		public String getBuyer_address1_dd() {
			return buyer_address1_dd;
		}

		public void setBuyer_address1_dd(String buyer_address1_dd) {
			this.buyer_address1_dd = buyer_address1_dd;
		}

		public String getBuyer_address2_dd() {
			return buyer_address2_dd;
		}

		public void setBuyer_address2_dd(String buyer_address2_dd) {
			this.buyer_address2_dd = buyer_address2_dd;
		}

		public String getBuyer_zip_dd() {
			return buyer_zip_dd;
		}

		public void setBuyer_zip_dd(String buyer_zip_dd) {
			this.buyer_zip_dd = buyer_zip_dd;
		}

		public String getBuyer_city_dd() {
			return buyer_city_dd;
		}

		public void setBuyer_city_dd(String buyer_city_dd) {
			this.buyer_city_dd = buyer_city_dd;
		}

		public String getBuyer_province_dd() {
			return buyer_province_dd;
		}

		public void setBuyer_province_dd(String buyer_province_dd) {
			this.buyer_province_dd = buyer_province_dd;
		}

		public String getBuyer_country_dd() {
			return buyer_country_dd;
		}

		public void setBuyer_country_dd(String buyer_country_dd) {
			this.buyer_country_dd = buyer_country_dd;
		}

		public Double getBuyer_latitude_dd() {
			return buyer_latitude_dd;
		}

		public void setBuyer_latitude_dd(Double buyer_latitude_dd) {
			this.buyer_latitude_dd = buyer_latitude_dd;
		}

		public Double getBuyer_longitude_dd() {
			return buyer_longitude_dd;
		}

		public void setBuyer_longitude_dd(Double buyer_longitude_dd) {
			this.buyer_longitude_dd = buyer_longitude_dd;
		}

		public String getBuyer_phone_dd() {
			return buyer_phone_dd;
		}

		public void setBuyer_phone_dd(String buyer_phone_dd) {
			this.buyer_phone_dd = buyer_phone_dd;
		}

		public String getBuyer_fax_dd() {
			return buyer_fax_dd;
		}

		public void setBuyer_fax_dd(String buyer_fax_dd) {
			this.buyer_fax_dd = buyer_fax_dd;
		}

		public String getBuyer_mobile_dd() {
			return buyer_mobile_dd;
		}

		public void setBuyer_mobile_dd(String buyer_mobile_dd) {
			this.buyer_mobile_dd = buyer_mobile_dd;
		}

		public String getShipping_note() {
			return shipping_note;
		}

		public void setShipping_note(String shipping_note) {
			this.shipping_note = shipping_note;
		}

		public String getPaypal_transaction_id() {
			return paypal_transaction_id;
		}

		public void setPaypal_transaction_id(String paypal_transaction_id) {
			this.paypal_transaction_id = paypal_transaction_id;
		}

		public Integer getBilled() {
			return billed;
		}

		public void setBilled(Integer billed) {
			this.billed = billed;
		}

		public String getTags() {
			return tags;
		}

		public void setTags(String tags) {
			this.tags = tags;
		}

		public CourierInfo getCourier_info() {
			return courier_info;
		}

		public void setCourier_info(CourierInfo courier_info) {
			this.courier_info = courier_info;
		}

		public String getProblem_description() {
			return problem_description;
		}

		public void setProblem_description(String problem_description) {
			this.problem_description = problem_description;
		}

		public MarketplacePaymentInfo getMarketplace_payment_info() {
			return marketplace_payment_info;
		}

		public void setMarketplace_payment_info(MarketplacePaymentInfo marketplace_payment_info) {
			this.marketplace_payment_info = marketplace_payment_info;
		}

		public Object getMarketplace_payment_info_date() {
			return marketplace_payment_info_date;
		}

		public void setMarketplace_payment_info_date(Object marketplace_payment_info_date) {
			this.marketplace_payment_info_date = marketplace_payment_info_date;
		}

		public Double getShipping_cost() {
			return shipping_cost;
		}

		public void setShipping_cost(Double shipping_cost) {
			this.shipping_cost = shipping_cost;
		}

		public Feedbacks getFeedbacks() {
			return feedbacks;
		}

		public void setFeedbacks(Feedbacks feedbacks) {
			this.feedbacks = feedbacks;
		}

		public Object getFeedbacks_date() {
			return feedbacks_date;
		}

		public void setFeedbacks_date(Object feedbacks_date) {
			this.feedbacks_date = feedbacks_date;
		}

		public String getContent_type() {
			return content_type;
		}

		public void setContent_type(String content_type) {
			this.content_type = content_type;
		}

		public Integer getHidden() {
			return hidden;
		}

		public void setHidden(Integer hidden) {
			this.hidden = hidden;
		}

		public Integer getRun_request() {
			return run_request;
		}

		public void setRun_request(Integer run_request) {
			this.run_request = run_request;
		}

		public DriverInfo getDriver_info() {
			return driver_info;
		}

		public void setDriver_info(DriverInfo driver_info) {
			this.driver_info = driver_info;
		}

		public String getMarketplace_country() {
			return marketplace_country;
		}

		public void setMarketplace_country(String marketplace_country) {
			this.marketplace_country = marketplace_country;
		}

		public String getAgent() {
			return agent;
		}

		public void setAgent(String agent) {
			this.agent = agent;
		}

		public String getBuyer_invoice_ecode() {
			return buyer_invoice_ecode;
		}

		public void setBuyer_invoice_ecode(String buyer_invoice_ecode) {
			this.buyer_invoice_ecode = buyer_invoice_ecode;
		}

		public String getBuyer_pec() {
			return buyer_pec;
		}

		public void setBuyer_pec(String buyer_pec) {
			this.buyer_pec = buyer_pec;
		}

		public Object getDate_last_ship() {
			return date_last_ship;
		}

		public void setDate_last_ship(Object date_last_ship) {
			this.date_last_ship = date_last_ship;
		}

		public Object getDate_last_delivery() {
			return date_last_delivery;
		}

		public void setDate_last_delivery(Object date_last_delivery) {
			this.date_last_delivery = date_last_delivery;
		}

		public Date getCreated() {
			return created;
		}

		public void setCreated(Date created) {
			this.created = created;
		}

		public Date getModified() {
			return modified;
		}

		public void setModified(Date modified) {
			this.modified = modified;
		}

		public Integer getIs_b2b() {
			return is_b2b;
		}

		public void setIs_b2b(Integer is_b2b) {
			this.is_b2b = is_b2b;
		}

		public BillingInfo getBilling_info() {
			return billing_info;
		}

		public void setBilling_info(BillingInfo billing_info) {
			this.billing_info = billing_info;
		}

		public String getForce_profit_loss_calculation() {
			return force_profit_loss_calculation;
		}

		public void setForce_profit_loss_calculation(String force_profit_loss_calculation) {
			this.force_profit_loss_calculation = force_profit_loss_calculation;
		}

		public Double getTotal_tax() {
			return total_tax;
		}

		public void setTotal_tax(Double total_tax) {
			this.total_tax = total_tax;
		}

		public String getTags_label() {
			return tags_label;
		}

		public void setTags_label(String tags_label) {
			this.tags_label = tags_label;
		}
		
		
	}

	public class MarketplacePaymentInfo implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public MarketplacePaymentInfo() {
			
		}
	}

	public class BillingInfo implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public BillingInfo() {
			
		}
	}

	public class CourierInfo implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private Integer packs_number;
		private String courier_box_type;
		private String courier_contact;
		private String tracking_url;
		private Integer shipping_declared_value;
		private String pack_dimensions;
		
		public CourierInfo() {
			
		}

		public Integer getPacks_number() {
			return packs_number;
		}

		public void setPacks_number(Integer packs_number) {
			this.packs_number = packs_number;
		}

		public String getCourier_box_type() {
			return courier_box_type;
		}

		public void setCourier_box_type(String courier_box_type) {
			this.courier_box_type = courier_box_type;
		}

		public String getCourier_contact() {
			return courier_contact;
		}

		public void setCourier_contact(String courier_contact) {
			this.courier_contact = courier_contact;
		}

		public String getTracking_url() {
			return tracking_url;
		}

		public void setTracking_url(String tracking_url) {
			this.tracking_url = tracking_url;
		}

		public Integer getShipping_declared_value() {
			return shipping_declared_value;
		}

		public void setShipping_declared_value(Integer shipping_declared_value) {
			this.shipping_declared_value = shipping_declared_value;
		}

		public String getPack_dimensions() {
			return pack_dimensions;
		}

		public void setPack_dimensions(String pack_dimensions) {
			this.pack_dimensions = pack_dimensions;
		}
		
		
	}

	public class DriverInfo implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public DriverInfo() {
			
		}
		
	}

	public class Feedbacks implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public Feedbacks() {
			
		}
		
	}

	public class Row implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private Integer id;
		private Integer order_head;
		private Integer order_row_supplier;
		private Integer supplier;
		private String order_supplier_code;
		private String courier_code;
		private String tracking;
		private String fields_lock;
		private Double shipping_cost;
		private String shipping_code;
		private String transaction_id;
		private String product_id;
		private String sku;
		private String ean;
		private String brand;
		private String mpn;
		private String sku_parent;
		private String title;
		private String title_extra;
		private Integer quantity;
		private Integer stock_unloaded;
		private Double price;
		private Double price_total;
		private Double price_discount_markup;
		private Double price_cost;
		private Double refund_price;
		private Object refund_date;
		private String refund_reason;
		private Double shipping_price;
		private Double shipping_insurance_price;
		private Object date_shipping;
		private String shipping_note;
		private Double cod_price;
		private Double marketplace_fee;
		private Double weight;
		private String note;
		private Double vat_perc;
		private String image_url;
		private String category_id;
		private String category_name;
		private Object date_payment;
		private ProductInfo product_info;
		private Object on_demand_date;
		private Date created;
		private Date modified;
		private Integer order_supplier;
		private Integer refund_supplier_quantity;
		private Double refund_marketplace_fee;
		private Double product_tax;
		private String no_vat;
		
		public Row() {
			
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getOrder_head() {
			return order_head;
		}

		public void setOrder_head(Integer order_head) {
			this.order_head = order_head;
		}

		public Integer getOrder_row_supplier() {
			return order_row_supplier;
		}

		public void setOrder_row_supplier(Integer order_row_supplier) {
			this.order_row_supplier = order_row_supplier;
		}

		public Integer getSupplier() {
			return supplier;
		}

		public void setSupplier(Integer supplier) {
			this.supplier = supplier;
		}

		public String getOrder_supplier_code() {
			return order_supplier_code;
		}

		public void setOrder_supplier_code(String order_supplier_code) {
			this.order_supplier_code = order_supplier_code;
		}

		public String getCourier_code() {
			return courier_code;
		}

		public void setCourier_code(String courier_code) {
			this.courier_code = courier_code;
		}

		public String getTracking() {
			return tracking;
		}

		public void setTracking(String tracking) {
			this.tracking = tracking;
		}

		public String getFields_lock() {
			return fields_lock;
		}

		public void setFields_lock(String fields_lock) {
			this.fields_lock = fields_lock;
		}

		public Double getShipping_cost() {
			return shipping_cost;
		}

		public void setShipping_cost(Double shipping_cost) {
			this.shipping_cost = shipping_cost;
		}

		public String getShipping_code() {
			return shipping_code;
		}

		public void setShipping_code(String shipping_code) {
			this.shipping_code = shipping_code;
		}

		public String getTransaction_id() {
			return transaction_id;
		}

		public void setTransaction_id(String transaction_id) {
			this.transaction_id = transaction_id;
		}

		public String getProduct_id() {
			return product_id;
		}

		public void setProduct_id(String product_id) {
			this.product_id = product_id;
		}

		public String getSku() {
			return sku;
		}

		public void setSku(String sku) {
			this.sku = sku;
		}

		public String getEan() {
			return ean;
		}

		public void setEan(String ean) {
			this.ean = ean;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getMpn() {
			return mpn;
		}

		public void setMpn(String mpn) {
			this.mpn = mpn;
		}

		public String getSku_parent() {
			return sku_parent;
		}

		public void setSku_parent(String sku_parent) {
			this.sku_parent = sku_parent;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getTitle_extra() {
			return title_extra;
		}

		public void setTitle_extra(String title_extra) {
			this.title_extra = title_extra;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Integer getStock_unloaded() {
			return stock_unloaded;
		}

		public void setStock_unloaded(Integer stock_unloaded) {
			this.stock_unloaded = stock_unloaded;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Double getPrice_total() {
			return price_total;
		}

		public void setPrice_total(Double price_total) {
			this.price_total = price_total;
		}

		public Double getPrice_discount_markup() {
			return price_discount_markup;
		}

		public void setPrice_discount_markup(Double price_discount_markup) {
			this.price_discount_markup = price_discount_markup;
		}

		public Double getPrice_cost() {
			return price_cost;
		}

		public void setPrice_cost(Double price_cost) {
			this.price_cost = price_cost;
		}

		public Double getRefund_price() {
			return refund_price;
		}

		public void setRefund_price(Double refund_price) {
			this.refund_price = refund_price;
		}

		public Object getRefund_date() {
			return refund_date;
		}

		public void setRefund_date(Object refund_date) {
			this.refund_date = refund_date;
		}

		public String getRefund_reason() {
			return refund_reason;
		}

		public void setRefund_reason(String refund_reason) {
			this.refund_reason = refund_reason;
		}

		public Double getShipping_price() {
			return shipping_price;
		}

		public void setShipping_price(Double shipping_price) {
			this.shipping_price = shipping_price;
		}

		public Double getShipping_insurance_price() {
			return shipping_insurance_price;
		}

		public void setShipping_insurance_price(Double shipping_insurance_price) {
			this.shipping_insurance_price = shipping_insurance_price;
		}

		public Object getDate_shipping() {
			return date_shipping;
		}

		public void setDate_shipping(Object date_shipping) {
			this.date_shipping = date_shipping;
		}

		public String getShipping_note() {
			return shipping_note;
		}

		public void setShipping_note(String shipping_note) {
			this.shipping_note = shipping_note;
		}

		public Double getCod_price() {
			return cod_price;
		}

		public void setCod_price(Double cod_price) {
			this.cod_price = cod_price;
		}

		public Double getMarketplace_fee() {
			return marketplace_fee;
		}

		public void setMarketplace_fee(Double marketplace_fee) {
			this.marketplace_fee = marketplace_fee;
		}

		public Double getWeight() {
			return weight;
		}

		public void setWeight(Double weight) {
			this.weight = weight;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

		public Double getVat_perc() {
			return vat_perc;
		}

		public void setVat_perc(Double vat_perc) {
			this.vat_perc = vat_perc;
		}

		public String getImage_url() {
			return image_url;
		}

		public void setImage_url(String image_url) {
			this.image_url = image_url;
		}

		public String getCategory_id() {
			return category_id;
		}

		public void setCategory_id(String category_id) {
			this.category_id = category_id;
		}

		public String getCategory_name() {
			return category_name;
		}

		public void setCategory_name(String category_name) {
			this.category_name = category_name;
		}

		public Object getDate_payment() {
			return date_payment;
		}

		public void setDate_payment(Object date_payment) {
			this.date_payment = date_payment;
		}

		public ProductInfo getProduct_info() {
			return product_info;
		}

		public void setProduct_info(ProductInfo product_info) {
			this.product_info = product_info;
		}

		public Object getOn_demand_date() {
			return on_demand_date;
		}

		public void setOn_demand_date(Object on_demand_date) {
			this.on_demand_date = on_demand_date;
		}

		public Date getCreated() {
			return created;
		}

		public void setCreated(Date created) {
			this.created = created;
		}

		public Date getModified() {
			return modified;
		}

		public void setModified(Date modified) {
			this.modified = modified;
		}

		public Integer getOrder_supplier() {
			return order_supplier;
		}

		public void setOrder_supplier(Integer order_supplier) {
			this.order_supplier = order_supplier;
		}

		public Integer getRefund_supplier_quantity() {
			return refund_supplier_quantity;
		}

		public void setRefund_supplier_quantity(Integer refund_supplier_quantity) {
			this.refund_supplier_quantity = refund_supplier_quantity;
		}

		public Double getRefund_marketplace_fee() {
			return refund_marketplace_fee;
		}

		public void setRefund_marketplace_fee(Double refund_marketplace_fee) {
			this.refund_marketplace_fee = refund_marketplace_fee;
		}

		public Double getProduct_tax() {
			return product_tax;
		}

		public void setProduct_tax(Double product_tax) {
			this.product_tax = product_tax;
		}

		public String getNo_vat() {
			return no_vat;
		}

		public void setNo_vat(String no_vat) {
			this.no_vat = no_vat;
		}
		
		
	}

	public class ProductInfo implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	}

}
