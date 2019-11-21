
package trabalhojava;

public class ContaCorrente extends Account{
    private double depositoInicial;
    private double limite;
        
    private static String tipoConta = "Corrente";
    
    public String getAccountType(){
        return tipoConta;
    }
    
    public String toString(){
        return "Tipo da Conta: Conta " + tipoConta + "\n" +
                "Numero da Conta: " + this.getAccountNumber() + "\n" +
                "Saldo: " + this.getBalance();
    }
    
    public void setDepositoInicial(double depositoInicial){
        this.depositoInicial = depositoInicial;
    }
    public double getDepositoInicial(){
        return this.depositoInicial;
    }
    public void setLimite(double limite){
        this.limite = limite;
    }
    public double getLimite(){
        return this.limite;
    }
    
    @Override
    public boolean withdraw(double valor){
        if(valor > super.getBalance() + limite){
            return false;
        } else {
            double balance = super.getBalance();
            balance = balance - valor;
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
