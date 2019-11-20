
package trabalhojava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;



public class Banco {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    
    void adicionaCliente (Cliente cliente) {
        if(contaExiste(cliente.getConta().getNConta())){
            cliente.getConta().setNConta(achaNumContaValido());
        }
        clientes.add(cliente);
    }
    
    private int achaNumContaValido(){
        int nConta;
        do {
            nConta = Conta.getProxNumConta();
        } while (contaExiste(nConta));
        return nConta;
    }
    
    private boolean contaExiste(int nConta){
        for(Cliente c : clientes){
            if(c.getConta().getNConta() == nConta) {
                return true;
            }
        }
        return false;
    }
    
    Cliente getCliente(int conta){
        return clientes.get(conta);
    }
    
    ArrayList<Cliente> getClientes(){
        return clientes;
    }
    
    Cliente getClientePorNumConta(int nConta){
        Cliente cliente = null;
        for(Cliente c : clientes){
            if(c.getConta().getNConta() == nConta){
                cliente = c;
                break;
            }
        }
        return cliente;
    }
    
    void removeCliente(Cliente cliente){
        clientes.remove(cliente);
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
