package CadastroPessoas;

public class LDENode {
    private LDENode prox;
    private LDENode ant;
    private Pessoa info;

    public LDENode(Pessoa info){
        this.info = info;
    }
    public LDENode getProx() {
        return prox;
    }
    public void setProx(LDENode prox) {
        this.prox = prox;
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
}
