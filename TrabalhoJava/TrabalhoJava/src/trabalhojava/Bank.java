
package trabalhojava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Bank {

    static private ArrayList<Customer> arrCustomers = new ArrayList<>();
    static DefaultTableModel customerTable = (DefaultTableModel) principalScreen.tabelaClientes.getModel();
    
    static void addCustomer (Customer customer) {
        customer.print();
        
        arrCustomers.add(customer);
        
        Object[] row = {customer.getName(),customer.getSurname(),customer.getAddress(),customer.getCpf(),customer.getRg(),customer.getSalary()};
        customerTable.addRow(row);
    }
    
    static void removeCustomer(Customer customer){
        
            customer.print();

            int index = arrCustomers.indexOf(customer);
            if(index == -1)
                System.out.println("ArrayList does not contain Customer");
            else
                arrCustomers.remove(customer);
            
            int numRows = principalScreen.tabelaClientes.getSelectedRows().length;
            for(int i=0; i<numRows ; i++ ) {
                customerTable.removeRow(principalScreen.tabelaClientes.getSelectedRow());
            }
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
