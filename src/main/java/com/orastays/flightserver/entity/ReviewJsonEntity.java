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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review_json")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ReviewJsonEntity extends CommonEntity {

	private static final long serialVersionUID = -4747023288912727433L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rvJson_id")
	@JsonProperty("rvJsonId")
	private Long rvJsonId;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "global_params_id", nullable = false)
	@JsonProperty("globalParams")
	private GlobalParamsEntity globalParamsEntity;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "user_params_id", nullable = false)
	@JsonProperty("userParams")
	private UserParamsEntity userParamsEntity;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reviewJsonEntity", cascade = { CascadeType.ALL })
	@JsonProperty("travellerParams")
	private List<TravellerParamEntity> travellerParamEntities;
	
	/*@OneToOne(fetch = FetchType.LAZY, mappedBy = "reviewJsonEntity", cascade = { CascadeType.ALL })
	@JsonProperty("bookings")
	private BookingEntity bookingEntity;*/
	
	@Override
	public String toString() {
		return Long.toString(rvJsonId);
	}
}
