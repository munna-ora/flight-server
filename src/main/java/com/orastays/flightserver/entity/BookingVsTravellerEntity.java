package com.orastays.flightserver.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "booking_vs_traveller")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class BookingVsTravellerEntity extends CommonEntity {

	private static final long serialVersionUID = -2670528661029242715L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_vs_traveller_id")
	@JsonProperty("bookingVsTravellerId")
	private Long bookingVsTravellerId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "booking_vs_flight_id", nullable = false)
	@JsonProperty("bookingVsFlight")
	private BookingVsFlightEntity bookingVsFlightEntity;
	
	@Column(name = "passenger_name")
	@JsonProperty("passengerName")
	private String passengerName;
	
	@Column(name = "passenger_email")
	@JsonProperty("passengerEmail")
	private String passengerEmail;

	@Column(name = "passenger_mobile")
	@JsonProperty("passengerMobile")
	private String passengerMobile;
	
	@Override
	public String toString() {
		return Long.toString(bookingVsTravellerId);
	}
}
