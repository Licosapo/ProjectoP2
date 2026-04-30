package modelo;

public class Aluno extends PessoaComAulas {

    public Aluno(String nome, long numero) {
        super(nome, numero);
    }

    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(nome);
    }

    public void associar(Aula aula) {
        aula.adicionarAluno(this);
    }

    public void desassociar(Aula aula) {
        aula.removerAluno(this);
    }

}
