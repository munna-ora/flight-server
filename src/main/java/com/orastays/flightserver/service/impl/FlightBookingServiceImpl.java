package com.orastays.flightserver.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.helper.FlightConstant;
import com.orastays.flightserver.helper.MessageUtil;
import com.orastays.flightserver.model.FlightBookingModel;
import com.orastays.flightserver.service.FlightBookingService;

@Service
@Transactional
public class FlightBookingServiceImpl extends BaseServiceImpl implements FlightBookingService {

	@Autowired
	protected MessageUtil messageUtil;

	@Autowired
	protected RestTemplate restTemplate;

	private static final Logger logger = LogManager.getLogger(FlightBookingServiceImpl.class);

	@Override
	public String bookFlights(FlightBookingModel flightBookingModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("bookFlights -- START");
		}

		flightBookingValidation.validateBookingDetails(flightBookingModel);
		HttpEntity<FlightBookingModel> request = null;
		ResponseEntity<String> response= null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers.add("emailId", messageUtil.getBundle("flight.email"));
			headers.add("password", messageUtil.getBundle("flight.password"));
			headers.add("apikey", messageUtil.getBundle("flight.key"));

			//Constants START
			flightBookingModel.getReviewJson().getGlobalParamsModel().setPrq("");
			flightBookingModel.getReviewJson().getGlobalParamsModel().setADTcreator("");
			flightBookingModel.getReviewJson().getGlobalParamsModel().setEbsSessionId("d99291547dc2c56cf2ddbdab43acdfd7");
			flightBookingModel.getReviewJson().getHotelCrossSellParamsModel().setIsHotelCrosssellBooking(false);
			flightBookingModel.getReviewJson().getHotelCrossSellParamsModel().setHotelBookingRequestJSON("");
			
			//Constants END
			flightBookingModel.reviewJson.getGlobalParamsModel().setChannel(FlightConstant.CHANNEL);
			flightBookingModel.reviewJson.getGlobalParamsModel().setProduct(FlightConstant.PRODUCT);
			flightBookingModel.reviewJson.getGlobalParamsModel().setIsPartial(FlightConstant.IS_PARTIAL);
			flightBookingModel.reviewJson.getGlobalParamsModel().setEbsAccountId(FlightConstant.EBS_ACCOUNTID);
			flightBookingModel.reviewJson.getGlobalParamsModel().setMoProfileType(FlightConstant.MO_PROFILE_TYPE);
			
			String originCountryCode = searchParameterDAO.fetchCountryCode(flightBookingModel.getReviewJson().getGlobalParamsModel().getOrg());
			String destCountryCode = searchParameterDAO.fetchCountryCode(flightBookingModel.getReviewJson().getGlobalParamsModel().getDest());
			if (originCountryCode.equals(destCountryCode)) {
				flightBookingModel.reviewJson.getGlobalParamsModel().setChildTenant(FlightConstant.DOM_TENANT_NAME);
			} else {
				flightBookingModel.reviewJson.getGlobalParamsModel().setChildTenant(FlightConstant.INT_TENANT_NAME);
			}
			flightBookingModel.reviewJson.getGlobalParamsModel().setVariation(FlightConstant.VARIATION);
			
			flightBookingModel.getReviewJson().getUserParamsModel().getAdditionalContactModel().setEmail(FlightConstant.ADTL_EMAIL);
			flightBookingModel.getReviewJson().getUserParamsModel().getAdditionalContactModel().setMobile(FlightConstant.ADTL_MOBILE);
			flightBookingModel.getReviewJson().getUserParamsModel().getAdditionalContactModel().setMobileISD(FlightConstant.ADTL_MOBILE_ISD);
			flightBookingModel.getReviewJson().getUserParamsModel().setEmailId(FlightConstant.EMAIL);
			flightBookingModel.getReviewJson().getUserParamsModel().setMobileNo(FlightConstant.MOBILE);
			flightBookingModel.getReviewJson().getUserParamsModel().setUserId(FlightConstant.USER_ID);
			flightBookingModel.getReviewJson().getUserParamsModel().setFirstName(FlightConstant.FIRST_NAME);
			flightBookingModel.getReviewJson().getUserParamsModel().setLastName(FlightConstant.LAST_NAME);
			flightBookingModel.getReviewJson().getUserParamsModel().setMobileNoISD(FlightConstant.ADTL_MOBILE_ISD);
			
			RestTemplate restTemplate = new RestTemplate();
			String url = messageUtil.getBundle("flight.booking.server.url");
			request = new HttpEntity<FlightBookingModel>(flightBookingModel, headers);
			ObjectMapper objectMapper = new ObjectMapper();
			response= 
				    restTemplate.exchange(
				    		url,
				        HttpMethod.POST, 
				        new HttpEntity(objectMapper.writeValueAsString(request), headers), 
				        String.class);
			System.out.println("rest::"+response);
			
			//STORE THE RESPONSE DATA IN DB

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (logger.isInfoEnabled()) {
			logger.info("bookFlights -- END");
		}
		
		return response.getBody();
	}
	
	@Override
	public String fetchBookingList(FlightBookingModel flightBookingModel) throws FormExceptions {


		if (logger.isInfoEnabled()) {
			logger.info("fetchBookingList -- START");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		flightBookingValidation.validateBookingList(flightBookingModel);
		String searchResponse = null;
		try {
			//searchResponse = oneWayFetch(flightBookingModel);
			JSONObject jsonObj = new JSONObject(searchResponse);
			boolean eagerFetch = jsonObj.getBoolean("eagerFetch");
			if (!eagerFetch) {
				boolean eagerFetchStop=false;
				for (int i=0;i<=2;i++) {
					//searchResponse = oneWayFetch(flightBookingModel);
					JSONObject jsonObj1 = new JSONObject(searchResponse);
					eagerFetchStop = jsonObj1.getBoolean("eagerFetch");
					if (eagerFetchStop) {
						return searchResponse;
					} 
				} 
				//Check response code
				if (!eagerFetchStop){
					exceptions.put(messageUtil.getBundle("common.error.code"), new Exception(messageUtil.getBundle("common.error..message")));
				} 
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("fetchBookingList -- END");
		}
		return searchResponse;
	}
}