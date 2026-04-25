package modelo;

import java.util.LinkedList;

public class Sala extends Divisao{
    private LinkedList<Aula> aulas;

    public Sala(String nome, EstadoPorta porta) {
        super(nome,porta);
        this.porta = porta;
        aulas=new LinkedList<>();
    }
    public Sala(String name, boolean aberta) {
        super(name,aberta);
        aulas=new LinkedList<>();
    }

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

    protected void associar(Aula aula) {
        aula.associarSala(this);
    }

    protected void desassociar(Aula aula) {
        aula.desassociarSala();
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
        if (aula == null || aulaIsSobreAulas(aula)) {
            return;
        }
        aulas.add(aula);
        associar(aula);
    }
    public void removerAula(Aula aula) {
        if (aula == null || !aulas.contains(aula)) {
            return;
        }
        aulas.remove(aula);
        desassociar(aula);
    }

}
