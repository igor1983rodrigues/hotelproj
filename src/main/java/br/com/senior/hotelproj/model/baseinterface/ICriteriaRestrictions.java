package br.com.senior.hotelproj.model.baseinterface;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;

public interface ICriteriaRestrictions {
	Criterion executar(Disjunction disjunction);
}
