package com.orastays.flightserver.helper;

public final class FlightConstant {

	private FlightConstant() {}

	public static final String COMMON_SUCCESS_CODE = "common.success.code";
	public static final String COMMON_SUCCESS_MESSAGE = "common.success.message";
	public static final String OUTGOING = "RESPONSE";
	public static final String INCOMING = "REQUEST";
	public static final String COMMON_ERROR_CODE = "common.error.code"; 
	public static final String COMMON_ERROR_MESSAGE = "common.error.message";
	public static final String FOR_ROW = "for ROW";
	public static final String STATUS = "status";
	public static final String LANGUAGEID = "languageId";

	//Flight Search and Pricing Details
	public static final String ONEWAY = "O";
	public static final String ROUNDTRIP = "R";
	public static final String MULTICITY = "M";
	public static final String DOM_TENANT_NAME = "b2bdomapi";
	public static final String INT_TENANT_NAME = "b2bintapi";
	public static final String UNIQUE = "1536664674033";
	public static final String ISSR = "false";
	public static final String BPC = "false";
	public static final int VARIATION = 0;
	public static final String VIEW_NAME = "normal";
	public static final int MAX_TRAVELLERS = 9;
	public static final String SEGMENTS_ONE_WAY = "1";
	public static final String SEGMENTS_ROUND_TRIP = "2";
	public static final String SEGMENTS_MULTICITY = "3";
	public static final String REQUEST_MODE = "Instant";

	//Booking
	public static final String CHANNEL = "b2b";
	public static final String PRODUCT = "flight";
	public static final boolean IS_PARTIAL = false;
	public static final String EBS_ACCOUNTID = "1026";
	public static final String MO_PROFILE_TYPE = "CASH";
	//Booking UserParams
	public static final String ADTL_EMAIL = "dipankar@orastays.com";
	public static final String ADTL_MOBILE = "9836666918";
	public static final String ADTL_MOBILE_ISD = "91";
	public static final String EMAIL = "akshay@orastays.com";
	public static final String MOBILE = "9742729028";
	public static final String USER_ID = "21975";
	public static final String FIRST_NAME = "Akshay";
	public static final String LAST_NAME = "Ball";
	
	// cashfree constants
	public static final String appId = "appId";
	public static final String secretKey = "secretKey";
	public static final String orderId = "orderId";
	public static final String orderAmount = "orderAmount";
	public static final String orderCurrency = "orderCurrency";
	public static final String customerEmail = "customerEmail";
	public static final String customerName = "customerName";
	public static final String customerPhone = "customerPhone";
	public static final String returnUrl = "returnUrl";
	public static final String notifyUrl = "notifyUrl";
	
	public static final String txStatus = "txStatus";
	public static final String referenceId = "referenceId";
	public static final String paymentMode = "paymentMode";
	public static final String txTime = "txTime";
	public static final String txMsg = "txMsg";
	public static final String signature = "signature";
	
	// cashfreeapi status
	public static final String MODE_CASHLESS = "cashless";
	public static final String CASHFREE_OK = "OK";
	public static final String CASHFREE_ERROR = "ERROR";

	// gateways
	public static final String CASHFREE = "cashfree";

	//payment status cashfree
	public static final String SUCCESS = "SUCCESS";
	public static final String FLAGGED = "FLAGGED";
	public static final String PENDING = "PENDING";
	public static final String FAILED = "FAILED";
	public static final String CANCELLED = "CANCELLED";
	
	//Booking Status Constants
	public static final String BEFORE_PAYMENT = "BEFORE_PAYMENT";
	public static final String PAYMENT_CALLED = "PAYMENT_CALLED";
	public static final String PAYMENT_SUCCESS = "PAYMENT_SUCCESS";
	public static final String BOOKING_CALLED = "BOOKING_CALLED";
	public static final String BOOKING_SUCCESS = "BOOKING_SUCCESS";
}
