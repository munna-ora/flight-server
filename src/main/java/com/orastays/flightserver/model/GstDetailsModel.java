package com.orastays.flightserver.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class GstDetailsModel extends CommonModel {

	public String gstState;
	public String gstMobileIsd;
	public String gstNumber;
	public String gstCompanyName;
	public String gstCompanyAddress;
	public String gstCity;
	public String gstPinCode;
	public String gstEmailId;
	public String gstMobileNo;
}
