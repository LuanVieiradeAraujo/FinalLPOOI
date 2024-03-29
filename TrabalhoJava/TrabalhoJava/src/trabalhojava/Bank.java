
package trabalhojava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static trabalhojava.addAccountFrame2.customer;

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
        
        JOptionPane.showConfirmDialog(null, 
                "Este cliente e todas as contas respectivas serao apagadas", "Ok!", JOptionPane.DEFAULT_OPTION);
        
        for(Customer customer : arrCustomers){
            if(customer.getRg().equals(rg)){
                arrCustomers.remove(customer);
                break;
            }
        }
        int numRows = principalScreen.tabelaClientes.getSelectedRows().length;
        for(int i=0; i<numRows ; i++ ) {
            customerTable.removeRow(principalScreen.tabelaClientes.getSelectedRow());
        }
    }
    
    static void editCustomer(Customer customer){
        
        int index = -1;
        
        for(Customer customerInstance : arrCustomers){
            index++;            
            if(customerInstance.getRg().equals(customer.getRg())){
                break;
            }
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

    static Customer findCustomer(String customerName) {
        ArrayList<Customer> customers = Bank.getCustomers();
        for (int linha = 0; linha < customers.size(); linha++) {
            customer = customers.get(linha);
            if (customer.getName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }
    
    
    static ArrayList<Customer> getCustomers(){
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
