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
@Table(name = "global_param")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class GlobalParamsEntity extends CommonEntity {

	private static final long serialVersionUID = 8877351094145264679L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "global_params_id")
	@JsonProperty("globalParamsId")
	private Long globalParamsId;
	
	@Column(name = "pricing_id")
	@JsonProperty("pricingId")
	private String pricingId;
	
	@Column(name = "search_id")
	@JsonProperty("searchId")
	private String searchId;
	
	@Column(name = "super_pnr")
	@JsonProperty("superPnr")
	private String superPnr;

	@Column(name = "ftype")
	@JsonProperty("ftype")
	private String ftype;
	
	@Column(name = "org")
	@JsonProperty("org")
	private String org;
	
	@Column(name = "dest")
	@JsonProperty("dest")
	private String dest;

	@Column(name = "child_tenant")
	@JsonProperty("childTenant")
	private String childTenant;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "globalParamsEntity", cascade = { CascadeType.ALL })
	@JsonProperty("reviewJson")
	private ReviewJsonEntity reviewJsonEntity;
	
	@Override
	public String toString() {
		return Long.toString(globalParamsId);
	}
}
