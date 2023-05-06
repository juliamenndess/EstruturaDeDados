package InserirOrdenados;

public class Inteiros {
    LDENode primeiro;
    LDENode ultimo;
    private int qtd;

    public boolean isEmpty() {
        if (this.primeiro == null && this.ultimo == null && this.qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    public LDENode buscar(Integer valor) { // busca sequencial simples, não ordenado
        LDENode aux;

        if (this.primeiro == null) {
            return null;
        } else {
            aux = this.primeiro;
            while (aux != null) {
                if (valor == aux.getInfo()) {
                    return aux;
                }
                aux = aux.getProx();
            }
            return null;
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

    public void remover(Integer valor) { // PARA ORDENADOS
        LDENode retorno;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else {
            retorno = this.buscaMelhorada(valor);
            if (retorno == null) {
                System.out.println("Valor não encontrado!");

            } else { // ACHOU!!
                if (this.primeiro.getInfo().compareTo(valor) == 0) {
                    while (!isEmpty() && this.primeiro.getInfo().compareTo(valor) == 0) { //no final
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

    // CRESCENTE COM REPETIDOS 
    public void inserirCrescenteRepetidos(int valor) {
        LDENode novo, atual, anterior;
        if (this.isEmpty() == true) {
            novo = new LDENode(valor);
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd = 1;
            System.out.println("Inserção efetuada.");
        } else { // lista não vazia
            if (valor < this.primeiro.getInfo()) { // inserir antes do primeiro
                novo = new LDENode(valor);
                this.primeiro.setAnt(novo);
                novo.setProx(this.primeiro);
                this.primeiro = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
            }

            else if (valor > this.ultimo.getInfo()) { // INSERIR ANTES DO ULTIMO! ALTERAR
                novo = new LDENode(valor);
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");

            } else { // inserir no "meio" da lista. Precisa procurar a posição de inserção
                atual = this.primeiro;
                while (atual != null) {
                    if (atual.getInfo() > valor) { // achamos a posição de inserção
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

    // CRESCENTE SEM REPETIDOS
    public void inserirCrescenteSemRepetidos(int valor) {
        LDENode novo, atual, anterior;
        if (this.isEmpty() == true) {
            novo = new LDENode(valor);
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd = 1;
            System.out.println("Inserção efetuada.");
        } else { // lista não vazia
            if (valor == this.primeiro.getInfo()) {
                System.out.println("Valor repetido. Inserção não efetuada.");
            } else if (valor < this.primeiro.getInfo()) { // inserir antes do primeiro
                novo = new LDENode(valor);
                this.primeiro.setAnt(novo);
                novo.setProx(this.primeiro);
                this.primeiro = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
            } else if (valor == this.ultimo.getInfo()) {
                System.out.println("Valor repetido. Inserção não efetuada.");
            } else if (valor > this.ultimo.getInfo()) { // inserir depois do último
                novo = new LDENode(valor);
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
            } else { // inserir no "meio" da lista. Precisa procurar a posição de inserção
                atual = this.primeiro;
                while (atual != null) {
                    if (atual.getInfo() == valor) {
                        System.out.println("Valor repetido. Inserção não efetuada.");
                        return;
                    } else if (atual.getInfo() > valor) { // achamos a posição de inserção
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

    // DECRESCENTE COM REPETIDOS  -falta terminar
    public void inserirDescrescenteRepetidos(Integer valor) {
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
            } else if (valor > this.primeiro.getInfo()) { // inserir antes do primeiro -aletração: ">"
                novo = new LDENode(valor);
                this.primeiro.setAnt(novo);
                novo.setProx(this.primeiro);
                this.primeiro = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
            } else if (valor.compareTo(this.ultimo.getInfo()) == 0) {
                System.out.println("Valor repetido. Inserção não efetuada.");
            } else if (valor.compareTo(this.ultimo.getInfo()) < 0) { // inserir depois do último -aletração: "<"
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
                    } else if (atual.getInfo().compareTo(valor) < 0) { // achamos a posição de inserção -aletração: "<"
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

    // DESCRESCENTE SEM REPETIDOS
    public void inserirDescrescenteSemRepetidos(Integer valor) {
        LDENode novo, atual, anterior;
        if (this.isEmpty() == true) {
            novo = new LDENode(valor);
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd = 1;
            System.out.println("Inserção efetuada.");
        } else { // lista não vazia
            if (valor == this.primeiro.getInfo()) {
                System.out.println("Valor repetido. Inserção não efetuada.");
            } else if (valor.compareTo(this.primeiro.getInfo()) > 0) { // inserir antes do primeiro -aletração: ">"
                novo = new LDENode(valor);
                this.primeiro.setAnt(novo);
                novo.setProx(this.primeiro);
                this.primeiro = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
            } else if (valor == this.ultimo.getInfo()) {
                System.out.println("Valor repetido. Inserção não efetuada.");
            } else if (valor < this.ultimo.getInfo()) { // inserir depois do último -aletração: "<"
                novo = new LDENode(valor);
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
            } else { // inserir no "meio" da lista. Precisa procurar a posição de inserção
                atual = this.primeiro;
                while (atual != null) {
                    if (atual.getInfo() == valor) {
                        System.out.println("Valor repetido. Inserção não efetuada.");
                        return;
                    } else if (atual.getInfo() < valor) { // achamos a posição de inserção -aletração: "<"
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
}
