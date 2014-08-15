/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb31;

import helloworld.beans.SingletonHelloWorldBeanRemote;
import helloworld.vo.GreetingRequest;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * The message producer.
 * @author rwatsh
 */
public class MessageProducerApp {

    private static Message createJMSMessageForjmsHelloWorldQueue(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    private static void sendJMSMessageToHelloWorldQueue(Object messageData) throws NamingException, JMSException {
        Context c = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) c.lookup("jms/HelloWorldQueueFactory");
        Connection conn = null;
        Session s = null;
        try {
            conn = cf.createConnection();
            s = conn.createSession(false, s.AUTO_ACKNOWLEDGE);
            Destination destination = (Destination) c.lookup("jms/HelloWorldQueue");
            MessageProducer mp = s.createProducer(destination);
            mp.send(createJMSMessageForjmsHelloWorldQueue(s, messageData));
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (JMSException e) {
                    System.err.println("Cannot close session - " + e);
                }
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    private static SingletonHelloWorldBeanRemote lookupSingletonHelloWorldBeanRemote() {
        try {
            Context c = new InitialContext();
            return (SingletonHelloWorldBeanRemote) c.lookup("java:global/EJB31/EJB31-ejb/SingletonHelloWorldBean");
        } catch (NamingException ne) {
            ne.printStackTrace();
            throw new RuntimeException(ne);
        }
    }

    public static void main(String[] args) {
        SingletonHelloWorldBeanRemote hwr = lookupSingletonHelloWorldBeanRemote();
        GreetingRequest result = hwr.sayHello();
        String resultStr = result.toString();
        try {
            sendJMSMessageToHelloWorldQueue(resultStr);
            System.out.println("MessageProducerApp.main: sent message - " + resultStr);
        } catch (Exception ex) {
            System.err.println("MessageProducerApp.main: failed to send message - " + ex);
        }

    }
}
