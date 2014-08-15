/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld.beans;

import helloworld.vo.GreetingRequest;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

/**
 *
 * @author rwatsh
 */
@Stateless
public class MessageFacade implements MessageFacadeRemote {

    @Resource(mappedName = "jms/HelloWorldQueue")
    private Queue helloWorldQueue;
    @Resource(mappedName = "jms/HelloWorldQueueFactory")
    private ConnectionFactory helloWorldQueueFactory;
    @EJB
    private SingletonHelloWorldBean singletonHelloWorldBean;

    private ObjectMessage createJMSMessageForjmsHelloWorldQueue(Session session, Serializable messageData) throws JMSException {
        // TODO create and populate message to send
        ObjectMessage om = session.createObjectMessage(messageData);
        return om;
    }

    private void sendJMSMessageToHelloWorldQueue(Serializable messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = helloWorldQueueFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(helloWorldQueue);
            messageProducer.send(createJMSMessageForjmsHelloWorldQueue(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public GreetingRequest sayHello() {
        GreetingRequest result = singletonHelloWorldBean.sayHello();
        try {
            sendJMSMessageToHelloWorldQueue(result);
            System.out.println("MessageFacade.sayHello: sent message - " + result);
        } catch (JMSException ex) {
            System.err.println("MessageFacade.sayHello: error sending message - "
                    + ex);
        }
        return result;
    }
}
