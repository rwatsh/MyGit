/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld.beans;

import helloworld.vo.GreetingRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author rwatsh
 */
@Stateful
public class StatefulHelloWorldBean implements StatefulHelloWorldBeanRemote {

    @EJB
    private TimeBasedHelloWorldBean timeBasedHelloWorldBean;
    private List<GreetingRequest> greetingRequests;

    public StatefulHelloWorldBean() {
        greetingRequests = new ArrayList<GreetingRequest>();
    }

    @PreDestroy
    private void destroy() {
        System.out.println("helloworld.beans.StatefulHelloWorldBean: @PreDestroy");
        printList();
    }

    @PostConstruct
    private void init() {
        System.out.println("helloworld.beans.StatefulHelloWorldBean: @PostConstruct");
        printList();
    }

    @PostActivate
    private void postActive() {
        System.out.println("helloworld.beans.StatefulHelloWorldBean: @PostActivate");
        printList();
    }

    @PrePassivate
    private void deinitialize() {
        System.out.println("helloworld.beans.StatefulHelloWorldBean: @PrePassivate");
        printList();
    }

    private void printList() {
        System.out.println("helloworld.beans.StatefulHelloWorldBean: greetingRequests.size - " + greetingRequests.size());
        for (GreetingRequest gr : greetingRequests) {
            System.out.println("helloworld.beans.StatefulHelloWorldBean: " + gr);
        }
    }

    @Override
    public GreetingRequest sayHello() {
        String greeting = timeBasedHelloWorldBean.sayHello();
        GreetingRequest request = new GreetingRequest(greeting);
        greetingRequests.add(request);
        return request;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    @Remove
    public GreetingRequest[] sayGoodBye() {
        return greetingRequests.toArray(new GreetingRequest[]{});
    }
}
