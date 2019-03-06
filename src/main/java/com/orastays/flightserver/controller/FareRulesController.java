package com.orastays.flightserver.controller;

import java.util.List;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.orastays.flightserver.model.FareRulesModel;
import com.orastays.flightserver.model.ResponseModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@Api(value = "Fare Rules", tags = "Fare Rules")
public class FareRulesController extends BaseController {
	
	private static final Logger logger = LogManager.getLogger(FareRulesController.class);	
	
	@PostMapping(value = "/fare-rules-dom", produces = "application/json")
	@ApiOperation(value = "Fare Rules Domestic", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!") })
	public ResponseEntity<ResponseModel> fareRulesDom(@RequestBody FareRulesModel fareRulesModel) {
		
		if (logger.isInfoEnabled()) {
			logger.info("fareRulesDom -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(fareRulesModel, FlightConstant.INCOMING, "Fare Rules Domestic", request);

		try {
			List<FareRulesModel> fareRulesModels= fareRulesService.fareRulesDom(fareRulesModel);
			responseModel.setResponseBody(fareRulesModels);
			responseModel.setResponseCode(messageUtil.getBundle(FlightConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(FlightConstant.COMMON_SUCCESS_MESSAGE));
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Fare Rules Domestic -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Fare Rules Domestic -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(FlightConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(FlightConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, FlightConstant.OUTGOING, "Fare Rules Domestic", request);

		if (logger.isInfoEnabled()) {
			logger.info("fareRulesDom -- END");
		}

		if (responseModel.getResponseCode().equals(messageUtil.getBundle(FlightConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}	
	
	@PostMapping(value = "/fare-rules-int", produces = "application/json")
	@ApiOperation(value = "Fare Rules International", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!") })
	public ResponseEntity<ResponseModel> fareRulesInt(@RequestBody FareRulesModel fareRulesModel) {
		
		if (logger.isInfoEnabled()) {
			logger.info("fareRulesInt -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(fareRulesModel, FlightConstant.INCOMING, "Fare Rules International", request);

		try {
			List<FareRulesModel> fareRulesModels= fareRulesService.fareRulesInt(fareRulesModel);
			responseModel.setResponseBody(fareRulesModels);
			responseModel.setResponseCode(messageUtil.getBundle(FlightConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(FlightConstant.COMMON_SUCCESS_MESSAGE));
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Fare Rules International -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Fare Rules International -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(FlightConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(FlightConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, FlightConstant.OUTGOING, "Fare Rules International", request);

		if (logger.isInfoEnabled()) {
			logger.info("fareRulesInt -- END");
		}

		if (responseModel.getResponseCode().equals(messageUtil.getBundle(FlightConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
}
