
package trabalhojava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Bank {

    static private ArrayList<Customer> arrCustomers = new ArrayList<>();
        
    static private int findValidAccount(){
        int accountNumber;
        do {
            accountNumber = Account.nextAccountNumber();
        } while (accountExists(accountNumber));
        return accountNumber;
    }
            
    static void addCustomer (Customer customer) {
        arrCustomers.add(customer);
        
        DefaultTableModel customerTable = (DefaultTableModel) principalScreen.tabelaClientes.getModel();
        Object[] row = {customer.getName(),customer.getSurname(),customer.getAddress(),customer.getRg(),customer.getCpf(),customer.getSalary()};
        customerTable.addRow(row);
        
    }
    
    static void removeCustomer(){
 
    }
    
    void editCustomer(Customer customer){

    }

    ArrayList<Customer> getCustomers(){
        return arrCustomers;
    }    
    
    static private boolean accountExists(int accountNumber){
        for(Customer c : arrCustomers){
            if(c.getAccount().getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false;
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
}
