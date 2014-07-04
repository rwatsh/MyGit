package rest.todo;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class TodoTest {

	private static WebResource service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		service = client.resource(getBaseURI());
	}

	@Test
	public void test() {
		// Get XML
		System.out.println(service.path("rest").path("todo")
				.accept(MediaType.TEXT_XML).get(String.class));
		// Get XML for application
		System.out.println(service.path("rest").path("todo")
				.accept(MediaType.APPLICATION_JSON).get(String.class));
		// Get JSON for application
		System.out.println(service.path("rest").path("todo")
				.accept(MediaType.APPLICATION_XML).get(String.class));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/rest").build();
	}

}
