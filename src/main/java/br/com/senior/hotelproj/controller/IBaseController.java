package br.com.senior.hotelproj.controller;

import java.util.List;

public interface IBaseController<T> {
	void gravar(T model);
	void atualizar(T model);
	void excluir(T model);
	List<T> listarTudo();
}
