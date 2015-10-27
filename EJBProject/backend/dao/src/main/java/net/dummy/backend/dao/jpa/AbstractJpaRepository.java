package net.dummy.backend.dao.jpa;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.dummy.backend.dao.Repository;
import net.dummy.backend.domain.AbstractEntity;

public abstract class AbstractJpaRepository<T extends AbstractEntity> implements Repository<T> {
	
	@PersistenceContext(unitName = "EJBProject")
	private EntityManager entityManager;
	
	@Override
	public T findById(Long id) {
		return entityManager.find(getEntityClass(), id);
	}
	
	@Override
	public T create(T entity) {
		entityManager.persist(entity);
		return entity;
	}
	
	@Override
	public T update(T entity) {
		return entityManager.merge(entity);
	}
	
	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
	
}
