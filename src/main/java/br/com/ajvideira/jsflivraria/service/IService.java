package br.com.ajvideira.jsflivraria.service;

import java.io.Serializable;
import java.util.List;

public interface IService<PK extends Serializable, T> {

	public T findById(PK pk);
 
    public void save(T entity);
 
    public void update(T entity);
 
    public void delete(T entity);
 
    public List<T> findAll();
	
}
