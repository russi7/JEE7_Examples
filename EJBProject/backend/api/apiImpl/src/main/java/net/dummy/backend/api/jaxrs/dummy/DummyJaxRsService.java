package net.dummy.backend.api.jaxrs.dummy;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import net.dummy.backend.api.jaxrs.AbstractJaxRsService;
import net.dummy.backend.api.rest.dummy.DummyRestService;
import net.dummy.backend.managers.dummy.DummyManager;
import net.dummy.dto.dummy.DummyDto;

@Stateless
public class DummyJaxRsService extends AbstractJaxRsService<DummyDto> implements DummyRestService {
	
	@Inject
	private DummyManager dummyManager;
	
	@Override
	public List<DummyDto> getList() {
		return dummyManager.getAll();
	}
	
	@Override
	public List<DummyDto> getDummyActive() {
		return dummyManager.getAll();
	}
	
	@Override
	public Response create(DummyDto dummyDto) {
		dummyManager.create(dummyDto);
		return Response.ok().build();
	}

	@Override
	public DummyDto get(Long id) {
		return dummyManager.getDummy(id);
	}

	@Override
	public Response update(DummyDto dto) {
		dummyManager.update(dto);
		return Response.ok().build();
	}

	@Override
	public Response delete(Long id) {
		dummyManager.delete(id);
		return Response.ok().build();
	}
	
}
