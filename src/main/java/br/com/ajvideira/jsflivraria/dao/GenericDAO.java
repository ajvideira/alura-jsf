package br.com.ajvideira.jsflivraria.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

@SuppressWarnings("unchecked")
public class GenericDAO<PK extends Serializable, T> {
    protected EntityManager entityManager;
 
    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 
    public T findById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }
 
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
    public void update(T entity) {
        entityManager.merge(entity);
    }
 
    public void delete(T entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
 
    public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
