package com.orastays.flightserver.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class MultiCityModel extends CommonModel{
	
	@JsonProperty("origin")
	private String origin;
	
	@JsonProperty("originCountry")
	private String originCountry;
	
	@JsonProperty("destination")
	private String destination;
	
	@JsonProperty("destinationCountry")
	private String destinationCountry;
	
	@JsonProperty("flightDepartDate")
	private String flightDepartDate;
}
