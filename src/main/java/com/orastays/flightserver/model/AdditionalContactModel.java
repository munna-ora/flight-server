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
public class AdditionalContactModel extends CommonModel {

	@JsonProperty("email")
	public String email;
	
	@JsonProperty("mobile")
	public String mobile;
	
	@JsonProperty("mobileISD")
	public String mobileISD;
	
	@JsonProperty("userParams")
	private UserParamsModel userParamsModel;
}
