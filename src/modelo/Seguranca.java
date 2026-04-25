package modelo;

import java.util.LinkedList;

public class Seguranca extends Pessoa{
    GabineteSeguranca gabineteSeguranca;
    private LinkedList<Horario> horariosDeAtendimento;

    public Seguranca(String name, long num, GabineteSeguranca gabineteSeguranca){
        super(name,num);
        this.gabineteSeguranca=gabineteSeguranca;
        horariosDeAtendimento= new LinkedList<>();
    }

    public GabineteSeguranca getGabineteSeguranca() {
        return gabineteSeguranca;
    }

    public LinkedList<Horario> getHorariosDeAtendimento() {
        return new LinkedList<>(horariosDeAtendimento);
    }
    public void associarGabinete(GabineteSeguranca gabineteSeguranca) {
        if (gabineteSeguranca==null || gabineteSeguranca==this.gabineteSeguranca){
            return;
        }
        if (this.gabineteSeguranca!=null){
            this.gabineteSeguranca.removerSeguranca(this);
        }
        this.gabineteSeguranca=gabineteSeguranca;
        gabineteSeguranca.adicionarSeguranca(this);
    }

    public void desassociarGabinete() {
        if (gabineteSeguranca == null) {
            return;
        }
        GabineteSeguranca gabineteSegurancaCopy = this.gabineteSeguranca;
        this.gabineteSeguranca=null;
        gabineteSegurancaCopy.removerSeguranca(this);
    }

    public void abrirGabinete(){
        if (gabineteSeguranca.isAberta()) {
            return;
        }
        gabineteSeguranca.abrir();
    }
    public void fecharGabinete(){
        if (gabineteSeguranca.isFechada()) {
            return;
        }
        gabineteSeguranca.fechar();
    }
    public void abrirGabineteProfessor(GabineteProfessor gabineteProfessor){
        if (gabineteProfessor.isAberta()) {
            return;
        }
        gabineteProfessor.abrir();
    }
    public void fecharGabineteProfessor(GabineteProfessor gabineteProfessor){
        if (gabineteProfessor.isFechada()) {
            return;
        }
        gabineteProfessor.fechar();
    }
    public void abrirSala(Sala sala){
        if (sala.isAberta()) {
            return;
        }
        sala.abrir();
    }
    public void fecharSala(Sala sala){
        if (sala.isFechada()) {
            return;
        }
        sala.fechar();
    }
    public void adicionarHorario(Horario horariosDeAtendimento) {
        if (horariosDeAtendimento == null || horarioIsSobreHorarios(horariosDeAtendimento)) {
            return;
        }
        this.horariosDeAtendimento.add(horariosDeAtendimento);
    }

    private boolean horarioIsSobreHorarios(Horario horario) {
        for (Horario horario1 : horariosDeAtendimento){
            if(horario1.isSobre(horario)){
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
