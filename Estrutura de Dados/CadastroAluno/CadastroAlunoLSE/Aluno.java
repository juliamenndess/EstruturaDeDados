package CadastroAluno.CadastroAlunoLSE;

public class Aluno implements Comparable <Aluno> {
    private String matricula;
    private String nome;
    private double media;
    private int faltas;

    public Aluno(String matricula){
        this.matricula = matricula;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public String getNome(){
        return this.nome;
    }

    public double getMedia(){
        return this.media;
    }

    public int getFaltas(){
        return this.faltas;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setMedia(double media){
        this.media = media;
    }

    public void setFaltas(int faltas){
        this.faltas = faltas;
    }

    public String toString(){
        return this.matricula + " " + this.nome + " " + this.media + " " + this.faltas;
    }
 
    public int compareTo(Aluno outro){
        return this.matricula.compareTo(outro.matricula);
    }
}
