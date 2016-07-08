package br.com.ajvideira.jsflivraria.service;

import java.util.List;

import br.com.ajvideira.jsflivraria.dao.LivroDAO;
import br.com.ajvideira.jsflivraria.model.Livro;
import br.com.ajvideira.jsflivraria.util.SimpleEntityManager;

public class LivroService implements IService<Integer, Livro> {

	private LivroDAO livroDao;
	
	private SimpleEntityManager simpleEntityManager;
	
	public LivroService(SimpleEntityManager simpleEntityManager) {
		this.simpleEntityManager = simpleEntityManager;
		livroDao = new LivroDAO(simpleEntityManager.getEntityManager());
	}
	
	@Override
	public Livro findById(Integer pk) {
		return livroDao.findById(pk);
	}

	@Override
	public void save(Livro entity) {
		simpleEntityManager.beginTransaction();
		livroDao.save(entity);
		simpleEntityManager.commit();
	}

	@Override
	public void update(Livro entity) {
		simpleEntityManager.beginTransaction();
		livroDao.update(entity);
		simpleEntityManager.commit();
	}

	@Override
	public void delete(Livro entity) {
		simpleEntityManager.beginTransaction();
		livroDao.delete(entity);
		simpleEntityManager.commit();
	}

	@Override
	public List<Livro> findAll() {
		return livroDao.findAll();
	}

	
	
}
