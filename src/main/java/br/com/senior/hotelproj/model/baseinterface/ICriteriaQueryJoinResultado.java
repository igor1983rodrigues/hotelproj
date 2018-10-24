package br.com.senior.hotelproj.model.baseinterface;

public interface ICriteriaQueryJoinResultado<T1, T2, TResult> {
	TResult executar(T1 obj1, T2 obj2);
}
