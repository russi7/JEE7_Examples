package restFulClient;

import net.dummy.dto.dummy.DummyDto;
import net.dummy.rest.client.dummy.DummyRestClient;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class TestDummyRestService {
	
	@Test
	public void test01() {
		DummyRestClient dummyRestClient = new DummyRestClient();
		DummyDto dummyDto = dummyRestClient.getDummy(1L);
		System.out.println(dummyDto);
		Assert.assertTrue(1L == dummyDto.getId());
	}
	
}
