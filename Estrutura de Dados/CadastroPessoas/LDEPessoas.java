package CadastroPessoas;

public class LDEPessoas {
    private LDENode primeiro;
    private LDENode ultimo;
    private int qtd;
    private int contMulher;
    private int contHomem;

    public LDENode getPrimeiro() {
        return primeiro;
    }
    public void setPrimeiro(LDENode primeiro) {
        this.primeiro = primeiro;
    }
    public LDENode getUltimo() {
        return ultimo;
    }
    public void setUltimo(LDENode ultimo) {
        this.ultimo = ultimo;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public boolean isEmpty() {
        if (this.primeiro == null && this.ultimo == null && this.qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void cadastrarFinal(Pessoa p){
        LDENode novo = new LDENode(p);
       
        if(this.primeiro == null){
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd++;

        }else{
            this.ultimo.setProx(novo);
            novo.setAnt(this.ultimo);
            this.ultimo = novo;
        }
    }

    public LDENode buscaMelhorada(Pessoa valor) { // para ordenados
        LDENode aux;
        boolean achou = false;
        aux = this.primeiro;
        while (aux != null) {
            if (aux.getInfo().compareTo(valor) == 0) {
                return aux;
            } else if (aux.getInfo().compareTo(valor) > 0) {
                return null;
            } else {
                aux = aux.getProx();
            }
        }
        return null;
    }

    public void inserirFinal (Pessoa valor) {
        LDENode novo = new LDENode (valor);

        if(buscaMelhorada(valor) == null ){
        if (this.isEmpty() == true) {
           this.primeiro = novo;
           this.ultimo = novo;
           this.qtd++;            
        }
        else {
            this.ultimo.setProx(novo);
            novo.setAnt(this.ultimo);
            this.ultimo = novo;
            this.qtd++;            
        }
    }else{
        System.out.println("Número repetido! ");
        }
    }  

    public void inserirInicio(Pessoa valor){
        LDENode novo = new LDENode(valor);
        novo.setInfo(valor);
        
        if(buscaMelhorada(valor) == null){
        if(this.isEmpty() == true){
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd++;
        }else{
           novo.setProx(this.primeiro);
           this.primeiro.setAnt(novo);
           this.primeiro = novo;
           this.qtd++;
        }
        }else{
        System.out.println("Número repetido! ");
        }
    } 

    public void inserirVazio(Pessoa valor){
        LDENode novo = new LDENode(valor);
        this.primeiro = novo;
        this.ultimo = novo;
        this.qtd = 1;
         System.out.println("Inserção efetuada.");
    }

    public void inserirMeio(Pessoa valor){
        LDENode novo, atual, anterior;
        atual = this.primeiro;
                while (atual != null) {
                    if (atual.getInfo() == valor) {
                        System.out.println("Valor repetido. Inserção não efetuada.");
                        return;
                    } else if (atual.getInfo().compareTo(valor) > 0) { // achamos a posição de inserção
                        novo = new LDENode(valor);
                        anterior = atual.getAnt();
                        // inserir novo nó entre o anterior e o atual
                        anterior.setProx(novo);
                        novo.setAnt(anterior);
                        novo.setProx(atual);
                        atual.setAnt(novo);
                        this.qtd++;
                        System.out.println("Inserção efetuada.");
                        return;
                    } else {
                        atual = atual.getProx();
                    }
                }
    }

    
    public void intercalar(LDEPessoas listaMulher, LDEPessoas listaHomem) { 
        contMulher = 0;
        contHomem = 0;
        LDENode aux = listaMulher.primeiro;
        LDENode aux2 = listaHomem.primeiro;
        
        //LISTA VAZIA!!
        
        Pessoa p = aux.getInfo();  

        if(listaMulher.isEmpty() != true){
        inserirVazio(p);
        aux = aux.getProx();
        contMulher++;
        }else if(listaHomem.isEmpty() != true){
            p = aux2.getInfo();
            inserirVazio(p);
            aux2 = aux2.getProx();
        }else{
            System.out.println("Ambas as listas vazias!");
        }
        

        
        while(aux.getProx() != null || aux2.getProx() != null){ //while vai rodar até percorrer as duas


        if(contMulher < contHomem){ //add mulher

            if(aux.getProx() == null){
             //logo insiro os homens, já que não tem mulheres
              p = aux2.getInfo();
              inserirMeio(p);
              contHomem++;
              aux2 = aux2.getProx();

            }else if (aux.getInfo().compareTo(this.primeiro.getInfo()) == 0) {
                System.out.println("Valor repetido. Inserção não efetuada.");

            } else if (aux.getInfo().compareTo(this.primeiro.getInfo()) < 0) { // inserir antes do primeiro < 0
                p = aux.getInfo();
                inserirInicio(p);
                contMulher++;
                aux = aux.getProx();

            } else if (aux.getInfo().compareTo(this.ultimo.getInfo()) == 0) {
                System.out.println("Valor repetido. Inserção não efetuada.");

            } else if (aux.getInfo().compareTo(this.ultimo.getInfo()) > 0) { // inserir depois do último
                p = aux.getInfo();
                inserirFinal(p);
                contMulher++;
                aux = aux.getProx();

            } else { // inserir no "meio" da lista. Precisa procurar a posição de inserção
                p = aux.getInfo();
                inserirMeio(p);
                contMulher++;
                aux = aux.getProx();
            }

         }else{ //quer dizer que contador de mulheres é maior, então vai add homem agora
            
            if(aux2.getProx() == null){
              //logo insiro mulheres, já que não tem homens
              p = aux.getInfo();
              inserirMeio(p);
              contMulher++;
              aux = aux.getProx();

            }  else if (aux2.getInfo() == this.primeiro.getInfo()) {
                System.out.println("Valor repetido. Inserção não efetuada.");

            } else if (aux2.getInfo().compareTo(this.primeiro.getInfo()) < 0) { // inserir antes do primeiro < 0
                p = aux2.getInfo();
                inserirInicio(p);
                contHomem++;
                aux2 = aux2.getProx();

            } else if (aux2.getInfo().compareTo(this.ultimo.getInfo()) == 0) {
                System.out.println("Valor repetido. Inserção não efetuada.");

            } else if (aux2.getInfo().compareTo(this.ultimo.getInfo()) > 0) { // inserir depois do último
                p = aux2.getInfo();
                inserirFinal(p);
                contHomem++;
                aux2 = aux2.getProx();

            } else { // inserir no "meio" da lista. Precisa procurar a posição de inserção
                p = aux2.getInfo();
                inserirMeio(p);
                contHomem++;
                aux2 = aux2.getProx();
            }
        }
     }
  }
}

