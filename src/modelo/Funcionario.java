package modelo;

import java.util.LinkedList;

public interface Funcionario {
    LinkedList<Horario> getHorariosDeAtendimento();

    void adicionarHorario(Horario horariosDeAtendimento);

    boolean horarioIsSobreHorarios(Horario horario);

    void removerhorariosDeAtendimento(Horario horariosDeAtendimento);
}
