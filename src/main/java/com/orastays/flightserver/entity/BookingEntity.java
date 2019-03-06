/**
 * @author Ora Dev
 */
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_booking")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class BookingEntity extends CommonEntity {

	private static final long serialVersionUID = 6715453926945816673L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	@JsonProperty("bookingId")
	private Long bookingId;

	@Column(name = "ora_booking_id")
	@JsonProperty("oraBookingId")
	private String oraBookingId;

	@Column(name = "user_id")
	@JsonProperty("userId")
	private Long userId;
	
	@Column(name = "progress")
	@JsonProperty("progress")
	private String progress;
	
	@Column(name = "pricing_id")
	@JsonProperty("pricingId")
	private String pricingId;
	
	@Column(name = "super_pnr")
	@JsonProperty("superPnr")
	private String superPnr;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "rvJson_id", nullable = false)
	@JsonProperty("reviewJson")
	public ReviewJsonEntity reviewJsonEntity;
	
	@Column(name = "base_fare")
	@JsonProperty("baseFare")
	private String baseFare;
	
	@Column(name = "fuel_surcharges")
	@JsonProperty("fuelSurcharges")
	private String fuelSurcharges;

	@Column(name = "other_charges")
	@JsonProperty("otherCharges")
	private String otherCharges;

	@Column(name = "yatra_gst")
	@JsonProperty("yatraGst")
	private String yatraGst;

	@Column(name = "passenger_fee")
	@JsonProperty("passengerFee")
	private String passengerFee;

	@Column(name = "user_dev_fee")
	@JsonProperty("userDevFee")
	private String userDevFee;

	@Column(name = "booking_fee")
	@JsonProperty("bookingFee")
	private String bookingFee;
	
	@Column(name = "igst")
    @JsonProperty("igst")
    private String igst;

	@Column(name = "total_fare")
    @JsonProperty("totalFare")
    private String totalFare;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinColumn(name = "convenience_id", nullable = false)
    @JsonProperty("conveniences")
    private ConvenienceEntity convenienceEntity;
	
	@Column(name = "total_fare_with_convenience")
    @JsonProperty("totalFareWithConvenience")
    private String totalFareWithConvenience;
	
	@Column(name = "failure_url")
    @JsonProperty("failureURL")
    private String failureURL;
	
	@Column(name = "success_url")
    @JsonProperty("successURL")
    private String successURL;
	
	@Column(name = "ora_commission")
    @JsonProperty("oraCommission")
    private String oraCommission;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinColumn(name = "gateway_id", nullable = false)
    @JsonProperty("gateway")
    private GatewayEntity gatewayEntity;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookingEntity", cascade = { CascadeType.ALL })
	@JsonProperty("bookingVsPayments")
	private List<BookingVsPaymentEntity> bookingVsPaymentEntities;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bookingEntity", cascade = { CascadeType.ALL })
	@JsonProperty("cancellations")
	private CancellationEntity cancellationEntity;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookingEntity", cascade = { CascadeType.ALL })
	@JsonProperty("bookingVsFlights")
	private List<BookingVsFlightEntity> bookingVsFlightEntities;
	
	@Override
	public String toString() {
		return Long.toString(bookingId);
	}
}