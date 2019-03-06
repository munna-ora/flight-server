package com.orastays.flightserver.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.orastays.flightserver.constants.Status;
import com.orastays.flightserver.converter.ConvenienceConverter;
import com.orastays.flightserver.dao.ConvenienceDAO;
import com.orastays.flightserver.entity.ConvenienceEntity;
import com.orastays.flightserver.helper.Util;
import com.orastays.flightserver.model.ConvenienceModel;
import com.orastays.flightserver.service.ConvenienceService;

@Service
@Transactional
public class ConvenienceServiceImpl implements ConvenienceService {

	private static final Logger logger = LogManager.getLogger(ConvenienceServiceImpl.class);

	@Autowired
	protected ConvenienceDAO convenienceDAO;

	@Value("${entitymanager.packagesToScan}")
	protected String entitymanagerPackagesToScan;

	@Autowired
	protected ConvenienceConverter convenienceConverter;
	/* (non-Javadoc)
	 * @see com.orastays.booking.bookingserver.serviceImpl.ConvenienceService#getActiveConvenienceEntity()
	 */
	@Override
	public ConvenienceEntity getActiveConvenienceEntity() {

		if (logger.isInfoEnabled()) {
			logger.info("getActiveConvenienceEntity -- START");
		}

		ConvenienceEntity convenienceEntity = null;
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put("status", String.valueOf(Status.ACTIVE.ordinal()));
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);

			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan + ".ConvenienceEntity", outerMap1);

			convenienceEntity = convenienceDAO.fetchObjectBySubCiteria(alliasMap);
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in getActiveConvenienceEntity -- " + Util.errorToString(e));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("getActiveConvenienceEntity -- END");
		}

		return convenienceEntity;
	}

	@Override
	public ConvenienceModel getActiveConvenienceModel() {
		// TODO Auto-generated method stub
		if (logger.isInfoEnabled()) {
			logger.info("getActiveConvenienceModel -- START");
		}
		ConvenienceModel convenienceModel = convenienceConverter.entityToModel(getActiveConvenienceEntity());
		if (logger.isInfoEnabled()) {
			logger.info("getActiveConvenienceModel -- END");
		}
		return convenienceModel;
	}
}
