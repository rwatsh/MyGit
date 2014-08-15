/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld.beans;

import java.util.Date;
import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 * Stateless session bean with a long running task executed asynchronously.
 *
 * @author rwatsh
 */
@Stateless
public class HelloEjbAsynchronous implements HelloEjbAsynchronousRemote {

    @Asynchronous
    @Override
    public Future<String> ejbAsynchronousSayHello(String name) {
        System.out.println(new Date().toString() + " - Begin - HelloEjbAsynchronous.ejbAsynchronousSayHello: " + name);

        // simulate some delay
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(new Date().toString() + " - End - HelloEjbAsynchronous.ejbAsynchronousSayHello: " + name);

        return new AsyncResult<String>("Hello " + name);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
