
package trabalhojava;

public class investmentAccount extends Account {
    private double minimumAmount;
    private double minimumDeposit;
    private double initialDeposit;
    
    private static String accountType = "Investimento";
    
     public String toString(){
        return "Tipo da Conta: Conta " + accountType + "\n" +
                "Numero da Conta: " + this.getAccountNumber() + "\n" +
                "Saldo: " + this.getBalance();
    }
     
    public String getAccountType(){
        return accountType;
    }

    public double getMinimumAmount() {
        return minimumAmount;
    }

    public double getMinimumDeposit() {
        return minimumDeposit;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setMinimumAmount(double newMinimumAmount) {
        this.minimumAmount = newMinimumAmount;
    }

    public void setMinimumDeposit(double newMinimumDeposit) {
        this.minimumDeposit = newMinimumDeposit;
    }

    public void setInitialDeposit(double newInitialDeposit) {
        this.initialDeposit = newInitialDeposit;
    }
    
    public boolean deposit(double value){
        if (value >= minimumDeposit){
            super.deposits(value);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean withdraw(double value) {
        double balance = super.getBalance();
        if (balance - value >= minimumAmount){
            super.withdraw(value);
            return true;
        } else {
            return false;
        }
    }
    
    public void pays(){
        double balance = super.getBalance();
        balance = balance + (balance*0.2);
        super.setBalance(balance); 
    }
}
