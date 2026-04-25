package modelo;

public enum DiaSemana {
    DOMINGO("Domingo"),
    SEGUNDA_FEIRA("2ª feira"),
    TERCA_FEIRA("3ª feira"),
    QUARTA_FEIRA("4ª feira"),
    QUINTA_FEIRA("5ª feira"),
    SEXTA_FEIRA("6ª feira"),
    SABADO("Sabado"),
    ;

    private final String descricao;

    DiaSemana(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
