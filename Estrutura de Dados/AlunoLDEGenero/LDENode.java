package AlunoLDEGenero;

public class LDENode {
    private LDENode ant;
    private Aluno info;
    private LDENode prox;

    public LDENode(Aluno p){
        this.info = p;
    }

    public LDENode getAnt() {
        return ant;
    }
    public void setAnt(LDENode ant) {
        this.ant = ant;
    }
    public Aluno getInfo() {
        return info;
    }
    public void setInfo(Aluno info) {
        this.info = info;
    }
    public LDENode getProx() {
        return prox;
    }
    public void setProx(LDENode prox) {
        this.prox = prox;
    }
}
