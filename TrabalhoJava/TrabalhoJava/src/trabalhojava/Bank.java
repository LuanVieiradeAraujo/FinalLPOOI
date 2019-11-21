
package trabalhojava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


public class Bank {
    private ArrayList<Customer> arrCustomers = new ArrayList<Customer>();
    
    void addClient (Customer customer) {
        if(accountExists(customer.getAccount().getNConta())){
            customer.getAccount().setNConta(findValidAccount());
        }
        arrCustomers.add(customer);
    }
    
    private boolean accountExists(int accountNumber){
        for(Customer c : arrCustomers){
            if(c.getAccount().getNConta() == accountNumber) {
                return true;
            }
        }
        return false;
    }
    
    Customer getCustomerPerAccountNum(int accountNum){
        Customer customer = null;
        for(Customer c : arrCustomers){
            if(c.getAccount().getNConta() == accountNum){
                customer = c;
                break;
            }
        }
        return customer;
    }
    
    void removeCustomer(Customer customer){
        arrCustomers.remove(customer);
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
    
    Customer getCustomerAccount(int conta){
        return arrCustomers.get(conta);
    }
    
    ArrayList<Customer> getCustomers(){
        return arrCustomers;
    }
}
