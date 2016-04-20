package com.stefanini.hackathon2.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.stefanini.hackathon2.util.LocalDatePersistenceConverter;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_pessoa", nullable=true)
	private Pessoa pessoa;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_livro", nullable=true)
	private Livro livro;
	@Column(nullable=true)
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate retirada;
	@Convert(converter = LocalDatePersistenceConverter.class)
	@Column(nullable=true)
	private LocalDate devolucao;
	@Column(nullable=true)
	private String status;
	
	
	public Emprestimo() {
		this.pessoa = new Pessoa();
		this.livro = new Livro();
		this.retirada = LocalDate.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LocalDate getRetirada() {
		return retirada;
	}

	public void setRetirada(LocalDate retirada) {
		this.retirada = retirada;
	}

	public LocalDate getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(LocalDate devolucao) {
		this.devolucao = devolucao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((devolucao == null) ? 0 : devolucao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((retirada == null) ? 0 : retirada.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (devolucao == null) {
			if (other.devolucao != null)
				return false;
		} else if (!devolucao.equals(other.devolucao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (retirada == null) {
			if (other.retirada != null)
				return false;
		} else if (!retirada.equals(other.retirada))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
}
