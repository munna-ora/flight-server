package com.orastays.flightserver.service;

import com.orastays.flightserver.entity.ConvenienceEntity;
import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.model.ConvenienceModel;

public interface ConvenienceService {

	ConvenienceEntity getActiveConvenienceEntity();
	ConvenienceModel getActiveConvenienceModel() throws FormExceptions;
}