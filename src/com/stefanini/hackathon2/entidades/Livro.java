package com.stefanini.hackathon2.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_livro;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String autor;
	@Column(nullable=false)
	private Integer paginas;
	@Column(nullable=false)
	private Integer qtde_estoque;
	@Column(nullable=true)
	private Integer qtde_emprestado;
	@Column(nullable=true)
	private String status;
	
	
	public Livro() {
	}


	public Integer getId() {
		return id_livro;
	}


	public void setId(Integer id_livro) {
		this.id_livro = id_livro;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public Integer getPaginas() {
		return paginas;
	}


	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}


	public Integer getQtde_estoque() {
		return qtde_estoque;
	}


	public void setQtde_estoque(Integer qtde_estoque) {
		this.qtde_estoque = qtde_estoque;
	}


	public Integer getQtde_emprestado() {
		return qtde_emprestado;
	}


	public void setQtde_emprestado(Integer qtde_emprestado) {
		this.qtde_emprestado = qtde_emprestado;
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
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((id_livro == null) ? 0 : id_livro.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((paginas == null) ? 0 : paginas.hashCode());
		result = prime * result + ((qtde_emprestado == null) ? 0 : qtde_emprestado.hashCode());
		result = prime * result + ((qtde_estoque == null) ? 0 : qtde_estoque.hashCode());
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
		Livro other = (Livro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (id_livro == null) {
			if (other.id_livro != null)
				return false;
		} else if (!id_livro.equals(other.id_livro))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (paginas == null) {
			if (other.paginas != null)
				return false;
		} else if (!paginas.equals(other.paginas))
			return false;
		if (qtde_emprestado == null) {
			if (other.qtde_emprestado != null)
				return false;
		} else if (!qtde_emprestado.equals(other.qtde_emprestado))
			return false;
		if (qtde_estoque == null) {
			if (other.qtde_estoque != null)
				return false;
		} else if (!qtde_estoque.equals(other.qtde_estoque))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
