package modelo;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa {
    protected LinkedList<Aula> aulas;

    public PessoaComAulas(String nome, long numero) {
        super(nome, numero);
        aulas = new LinkedList<>();
    }

    public void preencherSumario(Aula aula) {
        if (!aulas.contains(aula) || aula == null) {
            return;
        }
        escreverSumario(aula);
    }

    protected abstract void escreverSumario(Aula aula);

    public void adicionarAula(Aula aula) {
        if (aula == null || aulaIsSobreAulas(aula)) {
            return;
        }
        aulas.add(aula);
        associar(aula);
    }

    protected abstract void associar(Aula aula);

    public boolean aulaIsSobreAulas(Aula aula) {
        for (Aula aula1 : aulas) {
            if (aula1.isSobre(aula)) {
                return true;
            }
        }
        return false;
    }

    public void removerAula(Aula aula) {
        if (aula == null || !aulas.contains(aula)) {
            return;
        }
        aulas.remove(aula);
        desassociar(aula);
    }

    protected abstract void desassociar(Aula aula);

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> lista = new LinkedList<>();
        if (horario == null) {
            return lista;
        }

        for (Aula aula : aulas) {
            if (aula.isSobre(horario)) {
                lista.add(aula);
            }
        }
        return lista;
    }
}
