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
public class TotalBreakupModel extends CommonModel {

	@JsonProperty("meals")
    public MealsModel mealsModel;
	
	@JsonProperty("baggage")
    public BaggageModel baggageModel;
	
	@JsonProperty("seats")
    public SeatsModel seatsModel;
	
	@JsonProperty("others")
    public OthersModel othersModel;
	
	@JsonProperty("insurance")
    public InsuranceModel insuranceModel;
	
	@JsonProperty("beingHuman")
    public BeingHumanModel beingHumanModel;
	
	@JsonProperty("markup")
    public MarkupModel markupModel;
}
