/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld.beans;

import javax.ejb.Remote;
import javax.ejb.Timer;

/**
 * Interface to manage the EJB timer service.
 *
 * @author rwatsh
 */
@Remote
public interface AutomaticManagerBeanRemote {
    public void manageTimer(int interval, int threshold);

    void monitorAutomaticTimer(Timer timer);
}
