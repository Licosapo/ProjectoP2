package modelo;

import java.util.LinkedList;

public class Professor extends PessoaComAulas implements Funcionario<GabineteProfessor,Sala> {

    private GabineteProfessor gabineteProfessor;
    private final GestorFuncionario gestorFuncionario;

    public Professor(String nome, long numero, GabineteProfessor gabineteProfessor) {
        super(nome,numero);
        associarGabinete(gabineteProfessor);
        gestorFuncionario=new GestorFuncionario();
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
    public void associar(Aula aula) {
        aula.atribuirProfessor(this);
    }

    @Override
    public void desassociar(Aula aula) {
        aula.desassociarProfessor();
    }

    @Override
    public void associarGabinete(GabineteProfessor gabineteProfessor) {
        if (gabineteProfessor==null || gabineteProfessor==this.gabineteProfessor){
            return;
        }
        if (this.gabineteProfessor!=null){
            this.gabineteProfessor.remover(this);
        }
        this.gabineteProfessor=gabineteProfessor;
        gabineteProfessor.adicionar(this);
    }

    @Override
    public void desassociarGabinete() {
        if (gabineteProfessor == null) {
            return;
        }
        GabineteProfessor gabineteProfessorCopy = this.gabineteProfessor;
        this.gabineteProfessor=null;
        gabineteProfessorCopy.remover(this);
    }

    @Override
    public GabineteProfessor getGabinete() {
        return gabineteProfessor;
    }

    @Override
    public LinkedList<Horario> getHorariosDeAtendimento() {
        return gestorFuncionario.getHorariosDeAtendimento();
    }
    @Override
    public void abrirGabinete(){
        if (gabineteProfessor.isAberta()) {
            return;
        }
        gabineteProfessor.abrir();
    }
    @Override
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
    @Override
    public void adicionarHorario(Horario horariosDeAtendimento) {
        gestorFuncionario.adicionarHorario(horariosDeAtendimento);
    }

    @Override
    public boolean horarioIsSobreHorarios(Horario horario) {
        return gestorFuncionario.horarioIsSobreHorarios(horario);
    }

    @Override
    public void removerhorariosDeAtendimento(Horario horariosDeAtendimento) {
        gestorFuncionario.removerhorariosDeAtendimento(horariosDeAtendimento);
    }
}
