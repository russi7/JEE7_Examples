package net.dummy.rest.client.dummy;

import java.util.List;

import net.dummy.backend.api.rest.dummy.DummyRestService;
import net.dummy.dto.dummy.DummyDto;
import net.dummy.rest.client.AbstractRestClient;


public class DummyRestClient extends AbstractRestClient<DummyDto, DummyRestService> {
	
	public DummyDto getDummy(Long id) {
		return this.getService().get(id);
	}
	
	public List<DummyDto> getList() {
		return this.getService().getList();
	}
	
	public List<DummyDto> getDummyActive(Long id) {
		return getService().getDummyActive();
	}
	
	public void create(DummyDto dummyDto) {
		getService().create(dummyDto);
	}
	
	public void update(DummyDto dummyDto) {
		getService().update(dummyDto);
	}
	
	public void delete(Long id) {
		getService().delete(id);
	}
	
}
