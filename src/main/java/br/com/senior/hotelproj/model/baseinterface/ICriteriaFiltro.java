package br.com.senior.hotelproj.model.baseinterface;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public interface ICriteriaFiltro<T> {
	void executar(CriteriaBuilder builder, CriteriaQuery<T> criterio, Root<T> variableRoot);
	
}
