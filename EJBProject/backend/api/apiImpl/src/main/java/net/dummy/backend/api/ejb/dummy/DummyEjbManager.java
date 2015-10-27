package net.dummy.backend.api.ejb.dummy;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import net.dummy.backend.api.ejb.AbstractEjbManager;
import net.dummy.backend.dao.dummy.DummyRepository;
import net.dummy.backend.domain.DummyEntity;
import net.dummy.backend.managers.dummy.DummyManager;
import net.dummy.dto.dummy.DummyDto;
import net.dummy.mapping.DummyMapping;

@Stateless
public class DummyEjbManager extends AbstractEjbManager implements DummyManager {
	
	@Inject
	private DummyRepository dummyRepository;
	
	@Inject
	private DummyMapping dummyMapping;
	

	@Override
	public List<DummyDto> getAll() {
		return dummyMapping.toDto(this._getAll());
	}
	
	@Override
	public List<DummyEntity> _getAll() {
		return dummyRepository.findAll();
	}

	@Override
	public DummyDto getDummy(Long id) {
		return dummyMapping.toDto(this._getDummy(id));
	}
	
	@Override
	public DummyEntity _getDummy(Long id) {
		return dummyRepository.findById(id);
	}

	@Override
	public void create(DummyDto dummyDto) {
		this._create(dummyMapping.toEntity(dummyDto));
	}
	
	@Override
	public void _create(DummyEntity dummyEntity) {
		dummyRepository.create(dummyEntity);
	}

	@Override
	public void update(DummyDto dummyDto) {
		this._update(dummyMapping.toEntity(dummyDto));
	}
	
	@Override
	public void _update(DummyEntity dummyEntity) {
		dummyRepository.update(dummyEntity);
	}

	@Override
	public void delete(Long id) {
		dummyRepository.delete(this._getDummy(id));
	}

}
