package com.orastays.flightserver.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orastays.flightserver.entity.BookingVsFlightEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class BookingVsTravellerModel extends CommonModel {

	@JsonProperty("bookingVsTravellerId")
	private String bookingVsTravellerId;

	@JsonProperty("bookingVsFlight")
	private BookingVsFlightEntity bookingVsFlightEntity;
	
	@JsonProperty("passengerName")
	private String passengerName;
	
	@JsonProperty("passengerEmail")
	private String passengerEmail;

	@JsonProperty("passengerMobile")
	private String passengerMobile;
}
