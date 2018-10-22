package br.com.senior.hotelproj.controller;

import java.util.List;

import br.com.senior.hotelproj.model.dao.CheckinDao;
import br.com.senior.hotelproj.model.entity.CheckinEntity;
import br.com.senior.hotelproj.model.idao.ICheckinDao;

public class CheckinController {
	private ICheckinDao iCheckinDao;

	public CheckinController() throws Throwable {
		iCheckinDao = new CheckinDao();
	}

	public List<CheckinEntity> obterTodos() {
		return iCheckinDao.obterTodos();
	}
}
