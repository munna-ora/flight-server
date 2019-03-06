package com.orastays.flightserver.service;

import java.util.List;

import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.model.BaggageModel;

public interface BaggageService {

	List<BaggageModel> baggageInfo(BaggageModel baggageModel) throws FormExceptions;
}