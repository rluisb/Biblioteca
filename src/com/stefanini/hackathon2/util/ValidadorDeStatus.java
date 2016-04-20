package com.stefanini.hackathon2.util;

import com.stefanini.hackathon2.entidades.Emprestimo;

public class ValidadorDeStatus {
	
	;
	private int qtde;
	
	public boolean livroFoiEmprestado(Emprestimo emprestimo){
		if(!emprestimo.getRetirada().equals("")){
			qtde = emprestimo.getLivro().getQtde_emprestado();
			emprestimo.getLivro().setQtde_emprestado(qtde + 1);
			return true;
		}
		return false;
	}
	
	public boolean livroFoiDevolvido(Emprestimo emprestimo){
		if(!emprestimo.getDevolucao().equals("")){
			qtde = emprestimo.getLivro().getQtde_emprestado();
			emprestimo.getLivro().setQtde_emprestado(qtde - 1);
		}
		return false;
	}
	
	public boolean livroEstaDisponivel(Emprestimo emprestimo){
		if(emprestimo.getLivro().getQtde_estoque() > emprestimo.getLivro().getQtde_emprestado()){
			return true;
		}
		return false;
	}
}
