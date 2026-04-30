package modelo;

import java.util.LinkedList;

public class Sala extends Divisao implements RepositorioAulas {
    private final GestorAulas gestorAulas;

    public Sala(String nome, EstadoPorta porta) {
        super(nome,porta);
        gestorAulas = new GestorAulas(this);
    }
    public Sala(String name, boolean aberta) {
        super(name,aberta);
        gestorAulas = new GestorAulas(this);
    }

    @Override
    public LinkedList<Aula> getAulas() {
        return gestorAulas.getAulas();
    }

    @Override
    public LinkedList<Aula> getAulas(Horario horario) {

        return gestorAulas.getAulas(horario);
    }

    @Override
    public void associar(Aula aula) {
        aula.associarSala(this);
    }

    @Override
    public void desassociar(Aula aula) {
        aula.desassociarSala();
    }
    @Override
    public boolean aulaIsSobreAulas(Aula aula) {
        return gestorAulas.aulaIsSobreAulas(aula);
    }
    @Override
    public void adicionarAula(Aula aula) {
        gestorAulas.adicionarAula(aula);
    }
    @Override
    public void removerAula(Aula aula) {
        gestorAulas.removerAula(aula);
    }

    @Override
    public boolean contem(Aula aula) {
        return gestorAulas.contem(aula);
    }

}
