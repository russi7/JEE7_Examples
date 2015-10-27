package net.dummy.mapping.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.dummy.backend.domain.AbstractEntity;
import net.dummy.dto.AbstractDto;
import net.dummy.mapping.Mapping;

public abstract class AbstractBeanMapping<E extends AbstractEntity, D extends AbstractDto> implements Mapping<E, D> {
	
	public D toDto(E entity) {
		D dto = null;
		try {
			dto = getDtoClass().newInstance();
			BeanUtils.copyProperties(dto, entity);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			
		}
		return dto;
	}
	
	public List<D> toDto(List<E> entityList) {
		List<D> dtoList = new ArrayList<D>();
		
		for(E entity : entityList) {
			dtoList.add(toDto(entity));
		}
		
		return dtoList;
	}
	
	public E toEntity(D dto) {
		E entity = null;
		try {
			entity = getEntityClass().newInstance();
			BeanUtils.copyProperties(entity, dto);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			
		}
		return entity;
	}
	
	public List<E> toEntity(List<D> dtoList) {
		List<E> entityList = new ArrayList<E>();
		
		for(D dto : dtoList) {
			entityList.add(toEntity(dto));
		}
		
		return entityList;
	}
	
	@SuppressWarnings("unchecked")
	private Class<E> getEntityClass() {
		return (Class<E>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	private Class<D> getDtoClass() {
		return (Class<D>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
}
