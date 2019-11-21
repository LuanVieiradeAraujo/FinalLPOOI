
package trabalhojava;

public class currentAccount extends Account{
    private double initialDeposit;
    private double limit;
        
    private static String accountType = "Current";
    
    public String getAccountType(){
        return accountType;
    }
    
    public String toString(){
        return "Tipo da Conta: Conta " + accountType + "\n" +
                "Numero da Conta: " + this.getAccountNumber() + "\n" +
                "Saldo: " + this.getBalance();
    }
    
    public void setInitialDeposit(double newInitialDeposit){
        this.initialDeposit = newInitialDeposit;
    }
    public double getInitialDeposit(){
        return this.initialDeposit;
    }
    public void setLimit(double newLimit){
        this.limit = newLimit;
    }
    public double getLimit(){
        return this.limit;
    }
    
    @Override
    public boolean withdraw(double value){
        if(value > super.getBalance() + limit){
            return false;
        } else {
            double balance = super.getBalance();
            balance = balance - value;
            super.setBalance(balance);
            return true;
        }
    }
    
    @Override
    public void pays(){
        double balance = super.getBalance();
        balance = balance + (balance*0.1);
        super.setBalance(balance); 
    }

}
