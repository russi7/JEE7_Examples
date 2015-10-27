package net.dummy.web.vaadin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import net.dummy.backend.api.rest.dummy.DummyRestService;
import net.dummy.dto.dummy.DummyDto;
import net.dummy.rest.client.dummy.DummyRestClient;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@WebServlet("/TestServlet")
public class TestServlet extends GenericServlet {
	
	private static final String URL_BASE		= "http://localhost:8080/apiImpl/rest";
	
	private static final long serialVersionUID = 7762876238635283252L;
	
	@Inject
	private DummyRestClient dummyRestClient;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		/* EJB Manager */
//		for(DummyDto dummyDto : dummyManager.getAll()) {
//			System.out.println(dummyDto);
//		}
		
		/* JAX-RS Client */
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target(URL_BASE);
//		
//		res.getWriter().println("<html>");
//		res.getWriter().println("<body>");
//		DummyDto dummyDto = target.path("/dummy/2").request().get(DummyDto.class);
//		res.getWriter().println(dummyDto + "<br>");
		
//		List<DummyDto> dummyDtoList = target.path("/dummy").request().get(new GenericType<List<DummyDto>>(){});
//		for(DummyDto dummy : dummyDtoList) {
//			res.getWriter().println(dummy + "<br>");
//		}
//		res.getWriter().println("</body>");
//		res.getWriter().println("</html>");
		
		
		/* RestEasy Client */
//		ResteasyClient client = new ResteasyClientBuilder().build();
//		ResteasyWebTarget target = client.target(URL_BASE);
//		DummyRestService dummyRestService = target.proxy(DummyRestService.class);
//		
//		res.getWriter().println("<html>");
//		res.getWriter().println("<body>");
//		//DummyDto dummyDto = dummyRestService.get(1L).readEntity(DummyDto.class);
//		DummyDto dummyDto = dummyRestService.get(1L);
//		res.getWriter().println(dummyDto + "<br>");
//		
//		//List<DummyDto> dummyDtoList = dummyRestService.getList().readEntity(new GenericType<List<DummyDto>>(){});
//		List<DummyDto> dummyDtoList = dummyRestService.getList();
//		for(DummyDto dummy : dummyDtoList) {
//			res.getWriter().println(dummy + "<br>");
//		}
//		res.getWriter().println("</body>");
//		res.getWriter().println("</html>");
		
		
		/* Injected restClient */
		res.getWriter().println("<html>");
		res.getWriter().println("<body>");
		
		//Get dummies
		for(DummyDto dummy : dummyRestClient.getList()) {
			res.getWriter().println(dummy + "<br>");
		}
		
//		//Update dummy
//		DummyDto dummyDto = dummyRestClient.getDummy(1L);
//		dummyDto.setDescription("Updated Description dummy Num. 1");
//		dummyRestClient.update(dummyDto);
//		
//		//Create new dummy
//		DummyDto dummyDtoNew = new DummyDto();
//		dummyDtoNew.setName("Created dummy");
//		dummyDtoNew.setDescription("New created dummyDto");
//		dummyRestClient.create(dummyDtoNew);
		
		res.getWriter().println("</body>");
		res.getWriter().println("</html>");
		
	}
}
