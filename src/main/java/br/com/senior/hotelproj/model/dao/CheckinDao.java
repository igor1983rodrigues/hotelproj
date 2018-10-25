package br.com.senior.hotelproj.model.dao;

import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import br.com.senior.hotelproj.model.baserepository.BaseDaoRepository;
import br.com.senior.hotelproj.model.entity.CheckinEntity;
import br.com.senior.hotelproj.model.entity.HospedeEntity;
import br.com.senior.hotelproj.model.idao.ICheckinDao;

public class CheckinDao extends BaseDaoRepository<CheckinEntity> implements ICheckinDao {

	public CheckinDao() throws Exception {
		super();
	}

	@Override
	public List<CheckinEntity> obterEmAberto() {
		return obter((builder, criterio, variableRoot) -> {
			Path<Object> variavel = variableRoot.get("dataSaidaCheckin");
			criterio.select(variableRoot).where(builder.isNull(variavel));
		});
	}

	@Override
	public List<CheckinEntity> encerrado() {
		return obter((builder, criterio, variableRoot) -> criterio.select(variableRoot)
				.where(builder.notEqual(variableRoot.get("dataSaidaCheckin"), null)));
	}

	@Override
	public List<CheckinEntity> obterEmAberto(String nome, String documento, String telefone) {
		return queryJoin((builder, criteriaQuery, hospedeRoot, checkinRoot) -> {
			if (nome != null && !"".equalsIgnoreCase(nome)) {
				Predicate c1 = builder.like(hospedeRoot.get("nomeHospede"), String.format("%%%s%%", nome));
				criteriaQuery.where(c1);
			}
			if (documento != null && !"".equalsIgnoreCase(documento)) {
				criteriaQuery.where(builder.equal(hospedeRoot.get("documentoHospede"), documento));
			}
			if (telefone != null && !"".equalsIgnoreCase(telefone)) {
				criteriaQuery.where(builder.equal(hospedeRoot.get("telefoneHospede"), telefone));
			}

			criteriaQuery.where(builder.isNull(checkinRoot.get("dataSaidaCheckin")));
			criteriaQuery.where(builder.equal(hospedeRoot.get("idHospede"), checkinRoot.get("idHospede")));

		}, (hospede, checkin) -> {
			checkin.setHospede(hospede);
			return checkin;
		}, HospedeEntity.class, CheckinEntity.class, CheckinEntity.class);
	}

	@Override
	public List<CheckinEntity> encerrado(String nome, String documento, String telefone) {
		return queryJoin((builder, criteriaQuery, hospedeRoot, checkinRoot) -> {
			if (nome != null && !"".equalsIgnoreCase(nome)) {
				criteriaQuery.where(builder.like(hospedeRoot.get("nomeHospede"), String.format("%%%s%%", nome)));
			}
			if (documento != null && !"".equalsIgnoreCase(documento)) {
				criteriaQuery.where(builder.equal(hospedeRoot.get("documentoHospede"), documento));
			}
			if (telefone != null && !"".equalsIgnoreCase(telefone)) {
				criteriaQuery.where(builder.equal(hospedeRoot.get("telefoneHospede"), telefone));
			}

			criteriaQuery.where(builder.isNotNull(checkinRoot.get("dataSaidaCheckin")));
			criteriaQuery.where(builder.equal(hospedeRoot.get("idHospede"), checkinRoot.get("idHospede")));
		}, (hospede, checkin) -> {
			checkin.setHospede(hospede);
			return checkin;
		}, HospedeEntity.class, CheckinEntity.class, CheckinEntity.class);
	}

	@Override
	public CheckinEntity obterEmAberto(int idHospede) {
		List<CheckinEntity> lista = obter((builder, criterio, variableRoot) -> {
			criterio.select(variableRoot).where(builder.equal(variableRoot.get("idHospede"), idHospede));
			criterio.select(variableRoot).where(builder.isNull(variableRoot.get("dataSaidaCheckin")));
		});

		if (lista.size() > 0) {
			return lista.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<CheckinEntity> encerrado(int idHospede) {
		return obter((builder, criterio, variableRoot) -> {
			criterio.select(variableRoot).where(builder.equal(variableRoot.get("idHospede"), idHospede));
			criterio.select(variableRoot).where(builder.isNotNull(variableRoot.get("dataSaidaCheckin")));
		});
	}

}
