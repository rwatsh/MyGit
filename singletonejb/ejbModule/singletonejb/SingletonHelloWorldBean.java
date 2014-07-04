package singletonejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

import jmscommon.GreetingRequest;
import jmscommon.SingletonHelloWorldBeanRemote;

/**
 * Singleton bean implementation.
 * 
 * @author rwatsh
 */
@Singleton
public class SingletonHelloWorldBean implements SingletonHelloWorldBeanRemote {

	private List<GreetingRequest> greetingRequests;

	public SingletonHelloWorldBean() {
		greetingRequests = new ArrayList<>();
	}

	// Add business logic below. (Right-click in editor and choose
	// "Insert Code > Add Business Method")

	@Override
	public GreetingRequest sayHello() {
		String greeting = "Hi";
		GreetingRequest request = new GreetingRequest(greeting);
		greetingRequests.add(request);
		return request;
	}

	@Override
	public GreetingRequest[] auditRequests() {
		return greetingRequests.toArray(new GreetingRequest[] {});
	}

	@PreDestroy
	private void destroy() {
		System.out
				.println("helloworld.beans.SingletonHelloWorldBean: @PreDestroy");
		for (GreetingRequest gr : greetingRequests) {
			System.out.println(gr);
		}
		greetingRequests = null;
	}
}