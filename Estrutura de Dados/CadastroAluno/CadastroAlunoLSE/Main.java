package CadastroAluno.CadastroAlunoLSE;

import java.util.Scanner;

public class Main {

    public static void exibeOp(){
        System.out.println("1- Inserir um novo aluno no início da lista");
        System.out.println("2- Inserir um novo aluno no final da lista ");
        System.out.println("3- Exibir todos os alunos da lista");
        System.out.println("4- Exibir os dados de um aluno");
        System.out.println("5- Alterar os dados de um aluno");
        System.out.println("6- Remover o primeiro aluno da lista");
        System.out.println("7- Remover o último aluno da lista");
        System.out.println("8- Remover aluno escolhido");
        System.out.println("0- encerra programa");
    }

    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       int resp;
       LSEAluno turma1 = new LSEAluno();
       String matricula, nome;
       double media;
       int faltas;
       Aluno a;
       

       do{
        exibeOp();
        resp = in.nextInt();in.nextLine();

        switch(resp){
            case 1:
            System.out.println("Informe a matrícula do aluno: ");
            matricula = in.nextLine();
            a = new Aluno(matricula);

            System.out.println("Informe o nome do aluno: ");
            nome = in.nextLine();
            a.setNome(nome);

            System.out.println("Informe a média do aluno: ");
            media = in.nextDouble();in.nextLine();
            a.setMedia(media);

            System.out.println("Informe a quantidade de faltas do aluno: ");
            faltas = in.nextInt();in.nextLine();
            a.setFaltas(faltas);

            turma1.inserir(a);

            break;

            case 2:
            System.out.println("Inserir pelo final da lista");
            break;

            case 3:
            System.out.println("Todos os alunos da lista: ");
            turma1.exibirTodos();
            break;

            case 4:

            break;

            case 5:

            break;

            case 6:
            System.out.println("Remover o primeiro aluno da lista: ");
            turma1.removerInicio();
            
            break;

            case 7:
            System.out.println("Remover o último aluno da lista:");
            turma1.removerFinal();

            break;

            case 8:
            System.out.println("Informe a matrícula do aluno:");
            matricula = in.nextLine();
            turma1.remover(matricula);
        }

       }while(resp != 0);
    }
}
