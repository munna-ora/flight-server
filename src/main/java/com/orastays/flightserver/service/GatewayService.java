package com.orastays.flightserver.service;

import com.orastays.flightserver.entity.GatewayEntity;

public interface GatewayService {
	GatewayEntity getGatewayEntity(String gatewayName);
}
