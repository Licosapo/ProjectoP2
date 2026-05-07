package modelo;

import java.util.LinkedList;

public class GabineteSeguranca extends Gabinete<Seguranca> {
    public GabineteSeguranca(String name, EstadoPorta porta) {
    super(name,porta);
    }
public GabineteSeguranca(String name, boolean aberta) {
    super(name,aberta);
}
}