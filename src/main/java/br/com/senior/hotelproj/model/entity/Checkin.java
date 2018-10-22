package br.com.senior.hotelproj.model.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Checkin {
	@Id
	@GeneratedValue(generator = "increment")
	private int idCheckin;
	
	private int idHospede;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntradaCheckin;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSaidaCheckin;

	private boolean adicionalVeiculoCheckin;

	/**
	 * @return the idCheckin
	 */
	public int getIdCheckin() {
		return idCheckin;
	}

	/**
	 * @param idCheckin the idCheckin to set
	 */
	public void setIdCheckin(int idCheckin) {
		this.idCheckin = idCheckin;
	}

	/**
	 * @return the idHospede
	 */
	public int getIdHospede() {
		return idHospede;
	}

	/**
	 * @param idHospede the idHospede to set
	 */
	public void setIdHospede(int idHospede) {
		this.idHospede = idHospede;
	}

	/**
	 * @return the dataEntradaCheckin
	 */
	public Date getDataEntradaCheckin() {
		return dataEntradaCheckin;
	}

	/**
	 * @param dataEntradaCheckin the dataEntradaCheckin to set
	 */
	public void setDataEntradaCheckin(Date dataEntradaCheckin) {
		this.dataEntradaCheckin = dataEntradaCheckin;
	}

	/**
	 * @return the dataSaidaCheckin
	 */
	public Date getDataSaidaCheckin() {
		return dataSaidaCheckin;
	}

	/**
	 * @param dataSaidaCheckin the dataSaidaCheckin to set
	 */
	public void setDataSaidaCheckin(Date dataSaidaCheckin) {
		this.dataSaidaCheckin = dataSaidaCheckin;
	}

	/**
	 * @return the adicionalVeiculoCheckin
	 */
	public boolean isAdicionalVeiculoCheckin() {
		return adicionalVeiculoCheckin;
	}

	/**
	 * @param adicionalVeiculoCheckin the adicionalVeiculoCheckin to set
	 */
	public void setAdicionalVeiculoCheckin(boolean adicionalVeiculoCheckin) {
		this.adicionalVeiculoCheckin = adicionalVeiculoCheckin;
	}
}
