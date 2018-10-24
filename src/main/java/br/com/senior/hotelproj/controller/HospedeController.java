package br.com.senior.hotelproj.controller;

import java.util.List;

import br.com.senior.hotelproj.model.dao.HospedeDao;
import br.com.senior.hotelproj.model.entity.HospedeEntity;
import br.com.senior.hotelproj.model.idao.IHospedeDao;

public class HospedeController extends BaseApiController implements IBaseController<HospedeEntity> {
	private IHospedeDao iHospedeDao;

	public HospedeController() throws Throwable {
		iHospedeDao = new HospedeDao();
	}

	@Override
	public void gravar(HospedeEntity model) throws Throwable {
		StringBuilder strMensagem = new StringBuilder();
		if ("".equalsIgnoreCase(model.getNomeHospede()))
			strMensagem.append			("Favor, informar o nome do hospede.\n");

		if ("".equalsIgnoreCase(model.getDocumentoHospede()))
			strMensagem.append("Favor, informar o número de documento do hospede.");

		if ("".equalsIgnoreCase(model.getDocumentoHospede()))
			strMensagem.append("Favor, informar o número de documento do hospede.");
		
		if (strMensagem.length() > 0)
			throw new Exception(strMensagem.toString());
		
		iHospedeDao.inserir(model);
	}

	@Override
	public void atualizar(HospedeEntity model) throws Throwable {
		StringBuilder strMensagem = new StringBuilder();
		if ("".equalsIgnoreCase(model.getNomeHospede()))
			strMensagem.append			("Favor, informar o nome do hospede.\n");

		if ("".equalsIgnoreCase(model.getDocumentoHospede()))
			strMensagem.append("Favor, informar o número de documento do hospede.");

		if ("".equalsIgnoreCase(model.getDocumentoHospede()))
			strMensagem.append("Favor, informar o número de documento do hospede.");
		
		if (strMensagem.length() > 0)
			throw new Exception(strMensagem.toString());
		
		iHospedeDao.alterar(model);
	}

	@Override
	public void excluir(HospedeEntity model) {
		iHospedeDao.excluir(model);
	}

	@Override
	public List<HospedeEntity> listarTudo() {
		return iHospedeDao.obterTodos();
	}

	@Override
	public HospedeEntity getPorChave(int id) throws Throwable {
		HospedeEntity model = iHospedeDao.obterPorChave(id);
		
		if (model == null)
			throw new Exception("Hospede não encontrado!");
		return model;
	}
}
