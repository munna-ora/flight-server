package com.orastays.flightserver.dao;

import org.springframework.stereotype.Repository;

import com.orastays.flightserver.entity.BookingVsTravellerEntity;

@Repository
public class BookingVsTravellerDAO extends GenericDAO<BookingVsTravellerEntity, Long> {

	private static final long serialVersionUID = 3136876097336978477L;

	public BookingVsTravellerDAO() {
		super(BookingVsTravellerEntity.class);
	}
}
