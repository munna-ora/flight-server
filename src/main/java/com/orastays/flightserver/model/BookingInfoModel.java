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
public class BookingInfoModel extends CommonModel {

	
	@JsonProperty("bookingInfoId")
	private String bookingInfoId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("address")
	private String address;

	@JsonProperty("companyName")
	private String companyName;

	@JsonProperty("gstin")
	private String gstin;

	@JsonProperty("mobile")
	private String mobile;

	@JsonProperty("email")
	private String email;

	@JsonProperty("bookings")
	private BookingModel bookingModel;

}
