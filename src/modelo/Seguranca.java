package modelo;

import java.util.LinkedList;

public class Seguranca extends Pessoa implements Funcionario{
    private final GestorFuncionarios gestorFuncionarios = new GestorFuncionarios();
    GabineteSeguranca gabineteSeguranca;

    public Seguranca(String name, long num, GabineteSeguranca gabineteSeguranca){
        super(name,num);
        this.gabineteSeguranca=gabineteSeguranca;
        gestorFuncionarios.horariosDeAtendimento = new LinkedList<>();
    }

    public GabineteSeguranca getGabineteSeguranca() {
        return gabineteSeguranca;
    }

    public LinkedList<Horario> getHorariosDeAtendimento() {
        return gestorFuncionarios.getHorariosDeAtendimento();
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
    public void abrirDivisao(Divisao divisao){
        if (divisao.isAberta()) {
            return;
        }
        divisao.abrir();
    }
    public void fecharDivisao(Divisao divisao){
        if (divisao.isFechada()) {
            return;
        }
        divisao.fechar();
    }
    public void adicionarHorario(Horario horariosDeAtendimento) {
        gestorFuncionarios.adicionarHorario(horariosDeAtendimento);
    }

    public boolean horarioIsSobreHorarios(Horario horario) {
        return gestorFuncionarios.horarioIsSobreHorarios(horario);
    }

    public void removerhorariosDeAtendimento(Horario horariosDeAtendimento) {
        gestorFuncionarios.removerhorariosDeAtendimento(horariosDeAtendimento);
    }
}
