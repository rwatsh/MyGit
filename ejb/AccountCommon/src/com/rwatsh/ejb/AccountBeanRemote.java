/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rwatsh.ejb;

import javax.ejb.Remote;

/**
 * This is the Account remote interface.
 * 
 * @author rwatsh
 */
@Remote
public interface AccountBeanRemote {
    public double deposit(double amount);
    public double withdraw (double amount);
}
