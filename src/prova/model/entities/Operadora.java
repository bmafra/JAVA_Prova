package prova.model.entities;

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

