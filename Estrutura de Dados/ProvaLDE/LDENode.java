package ProvaLDE;

public class LDENode {
    private LDENode ant;
    private LDENode prox;
    private Integer info;

    public LDENode(Integer info){
        this.info = info;
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
