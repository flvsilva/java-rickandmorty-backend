package com.iterative.rickandmorty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class RegistroOperacao {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private int id;
	
	@Column
	private String chamada;
	
	@Column
	@Lob
	private String retorno;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChamada() {
		return chamada;
	}

	public void setChamada(String chamada) {
		this.chamada = chamada;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
	
}
