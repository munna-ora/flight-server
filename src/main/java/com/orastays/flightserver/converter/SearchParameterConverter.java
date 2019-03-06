package com.orastays.flightserver.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.flightserver.constants.Status;
import com.orastays.flightserver.entity.SearchParameterEntity;
import com.orastays.flightserver.helper.Util;
import com.orastays.flightserver.model.SearchParameterModel;

@Component
public class SearchParameterConverter extends CommonConverter implements BaseConverter<SearchParameterEntity, SearchParameterModel> {

	private static final long serialVersionUID = 353010995224080538L;
	
	private static final Logger logger = LogManager.getLogger(SearchParameterConverter.class);

	@Override
	public SearchParameterEntity modelToEntity(SearchParameterModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}
		
		SearchParameterEntity searchParameterEntity = new SearchParameterEntity();
		searchParameterEntity = (SearchParameterEntity) Util.transform(modelMapper, m, searchParameterEntity);
		searchParameterEntity.setStatus(Status.INACTIVE.ordinal());
		searchParameterEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		searchParameterEntity.setCreatedDate(Util.getCurrentDateTime());
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}
		
		return searchParameterEntity;	
	}

	@Override
	public SearchParameterModel entityToModel(SearchParameterEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		SearchParameterModel searchParameterModel = new SearchParameterModel();
		searchParameterModel = (SearchParameterModel) Util.transform(modelMapper, e, searchParameterModel);

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return searchParameterModel;
	}

	@Override
	public List<SearchParameterModel> entityListToModelList(List<SearchParameterEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<SearchParameterModel> searchParameterModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			searchParameterModels = new ArrayList<>();
			for (SearchParameterEntity searchParameterEntity : es) {
				searchParameterModels.add(entityToModel(searchParameterEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return searchParameterModels;
	}
}
