package br.com.senior.hotelproj.controller;

import java.util.List;

import br.com.senior.hotelproj.model.dao.HospedeDao;
import br.com.senior.hotelproj.model.entity.HospedeEntity;
import br.com.senior.hotelproj.model.idao.IHospedeDao;

public class HospedeController implements IBaseController<HospedeEntity> {
	private IHospedeDao iHospedeDao;

	public HospedeController() throws Throwable {
		iHospedeDao = new HospedeDao();
	}

	@Override
	public void gravar(HospedeEntity model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(HospedeEntity model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(HospedeEntity model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HospedeEntity> listarTudo() {
		return iHospedeDao.obterTodos();
	}
}
