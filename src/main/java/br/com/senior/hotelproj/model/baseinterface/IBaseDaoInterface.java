package br.com.senior.hotelproj.model.baseinterface;

import java.util.List;

public interface IBaseDaoInterface<T> {

	void inserir(T model);

	void alterar(T model);

	void excluir(T model);

	T obterPorChave(int parametros);

	List<T> obter(ICriteriaFiltro<T> filtrar);

	List<T> obterTodos();
}
