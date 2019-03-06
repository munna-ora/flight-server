package com.orastays.flightserver.controller;

import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.helper.FlightConstant;
import com.orastays.flightserver.helper.Util;
import com.orastays.flightserver.model.BookingModel;
import com.orastays.flightserver.model.FlightBookingModel;
import com.orastays.flightserver.model.PaymentModel;
import com.orastays.flightserver.model.ResponseModel;
import com.orastays.flightserver.service.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@Api(value = "Flight Booking", tags = "Flight Booking")
public class FlightBookingController extends BaseController {
	
	private static final Logger logger = LogManager.getLogger(FlightBookingController.class);	
	
	@Autowired
	protected BookingService bookingService;
	
	@PostMapping(value = "/book-flights", produces = "application/json")
	@ApiOperation(value = "Book Flights", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 1721, message = "Please provide input parameters!!"),
			@ApiResponse(code = 1722, message = "Please provide pricing Id!!"),
			@ApiResponse(code = 1723, message = "Please provide superPnr!!"),
			@ApiResponse(code = 1724, message = "Please provide review json details!!"),
			@ApiResponse(code = 1725, message = "Please provide parameters for reviewJson!!"),
			@ApiResponse(code = 1726, message = "Please provide search Id!!"),
			@ApiResponse(code = 1727, message = "Please provide traveller details!!") })
	public ResponseEntity<ResponseModel> bookFlights(@RequestBody FlightBookingModel flightBookingModel) {
		
		if (logger.isInfoEnabled()) {
			logger.info("bookFlights -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(flightBookingModel, FlightConstant.INCOMING, "Book Flights", request);

		try {
			//List<FlightBookingModel> flightBookingModels= flightBookingService.bookFlights(flightBookingModel);
			String flightBookingModels= flightBookingService.bookFlights(flightBookingModel);
			responseModel.setResponseBody(flightBookingModels);
			responseModel.setResponseCode(messageUtil.getBundle(FlightConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(FlightConstant.COMMON_SUCCESS_MESSAGE));
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Book Flights -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Book Flights -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(FlightConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(FlightConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, FlightConstant.OUTGOING, "Book Flights", request);

		if (logger.isInfoEnabled()) {
			logger.info("bookFlights -- END");
		}

		if (responseModel.getResponseCode().equals(messageUtil.getBundle(FlightConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/add-booking", produces = "application/json")
	@ApiOperation(value = "Add Booking", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 1721, message = "Please provide input parameters!!"),
			@ApiResponse(code = 1722, message = "Please provide pricing Id!!"),
			@ApiResponse(code = 1723, message = "Please provide superPnr!!"),
			@ApiResponse(code = 1724, message = "Please provide review json details!!"),
			@ApiResponse(code = 1725, message = "Please provide parameters for reviewJson!!"),
			@ApiResponse(code = 1712, message = "Please provide search Id!!"),
			@ApiResponse(code = 1727, message = "Please provide traveller details!!") })

	public ResponseEntity<ResponseModel> addBooking(@RequestBody BookingModel bookingModel) {

		logger.info("addBooking -- START");

		ResponseModel responseModel = new ResponseModel();
		Util.printLog(bookingModel, FlightConstant.INCOMING, "add-booking", request);
		try {
			PaymentModel paymentModel = bookingService.addBooking(bookingModel);
			responseModel.setResponseBody(paymentModel);
			responseModel.setResponseCode(commonSuccessCode);
			responseModel.setResponseMessage(commonSuccessMessage);
		} catch (FormExceptions fe) {
			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in add-booking -- {}", Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Add Booking -- {}", Util.errorToString(e));
			}
			responseModel.setResponseCode(commonErrorCode);
			responseModel.setResponseMessage(commonErrorMessage);
		}

		Util.printLog(responseModel, FlightConstant.OUTGOING, "add-booking", request);

		logger.info("addBooking -- END");

		if (responseModel.getResponseCode().equals(commonSuccessCode)) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/view-booking-list", produces = "application/json")
	@ApiOperation(value = "View Booking List", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!")})
	public ResponseEntity<ResponseModel> fetchBookingList(@RequestBody FlightBookingModel flightBookingModel) {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchBookingList -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(flightBookingModel, FlightConstant.INCOMING, "View Booking List", request);
		
		try {
			String response = flightBookingService.fetchBookingList(flightBookingModel);
			responseModel.setResponseBody(response);
			responseModel.setResponseCode(messageUtil.getBundle(FlightConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(FlightConstant.COMMON_SUCCESS_MESSAGE));
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in View Booking List -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in View Booking List -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(FlightConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(FlightConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, FlightConstant.OUTGOING, "View Booking List", request);

		if (logger.isInfoEnabled()) {
			logger.info("fetchBookingList -- END");
		}

		if (responseModel.getResponseCode().equals(messageUtil.getBundle(FlightConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}	
}
