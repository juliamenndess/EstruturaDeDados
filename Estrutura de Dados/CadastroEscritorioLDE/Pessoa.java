package CadastroEscritorioLDE;

public class Pessoa implements Comparable <Pessoa>{
    private String nome;
    private String rg;

    public Pessoa(String nome, String rg){
        this.nome = nome;
        this.rg = rg;
    }

    public Pessoa(String rg){
        this.nome = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public String toString(){
        return this.nome + " " + this.rg;
    }

    public int compareTo(Pessoa p){
        return this.rg.compareTo(p.rg);
    }
}
