package modelo;

public enum EstadoPorta {
    ABERTA(true),
    FECHADA(false);


    private final boolean aberta;

    EstadoPorta(boolean aberta){
        this.aberta=aberta;
    }

    public static EstadoPorta getEstado(boolean aberta) {
        return aberta ? ABERTA : FECHADA;
    }

    public boolean isAberta(){
        return aberta;
    }
    public boolean isFechado(){
        return !aberta;
    }
}
