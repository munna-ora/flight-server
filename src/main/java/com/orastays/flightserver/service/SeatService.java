package com.orastays.flightserver.service;

import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.model.SeatModel;

public interface SeatService {

	String getSeatDetails(SeatModel seatModel) throws FormExceptions;

}
