package modelo;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa implements RepositorioAulas{
    private final GestorAulas gestorAulas;

    public PessoaComAulas(String nome, long numero) {
        super(nome, numero);
        gestorAulas = new GestorAulas(this);
    }

    public void preencherSumario(Aula aula) {
        if (!gestorAulas.contem(aula) || aula == null) {
            return;
        }
        escreverSumario(aula);
    }

    protected abstract void escreverSumario(Aula aula);

    public void adicionarAula(Aula aula) {
        gestorAulas.adicionarAula(aula);
    }


    public boolean aulaIsSobreAulas(Aula aula) {
        return gestorAulas.aulaIsSobreAulas(aula);
    }

    public void removerAula(Aula aula) {
        gestorAulas.removerAula(aula);
    }


    public LinkedList<Aula> getAulas() {
        return gestorAulas.getAulas();
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        return gestorAulas.getAulas(horario);
    }
    public boolean contem(Aula aula) {
        return gestorAulas.contem(aula);
    }
}
