package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseConnection;
import models.PedidoProduto;

public class PedidoProdutoDao {

    private Connection myConnection;

    public PedidoProdutoDao() throws SQLException {
        myConnection = DatabaseConnection.getConexaoSingleton();
    }

    public PedidoProdutoDao(Connection conn) {
        myConnection = conn;
    }

    public boolean insert(PedidoProduto pedidoProduto) {

        String sql = "INSERT INTO TBL_PEDIDO_PRODUTO(pedp_quantidade, pedp_valor, pedp_valor_total, pedp_cod_produto, pedp_cod_pedido) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setInt(1, pedidoProduto.getPedp_quantidade());
            pst.setDouble(2, pedidoProduto.getPedp_valor());
            pst.setDouble(3, pedidoProduto.getPedp_valor_total());
            pst.setInt(4, pedidoProduto.getPedp_cod_produto());
            pst.setInt(5, pedidoProduto.getPedp_cod_pedido());

            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o registro " + e.getMessage());
        }
        return false;
    }

    public PedidoProduto recover(int id) {

        String sql = "SELECT pedp_codigo, pedp_quantidade, pedp_valor, pedp_valor_total, pedp_cod_produto, pedp_cod_pedido FROM TBL_PEDIDO_PRODUTO WHERE pedp_codigo = ?";

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            result.next();

            PedidoProduto pedidoProduto = new PedidoProduto();

            pedidoProduto.setPedp_codigo(result.getInt("pedp_codigo"));
            pedidoProduto.setPedp_quantidade(result.getInt("pedp_quantidade"));
            pedidoProduto.setPedp_valor(result.getDouble("pedp_valor"));    
            pedidoProduto.setPedp_valor_total(result.getDouble("pedp_valor_total"));    
            pedidoProduto.setPedp_cod_produto(result.getInt("pedp_cod_produto"));
            pedidoProduto.setPedp_cod_pedido(result.getInt("pedp_cod_pedido"));

            return pedidoProduto;
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar o registro " + e.getMessage());
            return null;
        }
    }

    public void update(PedidoProduto pedidoProduto) {
        String sql = "UPDATE TBL_PEDIDO_PRODUTO SET pedp_quantidade = ?, pedp_valor = ?, pedp_valor_total = ?, pedp_cod_produto = ?, pedp_cod_pedido = ? WHERE pedp_codigo = ?";
        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setInt(1, pedidoProduto.getPedp_quantidade());
            pst.setDouble(2, pedidoProduto.getPedp_valor());
            pst.setDouble(3, pedidoProduto.getPedp_valor_total());
            pst.setInt(4, pedidoProduto.getPedp_cod_produto());
            pst.setInt(5, pedidoProduto.getPedp_cod_pedido());

            pst.executeUpdate();
        } catch (SQLException err) {
            System.err.println("Erro ao atualizar o objeto: " + err.getMessage());
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM TBL_PEDIDO_PRODUTO WHERE pedp_codigo = ?";

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

    public ArrayList<PedidoProduto> recoverAll() {
        String sql = "SELECT pedp_codigo, pedp_quantidade, pedp_valor, pedp_valor_total, pedp_cod_produto, pedp_cod_pedido FROM TBL_PEDIDO_PRODUTO";
        ArrayList<PedidoProduto> pedidoProdutos = new ArrayList<PedidoProduto>();

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);

            ResultSet result = pst.executeQuery();

            while (result.next()) {
                
                PedidoProduto pedidoProduto = new PedidoProduto();

                pedidoProduto.setPedp_codigo(result.getInt("pedp_codigo"));
                pedidoProduto.setPedp_quantidade(result.getInt("pedp_quantidade"));
                pedidoProduto.setPedp_valor(result.getDouble("pedp_valor"));    
                pedidoProduto.setPedp_valor_total(result.getDouble("pedp_valor_total"));    
                pedidoProduto.setPedp_cod_produto(result.getInt("pedp_cod_produto"));
                pedidoProduto.setPedp_cod_pedido(result.getInt("pedp_cod_pedido"));

                pedidoProdutos.add(pedidoProduto);
            }
            return pedidoProdutos;

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }
}