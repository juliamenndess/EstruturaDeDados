package CadastroAluno.CadastroAlunoLSE;

public class LSENode {
    private Aluno info;
    private LSENode prox;

    public LSENode(Aluno aluno) {
    }

    public void setInfo(Aluno info){
        this.info = info;
    }

    public void setProx(LSENode prox){
        this.prox = prox;
    }

    public Aluno getInfo(){
        return this.info;
    }

    public LSENode getProx(){
        return this.prox;
    }
}
