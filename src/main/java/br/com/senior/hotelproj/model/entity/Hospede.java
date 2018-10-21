package br.com.senior.hotelproj.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_HOSPEDE")
public class Hospede {
	@Id
	@Column(name = "ID_HOSPEDE")
	private int idHospede;
	
	public int getIdHospede() {
		return this.idHospede;
	}
	
	public void setIdHospede(int idHospede) {
		this.idHospede = idHospede;\F
	}
}
