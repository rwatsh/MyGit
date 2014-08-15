/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld.beans;

import javax.ejb.Remote;

/**
 *
 * @author rwatsh
 */
@Remote
public interface HelloWorldBeanRemote {

    String sayHello();
    
}
