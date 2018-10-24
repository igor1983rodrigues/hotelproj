package br.com.senior.hotelproj.model.idao;

import java.util.List;

import br.com.senior.hotelproj.model.baseinterface.IBaseDaoInterface;
import br.com.senior.hotelproj.model.entity.HospedeEntity;

public interface IHospedeDao extends IBaseDaoInterface<HospedeEntity> {
	List<HospedeEntity> obterPorNome(String nomeHospede);

	List<HospedeEntity> obterPorTelefone(String nomeTelefone);

	HospedeEntity obterPorDocumento(String nomeDocumento);
}
