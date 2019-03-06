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
public class BookingModel extends CommonModel {

	@JsonProperty("bookingId")
	private String bookingId;

	@JsonProperty("oraBookingId")
	private String oraBookingId;

	@JsonProperty("userId")
	private Long userId;
	
	@JsonProperty("progress")
	private String progress;
	
	@JsonProperty("pricingId")
	private String pricingId;
	
	@JsonProperty("superPnr")
	private String superPnr;
	
	@JsonProperty("reviewJson")
	public ReviewJsonModel reviewJsonModel;
	
	@JsonProperty("baseFare")
	private String baseFare;
	
	@JsonProperty("fuelSurcharges")
	private String fuelSurcharges;

	@JsonProperty("otherCharges")
	private String otherCharges;

	@JsonProperty("yatraGst")
	private String yatraGst;

	@JsonProperty("passengerFee")
	private String passengerFee;

	@JsonProperty("userDevFee")
	private String userDevFee;

	@JsonProperty("bookingFee")
	private String bookingFee;
	
    @JsonProperty("igst")
    private String igst;

    @JsonProperty("totalFare")
    private String totalFare;

    @JsonProperty("conveniences")
    private ConvenienceModel convenienceModel;
	
    @JsonProperty("totalFareWithConvenience")
    private String totalFareWithConvenience;
	
    @JsonProperty("failureURL")
    private String failureURL;
	
    @JsonProperty("successURL")
    private String successURL;
	
    @JsonProperty("oraCommission")
    private String oraCommission;
	
    @JsonProperty("gateway")
    private GatewayModel gatewayModel;
	
	@JsonProperty("bookingVsPayments")
	private List<BookingVsPaymentModel> bookingVsPaymentModels;
	
	@JsonProperty("cancellations")
	private CancellationModel cancellationModel;
	
	@JsonProperty("bookingVsFlights")
	private List<BookingVsFlightModel> bookingVsFlightModels;
}



