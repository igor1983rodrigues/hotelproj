package br.com.senior.hotelproj.model.baseinterface;

import java.io.Serializable;
import java.util.List;

public interface IBaseDaoInterface<T> {

	void inserir(T model);

	void alterar(T model);

	void excluir(T model);

	<S extends Serializable> T obterPorChave(S parametros);

	List<T> obter(Object parametros);

	List<T> obterTodos();
}
