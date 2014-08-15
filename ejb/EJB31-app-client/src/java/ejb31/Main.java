/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb31;

import helloworld.beans.HelloWorldBeanRemote;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author rwatsh
 */
public class Main {

    @EJB
    private static HelloWorldBeanRemote helloWorldBean;

    /**
     * Lookup HelloWorldBean using JNDI lookup - Service locator pattern.
     *
     * @return
     */
    private static HelloWorldBeanRemote findHelloWorldBean() {
        String jndiPath = "java:global/EJB31/EJB31-ejb/HelloWorldBean";
        HelloWorldBeanRemote bean2 = null;
        try {
            Context ctx = new InitialContext();
            bean2 = (HelloWorldBeanRemote) ctx.lookup(jndiPath);
        } catch (NamingException ex) {
            System.err.println(
                    "ejb31.Main.findHelloWorldBean: Could not find HelloWorldBeanRemote");
            System.err.println("ejb31.Main.findHelloWorldBean: JNDI path used for lookup: " + jndiPath);
            ex.printStackTrace();
        }

        return bean2;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Main.main: calling HelloWorldBean");
        String greeting = helloWorldBean.sayHello();
        System.out.println("Main.main: HelloWorldBean said: "
                + greeting);

        HelloWorldBeanRemote bean2 = findHelloWorldBean();
        boolean equal = (helloWorldBean == bean2);
        System.out.println("Main.main: helloWorldBean == bean2: " + equal);
        boolean equals = (helloWorldBean.equals(bean2));
        System.out.println("Main.main: helloWorldBean.equals(bean2): " + equals);
    }
}
