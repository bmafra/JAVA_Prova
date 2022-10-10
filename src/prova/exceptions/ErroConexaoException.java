package prova.exceptions;

/**
 * Quando acontece um erro na conexão com o banco de dados é lançada essa exceção.
 */

public class ErroConexaoException extends Exception {
    public ErroConexaoException() {
        super("Erro na conexão");
    }
}
