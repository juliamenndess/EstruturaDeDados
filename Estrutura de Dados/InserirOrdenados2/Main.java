package InserirOrdenados2;

import java.util.Scanner;

public class Main {

    public static void op(){
        System.out.println("1- Preencher lista decrescente sem repetidos");
        System.out.println("2- Preencher lista crescente com repetidos, o repetido add depois do repetido que já ta");
        System.out.println("3- Preencher lista decrescente sem repetidos e com remoção");
        System.out.println("4- Preencher lista crescente sem repetidos");
        System.out.println("5- Exibir lista 1");
        System.out.println("6- Exibir lista 2");
        System.out.println("7- Exibir lista 3");
        System.out.println("8- Exibir lista 4");
        System.out.println("9- Remover ítem da lista decrescente sem repetidos(lista 3)");
        System.out.println("10- Remover ítem da lista crescente sem repetidos (lista4)");
        System.out.println("11- Encerrar programa");
     }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int resp = 0;
        Integer num = 0;

        Inteiros l1 = new Inteiros();  //decrescente sem repetidos
        Inteiros l2 = new Inteiros();  //crescente com repetidos, o repetido add depois do repetido que já ta
        Inteiros l3 = new Inteiros();  //decrescente sem repetidos e com remoção
        Inteiros l4 = new Inteiros();  //crescente sem repetidos e com remoção
        
        do{
            op();
            resp = in.nextInt();in.nextLine();

            switch(resp){

                case 1:
                System.out.println("Informe um numero");
                num = in.nextInt();in.nextLine();
                l1.inserirDescrescenteSemRepetidos(num);
                break;

                case 2:
                System.out.println("Informe um numero");
                num = in.nextInt();in.nextLine();
                l2.inserirCrescenteRepetidos(resp);
                break;

                case 3:
                System.out.println("Informe um numero");
                num = in.nextInt();in.nextLine();
                l3.inserirDescrescenteSemRepetidos(num);
                break;

                case 4:
                System.out.println("Informe um numero");
                num = in.nextInt();in.nextLine();
                l4.inserirCrescenteSemRepetidos(num);
                break;

                case 5:
                l1.exibir();
                break;

                case 6:
                l2.exibir();
                break;

                case 7:
                l3.exibir();
                break;

                case 8:
                l4.exibir();
                break;

                case 9:
                break;

                case 10:
                break;

                default: System.out.println("Opção inválida!");
            }

        }while(resp != 11);
    }
}
