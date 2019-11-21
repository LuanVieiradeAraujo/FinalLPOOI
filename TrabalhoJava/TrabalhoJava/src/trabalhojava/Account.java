package trabalhojava;

public abstract class Account implements InterfaceConta{
    private double balance = 0;
    private int accountNumber;
    private static int accountCount = 10000;

    Account(){
        this.accountNumber = nextAccountNumber();
    }
   
    public static int nextAccountNumber(){
        return ++accountCount;
    }
    
    public abstract String getAccountType();
    
    public double getBalance(){
        return balance;
    }
    
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }
        
    public int getAccountNumber(){
        return accountNumber;
    }
    
    public void setAccountNumber(int newAccountNumber){
        this.accountNumber = newAccountNumber;
    }
    
    public abstract void pays();
    
//    public Cliente getDono(){
//        return Cliente;
//    }
       
    public boolean deposits (double value){
        if(value > 0){
            this.balance = this.balance + value;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean withdraw (double newValue){
        if (newValue > 0){
            this.balance = this.balance - newValue;
            return true;
        } else {
            return false;
        }
    }
}

