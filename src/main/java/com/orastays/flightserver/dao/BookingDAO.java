package com.orastays.flightserver.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.orastays.flightserver.entity.BookingEntity;

@Repository
public class BookingDAO extends GenericDAO<BookingEntity, Long> {

	private static final long serialVersionUID = -5070151407565218463L;

	public BookingDAO() {
		super(BookingEntity.class);

	}

	public BookingEntity getBookingEntityById(Long id) {

		String hql = "FROM BookingEntity be where be.bookingId = " + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("rawtypes")
		List results = query.list();
		if(results != null && !results.isEmpty()) {
			return (BookingEntity) results.get(0);
		}
		return null;
	}
}
