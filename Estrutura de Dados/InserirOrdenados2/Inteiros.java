package InserirOrdenados2;

public class Inteiros {
    LDENode primeiro;
    LDENode ultimo;
    int qtd;

    public boolean isEmpty() {
        if (this.primeiro == null && this.ultimo == null && this.qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void exibir() {
        LDENode aux = this.primeiro;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else {
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    public LDENode buscaMelhorada(Integer valor) { // para ordenados
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

    public void removerInicioComRepetidos(Integer valor){
        LDENode aux;
            if(isEmpty() == true){
                System.out.println("Lista vazia!");
    
            }else{
            aux = this.primeiro;
            while(aux != null && aux.getInfo() == valor){   //O WHILE EXISTE PQ SE O SEGUNDO E TERCEIRO E ETC FOREM IGUAIS AO PRIMEIROS, JÁ REMOVE DE UMA VEZ
                if(this.qtd == 1){   //no caso de só ter 1 nó
                    this.primeiro = null;
                    this.ultimo = null;
                    this.qtd = 0;
        
                }else{ //casos gerais
                    this.primeiro = this.primeiro.getProx();
                    this.primeiro.setAnt(null);
                    this.qtd--;
                }
                aux = this.primeiro;
              }
            }
        }
    
        public void removerFinalComRepetidos(Integer valor){
           
            LDENode aux;
            if(isEmpty() == true){
                System.out.println("Lista vazia!");
    
            }else{
            aux = this.ultimo;
            while(aux != null && aux.getInfo() == valor){
                if(this.qtd == 1){   //no caso de só ter 1 nó
                    this.primeiro = null;
                    this.ultimo = null;
                    this.qtd = 0;
        
                }else{ //casos gerais
                    this.ultimo = this.ultimo.getAnt();
                    this.ultimo.setProx(null);
                    this.qtd--;
                }
                aux = this.ultimo;
              }
            }
        }

    public void remover(Integer valor) { // PARA ORDENADOS, com repetidos
        LDENode retorno;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else {
            retorno = this.buscaMelhorada(valor);
            if (retorno == null) {
                System.out.println("Valor não encontrado!");

            } else { // ACHOU!!
                if (this.primeiro.getInfo().compareTo(valor) == 0) {
                    while (!isEmpty() && this.primeiro.getInfo().compareTo(valor) == 0) { // no inicio
                        this.primeiro = this.primeiro.getProx();
                        this.primeiro.setAnt(null);
                        this.qtd--;
                    }
                } else if (this.ultimo.getInfo().compareTo(valor) == 0) { // no final
                    while (this.ultimo.getInfo().compareTo(valor) == 0) {
                        this.ultimo = this.ultimo.getAnt();
                        this.ultimo.setProx(null);
                        this.qtd--;
                    }
                } else { // no meio
                    retorno = this.buscaMelhorada(valor);
                    if (retorno == null) {
                        System.out.println("Valor não encontrado!");
                    } else {
                        LDENode anterior, proximo;
                        while (retorno.getInfo().compareTo(valor) == valor) { // SÓ FUNCIONA SE TIVER ORDENADA
                            anterior = retorno.getAnt();
                            proximo = retorno.getProx();
                            anterior.setProx(proximo);
                            proximo.setAnt(anterior);
                            this.qtd--;
                            retorno = retorno.getProx();
                        }
                    }
                }
            }
        }
    }

    public void removerInicioSemRepetidos(Integer valor){
        LDENode aux;
            if(isEmpty() == true){
                System.out.println("Lista vazia!");
    
            }else{
                if(this.qtd == 1){   //no caso de só ter 1 nó
                    this.primeiro = null;
                    this.ultimo = null;
                    this.qtd = 0;
        
                }else{ //casos gerais
                    this.primeiro = this.primeiro.getProx();
                    this.primeiro.setAnt(null);
                    this.qtd--;
                }
                
            }
        }
    
        public void removerFinalSemRepetidos(Integer valor){
           
            LDENode aux;
            if(isEmpty() == true){
                System.out.println("Lista vazia!");
    
            }else{
                if(this.qtd == 1){   //no caso de só ter 1 nó
                    this.primeiro = null;
                    this.ultimo = null;
                    this.qtd = 0;
        
                }else{ //casos gerais
                    this.ultimo = this.ultimo.getAnt();
                    this.ultimo.setProx(null);
                    this.qtd--;
                }
                
            }
        }

    public void removerSemRepetidos(Integer valor) {
        LDENode retorno;
        LDENode anterior, prox;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else {
            retorno = this.buscaMelhorada(valor);
            if (retorno == null) {
                System.out.println("Valor não encontrado!");

            } else { // ACHOU!!
                if (this.primeiro.getInfo().compareTo(valor) == 0) { //no inicio
                   removerInicioSemRepetidos(valor);

                } else if (this.ultimo.getInfo().compareTo(valor) == 0) { // no final
                    removerFinalSemRepetidos(valor);

                } else { // no meio
                    retorno = this.buscaMelhorada(valor);
                    if (retorno == null) {
                        System.out.println("Valor não encontrado!");
                    } else {
                        LDENode aux = this.primeiro; // CASOS GERAIS, SE TIVER PELO "MEIO"
                        while (aux != null) {
                            if (valor == aux.getInfo()) {
                                anterior = aux.getAnt();
                                prox = aux.getProx();
                                anterior.setProx(prox);
                                prox.setAnt(anterior);
                                this.qtd--;
                            }
                            aux = aux.getProx();
                        }
                    }
                }
            }
        }
    }

    // DESCRESCENTE SEM REPETIDOS -normal
    public void inserirDescrescenteSemRepetidos(Integer valor) {
        LDENode novo, atual, anterior;
        if (this.isEmpty() == true) {
            novo = new LDENode(valor);
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd = 1;
            System.out.println("Inserção efetuada.");
        } else { // lista não vazia
            if (valor.compareTo(this.primeiro.getInfo()) == 0) {
                System.out.println("Valor repetido. Inserção não efetuada.");
            } else if (valor.compareTo(this.primeiro.getInfo()) > 0) { // inserir antes do primeiro -aletração: ">"
                novo = new LDENode(valor);
                this.primeiro.setAnt(novo);
                novo.setProx(this.primeiro);
                this.primeiro = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
            } else if (valor == this.ultimo.getInfo()) { // == 0
                System.out.println("Valor repetido. Inserção não efetuada.");
            } else if (valor.compareTo(this.ultimo.getInfo()) < 0) { // inserir depois do último -aletração: "<"
                novo = new LDENode(valor);
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
            } else { // inserir no "meio" da lista. Precisa procurar a posição de inserção
                
                }
            }
        }
    

    // CRESCENTE COM REPETIDOs, se for repetido, inserir depois
    public void inserirCrescenteRepetidos(Integer valor) {
        LDENode novo, atual, anterior;
        if (this.isEmpty() == true) {
            novo = new LDENode(valor);
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd = 1;
            System.out.println("Inserção efetuada.");
        } else { // lista não vazia
            if (valor.compareTo(this.primeiro.getInfo()) < 0) { // inserir antes do primeiro

                novo = new LDENode(valor);
                this.primeiro.setAnt(novo);
                novo.setProx(this.primeiro);
                this.primeiro = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
            }

            else if (valor.compareTo(this.ultimo.getInfo()) > 0) { // Inserir depois do último
                novo = new LDENode(valor);
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");

            } else { // inserir no "meio" da lista. Precisa procurar a posição de inserção
                atual = this.primeiro;
                while (atual != null) {
                    if (atual.getInfo().compareTo(valor) > 0) { // achamos a posição de inserção
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
                    while(atual.getInfo().compareTo(valor) == valor){
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
                    }
                    atual = atual.getProx();
                }
            }
        }
    }

    public void inserirCrescenteSemRepetidos(Integer valor) {
        LDENode novo, atual, anterior;
        if (this.isEmpty() == true) {
            novo = new LDENode(valor);
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd = 1;
            System.out.println("Inserção efetuada.");
        } else { // lista não vazia
            if (valor.compareTo(this.primeiro.getInfo()) == 0) {
                System.out.println("Valor repetido. Inserção não efetuada.");

            } else if (valor.compareTo(this.primeiro.getInfo()) < 0) { // inserir antes do primeiro
                novo = new LDENode(valor);
                this.primeiro.setAnt(novo);
                novo.setProx(this.primeiro);
                this.primeiro = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
            } else if (valor.compareTo(this.ultimo.getInfo()) == 0) {
                System.out.println("Valor repetido. Inserção não efetuada.");

            } else if (valor.compareTo(this.ultimo.getInfo()) > 0) { // inserir depois do último
                novo = new LDENode(valor);
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");

            } else { // inserir no "meio" da lista. Precisa procurar a posição de inserção
                atual = this.primeiro;
                while (atual != null) {
                    if (atual.getInfo().compareTo(valor) == 0) {
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
        }
    }

}
