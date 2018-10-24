package br.com.senior.hotelproj.model.entity;

import java.io.Serializable;

public class RegrasEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4797706122636865882L;
	private float precoDiario;
	private float precoFDS;
	private float precoAdicionalVeiculoDiario;
	private float precoAdicionalVeiculoFDS;
	private float horarioLimite;

	public float getPrecoDiario() {
		return precoDiario;
	}

	public void setPrecoDiario(float precoDiario) {
		this.precoDiario = precoDiario;
	}

	public float getPrecoFDS() {
		return precoFDS;
	}

	public void setPrecoFDS(float precoFDS) {
		this.precoFDS = precoFDS;
	}

	public float getPrecoAdicionalVeiculoDiario() {
		return precoAdicionalVeiculoDiario;
	}

	public void setPrecoAdicionalVeiculoDiario(float precoAdicionalVeiculoDiario) {
		this.precoAdicionalVeiculoDiario = precoAdicionalVeiculoDiario;
	}

	public float getPrecoAdicionalVeiculoFDS() {
		return precoAdicionalVeiculoFDS;
	}

	public void setPrecoAdicionalVeiculoFDS(float precoAdicionalVeiculoFDS) {
		this.precoAdicionalVeiculoFDS = precoAdicionalVeiculoFDS;
	}

	public float getHorarioLimite() {
		return horarioLimite;
	}

	public void setHorarioLimite(float horarioLimite) {
		this.horarioLimite = horarioLimite;
	}
}
