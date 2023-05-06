package AlunoLDEGenero;

public class LDEAluno {
    LDENode primeiro;
    LDENode ultimo;
    private int qtd;

    public boolean isEmpty(){
        if(this.primeiro == null && this.ultimo == null && qtd == 0){
            return true;
        }else{
            return false;
        }
    }

    private LDENode buscar(Aluno a){
        LDENode aux;

        if(this.primeiro == null){
            return null;
        }else{
            aux = this.primeiro;
            while(aux != null){
                if(a.compareTo(aux.getInfo()) == 0){
                    return aux;
                }
                aux = aux.getProx();
            }
            return null;
        }
    }
    


    public void inserirFinal(Aluno al){
       
            LDENode novo = new LDENode(al);
            LDENode retorno;
            retorno = this.buscar(al);
    
            if(retorno != null){
                System.out.println("Pessoa já cadastrada!");
    
            }else if(this.primeiro == null){
                this.primeiro = novo;
                this.ultimo = novo;
                this.qtd++;
    
            }else{
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
            }
    }

    public void dividir(LDEAluno h, LDEAluno m){
        LDENode aux = this.primeiro;
        while(aux != null){
        char genero = aux.getInfo().getGenero();
        if(genero == 'h'){
            Aluno al = aux.getInfo();
            Aluno copia = new Aluno(al.getGenero(), al.getNome());
            h.inserirOrdenado(copia);
        }else{
            Aluno al = aux.getInfo();
            Aluno copia = new Aluno(al.getGenero(), al.getNome());
            m.inserirOrdenado(copia);
        }
        aux = aux.getProx();
     }
    }


    public void inserirOrdenado(Aluno a){
        LDENode novo, atual, anterior;
        if (this.isEmpty() == true) {
            novo = new LDENode (a);
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd = 1;
            System.out.println("Inserção efetuada.");
        }
        else { // lista não vazia
            if (a.compareTo(this.primeiro.getInfo()) == 0) {
                System.out.println("Valor repetido. Inserção não efetuada.");
            }
            else if (a.compareTo(this.primeiro.getInfo()) < 0) { // inserir antes do primeiro
                novo = new LDENode (a);
                this.primeiro.setAnt(novo);
                novo.setProx(this.primeiro);
                this.primeiro = novo;
                this.qtd++; 
                System.out.println("Inserção efetuada.");
            }
            else if (a.compareTo(this.ultimo.getInfo()) == 0) {
                System.out.println("Valor repetido. Inserção não efetuada.");
            }
            else if (a.compareTo(this.ultimo.getInfo()) > 0 ) { // inserir depois do último
                novo = new LDENode (a);
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
                this.qtd++;     
                System.out.println("Inserção efetuada.");
            }
            else { // inserir no "meio" da lista. Precisa procurar a posição de inserção
                atual = this.primeiro;
                while (atual != null) {
                    if (atual.getInfo().compareTo(a) == 0) {
                        System.out.println("Valor repetido. Inserção não efetuada.");
                        return;
                    }
                    else if (atual.getInfo().compareTo(a) > 0) { // achamos a posição de inserção
                        novo = new LDENode (a);
                        anterior = atual.getAnt();
                        // inserir novo nó entre o anterior e o atual                       
                        anterior.setProx(novo);
                        novo.setAnt(anterior);
                        novo.setProx(atual);
                        atual.setAnt(novo);
                        this.qtd++;
                        System.out.println("Inserção efetuada.");
                        return;
                    }
                    else {
                        atual = atual.getProx();
                    }
                }
            }
        }
    }

    public void exibir(){
        LDENode aux;
        Aluno a;
        
        if(this.primeiro == null){
            System.out.println("Lista vazia!");
        }else{
            aux = this.primeiro;
            while(aux != null){
                a = aux.getInfo();
               System.out.println(a);
               aux = aux.getProx();
            }
        }
    }

}
