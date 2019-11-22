
package trabalhojava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
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
    
    static void removeCustomer(String rg){
        
        for(Customer customer : arrCustomers){
            if(customer.getRg().equals(rg)){
                arrCustomers.remove(customer);
            }
        }
        int numRows = principalScreen.tabelaClientes.getSelectedRows().length;
        for(int i=0; i<numRows ; i++ ) {
            customerTable.removeRow(principalScreen.tabelaClientes.getSelectedRow());
        }
    }
    
    static void editCustomer(Customer customer){
        
        int index = 0;
        
        customer.print();
        
        for(Customer customerInstance : arrCustomers){
            if(customerInstance.getRg().equals(customer.getRg())){
                break;
            }
            index++;
        }
        
        System.out.println("Index: " + index);
        
        arrCustomers.get(index).setName(customer.getName());
        arrCustomers.get(index).setSurname(customer.getSurname());
        arrCustomers.get(index).setAddress(customer.getAddress());
        arrCustomers.get(index).setRg(customer.getRg());
        arrCustomers.get(index).setCpf(customer.getCpf());
        arrCustomers.get(index).setSalary(customer.getSalary());
                
        int selectedRow = principalScreen.tabelaClientes.getSelectedRow();
        
        System.out.println(selectedRow);
        
        customerTable.setValueAt(customer.getName(), selectedRow, 0);
        customerTable.setValueAt(customer.getSurname(), selectedRow, 1);
        customerTable.setValueAt(customer.getAddress(), selectedRow, 2);
        customerTable.setValueAt(customer.getRg(), selectedRow, 3);
        customerTable.setValueAt(customer.getCpf(), selectedRow, 4);
        customerTable.setValueAt(customer.getSalary(), selectedRow, 5);
        
        
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
