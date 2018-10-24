package br.com.senior.hotelproj.model.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.senior.hotelproj.model.baserepository.BaseDaoRepository;
import br.com.senior.hotelproj.model.entity.HospedeEntity;
import br.com.senior.hotelproj.model.idao.IHospedeDao;

public class HospedeDao extends BaseDaoRepository<HospedeEntity> implements IHospedeDao {

	public HospedeDao() throws Exception {
		super();
	}

	@Override
	public List<HospedeEntity> obterPorNome(String nomeHospede) {
		return obter(Restrictions.like("NOME_HOSPEDE", String.format("%%%s%%", nomeHospede)));
	}

	@Override
	public List<HospedeEntity> obterPorTelefone(String telefoneHospede) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("TEL_HOSPEDE", telefoneHospede);
		return null;
	}

	@Override
	public List<HospedeEntity> obterPorDocumento(String documentoHospede) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("DOC_HOSPEDE", documentoHospede);
		return null;
	}

}
