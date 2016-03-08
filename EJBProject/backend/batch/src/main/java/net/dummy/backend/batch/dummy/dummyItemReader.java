package net.dummy.backend.batch.dummy;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Inject;
import javax.inject.Named;

import net.dummy.backend.batch.ItemProcessor;
import net.dummy.backend.managers.dummy.DummyManager;
import net.dummy.dto.dummy.DummyDto;

@Named
public class dummyItemReader extends AbstractItemReader implements ItemProcessor {
	
	@Inject
	private DummyManager dummyManager;
	
	@Override
	public DummyDto readItem() throws Exception {
		DummyDto dummyDto = dummyManager.getDummy(1L);
		return dummyDto;
	}

}
