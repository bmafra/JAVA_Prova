package prova.model.factory;

import prova.model.entities.Operadora;

public class OperadoraFactory {
    public Operadora getOperadora(int opcao) {
        switch (opcao) {
            case 1 -> {
                return Operadora.VIVO;
            }
            case 2 -> {
                return Operadora.TIM;
            }
            case 3 -> {
                return Operadora.OI;
            }
            default -> {
                return Operadora.CLARO;
            }
        }
    }
}
