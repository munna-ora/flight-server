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
public class TravellerDetailsModel /*extends CommonModel*/ {

	@JsonProperty("id")
	public Integer id;
	
	@JsonProperty("title")
	public String title;
	
	@JsonProperty("firstName")
	public String firstName;
	
	@JsonProperty("middleName")
	public String middleName;
	
	@JsonProperty("lastName")
	public String lastName;
	
	@JsonProperty("paxClass")
	public String paxClass;
	
	@JsonProperty("passengerClass")
	public String passengerClass;
	
	@JsonProperty("dateOfBirth")
	public String dateOfBirth;
	
	@JsonProperty("passport")
    public PassportModel passportModel;
	
	@JsonProperty("frequentFlyer")
    public FrequentFlyerModel frequentFlyerModel;
	
	@JsonProperty("travellerParams")
	private TravellerParamModel travellerParamModel;
}
