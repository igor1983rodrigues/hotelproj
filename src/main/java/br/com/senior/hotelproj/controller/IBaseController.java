package br.com.senior.hotelproj.controller;

import java.io.Serializable;
import java.util.List;

public interface IBaseController<T> {
	void gravar(T model) throws Throwable;

	void atualizar(T model) throws Throwable;

	void excluir(T model);

	<S extends Serializable> T getPorChave(S id);

	List<T> listarTudo();
}
