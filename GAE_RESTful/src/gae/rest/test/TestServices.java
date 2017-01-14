package gae.rest.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class TestServices {
	
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String helloWorld(){
		return "<h1>Hello World</h1>";
	}
	
}
