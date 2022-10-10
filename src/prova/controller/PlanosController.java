package prova.controller;

import prova.model.entities.Operadora;
import prova.model.entities.Planos;
import prova.model.service.PlanosService;

import java.util.Collection;

/**
 * Faz a contado do usuário com a controller.
 */

public class PlanosController {
    PlanosService planosService = new PlanosService();

    public void cadastrarPlanos(Integer id, Integer qtdDados, Integer qtdBonus, String nome, Operadora operadora, String beneficios, Double valor) {
        planosService.cadastrarPlanos(id, qtdDados, qtdBonus, nome, operadora, beneficios, valor);
    }

    public void removerPlanos(Integer id) {
        planosService.removerPlanos(id);
    }

    public void atualizarPlanos(Integer id, Integer qtdDados, Integer qtdBonus, String nome, Operadora operadora, String beneficios, Double valor) {
        planosService.atualizarPlanos(id, qtdDados, qtdBonus, nome, operadora, beneficios, valor);
    }

    public Planos listarPlanoID(Integer id) {
        return planosService.listarPlanoID(id);
    }

    public Collection<Planos> listarTodosPlanos() {
        return planosService.listarTodosPlanos();
    }

    public Collection<Planos> listarPlanosOperadora(String indiceOperadora) {
        String operadora = switch (indiceOperadora) {
            case "1" -> "vivo";
            case "2" -> "tim";
            case "3" -> "oi";
            case "4" -> "claro";
            default -> "";
        };
        return planosService.listarPlanosOperadora(operadora);
    }
}
