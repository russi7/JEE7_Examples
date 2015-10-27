package net.dummy.rest.client;

import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;

import net.dummy.backend.api.rest.RestService;
import net.dummy.dto.AbstractDto;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@RequestScoped
public abstract class AbstractRestClient<D extends AbstractDto, S extends RestService<D>> {
	
	public static final String URL_BASE		= "http://localhost:8080/apiImpl/rest";
	
	protected ResteasyWebTarget target;
	protected S restService;
	
	@PostConstruct
	protected void init() {
		this.target = new ResteasyClientBuilder().build().target(URL_BASE);
		restService = target.proxy(this.getServiceClass());
	}
	
	@PreDestroy
	protected void closeRestConnection() {
		//necessarily?
		this.target.getResteasyClient().close();
	}
	
	protected S getService() {
		return this.restService;
	}
	
//	@SuppressWarnings("unchecked")
//	private Class<D> getDtoClass() {
//		return (Class<D>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//	}
	
	@SuppressWarnings("unchecked")
	private Class<S> getServiceClass() {
		return (Class<S>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
}
