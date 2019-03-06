package com.orastays.flightserver.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_search_param")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SearchParameterEntity extends CommonEntity{

	private static final long serialVersionUID = -8811504329554043838L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "search_param_id")
	@JsonProperty("searchParamId")
	private Long searchParamId;

	@Column(name = "airport_code")
	@JsonProperty("airportCode")
	private String airportCode;

	@Column(name = "airport_name")
	@JsonProperty("airportName")
	private String airportName;

	@Column(name = "city_code")
	@JsonProperty("cityCode")
	private String cityCode;

	@Column(name = "city_name")
	@JsonProperty("cityName")
	private String cityName;

	@Column(name = "continent")
	@JsonProperty("continent")
	private String continent;

	@Column(name = "country_code")
	@JsonProperty("countryCode")
	private String countryCode;

	@Column(name = "country_name")
	@JsonProperty("countryName")
	private String countryName;

	@Column(name = "gmt")
	@JsonProperty("Gmt")
	private BigDecimal Gmt;
	
	@Column(name = "dst_start_date")
	@JsonProperty("DstStartDate")
	private String DstStartDate;
	
	@Column(name = "dst_valid")
	@JsonProperty("dstValid")
	private String dstValid;

	@Column(name = "gmt1")
	@JsonProperty("gmt1")
	private Long gmt1;
	
	@Column(name = "dst_mv_hour")
	@JsonProperty("dstMvHour")
	private String dstMvHour;
	
	@Column(name = "dst_end_date")
	@JsonProperty("dstEndDate")
	private String dstEndDate;
	
	@Column(name = "currency")
	@JsonProperty("currency")
	private String currency;
	
	@Override
	public String toString() {
		return Long.toString(searchParamId);

	}
}
