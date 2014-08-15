/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld.beans;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Facade pattern - calling another EJB from facade EJB.
 *
 * @author rwatsh
 */
@Stateless
public class HelloWorldBean implements HelloWorldBeanRemote {

    @EJB
    private TimeBasedHelloWorldBean timeBasedHelloWorldBean;

    @Override
    public String sayHello() {
        return timeBasedHelloWorldBean.sayHello();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
