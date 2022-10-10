package prova.exceptions;

/**
 * Quando ocorre um erro na execução é lançado essa exceção.
 */

public class ErroExecucaoException extends Exception {
    public ErroExecucaoException() {
        super("Erro na execução.");
    }
}
