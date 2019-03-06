package com.orastays.flightserver.dao;

import org.springframework.stereotype.Repository;

import com.orastays.flightserver.entity.BookingInfoEntity;

@Repository
public class BookingInfoDAO extends GenericDAO<BookingInfoEntity, Long> {

	private static final long serialVersionUID = 6454932478890664232L;

	public BookingInfoDAO() {
		super(BookingInfoEntity.class);

	}
}
