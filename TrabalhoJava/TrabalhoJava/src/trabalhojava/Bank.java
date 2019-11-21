
package trabalhojava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Bank {
    static DefaultTableModel customerTable = (DefaultTableModel) principalScreen.tabelaClientes.getModel();
    static private ArrayList<Customer> arrCustomers = new ArrayList<Customer>();
        
    static private int findValidAccount(){
        int accountNumber;
        do {
            accountNumber = Account.nextAccountNumber();
        } while (accountExists(accountNumber));
        return accountNumber;
    }
            
    static void addCustomer (Customer customer) {
        arrCustomers.add(customer);
        Object[] row = {customer.getName(),customer.getSurname(),customer.getAddress(),customer.getRg(),customer.getCpf(),customer.getSalary()};
        customerTable.addRow(row);     
    }
    
    static void removeCustomer(){
        
        int column = 0;
        int row = principalScreen.tabelaClientes.getSelectedRow();
        
        String value = customerTable.getValueAt(row, column).toString();
        
        int r = 0;
        boolean found = false;
        
        do{
            arrCustomers.get(r).getName();
        
        }while(found == false);
        
        // arrCustomers.remove(customer);
        // Terminar remocao de cliente
        
        
        int numRows = principalScreen.tabelaClientes.getSelectedRows().length;
        for(int i=0; i<numRows ; i++ ) {
            customerTable.removeRow(principalScreen.tabelaClientes.getSelectedRow());
        }
    }
    
    void editCustomer(Customer customer){
        int column = 0;
        int row = principalScreen.tabelaClientes.getSelectedRow();
        
        String value = customerTable.getValueAt(0, column).toString();
        
        // terminar edicao de cliente
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
