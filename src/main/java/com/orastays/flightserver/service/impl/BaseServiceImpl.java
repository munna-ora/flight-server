package com.orastays.flightserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.orastays.flightserver.converter.SearchParameterConverter;
import com.orastays.flightserver.dao.SearchParameterDAO;
import com.orastays.flightserver.utils.BookingUtil;
import com.orastays.flightserver.validation.BaggageValidation;
import com.orastays.flightserver.validation.FareRulesValidation;
import com.orastays.flightserver.validation.FlightBookingValidation;
import com.orastays.flightserver.validation.FlightValidation;
import com.orastays.flightserver.validation.SeatValidation;

public abstract class BaseServiceImpl {

	@Value("${entitymanager.packagesToScan}")
	protected String entitymanagerPackagesToScan;
	
	@Autowired
	protected FlightValidation flightValidation;
	
	@Autowired
	protected FlightBookingValidation flightBookingValidation;
	
	@Autowired
	protected SearchParameterConverter searchParameterConverter;
	
	@Autowired
	protected SearchParameterDAO searchParameterDAO;
	
	@Autowired
	protected FareRulesValidation fareRulesValidation;
	
	@Autowired
	protected BaggageValidation baggageValidation;
	
	@Autowired
	protected SeatValidation seatValidation;
	
	@Autowired
	protected BookingUtil bookingUtil;
}
