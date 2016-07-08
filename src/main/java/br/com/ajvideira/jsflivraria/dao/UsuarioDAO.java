package br.com.ajvideira.jsflivraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.ajvideira.jsflivraria.model.Usuario;

public class UsuarioDAO extends GenericDAO<Integer, Usuario> {

	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	public Usuario findByLoginAndPassword(String login, String password) {
		TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha", Usuario.class);
		query.setParameter("login", login);
		query.setParameter("senha", password);
		
		try {
			return query.getSingleResult();
		} catch (NoResultException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
