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
public class UserParamsModel extends CommonModel {

	@JsonProperty("userParamsId")
    private String userParamsId;
	
	@JsonProperty("additionalContact")
    private AdditionalContactModel additionalContactModel;
	
	@JsonProperty("emailId")
    private String emailId;
	
	@JsonProperty("mobileNo")
    private String mobileNo;
	
	@JsonProperty("userId")
    private String userId;
	
	@JsonProperty("title")
    private String title;
	
	@JsonProperty("firstName")
    private String firstName;
	
	@JsonProperty("lastName")
    private String lastName;
	
	@JsonProperty("mobileNoISD")
    private String mobileNoISD;
	
	@JsonProperty("reviewJson")
	private ReviewJsonModel reviewJsonModel;
}
