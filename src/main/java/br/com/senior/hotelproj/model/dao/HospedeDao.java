package br.com.senior.hotelproj.model.dao;

import br.com.senior.hotelproj.model.baserepository.BaseDaoRepository;
import br.com.senior.hotelproj.model.entity.HospedeEntity;
import br.com.senior.hotelproj.model.idao.IHospedeDao;

public class HospedeDao extends BaseDaoRepository<HospedeEntity> implements IHospedeDao {

	public HospedeDao() throws Exception {
		super();
	}

}
