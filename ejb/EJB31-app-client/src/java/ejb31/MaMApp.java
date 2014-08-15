/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb31;

import helloworld.beans.AutomaticManagerBeanRemote;
import javax.ejb.EJB;

/**
 * Test the automatic timer bean through its session facade
 * AutomaticManagerBean.
 *
 * @author rwatsh
 */
public class MaMApp {

    @EJB
    private static AutomaticManagerBeanRemote automaticManagerBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        automaticManagerBean.manageTimer(1000 * 60, 50);
        System.out.println("MaMApp.main: started management process");
    }
}
