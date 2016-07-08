package br.com.ajvideira.jsflivraria.service;

import java.util.List;

import br.com.ajvideira.jsflivraria.dao.UsuarioDAO;
import br.com.ajvideira.jsflivraria.model.Usuario;
import br.com.ajvideira.jsflivraria.util.SimpleEntityManager;

public class UsuarioService implements IService<Integer, Usuario> {

	private UsuarioDAO usuarioDao;
	
	private SimpleEntityManager simpleEntityManager;
	
	public UsuarioService(SimpleEntityManager simpleEntityManager) {
		this.simpleEntityManager = simpleEntityManager;
		usuarioDao = new UsuarioDAO(simpleEntityManager.getEntityManager());
	}
	
	@Override
	public Usuario findById(Integer pk) {
		return usuarioDao.findById(pk);
	}

	@Override
	public void save(Usuario entity) {
		simpleEntityManager.beginTransaction();
		usuarioDao.save(entity);
		simpleEntityManager.commit();
	}

	@Override
	public void update(Usuario entity) {
		simpleEntityManager.beginTransaction();
		usuarioDao.update(entity);
		simpleEntityManager.commit();
	}

	@Override
	public void delete(Usuario entity) {
		simpleEntityManager.beginTransaction();
		usuarioDao.delete(entity);
		simpleEntityManager.commit();
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}
	
	public Usuario findByLoginAndPassword(String login, String password) {
		return usuarioDao.findByLoginAndPassword(login, password);
	}

}
