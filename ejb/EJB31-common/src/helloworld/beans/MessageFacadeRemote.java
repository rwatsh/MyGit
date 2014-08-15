/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld.beans;

import helloworld.vo.GreetingRequest;
import javax.ejb.Remote;

/**
 *
 * @author rwatsh
 */
@Remote
public interface MessageFacadeRemote {

    GreetingRequest sayHello();
    
}
