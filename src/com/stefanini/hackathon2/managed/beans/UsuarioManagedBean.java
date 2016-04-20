package com.stefanini.hackathon2.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Usuario;
import com.stefanini.hackathon2.servicos.UsuarioServico;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class UsuarioManagedBean {
	
	private Usuario Usuario;
	private List<Usuario> listaDeUsuariosCadastradas;
	
	@Inject
	private UsuarioServico servico;
	
	public UsuarioManagedBean() {
	}
	
	public void salvar() {
		servico.salvar(getUsuario());
		Mensageiro.notificaInformacao("Parabéns!", "Usuario salvo com sucesso!");
		carregaListaDeUsuarios();
		limpar();
	}
	
	public void deletar(Usuario Usuario) {
		servico.deletar(Usuario);
		Mensageiro.notificaInformacao("Parabéns!", "Usuario deletado com sucesso!");
		carregaListaDeUsuarios();
		limpar();
	}
	
	public void limpar() {
		setUsuario(new Usuario());
	}
	
	private void carregaListaDeUsuarios() {
		setListaDeUsuariosCadastradas(servico.carregaTodasUsuariosDoBanco());
	}
	
	public List<Usuario> getListaDeUsuariosCadastradas() {
		if (listaDeUsuariosCadastradas == null) {
			carregaListaDeUsuarios();
		}
		return listaDeUsuariosCadastradas;
	}
	
	public void setListaDeUsuariosCadastradas(List<Usuario> listaDeUsuariosCadastradas) {
		this.listaDeUsuariosCadastradas = listaDeUsuariosCadastradas;
	}
	
	public Usuario getUsuario() {
		if (Usuario == null) {
			limpar();
		}
		return Usuario;
	}
	
	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}
	
}
