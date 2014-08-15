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
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 *
 * @author rwatsh
 */
@Singleton
@DependsOn("TimeBasedHelloWorldBean")
@LocalBean
public class SingletonHelloWorldBean implements SingletonHelloWorldBeanRemote {

    @EJB
    private TimeBasedHelloWorldBean timeBasedHelloWorldBean;
    private List<GreetingRequest> greetingRequests;

    public SingletonHelloWorldBean() {
        greetingRequests = new ArrayList<GreetingRequest>();
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("SingletonHelloWorldBean.postConstruct");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public GreetingRequest sayHello() {
        String greeting = timeBasedHelloWorldBean.sayHello();
        GreetingRequest request = new GreetingRequest(greeting);
        greetingRequests.add(request);
        return request;
    }

    @Override
    public GreetingRequest[] auditRequests() {
        return greetingRequests.toArray(new GreetingRequest[]{});
    }

    @PreDestroy
    private void destroy() {
        System.out.println("helloworld.beans.SingletonHelloWorldBean: @PreDestroy");
        for (GreetingRequest gr : greetingRequests) {
            System.out.println(gr);
        }
        greetingRequests = null;
    }
}
