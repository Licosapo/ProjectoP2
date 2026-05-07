package modelo;

import java.util.LinkedList;

public interface Funcionario<Tgabinete extends Gabinete, Tdivisao extends Divisao>{
    void associarGabinete(Tgabinete tgabinete);

    void desassociarGabinete();

    Tgabinete getGabinete();

    LinkedList<Horario> getHorariosDeAtendimento();

    void abrirGabinete();

    void fecharGabinete();

    void adicionarHorario(Horario horariosDeAtendimento);

    boolean horarioIsSobreHorarios(Horario horario);

    void removerhorariosDeAtendimento(Horario horariosDeAtendimento);
}
