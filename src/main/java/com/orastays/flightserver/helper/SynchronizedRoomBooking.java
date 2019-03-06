package com.orastays.flightserver.helper;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orastays.flightserver.constants.PaymentStatus;
import com.orastays.flightserver.constants.Status;
import com.orastays.flightserver.dao.BookingDAO;
import com.orastays.flightserver.dao.BookingVsPaymentDAO;
import com.orastays.flightserver.entity.BookingEntity;
import com.orastays.flightserver.entity.BookingVsPaymentEntity;
import com.orastays.flightserver.entity.GatewayEntity;
import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.model.BookingModel;
import com.orastays.flightserver.model.PaymentModel;
import com.orastays.flightserver.service.BookingVsPaymentService;
import com.orastays.flightserver.service.GatewayService;

@Component
public class SynchronizedRoomBooking {

	private static final Logger logger = LogManager.getLogger(SynchronizedRoomBooking.class);

	@Autowired
	protected BookingVsPaymentService bookingVsPaymentService;

	@Autowired
	protected BookingDAO bookingDAO;

	@Autowired
	protected BookingVsPaymentDAO bookingVsPaymentDAO;

	@Autowired
	protected GatewayService gatewayService;

	@Autowired
	protected CashFreeApi cashFreeApi;

	@Autowired
	protected MessageUtil messageUtil;


	public PaymentModel bookRoomForCashLessPayments(BookingModel bm, BookingEntity be) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("bookRoomForCashLessPayments -- Start");
		}
		BookingVsPaymentEntity bookingVsPaymentEntity = new BookingVsPaymentEntity();
		bookingVsPaymentEntity.setBookingEntity(be);
		//bookingVsPaymentEntity.setCreatedBy(Long.parseLong(bm.getUserId()));
		bookingVsPaymentEntity.setCreatedDate(Util.getCurrentDateTime());
		bookingVsPaymentEntity.setOrderId("ORA_TRNS" + new Date().getTime());
		bookingVsPaymentEntity.setPercentage(Util.roundTo2Places(100.00)); // remove hardcode
		GatewayEntity gatewayEntity = gatewayService.getGatewayEntity(FlightConstant.MODE_CASHLESS);
		bookingVsPaymentEntity.setGatewayEntity(gatewayEntity);
		//bookingVsPaymentEntity.setOrderAmount(be.getGrandTotal());
		bookingVsPaymentEntity.setAmountPaid(String.valueOf(Status.ZERO.ordinal()));
		bookingVsPaymentEntity.setStatus(PaymentStatus.ACTIVE.ordinal());

		PaymentModel paymentModel = cashFreeApi.getPaymentLink(bm, be, bookingVsPaymentEntity);
		if (logger.isInfoEnabled()) {
			logger.info("bookRoomForCashLessPayments -- End");
		}
		return paymentModel;
	}
}
