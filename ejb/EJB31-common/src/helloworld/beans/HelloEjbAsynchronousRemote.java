/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld.beans;

import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 * Interface for the asynch session bean.
 *
 * @author rwatsh
 */
@Remote
public interface HelloEjbAsynchronousRemote {

    Future<String> ejbAsynchronousSayHello(String name);
    
}
