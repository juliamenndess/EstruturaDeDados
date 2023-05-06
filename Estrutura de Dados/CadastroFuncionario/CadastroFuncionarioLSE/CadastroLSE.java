package CadastroFuncionario.CadastroFuncionarioLSE;

public class CadastroLSE {
    
    private LSEnode primeiro;

    public void inserir(Funcionario f){
        // Inserir um novo funcionário no início da lista de funcionários
        // Inserção não ordenada
        // Permite repetidos

    LSEnode novo = new LSEnode(f); // criar um novo nó e guardou
       

        // Inserir o novo nó na lista de nós
        if(this.primeiro == null){ // se a lista estiver vazia
            this.primeiro = novo;
        }else{
            novo.setProx(this.primeiro);
            this.primeiro = novo;
            
        }
    
    }

    public void imprimiLista(){
        LSEnode noAtual = this.primeiro;
        while(noAtual != null){
            System.out.println(noAtual);
            noAtual = noAtual.getProx();
        }
    }

    
}
