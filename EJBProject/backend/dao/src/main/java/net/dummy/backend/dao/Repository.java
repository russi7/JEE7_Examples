package net.dummy.backend.dao;

import java.util.List;

import net.dummy.backend.domain.AbstractEntity;

public interface Repository<E extends AbstractEntity> {
	
	public List<E> findAll();
	
	public E findById(Long id);
	
	public E create(E entity);
	
	public E update(E entity);
	
	public void delete(E entity);
	
}
