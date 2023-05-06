package CadastroFuncionario.CadastroFuncionarioLSE;

import java.util.Scanner;

public class main {
    public static void exibeOpcoes() {
        System.out.println("Programa de controle de cadastro de funcionários");
        System.out.println("OPÇÕES");
        System.out.println("1 – Admitir novo funcionário");
        System.out.println("2 – Exibir todos os funcionários da empresa");
        System.out.println("3 – Aplicar aumento de salário a um funcionário");
        System.out.println("4 – Exibir os dados de um funcionário");
        System.out.println("5 – Exibir toda a lista encadeada");
        System.out.println("6 – Encerrar o programa");
        System.out.print("Informe a opção: ");
    }

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        
        CadastroLSE lista1;
        Funcionario f;
        int op;
        String matricula, nome, cargo;
        double percentual, salario;
        
        do{
            exibeOpcoes();
            op = in.nextInt();in.nextLine();

            switch(op){
                case 1:
                System.out.println("Informe a matrícula do funcionário: ");
                matricula = in.nextLine();
                f = new Funcionario(matricula);

                System.out.println("Informe o nome do funcionário: ");
                nome = in.nextLine();
                f.setNome(nome);

                System.out.println("Informe o cargo: ");
                cargo = in.nextLine();
                f.setCargo(cargo);

                System.out.println("Informe o salário: ");
                salario = in.nextDouble();in.nextLine();

                System.out.println("Informe o ano de contratação ");
                f.setAno(op);
                lista1.inserir(f);
                
                break;

                case 2:
                lista1.imprimiLista();
                break;

                case 3:
                System.out.println("Informe a matrícula do funcionário:");
                matricula = in.nextLine();
                System.out.println("Informe o percentual de aumento: ");
                percentual = in.nextDouble();
                cadFuncionarios.aumentarSalario(matricula, percentual);
                break;

                case 4:
                System.out.println("Informe a matrícula");
                matricula = in.nextLine();
                cadFuncionarios.exibirFuncionario(matricula);
                break;

                case 5:
                cadFuncionarios.imprimiLista();
                break;

                case 6:
                System.out.println("Fim de programa!");
                break;

                default: System.out.println("Opção inválida!!");
            }

        }while(op != 6);
    }
}
