package RemoverIguais;

public class LDENode {
    LDENode ant;
    LDENode prox;
    Integer info;

    public LDENode(Integer v){
        this.info = v;
    }

    public LDENode getAnt() {
        return ant;
    }
    public void setAnt(LDENode ant) {
        this.ant = ant;
    }
    public LDENode getProx() {
        return prox;
    }
    public void setProx(LDENode prox) {
        this.prox = prox;
    }
    public Integer getInfo() {
        return info;
    }
    public void setInfo(Integer info) {
        this.info = info;
    }
}
