package CadastroFuncionario.CadastroFuncionarioLSE;

public class LSEnode {
    private Funcionario info;
    private LSEnode prox;

  
    public LSEnode(Funcionario info) {
      this.info = info;
    }
    public void setInfo(Funcionario info){
      this.info = info;
    }
    public void setProx(LSEnode prox){
      this.prox = prox;
    }
    public Funcionario getInfo(){
      return this.info;
    }
    public LSEnode getProx(){
      return this.prox;
    }

}
