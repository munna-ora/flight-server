package com.orastays.flightserver.service.impl;

import java.net.URI;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.helper.FlightConstant;
import com.orastays.flightserver.helper.MessageUtil;
import com.orastays.flightserver.model.SeatModel;
import com.orastays.flightserver.service.SeatService;

@Service
@Transactional
public class SeatServiceImpl extends BaseServiceImpl implements SeatService {

	@Autowired
	protected MessageUtil messageUtil;

	@Autowired
	protected RestTemplate restTemplate;

	private static final Logger logger = LogManager.getLogger(SeatServiceImpl.class);

	@Override
	public String getSeatDetails(SeatModel seatModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("getSeatDetails -- START");
		}

		seatValidation.validateSeatDeatils(seatModel);

		HttpHeaders headers = new HttpHeaders();
		headers.add("emailId", messageUtil.getBundle("flight.email"));
		headers.add("password", messageUtil.getBundle("flight.password"));
		headers.add("apikey", messageUtil.getBundle("flight.key"));

		String depLocationCode = searchParameterDAO.fetchCountryCode(seatModel.getDepLocationCode());
		String arrivalLocationCode = searchParameterDAO.fetchCountryCode(seatModel.getArrivalLocationCode());
		String tenantName = null;
		if (depLocationCode.equals(arrivalLocationCode)) {
			tenantName = FlightConstant.DOM_TENANT_NAME;
		} else {
			tenantName = FlightConstant.INT_TENANT_NAME;
		}

		String createUrl = messageUtil.getBundle("flight.search.server.url")+"seatMapResponse?TenantID="+tenantName+"&cabin="+seatModel.getCabin()+
				"&departureDateTime="+seatModel.getDepartureDateTime()+"&flightNumber="+seatModel.getFlightNumber()+"&resBookDesigCode="+seatModel.getResBookDesigCode()+
				"&depLocationCode="+seatModel.getDepLocationCode()+"&arrivalLocationCode="+seatModel.getArrivalLocationCode()+"&oac="+seatModel.getOac()+
				"&pid="+seatModel.getPid()+"&superPnr="+seatModel.getSuperPnr();

		ResponseEntity<String> responseEntity = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			URI uri = UriComponentsBuilder.fromUriString(createUrl).build().encode().toUri();
			RequestEntity<String> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
			responseEntity = restTemplate.exchange(requestEntity, String.class);

		} catch (Exception e) {
			logger.info("Error in getSeatDetails response");
			e.getStackTrace();
		}

		if (logger.isInfoEnabled()) {
			logger.info("getSeatDetails -- END");
		}

		return responseEntity.getBody();
	}
}