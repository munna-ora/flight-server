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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "traveller_param")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TravellerParamEntity extends CommonEntity {

	private static final long serialVersionUID = -6668338632744442960L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pax_id")
	@JsonProperty("paxID")
	private Long paxID;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "id", nullable = false)
	@JsonProperty("travellerDetails")
	public TravellerDetailsEntity travellerDetailsEntity;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "ssrDetailsId", nullable = false)
	@JsonProperty("ssrDetails")
	public SsrDetailsEntity ssrDetailsEntity;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "rvJson_id", nullable = false)
	private ReviewJsonEntity reviewJsonEntity;
	
	@Override
	public String toString() {
		return Long.toString(paxID);
	}
}
