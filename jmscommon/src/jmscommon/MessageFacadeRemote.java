package jmscommon;

import javax.ejb.Remote;

@Remote
public interface MessageFacadeRemote {
	GreetingRequest sayHello();
}
