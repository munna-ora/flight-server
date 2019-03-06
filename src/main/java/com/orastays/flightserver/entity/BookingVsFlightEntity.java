package com.orastays.flightserver.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "booking_vs_flight")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class BookingVsFlightEntity extends CommonEntity {

	private static final long serialVersionUID = 6334466440815813007L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_vs_flight_id")
	@JsonProperty("bookingVsFlightId")
	private Long bookingVsFlightId;

	@Column(name = "pnr_number")
	@JsonProperty("pnrNumber")
	private String pnrNumber;
	
	@Column(name = "journey_date")
	@JsonProperty("journeyDate")
	private String journeyDate;

	@Column(name = "origin")
	@JsonProperty("origin")
	private String origin;

	@Column(name = "destination")
	@JsonProperty("destination")
	private String destination;
	
	@Column(name = "flt_schedule")
	@JsonProperty("fltSchedule")
	private String fltSchedule;

	@Column(name = "flight_class")
	@JsonProperty("flightClass")
	private String flightClass;

	@Column(name = "airline_code")
	@JsonProperty("airlineCode")
	private String airlineCode;
	
	@Column(name = "airline_number")
	@JsonProperty("airlineNumber")
	private String airlineNumber;
	
	@Column(name = "flight_number")
	@JsonProperty("flightNumber")
	private String flightNumber;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "booking_id", nullable = false)
	@JsonProperty("bookings")
	private BookingEntity bookingEntity;
	
	/*@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "bvp_id", nullable = false)
	@JsonProperty("bookingVsFlight")
	private BookingVsFlightEntity bookingVsFlightEntity;*/
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookingVsFlightEntity", cascade = { CascadeType.ALL })
	@JsonProperty("bookingVsTravellers")
	private List<BookingVsTravellerEntity> bookingVsTravellerEntities;
	
	@Override
	public String toString() {
		return Long.toString(bookingVsFlightId);
	}
}
