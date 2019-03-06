package com.orastays.flightserver.service;

import java.util.List;

import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.model.FareRulesModel;

public interface FareRulesService {

	List<FareRulesModel> fareRulesDom(FareRulesModel fareRulesModel) throws FormExceptions;

	List<FareRulesModel> fareRulesInt(FareRulesModel fareRulesModel) throws FormExceptions;
}