package modelo;

import java.util.LinkedList;

public class Aula extends Identificador{
    private Professor professor;
    private Sala sala;
    private LinkedList<Aluno> alunos;
    private StringBuilder sumario;
    private Horario horario;

    public Aula(String nome, long numero, Horario horario, Sala sala) {
        this(nome, numero, horario, null, new LinkedList<>(), sala);
    }



    public Aula(String nome, long numero, Horario horario, Professor professor, LinkedList<Aluno> alunos, Sala sala) {
        super(nome,numero);
        atribuirProfessor(professor);
        associarSala(sala);
        this.horario = horario;
        this.alunos = new LinkedList<>();
        for (Aluno aluno : alunos){
            adicionarAluno(aluno);
        }

        sumario = new StringBuilder();
    }
    public Horario getHorario() {
        return horario;
    }
    public void atribuirProfessor(Professor professor) {
        if (professor==null || professor==this.professor){
            return;
        }
        if(this.professor!=null){
            this.professor.removerAula(this);
        }
        this.professor=professor;
        professor.adicionarAula(this);
    }

    public void desassociarProfessor() {
        if (professor == null) {
            return;
        }
        Professor professor = this.professor;
        this.professor=null;
        professor.removerAula(this);
    }

    public void adicionarAluno(Aluno aluno) {
        if (aluno == null || alunos.contains(aluno)) {
            return;
        }
        alunos.add(aluno);
        aluno.adicionarAula(this);
    }

    public void removerAluno(Aluno aluno) {
        if (alunos == null || !alunos.contains(aluno)) {
            return;
        }
        alunos.remove(aluno);
        aluno.removerAula(this);
    }

    public void adicionarLinhaSumario(String linha) {
        sumario.append(linha).append('\n');
    }

    public boolean isSobre(Horario horario){
        if (horario == null) {
            return false;
        }
        return this.horario.isSobre(horario);
    }

    public String getSumario() {
        return sumario.toString();
    }

    public Professor getProfessor() {
        return professor;
    }

    public LinkedList<Aluno> getAlunos() {
        return new LinkedList<>(alunos);
    }

    public boolean isSobre(Aula aula) {
        return isSobre(aula.horario);
    }

    public Sala getSala() {
        return sala;
    }

    public void associarSala(Sala sala) {
        if (sala==null || sala==this.sala){
            return;
        }
        if(this.sala!=null){
            this.sala.removerAula(this);
        }
        this.sala=sala;
        sala.adicionarAula(this);
    }

    public void desassociarSala() {
        if (sala == null) {
            return;
        }
        Sala salaCopy = this.sala;
        this.sala=null;
        salaCopy.removerAula(this);
    }
}
