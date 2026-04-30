package modelo;

import java.util.LinkedList;

public class GestorAulas {
    private final RepositorioAulas repositorioAulas;
    private LinkedList<Aula> aulas;

    public GestorAulas(RepositorioAulas repositorioAulas) {
        this.repositorioAulas = repositorioAulas;
    }

    public LinkedList<Aula> getAulas() {
        return new LinkedList<Aula>(aulas);
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> lista = new LinkedList<Aula>();
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

    public boolean aulaIsSobreAulas(Aula aula) {
        for (Aula aula1 : aulas) {
            if (aula1.isSobre(aula)) {
                return true;
            }
        }
        return false;
    }

    public void adicionarAula(Aula aula) {
        if (aula == null || repositorioAulas.aulaIsSobreAulas(aula)) {
            return;
        }
        aulas.add(aula);
        repositorioAulas.associar(aula);
    }

    public void removerAula(Aula aula) {
        if (aula == null || repositorioAulas.contem(aula)) {
            return;
        }
        aulas.remove(aula);
        repositorioAulas.desassociar(aula);
    }

    public boolean contem(Aula aula) {
        return aulas.contains(aula);
    }
}