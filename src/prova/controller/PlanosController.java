package prova.controller;

import prova.model.entities.Operadora;
import prova.model.service.PlanosService;

public class PlanosController {
    PlanosService planosService = new PlanosService();

    public void cadastrarPlanos(Integer id, Integer qtdDados, Integer qtdBonus, String nome, Operadora operadora, String beneficios, Double valor){
        planosService.cadastrarPlanos(id, qtdDados, qtdBonus, nome, operadora, beneficios, valor);
    }

    public void removerPlanos(Integer id) {
        planosService.removerPlanos(id);
    }

    public void atualizarPlanos(Integer id, Integer qtdDados, Integer qtdBonus, String nome, Operadora operadora, String beneficios, Double valor) {
        planosService.atualizarPlanos(id, qtdDados, qtdBonus, nome, operadora, beneficios, valor);
    }

    public void listarPlanoID(Integer id) {
        planosService.listarPlanoID(id);
    }

    public void listarTodosPlanos() {
        planosService.listarTodosPlanos();
    }

    public void listarPlanosOperadora(String operadora) {
        planosService.listarPlanosOperadora(operadora);
    }
}
