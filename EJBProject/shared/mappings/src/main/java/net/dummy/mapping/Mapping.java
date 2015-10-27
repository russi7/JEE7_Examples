package net.dummy.mapping;

import java.util.List;

import net.dummy.backend.domain.AbstractEntity;
import net.dummy.dto.AbstractDto;

public interface Mapping<E extends AbstractEntity, D extends AbstractDto> {
	
	public D toDto(E entity);
	
	public List<D> toDto(List<E> entityList);
	
	public E toEntity(D dto);
	
	public List<E> toEntity(List<D> dtoList);
	
}
