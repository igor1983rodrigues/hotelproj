package br.com.senior.hotelproj.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_HOSPEDE")
public class Hospede {

	@Id
	@Column(name = "ID_HOSPEDE")
	@GeneratedValue(generator = "increment")
//	@GenericGenerator(name="increment", strategy = "increment")
	private int idHospede;

	@Column(name = "NOME_HOSPEDE")
	private String nomeHospede;

	@Column(name = "DOC_HOSPEDE")
	private String documentoHospede;

	@Column(name = "TEL_HOSPEDE")
	private String telefoneHospede;

	/**
	 * @return the idHospede
	 */
	public int getIdHospede() {
		return idHospede;
	}

	/**
	 * @return the nomeHospede
	 */
	public String getNomeHospede() {
		return nomeHospede;
	}

	/**
	 * @return the documentoHospede
	 */
	public String getDocumentoHospede() {
		return documentoHospede;
	}

	/**
	 * @return the telefoneHospede
	 */
	public String getTelefoneHospede() {
		return telefoneHospede;
	}

	/**
	 * @param idHospede the idHospede to set
	 */
	public void setIdHospede(int idHospede) {
		this.idHospede = idHospede;
	}

	/**
	 * @param nomeHospede the nomeHospede to set
	 */
	public void setNomeHospede(String nomeHospede) {
		this.nomeHospede = nomeHospede;
	}

	/**
	 * @param documentoHospede the documentoHospede to set
	 */
	public void setDocumentoHospede(String documentoHospede) {
		this.documentoHospede = documentoHospede;
	}

	/**
	 * @param telefoneHospede the telefoneHospede to set
	 */
	public void setTelefoneHospede(String telefoneHospede) {
		this.telefoneHospede = telefoneHospede;
	}
}
