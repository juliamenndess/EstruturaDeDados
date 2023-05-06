package Prova2ED1;

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
    
    public void juntar(LDEInteiros lista2){
        LDENode aux = lista2.primeiro;

        if(lista2.isEmpty() == true){
            System.out.println("Lista 2 está vazia!");

        }else 
              while(aux != null){
               if(this.isEmpty() == true){
                LDENode novo = new LDENode(aux.getInfo());
                this.primeiro = novo;
                this.ultimo = novo;
                this.qtd++;            
                aux = aux.getProx();
               }else{

                LDENode novo = new LDENode(aux.getInfo());
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
                this.qtd++;
                System.out.println("Inserção efetuada.");
                aux = aux.getProx();
               }
            }
               if(lista2.isEmpty() == false){
                lista2.primeiro = null;
                lista2.ultimo = null;
                }
            }
        }
        
    
        
    
    
    

    

