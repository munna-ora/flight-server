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
@Table(name = "user_addtl_contact")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AdditionalContactEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addtl_contact_id")
	@JsonProperty("addtlContactId")
	private Long addtlContactId;
	
	@Column(name = "email")
	@JsonProperty("email")
	public String email;
	
	@Column(name = "mobile")
	@JsonProperty("mobile")
	public String mobile;
	
	@Column(name = "mobileISD")
	@JsonProperty("mobileISD")
	public String mobileISD;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "additionalContactEntity", cascade = { CascadeType.ALL })
	@JsonProperty("userParams")
	private UserParamsEntity userParamsEntity;
	
	@Override
	public String toString() {
		return Long.toString(addtlContactId);
	}
}
