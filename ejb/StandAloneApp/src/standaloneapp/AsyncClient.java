/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package standaloneapp;

import helloworld.beans.HelloEjbAsynchronousRemote;
import java.util.concurrent.Future;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This client can be a SwingWorker waiting for server task to complete and
 * respond asynchronously while the client carries on with other UI tasks.
 *
 * @author rwatsh
 */
public class AsyncClient {

    private static HelloEjbAsynchronousRemote helloWorldBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.err.println("standaloneapp.Main.main: Stand-alone App started");
        String jndiPath = "java:global/EJB31/EJB31-ejb/HelloEjbAsynchronous";
        try {
            Context ctx = new InitialContext();
            System.out.println("standaloneapp.Main.main: looking up bean at: "
                    + jndiPath);
            helloWorldBean = (HelloEjbAsynchronousRemote) ctx.lookup(jndiPath);
            System.out.println("standaloneapp.Main.main: found HelloWorldBean: "
                    + helloWorldBean);
            System.out.println("standaloneapp.Main.main: calling sayHello");

            Future future = helloWorldBean.ejbAsynchronousSayHello("Watsh");

            while (!future.isDone()) {
                Thread.sleep(10000);
                System.out.println("Doing some other client tasks and waiting for server to respond");
            }

            String greeting = (String) future.get();

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
