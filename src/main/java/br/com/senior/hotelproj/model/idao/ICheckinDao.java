package br.com.senior.hotelproj.model.idao;

import java.util.List;

import br.com.senior.hotelproj.model.baseinterface.IBaseDaoInterface;
import br.com.senior.hotelproj.model.entity.CheckinEntity;

public interface ICheckinDao extends IBaseDaoInterface<CheckinEntity> {
	List<CheckinEntity> obterEmAberto();
	List<CheckinEntity> encerrado();

	CheckinEntity obterEmAberto(int idHospede);
	List<CheckinEntity> encerrado(int idHospede);

	List<CheckinEntity> obterEmAberto(String nome, String documento, String Telefone);
	List<CheckinEntity> encerrado(String nome, String documento, String Telefone);
}
