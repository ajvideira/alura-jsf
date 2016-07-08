package br.com.ajvideira.jsflivraria.dao;

import javax.persistence.EntityManager;

import br.com.ajvideira.jsflivraria.model.Autor;

public class AutorDAO extends GenericDAO<Integer, Autor> {

	public AutorDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
