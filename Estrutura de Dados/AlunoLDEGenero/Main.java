package AlunoLDEGenero;

import java.util.Scanner;


public class Main {

    public static void op(){
        System.out.println("Escolha uma opção: ");
        System.out.println("1- Cadastrar na lista aleatoria");
        System.out.println("2- Exibir lista dividida: ");
        System.out.println("3- Encerrar programa");
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int resp = 0;
        LDEAluno l1 = new LDEAluno();
        LDEAluno m = new LDEAluno();
        LDEAluno h = new LDEAluno();
        Aluno a;
        String matricula;
        String nome;
        char genero;

        do{
            op();
            resp = in.nextInt();in.nextLine();

            switch(resp){
                case 1:
                System.out.println("Informe sua matrícula");
                matricula = in.nextLine();
                a = new Aluno(matricula);

                System.out.println("Informe seu gênero: ");
                genero = in.next().charAt(0); in.nextLine();
                
                while(genero != 'm' && genero != 'h'){
                System.out.println("Gênero inválido! Informe um gênero válido. Informe m ou h");
                genero = in.next().charAt(0); in.nextLine();
                }
                a.setGenero(genero);

                System.out.println("Informe seu nome:");
                nome = in.nextLine();
                a.setNome(nome);

                l1.inserirFinal(a);
                

                break;

                case 2:

                h.exibir();
                m.exibir();
                break;

                case 3:
                l1.dividir(h, m);
                break;

            }

        }while(resp != 3);
    }
}
