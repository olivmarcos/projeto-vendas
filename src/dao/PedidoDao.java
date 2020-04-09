package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseConnection;
import models.Pedido;

public class PedidoDao {

    private Connection myConnection;

    public PedidoDao() throws SQLException {
        myConnection = DatabaseConnection.getConexaoSingleton();
    }

    public PedidoDao(Connection conn) {
        myConnection = conn;
    }

    public boolean insert(Pedido pedido) {

        String sql = "INSERT INTO TBL_PEDIDO(ped_data, ped_observacao, ped_cod_cliente, ped_cod_vendedor) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.setString(1, pedido.getPed_data());
            pst.setString(2, pedido.getPed_observacao());
            pst.setInt(3, pedido.getPed_cod_cliente());
            pst.setInt(4, pedido.getPed_cod_vendedor());

            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o registro " + e.getMessage());
            return false;
        }
    }

    public Pedido recover(int id) {

        String sql = "SELECT ped_codigo, ped_data, ped_observacao, ped_cod_cliente, ped_cod_vendedor FROM TBL_PEDIDO WHERE ped_codigo = ?";

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            result.next();

            Pedido pedido = new Pedido();
            pedido.setPed_codigo(result.getInt("ped_codigo"));
            pedido.setPed_data(result.getDate("ped_data"));
            pedido.setPed_observacao(result.getString("ped_observacao"));
            pedido.setPed_cod_cliente(result.getInt("ped_cod_cliente"));
            pedido.setPed_cod_vendedor(result.getInt("ped_cod_vendedor"));

            return pedido;
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar o registro " + e.getMessage());
            return null;
        }
    }

    public void update(Pedido pedido) {
        String sql = "UPDATE TBL_PEDIDO SET cped_data = ?, ped_observacao = ?, ped_cod_cliente = ?, ped_cod_vendedor = ? WHERE ped_codigo = ?";
        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setString(1, pedido.getPed_data());
            pst.setString(2, pedido.getPed_observacao());
            pst.setInt(3, pedido.getPed_cod_cliente());
            pst.setInt(4, pedido.getPed_cod_vendedor());

            pst.executeUpdate();
        } catch (SQLException err) {
            System.err.println("Erro ao atualizar o objeto: " + err.getMessage());
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM TBL_PEDIDO WHERE ped_codigo = ?";

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

    public ArrayList<Pedido> recoverAll() {
        String sql = "SELECT cli_codigo, cli_nome, cli_cpf, cli_ultima_compra FROM TBL_PEDIDO";
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);

            ResultSet result = pst.executeQuery();

            while (result.next()) {

                Pedido pedido = new Pedido();

                pedido.setPed_codigo(result.getInt("ped_codigo"));
                pedido.setPed_data(result.getDate("ped_data"));
                pedido.setPed_observacao(result.getString("ped_observacao"));
                pedido.setPed_cod_cliente(result.getInt("ped_cod_cliente"));
                pedido.setPed_cod_vendedor(result.getInt("ped_cod_vendedor"));

                pedidos.add(pedido);
            }
            return pedidos;

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }

    public int recoverUltimoCodigo() throws SQLException {
        String sql = "SELECT ped_codigo FROM TBL_PEDIDO ORDER BY ped_codigo DESC LIMIT 1";

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            result.next();

            int codigo = result.getInt("ped_codigo");
            return codigo;
        } catch (Exception err) {
            System.err.println("Erro ao recuperar o código do último pedido: " + err.getMessage());
        }
        return 0;
    }

    public Pedido recoverUltimoPedido(int id) {

        String sql = "SELECT ped_codigo, ped_data, ped_observacao, ped_cod_cliente, ped_cod_vendedor FROM TBL_PEDIDO WHERE ped_cod_CLIENTE = ? ORDER BY ped_codigo DESC LIMIT 1";

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            result.next();

            Pedido pedido = new Pedido();
            pedido.setPed_codigo(result.getInt("ped_codigo"));
            pedido.setPed_data(result.getDate("ped_data"));
            pedido.setPed_observacao(result.getString("ped_observacao"));
            pedido.setPed_cod_cliente(result.getInt("ped_cod_cliente"));
            pedido.setPed_cod_vendedor(result.getInt("ped_cod_vendedor"));

            return pedido;
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar o registro " + e.getMessage());
            return null;
        }
    }
}