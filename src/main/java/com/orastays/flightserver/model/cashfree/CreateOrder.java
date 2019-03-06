package com.orastays.flightserver.model.cashfree;

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
public class CreateOrder {
	private String appId;
	private String secretKey;
	private String orderId;
	private String orderAmount;
	private String orderCurrency;
	private String orderNote;
	private String customerEmail;
	private String customerName;
	private String customerPhone;
	private String returnUrl;
	private String notifyUrl;
}
