package com.github.vidaniello.sellrapido;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * The API is used to download all your orders from SellRapido to import them
 * into your management platform and independently process them.<br>
 * <br>
 * All field are optional. If not specified, the query return 1000 order.
 * 
 * @author Vincenzo D'Aniello (vidaniello@gmail.com) github.com/vidaniello
 *
 */
public class OrderRequest extends ReflectionUtilities implements Serializable {

	public static final String orderRequestDatePattern = "yyyy-MM-dd";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Format yyyy-mm-dd
	 */
	private String startDate;

	/**
	 * Format yyyy-mm-dd
	 */
	private String endDate;

	/**
	 * Format yyyy-mm-dd
	 */
	private String startModified;

	/**
	 * Format yyyy-mm-dd
	 */
	private String endModified;

	/**
	 * If it is given a value, it must contain an array of order codes that will be
	 * used to extract only the orders corresponding to those codes, so for
	 * example:<br>
	 * <br>
	 * <code>["224341564","AXDF5-23542","SDER-465632"]</code><br>
	 * <br>
	 * The Order codes are those assigned by the marketplace (not the SellRapido ID)
	 */
	private Collection<String> code;

	/**
	 * value: <i>csv</i> or <i>json</i><br>
	 * If not specified default is <i>json</i>
	 */
	private String format;

	/**
	 * Returned value can be:<br>
	 * <i>sent</i> or <i>standby</i> or <i>cancelled</i> or <i>accepted</i>
	 */
	private String status;

	/**
	 * Column separator, only if csv format is requested (es: <i>|</i>)
	 */
	private String columnSeparator;

	/**
	 * value: <i>true</i> or <i>false</i><br>
	 * <br>
	 * <i>true</i> to print the column headers, if not specified it is <i>true</i>
	 * by default<br>
	 * <br>
	 * Only if csv format is requested
	 */
	private Boolean writeHeading;

	/**
	 * First record to extract
	 */
	private Integer offset;

	/**
	 * Number of records to extract<br>
	 * <br>
	 * -1 to extract them all, by default it is 1000
	 */
	private Integer limit;

	/**
	 * Orders that contain at least one of the specified tags will be extracted<br>
	 * <br>
	 * For example: ["tag1", "tag2"]
	 */
	private Collection<String> tags;

	public OrderRequest() {

	}

	public Date getStartDate() throws ParseException {
		return new SimpleDateFormat(orderRequestDatePattern).parse(startDate);
	}

	public OrderRequest startDate(Date startDate) {
		this.startDate = new SimpleDateFormat(orderRequestDatePattern).format(startDate);
		return this;
	}

	public Date getEndDate() throws ParseException {
		return new SimpleDateFormat(orderRequestDatePattern).parse(endDate);
	}

	public OrderRequest endDate(Date endDate) {
		this.endDate = new SimpleDateFormat(orderRequestDatePattern).format(endDate);
		return this;
	}

	public Date getStartModified() throws ParseException {
		return new SimpleDateFormat(orderRequestDatePattern).parse(startModified);
	}

	public OrderRequest startModified(Date startModified) {
		this.startModified = new SimpleDateFormat(orderRequestDatePattern).format(startModified);
		return this;
	}

	public Date getEndModified() throws ParseException {
		return new SimpleDateFormat(orderRequestDatePattern).parse(endModified);
	}

	public OrderRequest endModified(Date endModified) {
		this.endModified = new SimpleDateFormat(orderRequestDatePattern).format(endModified);
		return this;
	}

	public Collection<String> code() {
		if (code == null)
			code = new ArrayList<>();
		return code;
	}

	public OrderRequest setCode(Collection<String> code) {
		this.code = code;
		return this;
	}

	public String getFormat() {
		return format;
	}

	public OrderRequest format(String format) {
		this.format = format;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public OrderRequest status(String status) {
		this.status = status;
		return this;
	}

	public String getColumnSeparator() {
		return columnSeparator;
	}

	public OrderRequest columnSeparator(String columnSeparator) {
		this.columnSeparator = columnSeparator;
		return this;
	}

	public Boolean getWriteHeading() {
		return writeHeading;
	}

	public OrderRequest writeHeading(Boolean writeHeading) {
		this.writeHeading = writeHeading;
		return this;
	}

	public Integer getOffset() {
		return offset;
	}

	public OrderRequest offset(Integer offset) {
		this.offset = offset;
		return this;
	}

	public Integer getLimit() {
		return limit;
	}

	public OrderRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public Collection<String> tags() {
		if (tags == null)
			tags = new ArrayList<>();
		return tags;
	}

	public OrderRequest setTags(Collection<String> tags) {
		this.tags = tags;
		return this;
	}

}
