package modelo;

import java.util.LinkedList;

public class GabineteProfessor extends Divisao {
    private LinkedList<Professor> professores;

    public GabineteProfessor(String nome, EstadoPorta porta) {
        super(nome, porta);
        professores=new LinkedList<>();
    }
    public GabineteProfessor(String name, boolean aberta) {
        super(name,aberta);
        professores=new LinkedList<>();
    }

    public LinkedList<Professor> getProfessores() {
        return new LinkedList<>(professores);
    }

    public void adicionarProfessor(Professor professor){
        if (professor == null || professores.contains(professor)) {
            return;
        }
        professores.add(professor);
        professor.associarGabinete(this);
    }
    public void removerProfessor(Professor professor){
        if (professores == null || !professores.contains(professor)) {
            return;
        }
        professores.remove(professor);
        professor.desassociarGabinete();
    }
}
