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
public class SeatModel extends CommonModel {

	@JsonProperty("cabin")
	private String cabin;
	
	@JsonProperty("departureDateTime")
	private String departureDateTime;
	
	@JsonProperty("flightNumber")
	private String flightNumber;
	
	@JsonProperty("resBookDesigCode")
	private String resBookDesigCode;
	
	@JsonProperty("depLocationCode")
	private String depLocationCode;
	
	@JsonProperty("arrivalLocationCode")
	private String arrivalLocationCode;
	
	@JsonProperty("oac")
	private String oac;
	
	@JsonProperty("pid")
	private String pid;
	
	@JsonProperty("superPnr")
	private String superPnr;
}
