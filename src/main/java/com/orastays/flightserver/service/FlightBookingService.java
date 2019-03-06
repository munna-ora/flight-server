package com.orastays.flightserver.service;

import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.model.FlightBookingModel;

public interface FlightBookingService {

	String fetchBookingList(FlightBookingModel flightBookingModel) throws FormExceptions;

	String bookFlights(FlightBookingModel flightBookingModel) throws FormExceptions;
}