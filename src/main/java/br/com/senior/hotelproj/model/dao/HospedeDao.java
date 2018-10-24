package br.com.senior.hotelproj.model.dao;

import java.util.List;

import br.com.senior.hotelproj.model.baserepository.BaseDaoRepository;
import br.com.senior.hotelproj.model.entity.HospedeEntity;
import br.com.senior.hotelproj.model.idao.IHospedeDao;

public class HospedeDao extends BaseDaoRepository<HospedeEntity> implements IHospedeDao {

	public HospedeDao() throws Exception {
		super();
	}

	@Override
	public List<HospedeEntity> obterPorNome(String nomeHospede) {
		return obter((builder, criterio, variableRoot) -> {
			criterio.select(variableRoot)
					.where(builder.like(variableRoot.get("NOME_HOSPEDE"), String.format("%%%s%%", nomeHospede)));

		});
	}

	@Override
	public List<HospedeEntity> obterPorTelefone(String telefoneHospede) {
		return obter((builder, criterio, variableRoot) -> {
			criterio.select(variableRoot).where(builder.equal(variableRoot.get("TEL_HOSPEDE"), telefoneHospede));

		});
	}

	@Override
	public HospedeEntity obterPorDocumento(String documentoHospede) {
		List<HospedeEntity> lista = obter((builder, criterio, variableRoot) -> {
			criterio.select(variableRoot).where(builder.equal(variableRoot.get("DOC_HOSPEDE"), documentoHospede));

		});

		if (lista.size() > 0)
			return lista.get(0);
		else
			return null;

	}
}
