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
@Table(name = "traveller_details")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TravellerDetailsEntity extends CommonEntity {

	private static final long serialVersionUID = 5982154797739962894L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "title")
	@JsonProperty("title")
	public String title;
	
	@Column(name = "first_name")
	@JsonProperty("firstName")
	public String firstName;
	
	@Column(name = "middle_name")
	@JsonProperty("middleName")
	public String middleName;
	
	@Column(name = "last_name")
	@JsonProperty("lastName")
	public String lastName;
	
	@Column(name = "pax_class")
	@JsonProperty("paxClass")
	public String paxClass;
	
	@Column(name = "passenger_class")
	@JsonProperty("passengerClass")
	public String passengerClass;
	
	@Column(name = "date_of_birth")
	@JsonProperty("dateOfBirth")
	public String dateOfBirth;
	
	/*@Column(name = "id")
	@JsonProperty("id")
    public PassportModel passportModel;
	
	@Column(name = "id")
	@JsonProperty("id")
    public FrequentFlyerModel frequentFlyerModel;*/
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "travellerDetailsEntity", cascade = { CascadeType.ALL })
	@JsonProperty("travellerParams")
	private TravellerParamEntity travellerParamEntity;
	
	@Override
	public String toString() {
		return Long.toString(id);
	}
}
