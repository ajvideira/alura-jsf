package br.com.ajvideira.jsflivraria.service;

import java.util.List;

import br.com.ajvideira.jsflivraria.dao.AutorDAO;
import br.com.ajvideira.jsflivraria.model.Autor;
import br.com.ajvideira.jsflivraria.util.SimpleEntityManager;

public class AutorService implements IService<Integer, Autor> {

	private AutorDAO autorDao;
	
	private SimpleEntityManager simpleEntityManager;
	
	public AutorService(SimpleEntityManager simpleEntityManager) {
		this.simpleEntityManager = simpleEntityManager;
		autorDao = new AutorDAO(simpleEntityManager.getEntityManager());
	}
	
	@Override
	public Autor findById(Integer pk) {
		return autorDao.findById(pk);
	}

	@Override
	public void save(Autor entity) {
		simpleEntityManager.beginTransaction();
		autorDao.save(entity);
		simpleEntityManager.commit();
	}

	@Override
	public void update(Autor entity) {
		simpleEntityManager.beginTransaction();
		autorDao.update(entity);
		simpleEntityManager.commit();
	}

	@Override
	public void delete(Autor entity) {
		simpleEntityManager.beginTransaction();
		autorDao.delete(entity);
		simpleEntityManager.commit();
	}

	@Override
	public List<Autor> findAll() {
		return autorDao.findAll();
	}

}
