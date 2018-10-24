package br.com.senior.hotelproj.controller;

import java.util.List;

public interface IBaseController<T> {
	void gravar(T model) throws Throwable;

	void atualizar(T model) throws Throwable;

	void excluir(T model);

	T listarPorChave(int id) throws Throwable;

	List<T> listarTudo();
}
