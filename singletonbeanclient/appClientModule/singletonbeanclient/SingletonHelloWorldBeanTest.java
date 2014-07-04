package singletonbeanclient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import jmscommon.GreetingRequest;
import jmscommon.SingletonHelloWorldBeanRemote;

public class SingletonHelloWorldBeanTest {
	private static SingletonHelloWorldBeanRemote helloWorldBean;
	public static void main(String[] args) {
        System.err.println("standaloneapp.Main.main: Stand-alone App started");
        String jndiPath = "java:global/EJB31/EJB31-ejb/SingletonHelloWorldBean";
        try {
            Context ctx = new InitialContext();
            System.out.println("standaloneapp.Main.main: looking up bean at: "
                    + jndiPath);
            helloWorldBean = (SingletonHelloWorldBeanRemote) ctx.lookup(jndiPath);
            System.out.println("standaloneapp.Main.main: found HelloWorldBean: "
                    + helloWorldBean);
            System.out.println("standaloneapp.Main.main: calling sayHello");
            GreetingRequest greeting = helloWorldBean.sayHello();
            System.out.println("standaloneapp.Main.main: HelloWorldBean said: "
                    + greeting);

            GreetingRequest[] audit = helloWorldBean.auditRequests();
            System.out.println("SingletonHelloWorldBeanTest.main: number of sayHello requests made on Singleton: " + audit.length);
        } catch (NamingException ex) {
            System.err.println(
                    "standaloneapp.Main.main: Could not find HelloWorldBeanRemote");
            System.err.println("standaloneapp.Main.main: JNDI path used for lookup: " + jndiPath);
            ex.printStackTrace();
        }
    }
}
