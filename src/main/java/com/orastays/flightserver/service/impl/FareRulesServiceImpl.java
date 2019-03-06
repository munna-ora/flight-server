package com.orastays.flightserver.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.helper.MessageUtil;
import com.orastays.flightserver.model.FareRulesModel;
import com.orastays.flightserver.model.FlightBookingModel;
import com.orastays.flightserver.model.ResponseModel;
import com.orastays.flightserver.service.FareRulesService;

@Service
@Transactional
public class FareRulesServiceImpl extends BaseServiceImpl implements FareRulesService {

	@Autowired
	protected MessageUtil messageUtil;

	@Autowired
	protected RestTemplate restTemplate;

	private static final Logger logger = LogManager.getLogger(FareRulesServiceImpl.class);

	@Override
	public List<FareRulesModel> fareRulesDom(FareRulesModel fareRulesModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("fareRulesDom -- START");
		}
		
		fareRulesValidation.validateFareRulesDom(fareRulesModel);
		List<FareRulesModel> fareRulesModels = null;
		HttpEntity<FareRulesModel> request = null;
		
		if (logger.isInfoEnabled()) {
			logger.info("fareRulesDom -- END");
		}
		
		return null;
	}
	
	@Override
	public List<FareRulesModel> fareRulesInt(FareRulesModel fareRulesModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("bookFlights -- START");
		}

		fareRulesValidation.validateFareRulesInt(fareRulesModel);
		List<FareRulesModel> fareRulesModels = null;
		HttpEntity<FareRulesModel> request = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("emailId", messageUtil.getBundle("flight.email"));
			headers.add("password", messageUtil.getBundle("flight.password"));
			headers.add("apikey", messageUtil.getBundle("flight.key"));


			String url = messageUtil.getBundle("flight.booking.server.url");
			request = new HttpEntity<FareRulesModel>(fareRulesModel, headers);
			ResponseModel responseModel = restTemplate.postForObject(url, request, ResponseModel.class);
			//ResponseModel responseModel = restTemplate.postForObject(url, flightBookingModel, ResponseModel.class);
			Gson gson = new Gson();
			String jsonString = gson.toJson(responseModel.getResponseBody());
			//To store the whole list because list contains object as well as array
			fareRulesModels = gson.fromJson(jsonString,new TypeToken<List<FlightBookingModel>>(){
			private static final long serialVersionUID = 6432872879861274827L;}.getType());

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (logger.isInfoEnabled()) {
			logger.info("bookFlights -- END");
		}
		
		return fareRulesModels;
	}
}