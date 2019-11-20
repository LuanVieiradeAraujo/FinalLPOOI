
package trabalhojava;

public class ContaCorrente extends Conta{
    private double depositoInicial;
    private double limite;
        
    private static String tipoConta = "Corrente";
    
    public String getTipoConta(){
        return tipoConta;
    }
    
    public String toString(){
        return "Tipo da Conta: Conta " + tipoConta + "\n" +
                "Numero da Conta: " + this.getNConta() + "\n" +
                "Saldo: " + this.getSaldo();
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
    
    public boolean saca(double valor){
        if(valor > super.getSaldo() + limite){
            return false;
        } else {
            double saldo = super.getSaldo();
            saldo = saldo - valor;
            super.setSaldo(saldo);
            return true;
        }
    }
    
    public void remunera(){
        double saldo = super.getSaldo();
        saldo = saldo + (saldo*0.1);
        super.setSaldo(saldo); 
    }
}
