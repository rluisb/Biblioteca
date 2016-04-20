package com.stefanini.hackathon2.repositorios;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.hackathon2.entidades.Usuario;

@SuppressWarnings("all")
public class UsuarioRepositorio {
	
	@Inject
	private EntityManager entityManager;
	
	public void inserir(Usuario usuario) {
		entityManager.persist(usuario);
	}

	public List<Usuario> todasUsuarios() {
		return entityManager.createQuery("select l from " + Usuario.class.getSimpleName() + " l").getResultList();
	}
	
	public void remover(Usuario usuario) {
		entityManager.remove(entityManager.merge(usuario));
	}

	public void removerPorId(Integer id) {
		Usuario entity = entityManager.find(Usuario.class, id);
		entityManager.remove(entity);	
	}

	public void atualizar(Usuario usuario) {
		entityManager.merge(usuario);	
	}
	
	public Usuario pesquisarPorID(Integer id) {
		return entityManager.find(Usuario.class, id);
	}
	
	
}
