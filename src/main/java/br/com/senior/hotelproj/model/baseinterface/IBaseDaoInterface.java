package br.com.senior.hotelproj.model.baseinterface;

import java.util.List;

public interface IBaseDaoInterface<T> {

	void inserir(T model, String mensagem);

	void alterar(T model, String mensagem);

	void excluir(T model, String mensagem);
	
	T obterPorChave(Object parametros);
	
	List<T> obter(Object parametros);
	
	List<T> obterTodos();

}
