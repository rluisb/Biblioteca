package com.stefanini.hackathon2.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_pessoa;
	@Column(nullable=false)
	private String nome_pessoa;
	@Column(nullable=false)
	private String cpf_pessoa;

	public Pessoa() {
	}
	public Integer getId() {
		return id_pessoa;
	}
	public void setId(Integer id) {
		this.id_pessoa = id;
	}
	public String getNome() {
		return nome_pessoa;
	}
	public void setNome(String nome) {
		this.nome_pessoa = nome;
	}
	public String getCpf() {
		return cpf_pessoa;
	}

	public void setCpf(String cpf) {
		this.cpf_pessoa = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf_pessoa == null) ? 0 : cpf_pessoa.hashCode());
		result = prime * result + ((id_pessoa == null) ? 0 : id_pessoa.hashCode());
		result = prime * result + ((nome_pessoa == null) ? 0 : nome_pessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf_pessoa == null) {
			if (other.cpf_pessoa != null)
				return false;
		} else if (!cpf_pessoa.equals(other.cpf_pessoa))
			return false;
		if (id_pessoa == null) {
			if (other.id_pessoa != null)
				return false;
		} else if (!id_pessoa.equals(other.id_pessoa))
			return false;
		if (nome_pessoa == null) {
			if (other.nome_pessoa != null)
				return false;
		} else if (!nome_pessoa.equals(other.nome_pessoa))
			return false;
		return true;
	}
}
