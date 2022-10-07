package prova.model.entities;

import java.util.Scanner;

public class Planos {
    private Integer identificador, qtdDados, qtdBonus;
    private Operadora operadora;
    private String nome, beneficios;
    private Double valor;

    public Planos(Integer identificador, Integer qtdDados, Integer qtdBonus, Operadora operadora, String nome, String beneficios, Double valor) {
        this.identificador = identificador;
        this.qtdDados = qtdDados;
        this.qtdBonus = qtdBonus;
        this.operadora = operadora;
        this.nome = nome;
        this.beneficios = beneficios;
        this.valor = valor;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getQtdDados() {
        return qtdDados;
    }

    public void setQtdDados(Integer qtdDados) {
        this.qtdDados = qtdDados;
    }

    public Integer getQtdBonus() {
        return qtdBonus;
    }

    public void setQtdBonus(Integer qtdBonus) {
        this.qtdBonus = qtdBonus;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
