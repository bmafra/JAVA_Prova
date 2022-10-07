package prova.model.entities;

/**
 * Atributo de Plano do qual se pode ter esses 4 tipos.
 */

public enum Operadora {
    VIVO("vivo"),
    TIM("tim"),
    OI("oi"),
    CLARO("claro");

    String nomeOperadora;

    Operadora(String nomeOperadora) {
        this.nomeOperadora = nomeOperadora;
    }
}

