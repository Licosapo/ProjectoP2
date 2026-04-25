package modelo;

public class Horario {
    private DiaSemana diaDaSemana;
    int horaI;
    int horaT;
    int duracao;

    public Horario(DiaSemana diaDaSemana, int horaI, int duracao) {
        this.diaDaSemana = diaDaSemana;
        this.horaI = horaI;
        horaT = horaI + duracao;
        this.duracao = duracao;
    }

    public Horario(int horaI, int horaT, DiaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
        this.horaI = horaI;
        this.horaT = horaT;
        duracao = horaT - horaI;
    }

    public DiaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public int getHoraI() {
        return horaI;
    }

    public int getHoraT() {
        return horaT;
    }

    public int getDuracao() {
        return duracao;
    }

    public boolean isSobre(Horario horario) {
        return horario != null &&
                horario.diaDaSemana == diaDaSemana &&
                horaI < horario.horaT &&
                horaT > horario.horaI;
    }
}
