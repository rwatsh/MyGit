package jmsejb;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import jmscommon.GreetingRequest;
import jmscommon.MessageFacadeRemote;

@Stateless
public class MessageFacade implements MessageFacadeRemote {
	@Resource(mappedName = "jms/Queue")
    private Queue helloWorldQueue;
    @Resource(mappedName = "jms/ConnectionFactory")
    private ConnectionFactory helloWorldQueueFactory;
    @EJB
    private SingletonHelloWorldBean singletonHelloWorldBean;
	@Override
	public GreetingRequest sayHello() {
		// TODO Auto-generated method stub
		return null;
	}

}
