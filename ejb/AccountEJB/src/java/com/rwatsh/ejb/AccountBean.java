/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rwatsh.ejb;

import javax.ejb.Stateful;

/**
 *
 * @author rwatsh
 */
@Stateful(name="AccountBean", mappedName="ejb/AccountBean")
public class AccountBean implements AccountBeanRemote {
    private double balance;
    
    @Override
    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    @Override
    public double withdraw(double amount) {
        balance -= amount;
        return balance;
    }
}
