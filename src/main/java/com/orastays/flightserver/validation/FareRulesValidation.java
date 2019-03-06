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
import com.orastays.flightserver.model.FareRulesModel;

@Component
@Transactional
public class FareRulesValidation extends AuthorizeUserValidation {

	private static final Logger logger = LogManager.getLogger(FareRulesValidation.class);

	public FareRulesModel validateFareRulesDom(FareRulesModel fareRulesModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateFareRulesDom -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		if(Objects.nonNull(fareRulesModel)) {

			if(StringUtils.isBlank(fareRulesModel.getTenantName())) {
				exceptions.put(messageUtil.getBundle("tenant.null.code"), new Exception(messageUtil.getBundle("tenant.null.message")));
			} else {
				if (!fareRulesModel.getTenantName().equals(FlightConstant.DOM_TENANT_NAME) && !fareRulesModel.getTenantName().equals(FlightConstant.INT_TENANT_NAME)) {
					exceptions.put(messageUtil.getBundle("tenant.invalid.code"), new Exception(messageUtil.getBundle("tenant.invalid.message")));
				}
			}
		}

		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validateFareRulesDom -- End");
		}	
		return fareRulesModel;
	}
	
	public FareRulesModel validateFareRulesInt(FareRulesModel fareRulesModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateFareRulesInt -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		if(Objects.nonNull(fareRulesModel)) {

			if(StringUtils.isBlank(fareRulesModel.getTenantName())) {
				exceptions.put(messageUtil.getBundle("tenant.null.code"), new Exception(messageUtil.getBundle("tenant.null.message")));
			} else {
				if (!fareRulesModel.getTenantName().equals(FlightConstant.DOM_TENANT_NAME) && !fareRulesModel.getTenantName().equals(FlightConstant.INT_TENANT_NAME)) {
					exceptions.put(messageUtil.getBundle("tenant.invalid.code"), new Exception(messageUtil.getBundle("tenant.invalid.message")));
				}
			}
		}

		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validateFareRulesInt -- End");
		}	
		return fareRulesModel;
	}
	
	public FareRulesModel validateBaggageInfo(FareRulesModel fareRulesModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateFareRulesInt -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		if(Objects.nonNull(fareRulesModel)) {

			if(StringUtils.isBlank(fareRulesModel.getTenantName())) {
				exceptions.put(messageUtil.getBundle("tenant.null.code"), new Exception(messageUtil.getBundle("tenant.null.message")));
			} else {
				if (!fareRulesModel.getTenantName().equals(FlightConstant.DOM_TENANT_NAME) && !fareRulesModel.getTenantName().equals(FlightConstant.INT_TENANT_NAME)) {
					exceptions.put(messageUtil.getBundle("tenant.invalid.code"), new Exception(messageUtil.getBundle("tenant.invalid.message")));
				}
			}
		}

		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validateFareRulesInt -- End");
		}	
		return fareRulesModel;
	}
}
