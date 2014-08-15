/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package standaloneapp;

import helloworld.beans.StatefulHelloWorldBeanRemote;
import helloworld.vo.GreetingRequest;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author rwatsh
 */
public class StatefulHelloWorldBeanTest {

    private static StatefulHelloWorldBeanRemote helloWorldBean;

    public static void main(String[] args) {
        System.err.println("standaloneapp.Main.main: Stand-alone App started");
        String jndiPath = "java:global/EJB31/EJB31-ejb/StatefulHelloWorldBean";
        try {
            Context ctx = new InitialContext();
            System.out.println("standaloneapp.Main.main: looking up bean at: "
                    + jndiPath);
            helloWorldBean = (StatefulHelloWorldBeanRemote) ctx.lookup(jndiPath);
            System.out.println("standaloneapp.Main.main: found HelloWorldBean: "
                    + helloWorldBean);
            System.out.println("standaloneapp.Main.main: calling sayHello");
            GreetingRequest greeting = helloWorldBean.sayHello();
            System.out.println("standaloneapp.StatefulHelloWorldBeanTest.main: HelloWorldBean said: " + greeting);
            for (int i = 0; i < 5; i++) {
                helloWorldBean.sayHello();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                }
            }
            GreetingRequest[] greetings = helloWorldBean.sayGoodBye();
            for(GreetingRequest gr : greetings) {
                System.out.println(gr);
            }
        } catch (NamingException ex) {
            System.err.println(
                    "standaloneapp.Main.main: Could not find HelloWorldBeanRemote");
            System.err.println("standaloneapp.Main.main: JNDI path used for lookup: " + jndiPath);
            ex.printStackTrace();
        }
    }
}
