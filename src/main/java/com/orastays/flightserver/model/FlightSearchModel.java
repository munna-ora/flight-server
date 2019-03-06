package com.orastays.flightserver.model;

import java.util.List;

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
public class FlightSearchModel extends CommonModel {

	@JsonProperty("tenantName")
	private String tenantName;
	
	@JsonProperty("tripType")
	private String tripType;
	
	/*@JsonProperty("noOfSegments")
	private String noOfSegments;*/
	
	@JsonProperty("arrival_date")
	private String arrivalDate;
	
	@JsonProperty("noOfAdults")
	private String noOfAdults;
	
	@JsonProperty("noOfChild")
	private String noOfChild;

	@JsonProperty("noOfInfants")
	private String noOfInfants;
	
	@JsonProperty("classType")
	private String classType;
	
	/*@JsonProperty("viewName")
	private String viewName;
	
	@JsonProperty("flexi")
	private String flexi;*/

	@JsonProperty("multiCities")
	List<MultiCityModel> multiCityModels;
}
