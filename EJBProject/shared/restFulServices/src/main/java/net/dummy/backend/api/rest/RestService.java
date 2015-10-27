package net.dummy.backend.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public interface RestService<T> {
	
	@POST
	public Response create(T dto);
	
	@PUT
	public Response update(T dto);
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id);
	
}