package br.com.senior.hotelproj.model.baseinterface;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public interface ICriteriaQueryJoin<T1, T2> {
	void executar(CriteriaBuilder builder, CriteriaQuery<Object[]> criteriaQuery, Root<T1> rootT1, Root<T2> rootT2);
}
