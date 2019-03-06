package com.orastays.flightserver.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class FlightPriceModel extends CommonModel {
	
	@JsonProperty("tenantName")
	private String tenantName;
	
	@JsonProperty("searchId")
	private String searchId;
	
	@JsonProperty("msid")
	private String msid;
	
	@JsonProperty("requestMode")
	private String requestMode;
	
	@JsonProperty("supplierCode")
	private String supplierCode;
	
	@JsonProperty("flightId")
	private String flightId;	
	
	@JsonProperty("flightPrice")
	private String flightPrice;
	
	@JsonProperty("origin")
	private String origin;
	
	@JsonProperty("destination")
	private String destination;
}
