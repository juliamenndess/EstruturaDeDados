package CadastroFuncionario.CadastroFuncionarioOrdenado;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Cadastro {
    private Funcionario[] lista;
    private int total;
    
    public Cadastro(int tam){
        this.lista = new Funcionario[tam];
    }

    public void admitir(String matricula){
        Scanner in = new Scanner(System.in);
        String nome, cargo, matrAux;
        double salario;
        int ano, i;
        int result = this.buscaMelhorada(matricula);

        if(this.total == this.lista.length){

            System.out.println("Cadastro cheio!!");

        } else{
            
            //se nao tiver cheio, verifica se eh repetido
            result = this.buscaMelhorada(matricula);
            matrAux = this.lista[result].getMatricula();
            if(matrAux.compareTo(matricula) == 0){
                System.out.println("Matrícula repetida! ");

            }else{ //cadastra o funcionario
            Funcionario f = new Funcionario(matricula);

            System.out.println("Informe o nome do funcionário: ");
            nome = in.nextLine();
            f.setNome(nome);

            System.out.println("Informe o cargo que o funcionário irá ocupar: ");
            cargo = in.nextLine();
            f.setCargo(cargo);

            System.out.println("Informe o salário inicial do funcionário: ");
            salario = in.nextDouble();in.nextLine();
            f.setSalario(salario);

            //Obter o ano atual
            Calendar cal = GregorianCalendar.getInstance();
            ano = cal.get(Calendar.YEAR);
            // fim
            f.setAno(ano);

            for(i = this.total; i > result; i--){  //inserir ordenado o novo funcionário 
                this.lista[i] = this.lista[i-1];
                
            }

            this.lista[result] = f;
            this.total++;
            System.out.println("Cadastramento realizado! ");
            }
        }
    }

    public void aumentarSalario(String matricula, double percentual){
        Funcionario f = new Funcionario(matricula);
        int result = this.buscaMelhorada(matricula);
        String matrAux = this.lista[result].getMatricula();

        for(int i = 0; i <=this.total; i++){
            if(matrAux.compareTo(matricula) == 0){
                f.AplicarAumento(percentual);
                System.out.println("Aumento aplicado! ");
            }
        }
    }

    public void exibirFuncionario(String matricula){
      int i;
      Funcionario exibeFun = new Funcionario(matricula);
      for(i = 0; i <= this.total; i++){
        if(this.lista[i].compareTo(exibeFun) == 0){
            System.out.println(exibeFun.getMatricula() + " " + exibeFun.getNome() + " " + exibeFun.getSalario());
        }else{
            System.out.println("Matrícula inexistente! ");
        }
      }
    }

    public int buscaMelhorada(String matricula) { //ordem crescente
      int i;
      Funcionario procurado = new Funcionario(matricula);
      for (i = 0; i <= this.total - 1; i++) {
          if (this.lista[i].compareTo(procurado) >= 0) {
              return i;
          }
      }
      return i;
  }

  
  public void exibirTodos() {
    int i;
    if (this.total == 0) {
        System.out.println("Cadastro de funcionários vazio!");
    } else {
        System.out.println("Dados dos funcionários da empresa");
        for (i = 0; i <= this.total - 1; i++) {
            System.out.println("Funcionário " + (i + 1));
            System.out.println(this.lista[i]);
        }
      }
    }
}