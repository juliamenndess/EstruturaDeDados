package InserirOrdenados;

import java.util.Scanner;

public class Main {

    public static void op(){
       System.out.println("1- Preencher lista crescente com repetidos:");
       System.out.println("2- Preencher lista crescente sem repetidos");
       System.out.println("3- Preencher lista decrescente com repetidos");
       System.out.println("4- Preencher lista descrescente sem repetidos");
       System.out.println("5- Exibir lista 1");
       System.out.println("6- Exibir lista 2");
       System.out.println("7- Exibir lista 3");
       System.out.println("8- Exibir lista 4");
       System.out.println("9- Encerrar programa");
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int resp = 0;
        Integer num = 0;

        Inteiros l1 = new Inteiros(); // Crescente com repetidos
        Inteiros l2 = new Inteiros(); // Crescente sem repetidos
        Inteiros l3 = new Inteiros(); // Decrescente com repetidos
        Inteiros l4 = new Inteiros(); // Decrescente sem repetidos
        
        do{
            op();
            resp = in.nextInt();in.nextLine();

            switch(resp){
                case 1:
                break;

                case 2:
                System.out.println("Informe um número: ");
                num = in.nextInt();
                l2.inserirCrescenteSemRepetidos(resp);
                break;

                case 3:
                break;

                case 4:
                System.out.println("Informe um número: ");
                num = in.nextInt();
                l4.inserirDescrescenteSemRepetidos(num);
                break;

                case 5:
                break;

                case 6:
                l2.exibir();
                break;

                case 7:
                break;

                case 8:
                l4.exibir();
                break;

                default: System.out.println("Opção inválida!");
            }

        }while(resp != 9);
    }
}
