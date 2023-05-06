package CadastroEscritorioLDE;

import java.util.Scanner;

public class Main {

    public static void op(){
        System.out.println("Escolha uma opção: ");
        System.out.println("1- Cadastrar");
        System.out.println("2- Exibir nome e RG de todos que estão presentes no prédio");
        System.out.println("3- Exibir nome e RG de todos que estão presentes no prédio do ultimo até o primeiro");
        System.out.println("4- Verificar se a pessoa se encontra no prédio");
        System.out.println("5- Sair do prédio");
        System.out.println("6- Encerrar programa");
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int resp = 0;
        String nome;
        String rg;
        Pessoa p;
        LDEPessoas lista = new LDEPessoas();
        int entrada = 0;

        do{
           op();
           resp = in.nextInt();in.nextLine();

            switch(resp){

                case 1:
                System.out.println("Informe seu RG: ");
                rg = in.nextLine();
                p = new Pessoa(rg);

                System.out.println("Informe seu nome");
                nome = in.nextLine();
                p.setNome(nome);

                lista.cadastrarFinal(p);

                System.out.println("Cadastro feito! Deseja mesmo entrar no prédio? ");
                System.out.println("1- sim");
                System.out.println("2- não");
                entrada = in.nextInt();in.nextLine();

                while(entrada != 1 && entrada != 2){
                    System.out.println("Opção inválida! Informe novamente.");
                    System.out.println("Deseja mesmo entrar no prédio? ");
                    System.out.println("1- sim");
                    System.out.println("2- não");
                    entrada = in.nextInt();in.nextLine();
                }

                if(entrada == 1){
                    System.out.println("Seja em vindo(a)!");
                }else{
                    lista.remover(p);
                }

                break;

                case 2:
                lista.exibir();
                break;

                case 3:
                lista.exibirInverso();
                break;

                case 4:
                System.out.println("Informe o RG da pessoa que procura: ");
                rg = in.nextLine();
                p = new Pessoa(rg);
                lista.buscarPor(p);
                
                break;

                case 5:
                System.out.println("Informe seu RG: ");
                rg = in.nextLine();
                p = new Pessoa(rg);
                lista.remover(p);
                break;

                default: System.out.println("Opção inválida, digite novamente.");
            }

        }while(resp != 6);
    }
}
