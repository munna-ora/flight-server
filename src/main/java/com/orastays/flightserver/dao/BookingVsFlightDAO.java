package com.orastays.flightserver.dao;

import org.springframework.stereotype.Repository;

import com.orastays.flightserver.entity.BookingVsFlightEntity;

@Repository
public class BookingVsFlightDAO extends GenericDAO<BookingVsFlightEntity, Long> {

	private static final long serialVersionUID = 2277028615495552548L;

	public BookingVsFlightDAO() {
		super(BookingVsFlightEntity.class);
	}
}
