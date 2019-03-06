package com.orastays.flightserver.service;

import java.util.List;

import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.model.FlightPriceModel;
import com.orastays.flightserver.model.FlightSearchModel;
import com.orastays.flightserver.model.SearchParameterModel;

public interface FlightService {

	List<SearchParameterModel> searchAirportDetails(String keyword) throws FormExceptions;
	
	String fetchOneWayFlights(FlightSearchModel flightSearchModel) throws FormExceptions;

	String fetchRoundTripFlights(FlightSearchModel flightSearchModel) throws FormExceptions;

	String fetchMultiCityFlights(FlightSearchModel flightSearchModel) throws FormExceptions;

	String fetchOneWayPricing(FlightPriceModel flightPriceModel) throws FormExceptions;

	String fetchRoundTripPricing(FlightPriceModel flightPriceModel) throws FormExceptions;

	String fetchMultiCityPricing(FlightPriceModel flightPriceModel) throws FormExceptions;
}