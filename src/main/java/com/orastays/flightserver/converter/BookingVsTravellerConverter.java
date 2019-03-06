package com.orastays.flightserver.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.flightserver.entity.BookingVsTravellerEntity;
import com.orastays.flightserver.helper.Util;
import com.orastays.flightserver.model.BookingVsTravellerModel;

@Component
public class BookingVsTravellerConverter extends CommonConverter
		implements BaseConverter<BookingVsTravellerEntity, BookingVsTravellerModel> {

	private static final long serialVersionUID = -5655366867452415417L;
	
	private static final Logger logger = LogManager.getLogger(BookingVsTravellerConverter.class);

	@Override
	public BookingVsTravellerEntity modelToEntity(BookingVsTravellerModel m) {

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		BookingVsTravellerEntity bookingVsTravellerEntity = new BookingVsTravellerEntity();

		bookingVsTravellerEntity = (BookingVsTravellerEntity) Util.transform(modelMapper, m, bookingVsTravellerEntity);
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}
		return bookingVsTravellerEntity;
	}

	@Override
	public BookingVsTravellerModel entityToModel(BookingVsTravellerEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		BookingVsTravellerModel bookingVsTravellerModel = new BookingVsTravellerModel();
		bookingVsTravellerModel = (BookingVsTravellerModel) Util.transform(modelMapper, e, bookingVsTravellerModel);

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return bookingVsTravellerModel;
	}

	@Override
	public List<BookingVsTravellerModel> entityListToModelList(List<BookingVsTravellerEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<BookingVsTravellerModel> bookingVsTravellerModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			bookingVsTravellerModels = new ArrayList<>();
			for (BookingVsTravellerEntity bookingVsTravellerEntity : es) {
				bookingVsTravellerModels.add(entityToModel(bookingVsTravellerEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return bookingVsTravellerModels;
	}

}
