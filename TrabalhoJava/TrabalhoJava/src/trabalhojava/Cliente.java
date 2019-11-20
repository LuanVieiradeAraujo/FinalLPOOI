package trabalhojava;

public class Cliente {
    private final String nome;
    private final String sobreNome;
    private final String endereco;
    private final String rg;
    private final String cpf;
    private final double salario;
    private final Conta conta;
    
    Cliente(String nome, String sobreNome, String endereco, String cpf, String rg, double salario, Conta conta){
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
        this.salario = salario;
        this.conta = conta;
    }

    public String toString(){
        return "\nInfo Cliente\n" + "Primeiro Nome: " +
                getNome() + "\n" + "Sobrenome: " + getSobreNome() + "\n" + "Endereco:" +
                getEndereco() + "\n" + "rg: " + getRg() + "\n" + "cpf: " + getCpf() + "\n" +
                "Salario: " + getSalario() + "\n" + conta;
    }
    
    
    Conta getConta() {
        return conta;
    }
    
    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }
    
    public double getSalario() {
        return salario;
    }
}
