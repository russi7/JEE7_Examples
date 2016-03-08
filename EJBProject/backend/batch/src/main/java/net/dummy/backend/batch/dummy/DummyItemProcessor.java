package net.dummy.backend.batch.dummy;

import javax.batch.api.chunk.ItemProcessor;

import net.dummy.dto.dummy.DummyDto;

public class DummyItemProcessor implements ItemProcessor {

	@Override
	public DummyDto processItem(Object item) throws Exception {
		DummyDto dummyDto = (DummyDto) item;
		
		dummyDto.setName("Item Processor");
		dummyDto.setDescription("DummyDto processed by DummyItemProcessor");
		
		return dummyDto;
	}

}
