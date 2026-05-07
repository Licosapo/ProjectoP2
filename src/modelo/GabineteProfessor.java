package modelo;

import java.util.LinkedList;

public class GabineteProfessor extends Gabinete<Professor> {
    private LinkedList<Professor> professores;

    public GabineteProfessor(String nome, EstadoPorta porta) {
        super(nome, porta);
    }
    public GabineteProfessor(String name, boolean aberta) {
        super(name,aberta);
    }
}
