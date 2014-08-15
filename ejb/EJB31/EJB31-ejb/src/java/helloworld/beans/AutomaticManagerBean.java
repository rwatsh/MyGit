/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.UserTransaction;

/**
 * Bean implementation for controlling the timer service EJB.
 * 
 * @author rwatsh
 */
@TransactionManagement(TransactionManagementType.BEAN)
@Stateless
public class AutomaticManagerBean implements AutomaticManagerBeanRemote {
    @EJB
    private AutomaticSayHelloBean automaticSayHelloBean;
    @Resource
    private TimerService timerService;
    private int threshold;
    @Resource SessionContext context;
    
    @Override
    public void manageTimer(int interval, int threshold) {
        this.threshold= threshold;
        int currentCount = automaticSayHelloBean.getNotificationCount();
        if (currentCount >= threshold){
            try {
                //automaticSayHelloBean.cancelTimer();
                cancelSayHelloTimer();
            } catch (Exception ex) {
                Logger.getLogger(AutomaticManagerBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            timerService.createIntervalTimer(interval, interval, null);
        }
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    @Timeout
    public void monitorAutomaticTimer(Timer timer) {        
        int currentCount = automaticSayHelloBean.getNotificationCount();
        if (currentCount >= threshold) {
            try {
                //automaticSayHelloBean.cancelTimer();
                cancelSayHelloTimer();
            } catch (Exception ex) {
                Logger.getLogger(AutomaticManagerBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            timer.cancel();
        }
    }
    
    private void cancelSayHelloTimer() throws Exception {
        UserTransaction ut = context.getUserTransaction();
        ut.begin();
        automaticSayHelloBean.cancelTimer();
        ut.commit();
    }

}
