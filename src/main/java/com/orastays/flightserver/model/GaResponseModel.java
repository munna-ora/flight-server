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
public class GaResponseModel extends CommonModel {
	
	@JsonProperty("gaResponseId")
	private Long gaResponseId;

	/*@JsonProperty("datas")
	public List<DataModel> dataModels;*/
	
	@JsonProperty("action")
	public String action;
	
	@JsonProperty("actionData")
	public String actionData;
	
	/*@JsonProperty("actionObj")
	public ActionObjModel actionObjModel;*/
	
	@JsonProperty("event")
	public String event;
}
