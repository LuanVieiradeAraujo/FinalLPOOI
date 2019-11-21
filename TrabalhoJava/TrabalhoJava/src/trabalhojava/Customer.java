/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

/**
 *
 * @author Usuario
 */
public class Customer {
    private String name;
    private String surname;
    private String address;
    private String rg;
    private String cpf;
    private double salary;
    private Account account;
    
    Customer(String newName, String newSurname, String newAddress, String cpf, String rg, double newSalary){
        this.name = newName;
        this.surname = newSurname;
        this.address = newAddress;
        this.cpf = cpf;
        this.rg = rg;
        this.salary = newSalary;
    }
    
    public String toString(){
        return "\nInfo Cliente\n" + "Primeiro Nome: " +
                getName() + "\n" + "Sobrenome: " + getSurname() + "\n" + "Endereco:" +
                getAddress() + "\n" + "rg: " + getRg() + "\n" + "cpf: " + getCpf() + "\n" +
                "Salario: " + getSalary() + "\n" + account;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public String getName() {
        return name;
    }

    Account getAccount() {
        return account;
    }    
    
    public void setAccount(Account newAccount){
        this.account = account;
    }
    
    public String getAddress() {
        return address;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }
    
    public double getSalary() {
        return salary;
    }
}

