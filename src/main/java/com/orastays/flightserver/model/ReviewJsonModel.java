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
public class ReviewJsonModel extends CommonModel {

	@JsonProperty("rvJsonId")
	private String rvJsonId;
	
	@JsonProperty("globalParams")
	private GlobalParamsModel globalParamsModel;
	
	@JsonProperty("addOnParams")
	private List<AddOnParamsModel> addOnParamsModels;
	
	@JsonProperty("hotelCrossSellParams")
	private HotelCrossSellParamsModel hotelCrossSellParamsModel;
	
	@JsonProperty("productParams")
	private ProductParamsModel productParamsModel;
	
	@JsonProperty("promoParams")
	private PromoParamsModel promoParamsModel;
	
	@JsonProperty("userParams")
	private UserParamsModel userParamsModel;
	
	@JsonProperty("travellerParams")
	private List<TravellerParamModel> travellerParamModels;
	
	@JsonProperty("gstDetails")
	private GstDetailsModel gstDetailsModel;
	
	@JsonProperty("discountParams")
	private DiscountParamsModel discountParamsModels;
	
	@JsonProperty("totalBreakup")
	private TotalBreakupModel totalBreakupModel;
	
	@JsonProperty("tourCodes")
	private List<TourCodeModel> tourCodeModels;
	
	@JsonProperty("advancedPricing")
	private AdvancedPricingModel advancedPricingModel;
	
	@JsonProperty("upSellParam")
	private List<UpSellParamsModel> upSellParamsModel;
	
	@JsonProperty("gaResponse")
	private GaResponseModel gaResponseModel;
	
	/*@JsonProperty("bookings")
	private BookingModel bookingModel;*/
}
