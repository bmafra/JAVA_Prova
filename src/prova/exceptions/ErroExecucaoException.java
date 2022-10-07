package prova.exceptions;

public class ErroExecucaoException extends RuntimeException {
    public ErroExecucaoException() {
        super("Erro na conexão.");
    }
}
