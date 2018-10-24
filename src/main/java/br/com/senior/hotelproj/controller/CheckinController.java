package br.com.senior.hotelproj.controller;

import java.util.Calendar;
import java.util.List;

import br.com.senior.hotelproj.model.dao.CheckinDao;
import br.com.senior.hotelproj.model.dao.HospedeDao;
import br.com.senior.hotelproj.model.entity.CheckinEntity;
import br.com.senior.hotelproj.model.entity.HospedeEntity;
import br.com.senior.hotelproj.model.idao.ICheckinDao;
import br.com.senior.hotelproj.model.idao.IHospedeDao;

public class CheckinController extends BaseApiController implements IBaseController<CheckinEntity> {
	private ICheckinDao iCheckinDao;

	public CheckinController() throws Throwable {
		iCheckinDao = new CheckinDao();
	}

	protected List<CheckinEntity> listarEmAberto() {
		return iCheckinDao.obterEmAberto();
	}

	protected void gravarPorDocumento(String documento, CheckinEntity checkin) throws Throwable {
		IHospedeDao iHospedeDao = new HospedeDao();
		HospedeEntity hospede = iHospedeDao.obterPorDocumento(documento);
		if (hospede == null)
			throw new Exception(
					"Não foi possível realizar o checkin, pois o hospede ainda não está cadastrado no sistema.");

		if (iCheckinDao.obterEmAberto(hospede.getIdHospede()) != null)
			throw new Exception("Já existe um checkin em aberto para este hospede.");

		checkin.setDataEntradaCheckin(Calendar.getInstance().getTime());
		checkin.setDataSaidaCheckin(null);
		
		gravar(checkin);
	}

	@Override
	public void gravar(CheckinEntity model) throws Throwable {
		if (model.getIdHospede() == 0)
			throw new Exception("Favor, informar o hospede.\n");

		if (iCheckinDao.obterEmAberto(model.getIdHospede()) != null)
			throw new Exception("Já existe um checkin em aberto para este hospede");

		model.setDataEntradaCheckin(Calendar.getInstance().getTime());
		model.setDataSaidaCheckin(null);

		iCheckinDao.inserir(model);
	}

	protected void encerrarCheckin(int idHospede) throws Throwable {
		CheckinEntity checkin = iCheckinDao.obterEmAberto(idHospede);
		if (checkin == null)
			throw new Exception("Não há checkin em aberto para este hospede.");

		checkin.setDataSaidaCheckin(Calendar.getInstance().getTime());

		atualizar(checkin);
	}

	protected void encerrarCheckin(String documento) throws Throwable {
		List<CheckinEntity> checkins = iCheckinDao.obterEmAberto(null, documento, null);
		if (checkins.isEmpty())
			throw new Exception("Não há checkin em aberto para este hospede.");

		CheckinEntity checkin = checkins.get(0);
		checkin.setDataSaidaCheckin(Calendar.getInstance().getTime());

		atualizar(checkin);
	}

	@Override
	public void atualizar(CheckinEntity model) {
		iCheckinDao.alterar(model);
	}

	@Override
	public void excluir(CheckinEntity model) {
		iCheckinDao.excluir(model);

	}
	
	@Override
	public List<CheckinEntity> listarTudo()  {
		return iCheckinDao.obterTodos();
	}

	@Override
	public CheckinEntity listarPorChave(int id) {
		return iCheckinDao.obterPorChave(id);
	}

	protected List<CheckinEntity> obterEmAbertoPorNome(String nome) {
		List<CheckinEntity> lista = iCheckinDao.obterEmAberto(nome, null, null);
		return lista;
	}
	
	protected List<CheckinEntity> obterEmAbertoPorDocumento(String documento) {
		List<CheckinEntity> lista = iCheckinDao.obterEmAberto(null, documento, null);
		return lista;
	}

	protected List<CheckinEntity> obterEmAbertoPorTelefone(String telefone) {
		List<CheckinEntity> lista = iCheckinDao.obterEmAberto(null, null, telefone);
		return lista;
	}
}
