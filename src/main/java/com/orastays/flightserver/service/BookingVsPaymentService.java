package com.orastays.flightserver.service;

import com.orastays.flightserver.entity.BookingVsPaymentEntity;

public interface BookingVsPaymentService {
	BookingVsPaymentEntity getBookingVsPaymentEntityByOrderId(String orderId);
}
