package net.dummy.backend.api.rest.dummy;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.dummy.backend.api.rest.RestService;
import net.dummy.dto.dummy.DummyDto;

@Path("/dummy")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public interface DummyRestService extends RestService<DummyDto> {
	
	@GET
	@Path("/active")
	public List<DummyDto> getDummyActive();
	
	@GET
	@Path("/{id}")
	public DummyDto get(@PathParam("id") Long id);
	
	@GET
	public List<DummyDto> getList();
	
}