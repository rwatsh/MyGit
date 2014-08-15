/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb31;

import helloworld.beans.MessageFacadeRemote;
import helloworld.vo.GreetingRequest;
import javax.ejb.EJB;

/**
 * Message facade tester.
 * @author rwatsh
 */
public class MessageFacadeTest {

    @EJB
    private static MessageFacadeRemote messageFacade;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GreetingRequest request = messageFacade.sayHello();
        System.out.println("MessageFacadeTest.main: facade said - "
                + request);
    }
}
