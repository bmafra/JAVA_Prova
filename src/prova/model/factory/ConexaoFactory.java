package prova.model.factory;

import prova.exceptions.ErroConexaoException;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Faz a conexão com o banco de dados
 */

public class ConexaoFactory {
    private String url = "jdbc:mysql://localhost:3306/planos";
    private String username = "root";
    private String password = "root";

    public Connection connectDB() throws ErroConexaoException {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErroConexaoException();
        }
    }
}
