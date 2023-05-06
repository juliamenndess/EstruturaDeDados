package InserirNumeroLDE;

public class LDENumero {
    private LDENode primeiro;
    private LDENode ultimo;
    private int qtd;
    
    public boolean isEmpty () {
        if (this.primeiro == null && this.ultimo == null && this.qtd == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public LDENode procurarAluno(Integer numero) {
        LDENode atual = primeiro;

        while (atual != null) {
            if (atual.getInfo() == numero) {
                return atual;
            }
            atual = atual.getProx();
        }
        return null;
    }

    public void inserirInicio(Integer valor){
        LDENode novo = new LDENode(valor);
        novo.setInfo(valor);
        
        if(procurarAluno(valor) == null){
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
    
    public void inserirFinal (Integer valor) {
        LDENode novo = new LDENode (valor);

        if(procurarAluno(valor) == null ){
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

    public void inserirOrdenado(Integer num){
        LDENode novo, atual, anterior;

        if(this.isEmpty() == true){  //CASO 1: LISTA VAZIA
            novo = new LDENode(num);
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd = 1;

        }else{

        } if(num == this.primeiro.getInfo()){  //CASO 2: INSERÇÃO NO INÍCIO DA LISTA
            System.out.println("Valor repetido! ");

        }
        if(num < this.primeiro.getInfo()){ 
            novo = new LDENode(num);
            novo.setProx(this.primeiro);
            this.primeiro.setAnt(novo);
            this.primeiro = novo;
            this.qtd++;

        }else if(num == this.ultimo.getInfo()){  //CASO 3: INSERÇÃO NO FINAL DA LISTA
            System.out.println("Valor repetido! ");

        }else if(num > this.ultimo.getInfo()){  
            novo = new LDENode(num);
            this.ultimo.setProx(novo);
            novo.setAnt(this.ultimo);
            this.ultimo = novo;
            this.qtd++;

        }else{  //CASO 4 (GERAL): INSERÇÃO NO MEIO DA LISTA
            atual = this.primeiro;

            while(atual != null){
                if(atual.getInfo() == num){
                    System.out.println("Valor repetido! ");
                    return;

                }else if(atual.getInfo() > num){
                    anterior = atual.getAnt();
                    novo = new LDENode(num);
                    novo.setAnt(anterior);
                    novo.setProx(atual);
                    anterior.setProx(novo);
                    atual.setAnt(novo);
                    this.qtd++;
                    return;
                }else{
                    atual = atual.getAnt();
                }
            }
        }


       
    }

    public void removerInicio(){

        if(isEmpty() == true){
            System.out.println("Lista vazia!");

        }else if(this.qtd == 1){   //no caso de só ter 1 nó
            this.primeiro = null;
            this.ultimo = null;
            this.qtd = 0;

        }else{ //casos gerais
            this.primeiro = this.primeiro.getProx();
            this.primeiro.setAnt(null);
            this.qtd--;
        }
    }

    public void removerFinal(){

        if(this.isEmpty() == true){
            System.out.println("Lista vazia!");

        }else if(this.qtd == 1){
            this.primeiro = null;
            this.ultimo = null;
            this.qtd = 0;

        }else{
            this.ultimo = this.ultimo.getAnt();
            this.ultimo.setAnt(null);
            this.qtd--;
        }
    }

    public void remover(Integer num){
        LDENode aux, anterior, prox;

        if(this.isEmpty() == true){
            System.out.println("Lista vazia!");

        }else{
            aux = this.procurarAluno(num);
            if(aux == null){
                System.out.println("Valor não encontrado! ");

            }else if(this.qtd == 1){  //
                this.primeiro = null;
                this.ultimo = null;
                this.qtd = 0;

            }else if(aux == this.primeiro){
                this.removerInicio();
                this.primeiro = this.primeiro.getProx();
                this.primeiro.setAnt(null);
                this.qtd--;

            }else if(aux == this.ultimo){
                this.removerFinal();
                this.ultimo = this.ultimo.getAnt();
                this.ultimo.setProx(null);
                this.qtd--;

            }else{
                anterior = aux.getAnt();
                prox = aux.getProx();
                anterior.setProx(prox);
                prox.setAnt(anterior);
                this.qtd--;

            }
        }
    }

    public void inserirRepetido(Integer num){
        LDENode novo = new LDENode(num);
        novo.setInfo(num);
        
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
    }


    public void removerRepetido(Integer num){
        LDENode prox, anterior, novo;
        int cont = 0;

        novo = this.procurarAluno(num); 
        

            if(this.isEmpty() == true){
                System.out.println("Lista vazia!");

            }else{
             if(novo == null){
                System.out.println("Número não existe! ");

             }
             else if(novo.getInfo() == num){ //se encontrou o número

               if(novo == this.primeiro){  //CASO ESTEJA NO PRIMEIRO NÓ
                if(this.qtd == 1){   //no caso de só ter 1 nó
                    this.primeiro = null;
                    this.ultimo = null;
                    this.qtd = 0;
                    cont++;
        
                }else{ 
                    LDENode primRemover = this.primeiro;
                    this.primeiro = primRemover.getProx();
                    this.primeiro.setAnt(null);
                    this.qtd--;
                    cont++;
                }

             }else if(novo == this.ultimo){ //CASO ESTEJA NO ÚLTIMO NÓ
                if(this.qtd == 1){  //caso só tenha um nó
                    this.primeiro = null;
                    this.ultimo = null;
                    this.qtd = 0;
                    cont++;
        
                }else{
                    LDENode ultRemover = this.ultimo;
                    this.ultimo = ultRemover.getAnt();
                    this.ultimo.setProx(null); //ou setAnterior
                    this.qtd--;
                    cont++;
                }
                
             }else{ //CASO O NÓ ESTEJA PELO MEIO
                novo = this.primeiro.getProx(); //novo.getAnt.setProx(novo.getProx)
                while(novo.getProx() != null){

                    if(num == novo.getInfo()){
                        anterior = novo.getAnt(); //
                        prox = novo.getProx();
                        anterior.setProx(prox);     
                        prox.setAnt(anterior);
                        this.qtd--;
                        cont++;                   //
                    }
                    novo = novo.getProx();
                }
             } 
        }
      }
      System.out.println("Você deletou " + cont + " do valor procurado!");
    }

    public void exibirInicio(){
        LDENode aux;
        Integer a;

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

    public void exibirFinal(){
        LDENode aux;
        Integer a;

        if(this.isEmpty() == true){
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
}
