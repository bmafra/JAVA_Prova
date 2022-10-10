package prova.exceptions;

/**
 * Quando da erro na conversão do dados do MySQL para java é lançado essa exceção.
 */

public class ErroTratamentoException extends Exception {
    public ErroTratamentoException() {
        super("Erro no tratamento");
    }
}
