package br.com.senior.hotelproj.model.dao;

import br.com.senior.hotelproj.model.baserepository.BaseDaoRepository;
import br.com.senior.hotelproj.model.entity.CheckinEntity;
import br.com.senior.hotelproj.model.idao.ICheckinDao;

public class CheckinDao extends BaseDaoRepository<CheckinEntity> implements ICheckinDao {

	public CheckinDao() throws Exception {
		super();
	}

}
