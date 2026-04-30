package modelo;

import java.util.LinkedList;

public class GestorFuncionarios implements Funcionario {
    LinkedList<Horario> horariosDeAtendimento;

    public GestorFuncionarios() {
    }

    public LinkedList<Horario> getHorariosDeAtendimento() {
        return new LinkedList<Horario>(horariosDeAtendimento);
    }

    public void adicionarHorario(Horario horariosDeAtendimento) {
        if (horariosDeAtendimento == null || null.horarioIsSobreHorarios(horariosDeAtendimento)) {
            return;
        }
        this.horariosDeAtendimento.add(horariosDeAtendimento);
    }

    public boolean horarioIsSobreHorarios(Horario horario) {
        for (Horario horario1 : horariosDeAtendimento) {
            if (horario1.isSobre(horario)) {
                return true;
            }
        }
        return false;
    }

    public void removerhorariosDeAtendimento(Horario horariosDeAtendimento) {
        if (horariosDeAtendimento == null || !this.horariosDeAtendimento.contains(horariosDeAtendimento)) {
            return;
        }
        this.horariosDeAtendimento.remove(horariosDeAtendimento);
    }
}