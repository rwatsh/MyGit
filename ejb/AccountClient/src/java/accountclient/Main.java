/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accountclient;

import com.rwatsh.ejb.AccountBeanRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author rwatsh
 */
public class Main {
    //@EJB 
    //private static AccountBeanRemote acc;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        double balance;
        Context c = new InitialContext();
        AccountBeanRemote acc = (AccountBeanRemote)c.lookup("ejb/AccountBean");
        balance = acc.deposit(1000);
        System.out.println(balance);
        balance = acc.deposit(2000);
        System.out.println(balance);
        balance = acc.withdraw(500);
        System.out.println(balance);
    }
}
