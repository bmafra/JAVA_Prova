package prova.model.dao;

import prova.model.entities.Operadora;
import prova.model.entities.Planos;
import prova.model.factory.ConexaoFactory;
import prova.model.factory.OperadoraFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlanosDAO {
    Connection connection;

    public PlanosDAO() {
        this.connection = new ConexaoFactory().connectDB();
    }

    public void cadastrarPlanos(Integer id, Integer qtdDados, Integer qtdBonus, String nome, Operadora operadora, String beneficios, Double valor) {
        System.out.println("cadastra");
        String sql = "insert into plano (identificador, plano, nome, qtdDdados, qtdBonus, beneficios, valor) values (?,?,?,?,?,?,?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
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
                throw new RuntimeException("Erro na execução do comando SQL (cadastrarPlanos)");
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL (cadastrarPlanos)");
        }
    }

    public void removerPlanos(Integer id) {
        String sql = "delete from planos where identificador = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try {
                preparedStatement.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL (removerPlanos)");
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL (removerPlanos)");
        }
    }

    public void atualizarPlanos(Integer id, Integer qtdDados, Integer qtdBonus, String nome, Operadora operadora, String beneficios, Double valor) {
        String sql = "update planos set qtdDados = ?, qtdBonus = ?, nome = ?, operadora = ?, beneficios = ?, valor = ? where identificador = " + id;

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
                throw new RuntimeException("Erro na execução do comando SQL");
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL");
        }

    }

    public void listarPlanoID(Integer id) {
        String sql = "select * from planos where identificador = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()){
                    return extrairObjeto(resultSet);
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL");
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL");
        }
    }

    private Planos extrairObjeto(ResultSet resultSet) {
        try {
            return new Planos(
                    resultSet.getInt("identificador"),
                    resultSet.getInt("qtdDados"),
                    resultSet.getInt("qtdBonus"),
                    new OperadoraFactory().getOperadora(""),
                    resultSet.getString("nome"),
                    resultSet.getString("beneficios"),
                    resultSet.getDouble("valor")
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao extrair o objeto!");
        }
    }
}
