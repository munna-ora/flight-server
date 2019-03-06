package com.orastays.flightserver.model;

import java.math.BigDecimal;

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
public class SearchParameterModel extends CommonModel {

	@JsonProperty("searchParamId")
	private String searchParamId;

	@JsonProperty("airportCode")
	private String airportCode;

	@JsonProperty("airportName")
	private String airportName;

	@JsonProperty("cityCode")
	private String cityCode;

	@JsonProperty("cityName")
	private String cityName;

	@JsonProperty("continent")
	private String continent;

	@JsonProperty("countryCode")
	private String countryCode;

	@JsonProperty("countryName")
	private String countryName;

	@JsonProperty("Gmt")
	private BigDecimal Gmt;
	
	@JsonProperty("DstStartDate")
	private String DstStartDate;
	
	@JsonProperty("dstValid")
	private String dstValid;

	@JsonProperty("gmt1")
	private Long gmt1;
	
	@JsonProperty("dstMvHour")
	private String dstMvHour;
	
	@JsonProperty("dstEndDate")
	private String dstEndDate;
	
	@JsonProperty("currency")
	private String currency;
}
