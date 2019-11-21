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

public interface InterfaceConta {
        boolean deposita(double valor);
    boolean saca(double valor);
//  Cliente getDono();
    int getNConta();
    double getSaldo();
    void remunera();
}

