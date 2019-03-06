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
import com.orastays.flightserver.dao.GatewayDAO;
import com.orastays.flightserver.entity.GatewayEntity;
import com.orastays.flightserver.helper.Util;
import com.orastays.flightserver.service.GatewayService;

@Service
@Transactional
public class GatewayServiceImpl implements GatewayService {

	private static final Logger logger = LogManager.getLogger(GatewayServiceImpl.class);

	@Autowired
	protected GatewayDAO gatewayDAO;

	@Value("${entitymanager.packagesToScan}")
	protected String entitymanagerPackagesToScan;

	@Override
	public GatewayEntity getGatewayEntity(String gatewayName) {
		if (logger.isInfoEnabled()) {
			logger.info("getGatewayEntity -- START");
		}

		GatewayEntity gatewayEntity = null;
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put("status", String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put("gatewayName", gatewayName.toUpperCase());
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);

			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan + ".GatewayEntity", outerMap1);

			gatewayEntity = gatewayDAO.fetchObjectBySubCiteria(alliasMap);
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in getGatewayEntity -- " + Util.errorToString(e));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("getActiveConvenienceEntity -- END");
		}

		return gatewayEntity;
	}

}
