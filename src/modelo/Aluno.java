package modelo;

public class Aluno extends PessoaComAulas {

    public Aluno(String nome, long numero) {
        super(nome, numero);
    }

    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(nome);
    }

    protected void associar(Aula aula) {
        aula.adicionarAluno(this);
    }

    protected void desassociar(Aula aula) {
        aula.removerAluno(this);
    }

}
