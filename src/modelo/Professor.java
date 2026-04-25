package modelo;

import java.util.LinkedList;

public class Professor extends PessoaComAulas {

    private GabineteProfessor gabineteProfessor;
    private LinkedList<Horario> horariosDeAtendimento;

    public Professor(String nome, long numero, GabineteProfessor gabineteProfessor) {
        super(nome,numero);
        associarGabinete(gabineteProfessor);
    }

    @Override
    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(nome);
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }

    @Override
    protected void associar(Aula aula) {
        aula.atribuirProfessor(this);
    }

    @Override
    protected void desassociar(Aula aula) {
        aula.desassociarProfessor();
    }

    public void associarGabinete(GabineteProfessor gabineteProfessor) {
        if (gabineteProfessor==null || gabineteProfessor==this.gabineteProfessor){
            return;
        }
        if (this.gabineteProfessor!=null){
            this.gabineteProfessor.removerProfessor(this);
        }
        this.gabineteProfessor=gabineteProfessor;
        gabineteProfessor.adicionarProfessor(this);
    }

    public void desassociarGabinete() {
        if (gabineteProfessor == null) {
            return;
        }
        GabineteProfessor gabineteProfessorCopy = this.gabineteProfessor;
        this.gabineteProfessor=null;
        gabineteProfessorCopy.removerProfessor(this);
    }

    public GabineteProfessor getGabineteProfessor() {
        return gabineteProfessor;
    }

    public LinkedList<Horario> getHorariosDeAtendimento() {
        return new LinkedList<>(horariosDeAtendimento);
    }
    public void abrirGabinete(){
        if (gabineteProfessor.isAberta()) {
            return;
        }
        gabineteProfessor.abrir();
    }
    public void fecharGabinete(){
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
