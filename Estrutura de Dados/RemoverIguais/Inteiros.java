package RemoverIguais;

public class Inteiros {
    LDENode primeiro;
    LDENode ultimo;
    private int qtd;

    public boolean isEmpty () {
        if (this.primeiro == null && this.ultimo == null && this.qtd == 0) {
            return true;
        }
        else {
            return false;
        }
    }


    public void inserirFinal(Integer valor){

    LDENode novo = new LDENode (valor);
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

    }

    public void removerInicio(Integer valor){
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

    public void removerFinal(Integer valor){
       
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

    public void remover(Integer valor){
       LDENode anterior, prox;
       int cont = 0;

        if(this.primeiro == null){ // LISTA VAZIA
            System.out.println("Lista vazia");

        }else if(this.qtd == 1){ // APENAS UM NÓ
            this.primeiro = null;
            this.ultimo = null;
            this.qtd = 0;

        }else if(valor == this.primeiro.getInfo()){  //VALOR ENCONTRADO NO PRIMEIRO NÓ
            removerInicio(valor);
            cont++;

        }else if(valor == this.ultimo.getInfo()){  //VALOR ENCONTRADO NO ÚLTIMO NÓ
            removerFinal(valor);
            cont++;

        }else{

            LDENode aux = this.primeiro;  //CASOS GERAIS, SE TIVER PELO "MEIO"
            while(aux != null){
                if(valor == aux.getInfo()){
                anterior = aux.getAnt();
                prox = aux.getProx();
                anterior.setProx(prox);
                prox.setAnt(anterior);
                this.qtd--;
                cont++;
                }
                aux = aux.getProx();
            }
        }
        System.out.println("A quantidade de números iguais removidos foram: " + cont);
    }

    public void removerSemRepetidos(Integer valor){
       LDENode anterior, prox;

        if(this.primeiro == null){ // LISTA VAZIA
            System.out.println("Lista vazia");

        }else if(this.qtd == 1){ // APENAS UM NÓ
            this.primeiro = null;
            this.ultimo = null;
            this.qtd = 0;

        }else if(valor == this.primeiro.getInfo()){
            System.out.println();
        }else if(valor == this.ultimo.getInfo()){
            System.out.println();
        }else{
            LDENode aux = this.primeiro;  //CASOS GERAIS, SE TIVER PELO "MEIO"
            while(aux != null){
                if(valor == aux.getInfo()){
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
