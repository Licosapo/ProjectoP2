package modelo;

import java.util.LinkedList;

public class GabineteSeguranca extends Divisao{
    private LinkedList<Seguranca> segurancas;

public GabineteSeguranca(String name, EstadoPorta porta) {
    super(name,porta);
    segurancas=new LinkedList<>();
}
public GabineteSeguranca(String name, boolean aberta) {
    super(name,aberta);
    segurancas=new LinkedList<>();
}

public LinkedList<Seguranca> getSegurancas() {
    return new LinkedList<>(segurancas);
}

public void adicionarSeguranca(Seguranca seguranca){
    if (seguranca == null || segurancas.contains(seguranca)) {
        return;
    }
    segurancas.add(seguranca);
    seguranca.associarGabinete(this);
}
public void removerSeguranca(Seguranca seguranca){
    if (segurancas == null || !segurancas.contains(seguranca)) {
        return;
    }
    segurancas.remove(seguranca);
    seguranca.desassociarGabinete();
}
}