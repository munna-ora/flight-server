package com.orastays.flightserver.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.flightserver.entity.BookingVsFlightEntity;
import com.orastays.flightserver.helper.Util;
import com.orastays.flightserver.model.BookingVsFlightModel;

@Component
public class BookingVsFlightConverter extends CommonConverter
		implements BaseConverter<BookingVsFlightEntity, BookingVsFlightModel> {

	private static final long serialVersionUID = 545556256575149148L;
	
	private static final Logger logger = LogManager.getLogger(BookingVsFlightConverter.class);

	@Override
	public BookingVsFlightEntity modelToEntity(BookingVsFlightModel m) {

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		BookingVsFlightEntity bookingVsFlightEntity = new BookingVsFlightEntity();

		bookingVsFlightEntity = (BookingVsFlightEntity) Util.transform(modelMapper, m, bookingVsFlightEntity);
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}
		return bookingVsFlightEntity;
	}

	@Override
	public BookingVsFlightModel entityToModel(BookingVsFlightEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		BookingVsFlightModel bookingVsFlightModel = new BookingVsFlightModel();
		bookingVsFlightModel = (BookingVsFlightModel) Util.transform(modelMapper, e, bookingVsFlightModel);

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return bookingVsFlightModel;
	}

	@Override
	public List<BookingVsFlightModel> entityListToModelList(List<BookingVsFlightEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<BookingVsFlightModel> bookingVsFlightModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			bookingVsFlightModels = new ArrayList<>();
			for (BookingVsFlightEntity bookingVsFlightEntity : es) {
				bookingVsFlightModels.add(entityToModel(bookingVsFlightEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return bookingVsFlightModels;
	}

}
