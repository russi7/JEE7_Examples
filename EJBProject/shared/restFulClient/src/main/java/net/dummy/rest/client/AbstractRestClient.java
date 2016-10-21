package net.dummy.rest.client;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.context.RequestScoped;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import net.dummy.backend.api.rest.RestService;
import net.dummy.dto.AbstractDto;

@RequestScoped
public abstract class AbstractRestClient<D extends AbstractDto, S extends RestService<D>> {
	
	public static final String URL_BASE		= "http://localhost:8080/apiImpl/rest";
	
	protected S getService() {
		ResteasyWebTarget target = new ResteasyClientBuilder().build().target(getUrlBase());
		S restService = target.proxy(this.getServiceClass());
		
		return restService;
	}
	
	protected String getUrlBase() {
		return URL_BASE;
	}
	
	@SuppressWarnings("unchecked")
	private Class<S> getServiceClass() {
		return (Class<S>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
}
