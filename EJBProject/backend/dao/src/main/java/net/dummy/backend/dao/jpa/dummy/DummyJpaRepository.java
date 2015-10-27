package net.dummy.backend.dao.jpa.dummy;

import java.util.List;

import net.dummy.backend.dao.dummy.DummyRepository;
import net.dummy.backend.dao.jpa.AbstractJpaRepository;
import net.dummy.backend.domain.DummyEntity;

public class DummyJpaRepository extends AbstractJpaRepository<DummyEntity> implements DummyRepository {
	
	@Override
	public List<DummyEntity> findAll() {
		return getEntityManager()
				.createNamedQuery(DummyEntity.NAMED_QUERY_FINDALL_NAME, DummyEntity.class)
				.getResultList();
	}
	
}
