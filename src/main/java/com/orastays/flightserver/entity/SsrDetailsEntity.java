package com.orastays.flightserver.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ssr_details")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SsrDetailsEntity extends CommonEntity {

	private static final long serialVersionUID = -2611780840088480501L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ssr_details_id")
	@JsonProperty("ssrDetailsId")
	private Long ssrDetailsId;
	
	/*@JsonProperty("ssrMealDetails")
    public List<SsrMealDetailsModel> ssrMealDetailsModels;
	
	@JsonProperty("ssrBaggageDetails")
    public List<SsrBaggageDetailsModel> SsrBaggageDetailsModels;
	
	@JsonProperty("ssrSeatDetails")
    public List<SsrSeatDetailsModel> ssrSeatDetailsModel;
	
	@JsonProperty("ssrOtherDetails")
    public List<SsrOtherDetailsModel> ssrOtherDetailsModels;*/
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "ssrDetailsEntity", cascade = { CascadeType.ALL })
	@JsonProperty("travellerParams")
	private TravellerParamEntity travellerParamEntity;
	
	@Override
	public String toString() {
		return Long.toString(ssrDetailsId);
	}
	
}
