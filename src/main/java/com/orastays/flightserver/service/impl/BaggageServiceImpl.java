package com.orastays.flightserver.service.impl;

import java.net.URI;
import java.util.List;

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
import com.orastays.flightserver.helper.MessageUtil;
import com.orastays.flightserver.model.BaggageModel;
import com.orastays.flightserver.service.BaggageService;

@Service
@Transactional
public class BaggageServiceImpl extends BaseServiceImpl implements BaggageService {

	@Autowired
	protected MessageUtil messageUtil;

	@Autowired
	protected RestTemplate restTemplate;

	private static final Logger logger = LogManager.getLogger(BaggageServiceImpl.class);

	@Override
	public List<BaggageModel> baggageInfo(BaggageModel baggageModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("baggageInfo -- START");
		}

		baggageValidation.validateBaggageInfo(baggageModel);
		ResponseEntity<String> responseEntity = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("emailId", messageUtil.getBundle("flight.email"));
			headers.add("password", messageUtil.getBundle("flight.password"));
			headers.add("apikey", messageUtil.getBundle("flight.key"));
			
			/*String createUrl = messageUtil.getBundle("flight.search.server.url")+baggageModel.getTenantName()+"/getbaggageinfo?searchId="+baggageModel.getSearchId()+
					"&sc="+baggageModel.getSc()+"&flightIdCSV="+baggageModel.getFlightIdCSV();
			
			RestTemplate restTemplate = new RestTemplate();
			URI uri = UriComponentsBuilder.fromUriString(createUrl).build().encode().toUri();
			RequestEntity<String> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
			responseEntity = restTemplate.exchange(requestEntity, String.class);*/
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (logger.isInfoEnabled()) {
			logger.info("baggageInfo -- END");
		}
		
		//return responseEntity.getBody();
		return null;
	}
}