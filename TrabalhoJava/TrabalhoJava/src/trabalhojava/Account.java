package trabalhojava;

import javax.swing.table.DefaultTableModel;

public abstract class Account implements accountInterface{
    private double balance = 0;
    private int accountNumber;
    private static int accountCount = 10000;
    Customer owner;

    Account(Customer owner){
        this.accountNumber = nextAccountNumber();
        this.owner = owner;
        DefaultTableModel accountTable = (DefaultTableModel) principalScreen.tabelaContas.getModel();
        Object[] row = {this.getAccountNumber(),this.getOwner(),this.getBalance(),this.getAccountType()};
        accountTable.addRow(row);
    }
 
    public abstract String getAccountType();
    
    public boolean withdraw (double newValue){
        if (newValue > 0){
            this.balance = this.balance - newValue;
            return true;
        } else {
            return false;
        }
    }    
    
    public static int nextAccountNumber(){
        return ++accountCount;
    }
    
    public void setAccountNumber(int newAccountNumber){
        this.accountNumber = newAccountNumber;
    }
    
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }
        
    public int getAccountNumber(){
        return accountNumber;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public abstract void pays();
    
    public Customer getOwner() {
        return this.owner;
    }
       
    public boolean deposits (double value){
        if(value > 0){
            this.balance = this.balance + value;
            return true;
        } else {
            return false;
        }
    }
    
}

