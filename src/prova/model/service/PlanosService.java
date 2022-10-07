package prova.model.service;

import prova.model.dao.PlanosDAO;
import prova.model.entities.Operadora;

/**
 * Faz a ponte entre a controller e a DAO.
 */

public class PlanosService {

    public void cadastrarPlanos(Integer id, Integer qtdDados, Integer qtdBonus, String nome, Operadora operadora, String beneficios, Double valor){
        try {
            new PlanosDAO().cadastrarPlanos(id, qtdDados, qtdBonus, nome, operadora, beneficios, valor);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void removerPlanos(Integer id) {
        try {
            new PlanosDAO().removerPlanos(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void atualizarPlanos(Integer id, Integer qtdDados, Integer qtdBonus, String nome, Operadora operadora, String beneficios, Double valor) {
        try {
            new PlanosDAO().atualizarPlanos(id, qtdDados, qtdBonus, nome, operadora, beneficios, valor);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void listarPlanoID(Integer id) {
        try {
            new PlanosDAO().listarPlanoID(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void listarTodosPlanos() {
        try {
            new PlanosDAO().listarTodosPlanos();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void listarPlanosOperadora(String operadora) {
        try {
            new PlanosDAO().listarPlanosOperadora(operadora);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
