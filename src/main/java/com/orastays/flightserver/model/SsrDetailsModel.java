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
public class SsrDetailsModel /*extends CommonModel*/ {

	@JsonProperty("ssrDetailsId")
	private String ssrDetailsId;
	
	@JsonProperty("ssrMealDetails")
    private List<SsrMealDetailsModel> ssrMealDetailsModels;
	
	@JsonProperty("ssrBaggageDetails")
    private List<SsrBaggageDetailsModel> SsrBaggageDetailsModels;
	
	@JsonProperty("ssrSeatDetails")
    private List<SsrSeatDetailsModel> ssrSeatDetailsModel;
	
	@JsonProperty("ssrOtherDetails")
    private List<SsrOtherDetailsModel> ssrOtherDetailsModels;
	
	@JsonProperty("travellerParams")
	private TravellerParamModel travellerParamModel;
	
}
