package com.orastays.flightserver.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.orastays.flightserver.converter.BookingConverter;
import com.orastays.flightserver.converter.BookingInfoConverter;
import com.orastays.flightserver.dao.BookingDAO;
import com.orastays.flightserver.dao.BookingInfoDAO;
import com.orastays.flightserver.dao.ConvenienceDAO;
import com.orastays.flightserver.helper.CashFreeApi;
import com.orastays.flightserver.service.ConvenienceService;
import com.orastays.flightserver.service.GatewayService;

public class BaseUtil {
	@Autowired
	protected BookingConverter bookingConverter;
	
	@Autowired
	protected BookingDAO bookingDAO;
	
	@Autowired
	protected ConvenienceDAO convenienceDAO;
	
	@Autowired
	protected BookingInfoConverter bookingInfoConverter;
	
	@Autowired
	protected BookingInfoDAO bookingInfoDAO;
	
	@Autowired
	protected ConvenienceService convenienceService;
	
	@Value("${generic.error.code}")
	protected String genericErrorCode;
	
	@Value("${generic.error.message}")
	protected String genericErrorMessage;
	
	@Autowired
	protected CashFreeApi cashFreeApi;
	
	@Autowired
	protected GatewayService gatewayService;
}
