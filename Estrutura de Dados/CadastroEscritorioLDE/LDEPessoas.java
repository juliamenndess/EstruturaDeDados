package CadastroEscritorioLDE;

public class LDEPessoas {
    private LDENode primeiro;
    private LDENode ultimo;
    private int qtd = 0;

    public boolean isEmpty(){
        if(this.primeiro == null && this.ultimo == null && qtd == 0){
            return true;
        }else{
            return false;
        }
    }

    private LDENode buscar(Pessoa p){
        LDENode aux;

        if(this.primeiro == null){
            return null;
        }else{
            aux = this.primeiro;
            while(aux != null){
                if(p.compareTo(aux.getInfo()) == 0){
                    return aux;
                }
                aux = aux.getProx();
            }
            return null;
        }
    }

    public void buscarPor(Pessoa p){
        LDENode aux;
        if(this.primeiro == null){
            System.out.println("RG não encontrado!");
        }else{
            aux = this.primeiro;
            while(aux != null){
                if(p.compareTo(aux.getInfo()) == 0){
                    System.out.println("Pessoa cadastrada! ");
                }
                aux = aux.getProx();
            }
            System.out.println("RG não encontrado!");
        }
    }

    public void exibir(){
        LDENode aux;
        Pessoa a;
        
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

    public void exibirInverso(){
        LDENode aux;
        Pessoa a;

        if(isEmpty() == true){
            System.out.println("Lista vazia! ");
        }else{
            aux = this.ultimo;
            while(aux != null){
                a = aux.getInfo();
                System.out.println(a);
                aux = aux.getAnt();
            }
        }
    }

    public void cadastrarFinal(Pessoa p){
        LDENode novo = new LDENode(p);
        LDENode retorno;
        retorno = this.buscar(p);

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

    public void removerInicio(){

        if(isEmpty() == true){
            System.out.println("Lista vazia!");
        }else if(this.qtd == 1){
            this.primeiro = null;
            this.ultimo = null;
            this.qtd = 0;
        }else{
            this.primeiro = this.primeiro.getProx();
            this.primeiro.setAnt(null);
            this.qtd--;
        }
    }

    public void removerFinal(){

        if(isEmpty() == true){
            System.out.println("Lista vazia!");
        }else if(this.qtd == 1){
            this.primeiro = null;
            this.ultimo = null;
            this.qtd = 0;
        }else{
            this.ultimo = this.ultimo.getAnt();
            this.ultimo.setProx(null);
            this.qtd--;
        }
    }

    public void remover(Pessoa p){
        LDENode aux, anterior, proximo;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia");

        } else {
            aux = this.buscar(p);
            if (aux == null){
                System.out.println("Valor não encontrado.");

            }
            else {  // achou!
                if (aux == this.primeiro) { // remover no início
                    this.removerInicio();

                }
                else if (aux == this.ultimo) {   // remover no final
                    this.removerFinal();

                }
                else {    // remover no "meio"
                    anterior = aux.getAnt();
                    proximo = aux.getProx();
                    anterior.setProx(proximo);
                    proximo.setAnt(anterior);
                    this.qtd--;
                }
                System.out.println("Remoção do cadastro efetuada! ");
           }
      }
   }
}
