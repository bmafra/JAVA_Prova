package prova.model.service;

import prova.model.dao.PlanosDAO;
import prova.model.entities.Operadora;

public class PlanosService {

    public void cadastrarPlanos(Integer id, Integer qtdDados, Integer qtdBonus, String nome, Operadora operadora, String beneficios, Double valor){
        System.out.println("entrou service");
        new PlanosDAO().cadastrarPlanos(id, qtdDados, qtdBonus, nome, operadora, beneficios, valor);
    }

    public void removerPlanos(Integer id) {
        new PlanosDAO().removerPlanos(id);
    }

    public void atualizarPlanos(Integer id, Integer qtdDados, Integer qtdBonus, String nome, Operadora operadora, String beneficios, Double valor) {
        new PlanosDAO().atualizarPlanos(id, qtdDados, qtdBonus, nome, operadora, beneficios, valor);
    }

    public void listarPlanoID(Integer id) {
        new PlanosDAO().listarPlanoID(id);
    }
}
