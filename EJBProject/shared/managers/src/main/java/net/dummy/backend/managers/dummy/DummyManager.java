package net.dummy.backend.managers.dummy;

import java.util.List;

import net.dummy.backend.domain.DummyEntity;
import net.dummy.backend.managers.Manager;
import net.dummy.dto.dummy.DummyDto;

public interface DummyManager extends Manager {
	
	public List<DummyDto> getAll();
	public List<DummyEntity> _getAll();
	
	public DummyDto getDummy(Long id);
	public DummyEntity _getDummy(Long id);
	
	public void create(DummyDto dummyDto);
	public void _create(DummyEntity dummyEntity);
	
	public void update(DummyDto dummyDto);
	public void _update(DummyEntity dummyEntity);
	
	public void delete(Long id);
	
}
