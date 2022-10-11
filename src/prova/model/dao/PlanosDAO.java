package prova.model.dao;

import prova.exceptions.ErroConexaoException;
import prova.exceptions.ErroExecucaoException;
import prova.exceptions.ErroTratamentoException;
import prova.model.entities.Operadora;
import prova.model.entities.Planos;
import prova.model.factory.ConexaoFactory;
import prova.model.factory.OperadoraFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Faz o contato com o banco
 */

public class PlanosDAO {
    Connection connection;

    public PlanosDAO() throws ErroConexaoException {
        this.connection = new ConexaoFactory().connectDB();
    }

    public void cadastrarPlanos(Integer id, Integer qtdDados, Integer qtdBonus, String nome, Operadora operadora, String beneficios, Double valor) throws SQLException, ErroExecucaoException {
        String sql = "insert into plano (identificador, operadora, nome, qtdDados, qtdBonus, beneficios, valor) values (?,?,?,?,?,?,?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, operadora.toString());
            preparedStatement.setString(3, nome);
            preparedStatement.setInt(4, qtdDados);
            preparedStatement.setInt(5, qtdBonus);
            preparedStatement.setString(6, beneficios);
            preparedStatement.setDouble(7, valor);

            try {
                preparedStatement.execute();
            } catch (Exception e) {
                e.printStackTrace();
                throw new ErroExecucaoException();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void removerPlanos(Integer id) throws SQLException, ErroExecucaoException {
        String sql = "delete from plano where identificador = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try {
                preparedStatement.execute();
            } catch (Exception e) {
                throw new ErroExecucaoException();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void atualizarPlanos(Integer id, Integer qtdDados, Integer qtdBonus, String nome, Operadora operadora, String beneficios, Double valor) throws SQLException, ErroExecucaoException {
        String sql = "update plano set qtdDados = ?, qtdBonus = ?, nome = ?, operadora = ?, beneficios = ?, valor = ? where identificador = " + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, qtdDados);
            preparedStatement.setInt(2, qtdBonus);
            preparedStatement.setString(3, nome);
            preparedStatement.setString(4, operadora.toString());
            preparedStatement.setString(5, beneficios);
            preparedStatement.setDouble(6, valor);

            try {
                preparedStatement.execute();
            } catch (Exception e) {
                throw new ErroExecucaoException();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public Planos listarPlanoID(Integer id) throws SQLException, ErroExecucaoException {
        String sql = "select * from plano where identificador = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extrairObjeto(resultSet);
                }
            } catch (Exception e) {
                throw new ErroExecucaoException();
            }

        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public Collection<Planos> listarTodosPlanos() throws ErroExecucaoException, SQLException {
        Collection<Planos> listaPlanos = new ArrayList<>();
        String sql = "select identificador, operadora, nome, qtdDados, valor from  order by plano.operadora;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    listaPlanos.add(extrairObjetoListarTodos(resultSet));
                }
                return listaPlanos;
            } catch (Exception e) {
                throw new ErroExecucaoException();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    private Planos extrairObjetoListarTodos(ResultSet resultSet) throws ErroTratamentoException {
        try {
            int opcao = switch (resultSet.getString("operadora")) {
                case "vivo" -> 1;
                case "tim" -> 2;
                case "oi" -> 3;
                case "claro" -> 4;
                default -> 0;
            };

            return new Planos(
                    resultSet.getInt("identificador"),
                    resultSet.getInt("qtdDados"),
                    new OperadoraFactory().getOperadora(opcao),
                    resultSet.getString("nome"),
                    resultSet.getDouble("valor")
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErroTratamentoException();
        }
    }

    public Collection<Planos> listarPlanosOperadora(String operadora) throws ErroExecucaoException, SQLException {
        Collection<Planos> listaPlanos = new ArrayList<>();
        String sql = "select identificador, operadora, nome, qtdDados, valor from plano where operadora = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, operadora);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    listaPlanos.add(extrairObjeto(resultSet));
                }
                return listaPlanos;
            } catch (Exception e) {
                throw new ErroExecucaoException();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private Planos extrairObjeto(ResultSet resultSet) throws ErroTratamentoException {
        try {
            int opcao = switch (resultSet.getString("operadora")) {
                case "vivo" -> 1;
                case "tim" -> 2;
                case "oi" -> 3;
                case "claro" -> 4;
                default -> 0;
            };

            return new Planos(
                    resultSet.getInt("identificador"),
                    resultSet.getInt("qtdDados"),
                    resultSet.getInt("qtdBonus"),
                    new OperadoraFactory().getOperadora(opcao),
                    resultSet.getString("nome"),
                    resultSet.getString("beneficios"),
                    resultSet.getDouble("valor")
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErroTratamentoException();
        }
    }
}
