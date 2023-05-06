package ProvaLDE;

public class LDEInteiros {
    private LDENode primeiro;
    private LDENode ultimo;
    private int qtd;

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

    public void inserirDrescenteRepetidos(Integer valor) {
        LDENode novo, atual, anterior;
        if (this.isEmpty() == true) {
            novo = new LDENode(valor);
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd = 1;
            System.out.println("Inserção efetuada.");
        } else { // lista não vazia
            if (valor.compareTo(this.primeiro.getInfo()) > 0) { // inserir antes do primeiro

                novo = new LDENode(valor);
                this.primeiro.setAnt(novo);
                novo.setProx(this.primeiro);
                this.primeiro = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
            }

            else if (valor.compareTo(this.ultimo.getInfo()) < 0) { // Inserir depois do último
                novo = new LDENode(valor);
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");

            } else { // inserir no "meio" da lista. Precisa procurar a posição de inserção
                atual = this.primeiro;
                while (atual != null) {
                    if (atual.getInfo().compareTo(valor) < 0) { // achamos a posição de inserção
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
                    } 
                    while(atual.getInfo().compareTo(valor) == valor){  //INSERIR DEPOIS DO IGUAL
                        LDENode proximo = atual.getProx();
                        if(proximo.getInfo() != valor){
                            novo = new LDENode(valor);
                            novo.setProx(proximo);
                            proximo.setAnt(novo);
                            novo.setAnt(atual);
                            atual.setProx(novo);
                            this.qtd++;
                            System.out.println("Inserido com sucesso!");
                            return;
                        }
                          atual = proximo;

                          /* 
                          INSERIR ANTES DO IGUAL

                          WHILE(atual.getinfo().CompareTo(valor) == valor)
                          LDENode anterior = atual.getAnt();
                          if(anterior.getInfo() != valor){
                            novo = new LDENode(valor);
                            novo.setProx(anterior);
                            proximo.setAnt(novo);
                            novo.setAnt(atual);
                            atual.setProx(novo);
                            this.qtd++;
                            return
                            }
                          atual = anterior;

                          */
                    }
                    atual = atual.getProx();
                }
            }
        }
    }

    public void juntar(LDEInteiros lista2){
        LDENode aux = lista2.primeiro;

        while(aux != null){
           LDENode novo = new LDENode(aux.getInfo());
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
                aux = aux.getProx();
        }

        lista2.primeiro = null;
        lista2.ultimo = null;
    }
}
