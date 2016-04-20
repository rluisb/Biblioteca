package com.stefanini.hackathon2.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Funcionario;
import com.stefanini.hackathon2.servicos.FuncionarioServico;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class FuncionarioManagedBean {
	
	private Funcionario Funcionario;
	private List<Funcionario> listaDeFuncionariosCadastradas;
	
	@Inject
	private FuncionarioServico servico;
	
	public FuncionarioManagedBean() {
	}
	
	public void salvar() {
		servico.salvar(getFuncionario());
		Mensageiro.notificaInformacao("Parabéns!", "Funcionario salva com sucesso!");
		carregaListaDeFuncionarios();
		limpar();
	}
	
	public void deletar(Funcionario Funcionario) {
		servico.deletar(Funcionario);
		Mensageiro.notificaInformacao("Parabéns!", "Funcionario deletada com sucesso!");
		carregaListaDeFuncionarios();
		limpar();
	}
	
	public void limpar() {
		setFuncionario(new Funcionario());
	}
	
	private void carregaListaDeFuncionarios() {
		setListaDeFuncionariosCadastradas(servico.carregaTodasFuncionariosDoBanco());
	}
	
	public List<Funcionario> getListaDeFuncionariosCadastradas() {
		if (listaDeFuncionariosCadastradas == null) {
			carregaListaDeFuncionarios();
		}
		return listaDeFuncionariosCadastradas;
	}
	
	public void setListaDeFuncionariosCadastradas(List<Funcionario> listaDeFuncionariosCadastradas) {
		this.listaDeFuncionariosCadastradas = listaDeFuncionariosCadastradas;
	}
	
	public Funcionario getFuncionario() {
		if (Funcionario == null) {
			limpar();
		}
		return Funcionario;
	}
	
	public void setFuncionario(Funcionario Funcionario) {
		this.Funcionario = Funcionario;
	}
	
}
