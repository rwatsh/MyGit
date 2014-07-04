package jmscommon;

import javax.ejb.Remote;

@Remote
public interface SingletonHelloWorldBeanRemote {

    GreetingRequest sayHello();

    GreetingRequest[] auditRequests();
  
}
