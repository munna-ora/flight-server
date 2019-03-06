package com.orastays.flightserver.service;

import org.springframework.stereotype.Service;

import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.model.BookingModel;
import com.orastays.flightserver.model.PaymentModel;

@Service
public interface BookingService {
	
	PaymentModel addBooking(BookingModel bookingModel) throws FormExceptions;
}
