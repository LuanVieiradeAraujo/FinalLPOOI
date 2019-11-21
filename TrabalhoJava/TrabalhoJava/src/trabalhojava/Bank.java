
package trabalhojava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> arrCustomers = new ArrayList<Customer>();
    
    void addClient (Customer customer) {
        if(accountExists(customer.getAccount().getAccountNumber())){
            customer.getAccount().setAccountNumber(findValidAccount());
        }
        arrCustomers.add(customer);
    }
    
    private int findValidAccount(){
        int accountNumber;
        do {
            accountNumber = Account.nextAccountNumber();
        } while (accountExists(accountNumber));
        return accountNumber;
    }
        
    private boolean accountExists(int accountNumber){
        for(Customer c : arrCustomers){
            if(c.getAccount().getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false;
    }
    
    void removeCustomer(Customer customer){
        arrCustomers.remove(customer);
    }

    ArrayList<Customer> getCustomers(){
        return arrCustomers;
    }    
    
    Customer getCustomerAccount(int conta){
        return arrCustomers.get(conta);
    }
    
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    Customer getCustomerPerAccountNum(int accountNum){
        Customer customer = null;
        for(Customer c : arrCustomers){
            if(c.getAccount().getAccountNumber() == accountNum){
                customer = c;
                break;
            }
        }
        return customer;
    }    
}
