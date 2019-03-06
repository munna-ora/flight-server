package com.orastays.flightserver.validation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.model.BookingModel;
import com.orastays.flightserver.model.FlightBookingModel;

@Component
@Transactional
public class FlightBookingValidation extends AuthorizeUserValidation {

	private static final Logger logger = LogManager.getLogger(FlightBookingValidation.class);

	public void validateBookingDetails(FlightBookingModel flightBookingModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateBookingDetails -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		if(Objects.isNull(flightBookingModel)) { 
			exceptions.put(messageUtil.getBundle("booking.list.null.code"), new Exception(messageUtil.getBundle("booking.list.null.message")));
		} else {
			if(StringUtils.isBlank(flightBookingModel.getPricingId())) {
				exceptions.put(messageUtil.getBundle("pricing.id.null.code"), new Exception(messageUtil.getBundle("pricing.id.null.message")));
			} 
			if(StringUtils.isBlank(flightBookingModel.getSuperPnr())) {
				exceptions.put(messageUtil.getBundle("superPnr.null.code"), new Exception(messageUtil.getBundle("superPnr.null.message")));
			}
			//ReviewJson
			if (Objects.isNull(flightBookingModel.getReviewJson())) {
				exceptions.put(messageUtil.getBundle("review.json.null.code"), new Exception(messageUtil.getBundle("review.json.null.message")));
			} else {
				//GlobalParams
				if(Objects.isNull(flightBookingModel.getReviewJson().getGlobalParamsModel())) {
					exceptions.put(messageUtil.getBundle("global.params.null.code"), new Exception(messageUtil.getBundle("global.params.null.message")));
				} else {
					if (StringUtils.isBlank(flightBookingModel.getReviewJson().getGlobalParamsModel().getPricingId())) {
						exceptions.put(messageUtil.getBundle("pricing.id.null.code"), new Exception(messageUtil.getBundle("pricing.id.null.message")));
					}
					if (StringUtils.isBlank(flightBookingModel.getReviewJson().getGlobalParamsModel().getSuperPnr())) {
						exceptions.put(messageUtil.getBundle("superPnr.null.code"), new Exception(messageUtil.getBundle("superPnr.null.message")));
					}
					if (StringUtils.isBlank(flightBookingModel.getReviewJson().getGlobalParamsModel().getSearchId())) {
						exceptions.put(messageUtil.getBundle("search.id.null.code"), new Exception(messageUtil.getBundle("search.id.null.message")));
					}
					if (StringUtils.isBlank(flightBookingModel.getReviewJson().getGlobalParamsModel().getOrg())) {
						exceptions.put(messageUtil.getBundle("origin.null.code"), new Exception(messageUtil.getBundle("origin.null.message")));
					}
					if (StringUtils.isBlank(flightBookingModel.getReviewJson().getGlobalParamsModel().getDest())) {
						exceptions.put(messageUtil.getBundle("destination.null.code"), new Exception(messageUtil.getBundle("destination.null.message")));
					}
				}

				//travellerParams
				if(Objects.isNull(flightBookingModel.getReviewJson().getTravellerParamModels())) {
					exceptions.put(messageUtil.getBundle("traveller.params.null.code"), new Exception(messageUtil.getBundle("traveller.params.null.message")));
				} else {/*
					for (TravellerParamModel travellerParamModel : flightBookingModel.getReviewJson().getTravellerParamModels()) {
						if (StringUtils.isBlank(travellerParamModel.getPaxID())) {
							exceptions.put(messageUtil.getBundle("paxId.null.code"), new Exception(messageUtil.getBundle("paxId.null.message")));
						}
						if (Objects.isNull(travellerParamModel.getTravellerDetailsModel())) {
							exceptions.put(messageUtil.getBundle("traveller.details.null.code"), new Exception(messageUtil.getBundle("traveller.details.null.message")));
						} else {
							if (StringUtils.isBlank(travellerParamModel.getTravellerDetailsModel().getId())) {
								exceptions.put(messageUtil.getBundle("traveller.id.null.code"), new Exception(messageUtil.getBundle("traveller.id.null.message")));
							}
							if (StringUtils.isBlank(travellerParamModel.getTravellerDetailsModel().getTitle())) {
								exceptions.put(messageUtil.getBundle("title.null.code"), new Exception(messageUtil.getBundle("title.null.message")));
							}
							if (StringUtils.isBlank(travellerParamModel.getTravellerDetailsModel().getFirstName())) {
								exceptions.put(messageUtil.getBundle("first.name.null.code"), new Exception(messageUtil.getBundle("first.name.null.message")));
							}
							if (StringUtils.isBlank(travellerParamModel.getTravellerDetailsModel().getLastName())) {
								exceptions.put(messageUtil.getBundle("last.name.null.code"), new Exception(messageUtil.getBundle("last.name.null.message")));
							}
							if (StringUtils.isBlank(travellerParamModel.getTravellerDetailsModel().getPaxClass())) {
								exceptions.put(messageUtil.getBundle("pax.class.null.code"), new Exception(messageUtil.getBundle("pax.class.null.message")));
							}
							if (StringUtils.isBlank(travellerParamModel.getTravellerDetailsModel().getPassengerClass())) {
								exceptions.put(messageUtil.getBundle("passenger.class.null.code"), new Exception(messageUtil.getBundle("passenger.class.null.message")));
							}
						}
					}
				*/}
			}
		}

		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validateBookingDetails -- End");
		}	
	}

	public FlightBookingModel validateBookingList(FlightBookingModel flightBookingModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateBookingList -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validateBookingList -- End");
		}	
		return flightBookingModel;
	}
	
	public void validateBookingBeforePayment(BookingModel bookingModel) throws FormExceptions {
		if (logger.isInfoEnabled()) {
			logger.info("validateBookingBeforePayment -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		if(Objects.isNull(bookingModel)) { 
			exceptions.put(messageUtil.getBundle("booking.list.null.code"), new Exception(messageUtil.getBundle("booking.list.null.message")));
		} else {
			if(StringUtils.isBlank(bookingModel.getPricingId())) {
				exceptions.put(messageUtil.getBundle("pricing.id.null.code"), new Exception(messageUtil.getBundle("pricing.id.null.message")));
			} 
			if(StringUtils.isBlank(bookingModel.getSuperPnr())) {
				exceptions.put(messageUtil.getBundle("superPnr.null.code"), new Exception(messageUtil.getBundle("superPnr.null.message")));
			}
			//ReviewJson
			if (Objects.isNull(bookingModel.getReviewJsonModel())) {
				exceptions.put(messageUtil.getBundle("review.json.null.code"), new Exception(messageUtil.getBundle("review.json.null.message")));
			} else {
				//GlobalParams
				if(Objects.isNull(bookingModel.getReviewJsonModel().getGlobalParamsModel())) {
					exceptions.put(messageUtil.getBundle("global.params.null.code"), new Exception(messageUtil.getBundle("global.params.null.message")));
				} else {
					if (StringUtils.isBlank(bookingModel.getReviewJsonModel().getGlobalParamsModel().getPricingId())) {
						exceptions.put(messageUtil.getBundle("pricing.id.null.code"), new Exception(messageUtil.getBundle("pricing.id.null.message")));
					}
					if (StringUtils.isBlank(bookingModel.getReviewJsonModel().getGlobalParamsModel().getSuperPnr())) {
						exceptions.put(messageUtil.getBundle("superPnr.null.code"), new Exception(messageUtil.getBundle("superPnr.null.message")));
					}
					if (StringUtils.isBlank(bookingModel.getReviewJsonModel().getGlobalParamsModel().getSearchId())) {
						exceptions.put(messageUtil.getBundle("search.id.null.code"), new Exception(messageUtil.getBundle("search.id.null.message")));
					}
					if (StringUtils.isBlank(bookingModel.getReviewJsonModel().getGlobalParamsModel().getOrg())) {
						exceptions.put(messageUtil.getBundle("origin.null.code"), new Exception(messageUtil.getBundle("origin.null.message")));
					}
					if (StringUtils.isBlank(bookingModel.getReviewJsonModel().getGlobalParamsModel().getDest())) {
						exceptions.put(messageUtil.getBundle("destination.null.code"), new Exception(messageUtil.getBundle("destination.null.message")));
					}
				}

				//travellerParams
				if(Objects.isNull(bookingModel.getReviewJsonModel().getTravellerParamModels())) {
					exceptions.put(messageUtil.getBundle("traveller.params.null.code"), new Exception(messageUtil.getBundle("traveller.params.null.message")));
				} else {/*
					for (TravellerParamModel travellerParamModel : flightBookingModel.getReviewJson().getTravellerParamModels()) {
						if (StringUtils.isBlank(travellerParamModel.getPaxID())) {
							exceptions.put(messageUtil.getBundle("paxId.null.code"), new Exception(messageUtil.getBundle("paxId.null.message")));
						}
						if (Objects.isNull(travellerParamModel.getTravellerDetailsModel())) {
							exceptions.put(messageUtil.getBundle("traveller.details.null.code"), new Exception(messageUtil.getBundle("traveller.details.null.message")));
						} else {
							if (StringUtils.isBlank(travellerParamModel.getTravellerDetailsModel().getId())) {
								exceptions.put(messageUtil.getBundle("traveller.id.null.code"), new Exception(messageUtil.getBundle("traveller.id.null.message")));
							}
							if (StringUtils.isBlank(travellerParamModel.getTravellerDetailsModel().getTitle())) {
								exceptions.put(messageUtil.getBundle("title.null.code"), new Exception(messageUtil.getBundle("title.null.message")));
							}
							if (StringUtils.isBlank(travellerParamModel.getTravellerDetailsModel().getFirstName())) {
								exceptions.put(messageUtil.getBundle("first.name.null.code"), new Exception(messageUtil.getBundle("first.name.null.message")));
							}
							if (StringUtils.isBlank(travellerParamModel.getTravellerDetailsModel().getLastName())) {
								exceptions.put(messageUtil.getBundle("last.name.null.code"), new Exception(messageUtil.getBundle("last.name.null.message")));
							}
							if (StringUtils.isBlank(travellerParamModel.getTravellerDetailsModel().getPaxClass())) {
								exceptions.put(messageUtil.getBundle("pax.class.null.code"), new Exception(messageUtil.getBundle("pax.class.null.message")));
							}
							if (StringUtils.isBlank(travellerParamModel.getTravellerDetailsModel().getPassengerClass())) {
								exceptions.put(messageUtil.getBundle("passenger.class.null.code"), new Exception(messageUtil.getBundle("passenger.class.null.message")));
							}
						}
					}
				*/}
			}
		}
		
		CopyOnWriteArrayList<BookingModel> booked = new CopyOnWriteArrayList<>();

		if (logger.isInfoEnabled()) {
			logger.info("validateBookingBeforePayment -- End");
		}
	}
}
