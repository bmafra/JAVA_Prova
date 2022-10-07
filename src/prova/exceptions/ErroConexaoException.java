package prova.exceptions;

public class ErroConexaoException extends RuntimeException {
    public ErroConexaoException() {
        super("Erro na conexão");
    }
}
