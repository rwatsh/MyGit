package rest;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class HelloTest {

	private static WebResource service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		service = client.resource(getBaseURI());
	}

	@Test
	public void testSayPlainTextHello() {
		String msg = service.path("rest").path("hello")
				.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class)
				.toString();
		System.out.println(msg);
		assertEquals(true, msg.contains("200"));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/rest").build();
	}

}
