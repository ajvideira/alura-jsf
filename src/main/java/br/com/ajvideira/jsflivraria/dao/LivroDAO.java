package br.com.ajvideira.jsflivraria.dao;

import javax.persistence.EntityManager;

import br.com.ajvideira.jsflivraria.model.Livro;

public class LivroDAO extends GenericDAO<Integer, Livro> {

	public LivroDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
