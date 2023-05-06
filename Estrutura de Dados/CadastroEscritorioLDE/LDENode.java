package CadastroEscritorioLDE;

public class LDENode {
    private LDENode ant;
    private Pessoa info;
    private LDENode prox;

    public LDENode(Pessoa p){
        this.info = p;
    }

    public LDENode getAnt() {
        return ant;
    }
    public void setAnt(LDENode ant) {
        this.ant = ant;
    }
    public Pessoa getInfo() {
        return info;
    }
    public void setInfo(Pessoa info) {
        this.info = info;
    }
    public LDENode getProx() {
        return prox;
    }
    public void setProx(LDENode prox) {
        this.prox = prox;
    }
}
