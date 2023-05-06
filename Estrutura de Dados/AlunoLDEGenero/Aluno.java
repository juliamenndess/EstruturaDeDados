package AlunoLDEGenero;

public class Aluno implements Comparable <Aluno> {
    private char genero;
    private String nome;
    private String matricula;

    public Aluno(char genero, String nome){
        this.genero = genero;
        this.nome = nome;
    }

    public Aluno(char genero){
        this.genero = genero;
    }

    public Aluno (String matricula){
        this.matricula = matricula;
    }

    public char getGenero() {
        return genero;
    }
    public void setGenero(char genero) {
        this.genero = genero;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int compareTo(Aluno procurado){
        int compara;
        compara = this.nome.compareTo(procurado.nome);
        return compara;
    }
    
}
