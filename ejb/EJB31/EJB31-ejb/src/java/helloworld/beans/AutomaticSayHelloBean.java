/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld.beans;

import helloworld.interceptors.PMInterceptor;
import helloworld.vo.GreetingRequest;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

/**
 * This is a stateless bean using EJB timer service.
 *
 * @author rwatsh
 */
@Singleton
@LocalBean
@Startup
public class AutomaticSayHelloBean {

    @EJB
    private SingletonHelloWorldBean singletonHelloWorldBean;
    private int timerNotifications;
    private boolean cancelTimer = false;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /**
     * Using schedule will cause a timer notification to occur every 5 seconds.
     */
    @Interceptors(PMInterceptor.class)
    @Schedule(second = "*/5", minute = "*", hour = "*")
    public void sayHello(Timer timer) {
        if (!cancelTimer) {
            GreetingRequest request = singletonHelloWorldBean.sayHello();
            System.out.println("AutomaticSayHelloBean.sayHello:- " + request);
            timerNotifications++;
        } else {
            timer.cancel();
            System.out.println("AutomaticSayHelloBean.sayHello: canceled timer");
        }
    }

    public int getNotificationCount() {
        return timerNotifications;
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void cancelTimer() {
        this.cancelTimer = true;
    }
}
