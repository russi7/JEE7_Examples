package net.dummy.backend.batch.dummy;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Inject;

import net.dummy.backend.batch.ItemWriter;
import net.dummy.backend.managers.dummy.DummyManager;
import net.dummy.dto.dummy.DummyDto;

public class DummyItemWriter extends AbstractItemWriter implements ItemWriter {
	
	@Inject
	private DummyManager dummyManager;
	
	@Override
	public void writeItems(List<Object> items) throws Exception {
		
		for(Object item : items) {
			DummyDto dummyDto = (DummyDto) item;
			dummyManager.update(dummyDto);
		}
	}

}
