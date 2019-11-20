
package trabalhojava;

public class ContaInvestimento extends Conta {
    private double montanteMinimo;
    private double depositoMinimo;
    private double depositoInicial;
    
    private static String tipoConta = "Investimento";
    
     public String toString(){
        return "Tipo da Conta: Conta " + tipoConta + "\n" +
                "Numero da Conta: " + this.getNConta() + "\n" +
                "Saldo: " + this.getSaldo();
    }
     
    public String getTipoConta(){
        return tipoConta;
    }

    public double getMontanteMinimo() {
        return montanteMinimo;
    }

    public double getDepositoMinimo() {
        return depositoMinimo;
    }

    public double getDepositoInicial() {
        return depositoInicial;
    }

    public void setMontanteMinimo(double montanteMinimo) {
        this.montanteMinimo = montanteMinimo;
    }

    public void setDepositoMinimo(double depositoMinimo) {
        this.depositoMinimo = depositoMinimo;
    }

    public void setDepositoInicial(double depositoInicial) {
        this.depositoInicial = depositoInicial;
    }
    
    
    public boolean deposita(double valor){
        if (valor >= depositoMinimo){
            super.deposita(valor);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean saca(double valor) {
        double saldo = super.getSaldo();
        if (saldo - valor >= montanteMinimo){
            super.saca(valor);
            return true;
        } else {
            return false;
        }
    }
    
    public void remunera(){
        double saldo = super.getSaldo();
        saldo = saldo + (saldo*0.2);
        super.setSaldo(saldo); 
    }
}
