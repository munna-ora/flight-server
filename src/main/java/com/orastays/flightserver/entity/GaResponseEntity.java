/**
 * @author Ora Dev
 */
package com.orastays.flightserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ga_response")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class GaResponseEntity extends CommonEntity {

	private static final long serialVersionUID = -4123694097468197639L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gaResponseId")
	@JsonProperty("gaResponseId")
	private Long gaResponseId;

	/*@JsonProperty("datas")
	public List<DataModel> dataModels;*/
	
	@Column(name = "action")
	@JsonProperty("action")
	public String action;
	
	@Column(name = "action_data")
	@JsonProperty("actionData")
	public String actionData;
	
	
	/*@JsonProperty("actionObj")
	public ActionObjModel actionObjModel;*/
	
	@Column(name = "event")
	@JsonProperty("event")
	public String event;

	@Override
	public String toString() {
		return Long.toString(gaResponseId);
	}

}
