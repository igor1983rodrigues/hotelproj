package br.com.senior.hotelproj.controller;

import java.util.List;

import br.com.senior.hotelproj.model.dao.CheckinDao;
import br.com.senior.hotelproj.model.entity.CheckinEntity;
import br.com.senior.hotelproj.model.idao.ICheckinDao;

public class CheckinController implements IBaseController<CheckinEntity> {
	private ICheckinDao iCheckinDao;

	public CheckinController() throws Throwable {
		iCheckinDao = new CheckinDao();
	}

	@Override
	public void gravar(CheckinEntity model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(CheckinEntity model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(CheckinEntity model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CheckinEntity> listarTudo() {
		return iCheckinDao.obterTodos();
	}
}
