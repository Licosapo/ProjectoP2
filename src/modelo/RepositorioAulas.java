package modelo;

import java.util.LinkedList;

public interface RepositorioAulas {
    LinkedList<Aula> getAulas();

    LinkedList<Aula> getAulas(Horario horario);

    void associar(Aula aula);

    void desassociar(Aula aula);

    boolean aulaIsSobreAulas(Aula aula);

    void adicionarAula(Aula aula);

    void removerAula(Aula aula);

    boolean contem(Aula aula);
}
