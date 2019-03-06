package com.orastays.flightserver.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_params")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class UserParamsEntity extends CommonEntity {

	private static final long serialVersionUID = -757911543402600202L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_params_id")
	@JsonProperty("userParamsId")
	private Long userParamsId;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "addtl_contact_id", nullable = false)
	@JsonProperty("additionalContact")
    public AdditionalContactEntity additionalContactEntity;
	
	@Column(name = "email_id")
	@JsonProperty("emailId")
    public String emailId;
	
	@Column(name = "mobile_no")
	@JsonProperty("mobileNo")
    public String mobileNo;
	
	@Column(name = "user_id")
	@JsonProperty("userId")
    public String userId;
	
	@Column(name = "title")
	@JsonProperty("title")
    public String title;
	
	@Column(name = "first_name")
	@JsonProperty("firstName")
    public String firstName;
	
	@Column(name = "last_name")
	@JsonProperty("lastName")
    public String lastName;
	
	@Column(name = "mobile_no_ISD")
	@JsonProperty("mobileNoISD")
    public String mobileNoISD;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "userParamsEntity", cascade = { CascadeType.ALL })
	@JsonProperty("reviewJson")
	private ReviewJsonEntity reviewJsonEntity;
	
	@Override
	public String toString() {
		return Long.toString(userParamsId);
	}
}
