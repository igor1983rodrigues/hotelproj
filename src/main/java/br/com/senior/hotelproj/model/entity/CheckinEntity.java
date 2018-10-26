package br.com.senior.hotelproj.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.inject.Default;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_CHECKIN", schema = "PUBLIC")
public class CheckinEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2734002046870572283L;

	@Id
	@Column(name="ID_CHECKIN")
	@GeneratedValue(generator = "increment")
	private int idCheckin;
	
	@Column(name = "ID_HOSPEDE")
	private int idHospede;

	@NotNull
	@Default
	@Column(name = "DT_ENTRADA_CHECKIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntradaCheckin;

	@Column(name = "DT_SAIDA_CHECKIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSaidaCheckin;
	
	@Column(name = "ADD_VEICULO_CHECKIN")
	private boolean adicionalVeiculoCheckin;
	
	@ManyToOne
	private HospedeEntity hospede;

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

	public HospedeEntity getHospede() {
		return hospede;
	}

	public void setHospede(HospedeEntity hospede) {
		this.hospede = hospede;
	}
}
