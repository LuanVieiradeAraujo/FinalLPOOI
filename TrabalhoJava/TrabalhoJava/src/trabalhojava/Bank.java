
package trabalhojava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


public class Bank {
    private ArrayList<Cliente> arrCustomers = new ArrayList<Cliente>();
    
    void addClient (Cliente customer) {
        if(accountExists(customer.getConta().getNConta())){
            customer.getConta().setNConta(findValidAccount());
        }
        arrCustomers.add(customer);
    }
    
    private boolean accountExists(int accountNumber){
        for(Cliente c : arrCustomers){
            if(c.getConta().getNConta() == accountNumber) {
                return true;
            }
        }
        return false;
    }
    
    Cliente getCustomerPerAccountNum(int accountNum){
        Cliente customer = null;
        for(Cliente c : arrCustomers){
            if(c.getConta().getNConta() == accountNum){
                customer = c;
                break;
            }
        }
        return customer;
    }
    
    void removeCustomer(Cliente cliente){
        arrCustomers.remove(cliente);
    }
    
    private int findValidAccount(){
        int accountNumber;
        do {
            accountNumber = Conta.getProxNumConta();
        } while (accountExists(accountNumber));
        return accountNumber;
    }
        
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    Cliente getCustomerAccount(int conta){
        return arrCustomers.get(conta);
    }
    
    ArrayList<Cliente> getCustomers(){
        return arrCustomers;
    }
}
