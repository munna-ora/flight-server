package com.orastays.flightserver.dao;

import org.springframework.stereotype.Repository;

import com.orastays.flightserver.entity.ConvenienceEntity;

@Repository
public class ConvenienceDAO extends GenericDAO<ConvenienceEntity, Long> {

	private static final long serialVersionUID = 764287020568903042L;

	public ConvenienceDAO() {
		super(ConvenienceEntity.class);

	}
/*	
	public ConvenienceEntity getActiveConvenienceFee(int status) {

		String hql = "FROM ConvenienceEntity be where be.status = " + status;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("rawtypes")
		List results = query.list();
		System.out.println("results::"+results);
		return (ConvenienceEntity) results.get(0);
	}*/
}
