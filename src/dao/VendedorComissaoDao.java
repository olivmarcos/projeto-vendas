package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseConnection;
import models.VendedorComissao;

public class VendedorComissaoDao {

    private Connection myConnection;

    public VendedorComissaoDao() throws SQLException {
        myConnection = DatabaseConnection.getConexaoSingleton();
    }

    public VendedorComissaoDao(Connection conn) {
        myConnection = conn;
    }

    public boolean insert(VendedorComissao vendedorComissaoDao) {

        String sql = "INSERT INTO TBL_VENDEDOR_COMISSAO(vnc_comissao, vnc_cod_vendedor, vnc_cod_pedido) VALUES (?, ?, ?)";

        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setDouble(1, vendedorComissaoDao.getVnc_comissao());
            pst.setInt(2, vendedorComissaoDao.getVnc_cod_vendedor());
            pst.setInt(3, vendedorComissaoDao.getVnc_cod_pedido());

            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o registro " + e.getMessage());
        }
        return false;
    }

    public VendedorComissao recover(int id) {

        String sql = "SELECT vnc_codigo, vnc_comissao, vnc_cod_vendedor, vnc_cod_pedido FROM TBL_VENDEDOR_COMISSAO WHERE vnc_codigo = ?";

        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            result.next();

            VendedorComissao vendedorComissaoDao = new VendedorComissao();

            vendedorComissaoDao.setVnc_codigo(result.getInt("vnc_codigo"));
            vendedorComissaoDao.setVnc_comissao(result.getDouble("vnc_comissao"));
            vendedorComissaoDao.setVnc_cod_vendedor(result.getInt("vnc_cod_vendedor"));
            vendedorComissaoDao.setVnc_cod_pedido(result.getInt("vnc_cod_pedido"));

            return vendedorComissaoDao;
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar o registro " + e.getMessage());
            return null;
        }
    }

    public void update(VendedorComissao vendedorComissaoDao) {

        String sql = "UPDATE TBL_VENDEDOR_COMISSAO SET vnc_comissao = ?, vnc_cod_vendedor = ?, vnc_cod_pedido = ? WHERE vnc_codigo = ?";

        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setDouble(1, vendedorComissaoDao.getVnc_comissao());
            pst.setInt(2, vendedorComissaoDao.getVnc_cod_vendedor());
            pst.setInt(3, vendedorComissaoDao.getVnc_cod_pedido());

            pst.executeUpdate();
        } catch (SQLException err) {
            System.err.println("Erro ao atualizar o objeto: " + err.getMessage());
        }
    }

    public boolean delete(int id) {

        String sql = "DELETE FROM TBL_VENDEDOR_COMISSAO WHERE prod_codigo = ?";

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

    public ArrayList<VendedorComissao> recoverAll() {
        String sql = "SELECT prodm_codigo, prodm_data, prodm_descricao, prodm_cod_produto FROM TBL_VENDEDOR_COMISSAO";
        ArrayList<VendedorComissao> vendedorComissoes = new ArrayList<VendedorComissao>();

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);

            ResultSet result = pst.executeQuery();

            while (result.next()) {

                VendedorComissao vendedorComissao = new VendedorComissao();

                vendedorComissao.setVnc_codigo(result.getInt("vnc_codigo"));
                vendedorComissao.setVnc_comissao(result.getDouble("vnc_comissao"));
                vendedorComissao.setVnc_cod_vendedor(result.getInt("vnc_cod_vendedor"));
                vendedorComissao.setVnc_cod_pedido(result.getInt("vnc_cod_pedido"));

                vendedorComissoes.add(vendedorComissao);
            }
            return vendedorComissoes;

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }
}