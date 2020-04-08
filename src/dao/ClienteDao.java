package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseConnection;
import models.Cliente;

public class ClienteDao {

    private Connection myConnection;

    public ClienteDao() throws SQLException {
        myConnection = DatabaseConnection.getConexaoSingleton();
    }

    public ClienteDao(Connection conn) {
        myConnection = conn;
    }

    public boolean insert(Cliente cliente) {

        String sql = "INSERT INTO TBL_CLIENTE(cli_nome, cli_cpf, cli_ultima_compra) VALUES (?, ?, ?)";

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.setString(1, cliente.getCli_nome());
            pst.setString(2, cliente.getCli_cpf());
            pst.setString(3, cliente.getCli_ultima_compra());

            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o registro " + e.getMessage());
        }
        return false;
    }

    public Cliente recover(int id) {

        String sql = "SELECT cli_codigo, cli_nome, cli_cpf, cli_ultima_compra FROM TBL_CLIENTE WHERE cli_codigo = ?";

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            result.next();

            Cliente cliente = new Cliente();
            cliente.setCli_codigo(result.getInt("cli_codigo"));
            cliente.setCli_nome(result.getString("cli_nome"));
            cliente.setCli_cpf(result.getString("cli_cpf"));    
            cliente.setCli_ultima_compra(result.getDate("cli_ultima_compra"));

            return cliente;
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar o registro " + e.getMessage());
            return null;
        }
    }

    public void update(Cliente cliente) {
        String sql = "UPDATE TBL_CLIENTE SET cli_nome = ?, cli_cpf = ?, cli_ultima_compra = ? WHERE cli_codigo = ?";
        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setString(1, cliente.getCli_nome());
            pst.setString(2, cliente.getCli_cpf());
            pst.setString(3, cliente.getCli_ultima_compra());
            pst.setInt(4, cliente.getCli_codigo());

            pst.executeUpdate();
        } catch (SQLException err) {
            System.err.println("Erro ao atualizar o objeto: " + err.getMessage());
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM TBL_CLIENTE WHERE cli_nome = ?";

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException err) {
            System.err.println("Erro ao deletar o objeto: " + err.getMessage());
        }
        return false;
    }

    public ArrayList<Cliente> recoverAll() {
        String sql = "SELECT cli_codigo, cli_nome, cli_cpf, cli_ultima_compra FROM TBL_CLIENTE";
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);

            ResultSet result = pst.executeQuery();

            while (result.next()) {
                
                    Cliente cliente = new Cliente();

                    cliente.setCli_codigo(result.getInt("cli_codigo"));
                    cliente.setCli_nome(result.getString("cli_nome"));
                    cliente.setCli_cpf(result.getString("cli_cpf"));    
                    cliente.setCli_ultima_compra(result.getDate("cli_ultima_compra"));

                    clientes.add(cliente);
            }
            return clientes;

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }
}