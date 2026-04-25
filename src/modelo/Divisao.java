package modelo;

public abstract class Divisao extends Descritor {
    protected EstadoPorta porta;

    public Divisao(String nome, EstadoPorta porta) {
        super(nome);
        this.porta = porta;
    }
    public Divisao(String nome, boolean aberta) {
        this(nome,EstadoPorta.getEstado(aberta));
    }

    public EstadoPorta getPorta() {
        return porta;
    }

    public boolean isAberta() {
        return porta.isAberta();
    }

    public boolean isFechada() {
        return porta.isFechado();
    }

    public void abrir() {
        porta = porta.ABERTA;
    }

    public void fechar() {
        porta = porta.FECHADA;
    }
}
