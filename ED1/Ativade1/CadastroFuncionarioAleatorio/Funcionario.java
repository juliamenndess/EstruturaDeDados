package Ativade1.CadastroFuncionarioAleatorio;

public class Funcionario implements Comparable <Funcionario>{
    private String matricula;
    private String nome;
    private String cargo;
    private double salario;
    private int ano;
    
    
    public Funcionario(String matricula){
        this.matricula = matricula;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCargo(){
        return this.cargo;
    }

    public double getSalario(){
        return this.salario;
        
    }

    public int getAno(){
        return this.ano;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

    public String toString(){
        return this.matricula + " " + this.nome + " " + this.cargo + " " + this.salario + " " + this.ano;
    }

    public int compareTo(Funcionario outro){
        return this.matricula.compareTo(outro.matricula);
    }

    public void AplicarAumento(double percentual){
        this.salario = this.salario + this.salario * percentual/100;
    }
}
