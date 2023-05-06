package InserirNumeroLDE;

import java.util.Scanner;

public class main {

    public static void exibirop(){
        System.out.println("Informe qual procedimento deseja: ");
        System.out.println("1- Inserir um número no início da lista");
        System.out.println("2- Remover o primeiro número da lista");
        System.out.println("3- Inserir um novo número no final da lista");
        System.out.println("4- Remover o último numero da lista");
        System.out.println("5- Exibir todos os números da lista do primeiro até o último");
        System.out.println("6- Exibir todos os números da lista do último até o primeiro");
        System.out.println("7- Inserir ordenado");
        System.out.println("8- Exibir os números ordenados ");
        System.out.println("9- Inserir aleatório ");
        System.out.println("10- Remover um número que não está ordenado");
        System.out.println("11- Exibir lista com repetidos: ");
        System.out.println("12- Sair do programa");

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int op = 0;
        Integer num;
        LDENumero lista1 = new LDENumero(); //Aleatório inserido no início s/ repetidos
        LDENumero lista2 = new LDENumero(); //Aleatório inserido no final s/ repetidos
        LDENumero lista3 = new LDENumero(); //Inserir ORDENADO s/ repetidos
        LDENumero lista4 = new LDENumero(); //Inserir repetido

        do{
            exibirop();
            op = in.nextInt();

            switch(op){
                case 1:
                System.out.println("Informe um número: ");
                num = in.nextInt();

                lista1.inserirInicio(num);
                break;

                case 2:
                System.out.println("Informe o número que deseja remover: ");
                num = in.nextInt();

                lista1.removerInicio();
                break;

                case 3:
                System.out.println("Informe o número que deseja inserir no final da lista: ");
                num = in.nextInt();

                lista1.inserirFinal(num);
                break;

                case 4:
                System.out.println("Informe o número que deseja remover no final da lista: ");
                num = in.nextInt();

                lista1.removerFinal();
                break;

                case 5:
                System.out.println("Número exibidos do início até o final: ");
                
                lista1.exibirInicio();
                break;

                case 6:
                System.out.println("Números exibidos do último até o início: ");

                lista1.exibirFinal();
                break;

                case 7:
                System.out.println("Informe um número:" );
                num = in.nextInt();

                lista3.inserirOrdenado(num);
                break;

                case 8:
                lista3.exibirInicio();

                default: System.out.println("Opção inválida!");

                case 9:
                System.out.println("Informe um número para ser inserido: ");
                num = in.nextInt();
 
                lista4.inserirRepetido(num);
                break;

                case 10:
                System.out.println("Informe o número que deseja remover: ");
                num = in.nextInt();

                lista4.removerRepetido(num);
                break;

                case 11:
                lista4.exibirInicio();
                break;

                

            }

        }while(op != 12);
    }
}
