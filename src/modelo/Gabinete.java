package modelo;

import java.util.LinkedList;

public class Gabinete<TFuncionario extends Funcionario> extends Divisao {
    protected LinkedList<TFuncionario> funcionarios;

    public Gabinete(String nome, boolean aberta) {
        super(nome, aberta);
        funcionarios = new LinkedList<>();
    }

    public Gabinete(String nome, EstadoPorta porta) {
        super(nome, porta);
        funcionarios = new LinkedList<>();
    }
    public LinkedList<TFuncionario> getFuncionarios() {
        return new LinkedList<>(funcionarios);
    }

    public void adicionar(TFuncionario funcionario){
        if (funcionario == null || funcionarios.contains(funcionario)) {
            return;
        }
        funcionarios.add(funcionario);
        funcionario.associarGabinete(this);
    }
    public void remover(TFuncionario funcionario){
        if (funcionarios == null || !funcionarios.contains(funcionario)) {
            return;
        }
        funcionarios.remove(funcionario);
        funcionario.desassociarGabinete();
    }
}
