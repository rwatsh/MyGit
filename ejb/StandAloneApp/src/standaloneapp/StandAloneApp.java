/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package standaloneapp;

import helloworld.beans.HelloWorldBeanRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author rwatsh
 */
public class StandAloneApp {

    private static HelloWorldBeanRemote helloWorldBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.err.println("standaloneapp.Main.main: Stand-alone App started");
        String jndiPath = "java:global/EJB31/EJB31-ejb/HelloWorldBean";
        try {
            Context ctx = new InitialContext();
            System.out.println("standaloneapp.Main.main: looking up bean at: "
                    + jndiPath);
            helloWorldBean = (HelloWorldBeanRemote) ctx.lookup(jndiPath);
            System.out.println("standaloneapp.Main.main: found HelloWorldBean: "
                    + helloWorldBean);
            System.out.println("standaloneapp.Main.main: calling sayHello");
            String greeting = helloWorldBean.sayHello();
            System.out.println("standaloneapp.Main.main: HelloWorldBean said: "
                    + greeting);
        } catch (NamingException ex) {
            System.err.println(
                    "standaloneapp.Main.main: Could not find HelloWorldBeanRemote");
            System.err.println("standaloneapp.Main.main: JNDI path used for lookup: " + jndiPath);
            ex.printStackTrace();
        }
    }
}
