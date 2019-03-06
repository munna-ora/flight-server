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
public class BookingVsFlightModel extends CommonModel {

	@JsonProperty("bookingVsFlightId")
	private String bookingVsFlightId;

	@JsonProperty("pnrNumber")
	private String pnrNumber;
	
	@JsonProperty("journeyDate")
	private String journeyDate;

	@JsonProperty("origin")
	private String origin;

	@JsonProperty("destination")
	private String destination;
	
	@JsonProperty("fltSchedule")
	private String fltSchedule;

	@JsonProperty("flightClass")
	private String flightClass;

	@JsonProperty("airlineCode")
	private String airlineCode;
	
	@JsonProperty("airlineNumber")
	private String airlineNumber;
	
	@JsonProperty("flightNumber")
	private String flightNumber;

	@JsonProperty("bookings")
	private BookingModel bookingModel;

	/*@JsonProperty("cancellationVsRooms")
	private CancellationVsRoomModel cancellationVsRoomModel;*/
	
	@JsonProperty("bookingVsTravellers")
	private List<BookingVsTravellerModel> bookingVsTravellerModels;
	
}
