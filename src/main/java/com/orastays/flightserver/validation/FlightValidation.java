package com.orastays.flightserver.validation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.helper.FlightConstant;
import com.orastays.flightserver.model.FlightPriceModel;
import com.orastays.flightserver.model.FlightSearchModel;
import com.orastays.flightserver.model.MultiCityModel;

@Component
@Transactional
public class FlightValidation extends AuthorizeUserValidation {

	private static final Logger logger = LogManager.getLogger(FlightValidation.class);

	public FlightSearchModel validateOneWayData(FlightSearchModel flightSearchModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateOneWayData -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		if(Objects.nonNull(flightSearchModel)) {

			if(StringUtils.isBlank(flightSearchModel.getNoOfAdults())) {
				exceptions.put(messageUtil.getBundle("adult.number.null.code"), new Exception(messageUtil.getBundle("adult.number.null.message")));
			} else {
				int totalTravellers = Integer.parseInt(flightSearchModel.getNoOfAdults())+Integer.parseInt(flightSearchModel.getNoOfChild());
				if (totalTravellers>FlightConstant.MAX_TRAVELLERS) {
					exceptions.put(messageUtil.getBundle("max.traveller.exceed.code"), new Exception(messageUtil.getBundle("max.traveller.exceed.message")));
				}
				//Check INF<=ADT
				int numberOfAdult=Integer.parseInt(flightSearchModel.getNoOfAdults());
				int numberOfInfant=Integer.parseInt(flightSearchModel.getNoOfInfants());
				if (numberOfInfant>numberOfAdult) {
					exceptions.put(messageUtil.getBundle("infant.invalid.code"), new Exception(messageUtil.getBundle("infant.invalid.message")));
				}
			}

			if(StringUtils.isBlank(flightSearchModel.getClassType())) {
				exceptions.put(messageUtil.getBundle("class.type.null.code"), new Exception(messageUtil.getBundle("class.type.null.message")));
			}

			if(Objects.nonNull(flightSearchModel.getMultiCityModels())) {
				for(MultiCityModel multiCityModel:flightSearchModel.getMultiCityModels()) {
					if(StringUtils.isBlank(multiCityModel.getOrigin())) {
						exceptions.put(messageUtil.getBundle("origin.null.code"), new Exception(messageUtil.getBundle("origin.null.message")));
					}
					if(StringUtils.isBlank(multiCityModel.getDestination())) {
						exceptions.put(messageUtil.getBundle("destination.null.code"), new Exception(messageUtil.getBundle("destination.null.message")));
					}
					if(StringUtils.isBlank(multiCityModel.getFlightDepartDate())) {
						exceptions.put(messageUtil.getBundle("depart.date.null.code"), new Exception(messageUtil.getBundle("depart.date.null.message")));
					}
					if(StringUtils.equals(multiCityModel.getOrigin(), multiCityModel.getDestination())) {
						exceptions.put(messageUtil.getBundle("origin.dest.same.code"), new Exception(messageUtil.getBundle("origin.dest.same.message")));
					}
				}
			}
		}	

		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validateOneWayData -- End");
		}	
		return flightSearchModel;
	}

	public FlightSearchModel validateRoundTripData(FlightSearchModel flightSearchModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateRoundTripData -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		if(Objects.nonNull(flightSearchModel)) {

			if(StringUtils.isBlank(flightSearchModel.getNoOfAdults())) {
				exceptions.put(messageUtil.getBundle("adult.number.null.code"), new Exception(messageUtil.getBundle("adult.number.null.message")));
			} else {
				int totalTravellers = Integer.parseInt(flightSearchModel.getNoOfAdults())+Integer.parseInt(flightSearchModel.getNoOfChild());
				if (totalTravellers>FlightConstant.MAX_TRAVELLERS) {
					exceptions.put(messageUtil.getBundle("max.traveller.exceed.code"), new Exception(messageUtil.getBundle("max.traveller.exceed.message")));
				}
				//Check INF<=ADT
				int numberOfAdult=Integer.parseInt(flightSearchModel.getNoOfAdults());
				int numberOfInfant=Integer.parseInt(flightSearchModel.getNoOfInfants());
				if (numberOfInfant>numberOfAdult) {
					exceptions.put(messageUtil.getBundle("infant.invalid.code"), new Exception(messageUtil.getBundle("infant.invalid.message")));
				}
			}

			if(StringUtils.isBlank(flightSearchModel.getClassType())) {
				exceptions.put(messageUtil.getBundle("class.type.null.code"), new Exception(messageUtil.getBundle("class.type.null.message")));
			}

			if(StringUtils.isBlank(flightSearchModel.getArrivalDate())) {
				exceptions.put(messageUtil.getBundle("arrival.date.null.code"), new Exception(messageUtil.getBundle("arrival.date.null.message")));
			}

			if(Objects.nonNull(flightSearchModel.getMultiCityModels())) {
				for(MultiCityModel multiCityModel:flightSearchModel.getMultiCityModels()) {
					if(StringUtils.isBlank(multiCityModel.getOrigin())) {
						exceptions.put(messageUtil.getBundle("origin.null.code"), new Exception(messageUtil.getBundle("origin.null.message")));
					}
					if(StringUtils.isBlank(multiCityModel.getDestination())) {
						exceptions.put(messageUtil.getBundle("destination.null.code"), new Exception(messageUtil.getBundle("destination.null.message")));
					}
					if(StringUtils.isBlank(multiCityModel.getFlightDepartDate())) {
						exceptions.put(messageUtil.getBundle("depart.date.null.code"), new Exception(messageUtil.getBundle("depart.date.null.message")));
					}
					if(StringUtils.equals(multiCityModel.getOrigin(), multiCityModel.getDestination())) {
						exceptions.put(messageUtil.getBundle("origin.dest.same.code"), new Exception(messageUtil.getBundle("origin.dest.same.message")));
					}
				}
			}
		}	

		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validateRoundTripData -- End");
		}	
		return flightSearchModel;
	}

	public FlightSearchModel validateMulticityData(FlightSearchModel flightSearchModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateMulticityData -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		if(Objects.nonNull(flightSearchModel)) {

			if(StringUtils.isBlank(flightSearchModel.getNoOfAdults())) {
				exceptions.put(messageUtil.getBundle("adult.number.null.code"), new Exception(messageUtil.getBundle("adult.number.null.message")));
			} else {
				int totalTravellers = Integer.parseInt(flightSearchModel.getNoOfAdults())+Integer.parseInt(flightSearchModel.getNoOfChild());
				if (totalTravellers>FlightConstant.MAX_TRAVELLERS) {
					exceptions.put(messageUtil.getBundle("max.traveller.exceed.code"), new Exception(messageUtil.getBundle("max.traveller.exceed.message")));
				}
				//Check INF<=ADT
				int numberOfAdult=Integer.parseInt(flightSearchModel.getNoOfAdults());
				int numberOfInfant=Integer.parseInt(flightSearchModel.getNoOfInfants());
				if (numberOfInfant>numberOfAdult) {
					exceptions.put(messageUtil.getBundle("infant.invalid.code"), new Exception(messageUtil.getBundle("infant.invalid.message")));
				}
			}

			if(StringUtils.isBlank(flightSearchModel.getClassType())) {
				exceptions.put(messageUtil.getBundle("class.type.null.code"), new Exception(messageUtil.getBundle("class.type.null.message")));
			}

			if(Objects.nonNull(flightSearchModel.getMultiCityModels())) {
				for(MultiCityModel multiCityModel:flightSearchModel.getMultiCityModels()) {
					if(StringUtils.isBlank(multiCityModel.getOrigin())) {
						exceptions.put(messageUtil.getBundle("origin.null.code"), new Exception(messageUtil.getBundle("origin.null.message")));
					}
					if(StringUtils.isBlank(multiCityModel.getDestination())) {
						exceptions.put(messageUtil.getBundle("destination.null.code"), new Exception(messageUtil.getBundle("destination.null.message")));
					}
					if(StringUtils.isBlank(multiCityModel.getFlightDepartDate())) {
						exceptions.put(messageUtil.getBundle("depart.date.null.code"), new Exception(messageUtil.getBundle("depart.date.null.message")));
					}
					if(StringUtils.equals(multiCityModel.getOrigin(), multiCityModel.getDestination())) {
						exceptions.put(messageUtil.getBundle("origin.dest.same.code"), new Exception(messageUtil.getBundle("origin.dest.same.message")));
					}
				}
			}
		}	

		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validateMulticityData -- End");
		}	
		return flightSearchModel;
	}

	public FlightPriceModel validateOneWayPricing(FlightPriceModel flightPriceModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateOneWayPricing -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		if(Objects.nonNull(flightPriceModel)) {

			if(StringUtils.isBlank(flightPriceModel.getSearchId())) {
				exceptions.put(messageUtil.getBundle("search.id.null.code"), new Exception(messageUtil.getBundle("search.id.null.message")));
			}

			if(StringUtils.isBlank(flightPriceModel.getMsid())) {
				exceptions.put(messageUtil.getBundle("msid.null.code"), new Exception(messageUtil.getBundle("msid.null.message")));
			}

			if(StringUtils.isBlank(flightPriceModel.getFlightPrice())) {
				exceptions.put(messageUtil.getBundle("flight.price.null.code"), new Exception(messageUtil.getBundle("flight.price.null.message")));
			}

			if (StringUtils.isBlank(flightPriceModel.getSupplierCode())) {
				exceptions.put(messageUtil.getBundle("supplier.code.null.code"), new Exception(messageUtil.getBundle("supplier.code.null.message")));
			}	
			
			if (StringUtils.isBlank(flightPriceModel.getFlightId())){
				exceptions.put(messageUtil.getBundle("flight.id.null.code"), new Exception(messageUtil.getBundle("flight.id.null.message")));
			}
		}	

		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validateOneWayPricing -- End");
		}	
		return flightPriceModel;
	}

	public FlightPriceModel validateRoundTripPricing(FlightPriceModel flightPriceModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateRoundTripPricing -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		if(Objects.nonNull(flightPriceModel)) {

			if(StringUtils.isBlank(flightPriceModel.getSearchId())) {
				exceptions.put(messageUtil.getBundle("search.id.null.code"), new Exception(messageUtil.getBundle("search.id.null.message")));
			}

			if(StringUtils.isBlank(flightPriceModel.getMsid())) {
				exceptions.put(messageUtil.getBundle("msid.null.code"), new Exception(messageUtil.getBundle("msid.null.message")));
			}

			if(StringUtils.isBlank(flightPriceModel.getFlightPrice())) {
				exceptions.put(messageUtil.getBundle("flight.price.null.code"), new Exception(messageUtil.getBundle("flight.price.null.message")));
			}

			if (StringUtils.isBlank(flightPriceModel.getSupplierCode())) {
				exceptions.put(messageUtil.getBundle("supplier.code.null.code"), new Exception(messageUtil.getBundle("supplier.code.null.message")));
			}	
			if (StringUtils.isBlank(flightPriceModel.getFlightId())){
				exceptions.put(messageUtil.getBundle("flight.id.null.code"), new Exception(messageUtil.getBundle("flight.id.null.message")));
			}
		}	

		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validateRoundTripPricing -- End");
		}	
		return flightPriceModel;
	}
	
	public FlightPriceModel validateMultiCityPricing(FlightPriceModel flightPriceModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateMultiCityPricing -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		if(Objects.nonNull(flightPriceModel)) {

			if(StringUtils.isBlank(flightPriceModel.getSearchId())) {
				exceptions.put(messageUtil.getBundle("search.id.null.code"), new Exception(messageUtil.getBundle("search.id.null.message")));
			}

			if(StringUtils.isBlank(flightPriceModel.getMsid())) {
				exceptions.put(messageUtil.getBundle("msid.null.code"), new Exception(messageUtil.getBundle("msid.null.message")));
			}

			if(StringUtils.isBlank(flightPriceModel.getFlightPrice())) {
				exceptions.put(messageUtil.getBundle("flight.price.null.code"), new Exception(messageUtil.getBundle("flight.price.null.message")));
			}

			if (StringUtils.isBlank(flightPriceModel.getSupplierCode())) {
				exceptions.put(messageUtil.getBundle("supplier.code.null.code"), new Exception(messageUtil.getBundle("supplier.code.null.message")));
			}	
			
			if (StringUtils.isBlank(flightPriceModel.getFlightId())){
				exceptions.put(messageUtil.getBundle("flight.id.null.code"), new Exception(messageUtil.getBundle("flight.id.null.message")));
			}	
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validateMultiCityPricing -- End");
		}	
		
		return flightPriceModel;
	}
}