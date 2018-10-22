package br.com.senior.hotelproj.controller;

import br.com.senior.hotelproj.model.dao.HospedeDao;
import br.com.senior.hotelproj.model.idao.IHospedeDao;

public class HospedeController {
	private IHospedeDao iHospedeDao;

	public HospedeController() throws Throwable {
		iHospedeDao = new HospedeDao();
	}
}
