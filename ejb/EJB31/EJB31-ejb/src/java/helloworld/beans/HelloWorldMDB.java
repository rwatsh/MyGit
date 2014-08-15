/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld.beans;

import helloworld.vo.GreetingRequest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author rwatsh
 */
@MessageDriven(mappedName = "jms/HelloWorldQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class HelloWorldMDB implements MessageListener {

    public HelloWorldMDB() {
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("HelloWorldMDB: @PostConstruct");
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                TextMessage textMessage = (TextMessage) message;
                String messageValue = textMessage.getText();
                System.out.println("HelloWorldMDB.onMessage: received text message - " + messageValue);
            } catch (JMSException ex) {
                Logger.getLogger(HelloWorldMDB.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (message instanceof ObjectMessage) {
            try {
                ObjectMessage objMessage = (ObjectMessage) message;
                Object contents = objMessage.getObject();
                if (contents instanceof GreetingRequest) {
                    String messageValue = contents.toString();
                    System.out.println("HelloWorldMDB.onMessage: received object message - " + messageValue);
                }
            } catch (JMSException ex) {
            }

        } else {
//do nothing
        }
    }

    @PreDestroy
    private void destroy() {
        System.out.println("HelloWorldMDB: @PreDestroy");
    }
}
