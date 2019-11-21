/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

/**
 *
 * @author Usuario
 */

public interface accountInterface {
    boolean deposits(double valor);
    boolean withdraw(double valor);
    Customer getOwner();
    int getAccountNumber();
    double getBalance();
    void pays();
}

