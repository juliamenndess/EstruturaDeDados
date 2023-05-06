package CadastroAluno.CadastroAlunoLSE;

public class LSEAluno {

    private LSENode primeiro;

    public LSEAluno(LSENode primeiro) {
        this.primeiro = primeiro;
    }

    public LSEAluno(){}

    public LSENode procurarAluno(Aluno aluno) {
        LSENode atual = primeiro;

        while (atual != null) {
            if (atual.getInfo().compareTo(aluno) == 0) {
                return atual;
            }
            atual = atual.getProx();
        }
        return null;
    }

    public void inserir(Aluno a){
            // Inserir um novo funcionário no início da lista de funcionários
            // Inserção não ordenada
            // Permite repetidos
            LSENode novo = new LSENode(a); // criar um novo nó
            novo.setInfo(a);          // "guardar" o funcionário no novo nó
            
            // Inserir o novo nó na lista de nós
            if (this.primeiro == null) {    // se a lista estiver vazia
                 this.primeiro = novo;
            }
            else {
                novo.setProx(this.primeiro);
                this.primeiro = novo;
            }
    }

    public void inserirFinal(Aluno aluno){
        if (procurarAluno(aluno) == null) {
            LSENode novoNo = new LSENode(aluno);

            if (primeiro == null) {
                primeiro = novoNo;
            } else {
                LSENode atual = primeiro;
                while (atual.getProx() != null) {
                    atual = atual.getProx();
                }
                atual.setProx(novoNo);
            }
        } else {
            System.out.println("O aluno já está na lista.");
        }
    }

    public boolean isEmpty() { // função para testar se a lista está vazia
        if (this.primeiro == null) {
            return true;
        }
        else {
            return false;
        }
    }    

    public void exibirTodos () {
        LSENode aux;
        Aluno a;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia");
        }
        else { 
            aux = this.primeiro;
            while (aux != null) {
                a = aux.getInfo();
                System.out.println(a);
                aux = aux.getProx();
            }
        }
    }

    public void exibirAluno(){

    }

    public void alterarDados(){

    }

    public void removerInicio(){

        if(this.primeiro ==  null){
            System.out.println("Lista vazia!");
        }else{

            this.primeiro = this.primeiro.getProx();
            System.out.println("Remoção efetuada!!");
        }
    }

    public void removerFinal(){
        LSENode aux, anterior;
        if(this.primeiro ==  null){

            System.out.println("Lista vazia!!");

        }else if(this.primeiro.getProx() == null){  //lista tem apenas um nó

            this.primeiro = this.primeiro.getProx();
            System.out.println("Remoção efetuada!! ");

        }else{
            anterior = null;
            aux = this.primeiro;
            while(aux.getProx() != null){
                anterior = aux;
                aux = aux.getProx();
            }
            anterior.setProx(null);
            System.out.println("Remoção efetuada!");
        }
        
    }

    public void remover(String matricula){
        Aluno alunoAux = new Aluno(matricula);
        LSENode atual, anterior;
        boolean flag = false;

        if(this.primeiro == null){
            System.out.println("Lista vazia!!");  //lista vazia

        }else if(this.primeiro.getProx() == null){
            this.primeiro = this.primeiro.getProx(); //apenas um nó

        }else{
            anterior = this.primeiro;
            atual = this.primeiro.getProx();
            while(atual != null){
                if(alunoAux.compareTo(atual.getInfo())!= 0){
                anterior = atual;
                atual = atual.getProx();
                
                }else{
                    flag = true;
                    break;
                }
            }
            if(flag == true){
                anterior.setProx(atual.getProx());
            }else{
                System.out.println("Aluno não encontrado!");
            }
        }
    }
}
