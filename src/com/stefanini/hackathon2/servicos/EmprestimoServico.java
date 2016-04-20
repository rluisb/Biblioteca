package com.stefanini.hackathon2.servicos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Emprestimo;
import com.stefanini.hackathon2.repositorios.EmprestimoRepositorio;
import com.stefanini.hackathon2.transacao.Transacional;

public class EmprestimoServico {
	
	@Inject
	private EmprestimoRepositorio repositorio;
	
	@Transacional
	public void salvar(Emprestimo emprestimo) {
		if (emprestimo.getId() == null) {
			repositorio.inserir(emprestimo);
		} else {
			repositorio.atualizar(emprestimo);
		}
	}

	@Transacional
	public List<Emprestimo> carregaTodosEmprestimosDoBanco() {
		return repositorio.todosEmprestimos();
	}

	@Transacional
	public void deletar(Emprestimo emprestimo) {
		repositorio.remover(emprestimo);
	}
	
	
	@Transacional
	public int calcIntervaloDias(LocalDate inicio, LocalDate fim) {
		LocalDate diaDaSemana = inicio;
		Integer qtdDias = 0;

		if(fim == null) {
			fim = LocalDate.now();
		}
		
		while(diaDaSemana.isBefore(fim)) {
			if(diaDaSemana.getDayOfWeek() == DayOfWeek.FRIDAY) {
				diaDaSemana = diaDaSemana.plusDays(3);
			} else {
				diaDaSemana = diaDaSemana.plusDays(1);
			}
			qtdDias++;
		}
		return qtdDias <= 7 ? 0 : qtdDias - 7;
	}
}
