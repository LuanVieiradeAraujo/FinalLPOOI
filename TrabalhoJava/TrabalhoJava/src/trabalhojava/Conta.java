package trabalhojava;

public abstract class Conta implements ContaI{
    private int nConta;
    private double saldo = 0;
    private static int numeroContas = 10000;

    Conta(){
        this.nConta = getProxNumConta();
    }
   
    public static int getProxNumConta(){
        return ++numeroContas;
    }
    
    public abstract String getTipoConta();
    
    public double getSaldo(){
        return saldo;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
        
    public int getNConta(){
        return nConta;
    }
    
    public void setNConta(int nConta){
        this.nConta = nConta;
    }
    
    public abstract void remunera();
    
//    public Cliente getDono(){
//        return Cliente;
//    }
       
    public boolean deposita (double valor){
        if(valor > 0){
            this.saldo = this.saldo + valor;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean saca (double valor){
        if (valor > 0){
            this.saldo = this.saldo - valor;
            return true;
        } else {
            return false;
        }
    }
}

