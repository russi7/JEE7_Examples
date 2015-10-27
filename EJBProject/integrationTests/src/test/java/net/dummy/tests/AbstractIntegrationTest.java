package net.dummy.tests;

import javax.inject.Inject;

import net.dummy.backend.managers.dummy.DummyManager;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class AbstractIntegrationTest {
	
	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addClasses(DummyManager.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		return jar;
	}
	
	@Inject
	private DummyManager dummyManager;
	
	@Test
	public void testInject() {
		Assert.assertEquals("", (long) dummyManager.getDummy(1L).getId(), 1L);
	}
	
}
