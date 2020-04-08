package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseConnection;
import models.Vendedor;

public class VendedorDao {

    private Connection myConnection;

    public VendedorDao() throws SQLException {
        myConnection = DatabaseConnection.getConexaoSingleton();
    }

    public VendedorDao(Connection conn) {
        myConnection = conn;
    }

    public boolean insert(Vendedor vendedor) {

        String sql = "INSERT INTO TBL_VENDEDOR(vend_nome, vend_percentual_comissao) VALUES (?, ?)";

        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setString(1, vendedor.getVend_nome());
            pst.setDouble(2, vendedor.getVend_percentual_comissao());

            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o registro " + e.getMessage());
        }
        return false;
    }

    public Vendedor recover(int id) {

        String sql = "SELECT vend_codigo, vend_nome, vend_percentual_comissao FROM TBL_VENDEDOR WHERE vend_codigo = ?";

        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            result.next();

            Vendedor vendedor = new Vendedor();

            vendedor.setVend_codigo(result.getInt("vend_codigo"));
            vendedor.setVend_nome(result.getString("vend_nome"));
            vendedor.setVend_percentual_comissao(result.getDouble("vend_percentual_comissao"));

            return vendedor;
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar o registro " + e.getMessage());
            return null;
        }
    }

    public void update(Vendedor vendedor) {

        String sql = "UPDATE TBL_VENDEDOR SET vend_nome = ?, vend_percentual_comissao = ? WHERE vend_codigo = ?";

        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setString(1, vendedor.getVend_nome());
            pst.setDouble(2, vendedor.getVend_percentual_comissao());

            pst.executeUpdate();
        } catch (SQLException err) {
            System.err.println("Erro ao atualizar o objeto: " + err.getMessage());
        }
    }

    public boolean delete(int id) {

        String sql = "DELETE FROM TBL_VENDEDOR WHERE vend_codigo = ?";

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

    public ArrayList<Vendedor> recoverAll() {
        String sql = "SELECT prodm_codigo, prodm_data, prodm_descricao, prodm_cod_produto FROM TBL_VENDEDOR";
        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);

            ResultSet result = pst.executeQuery();

            while (result.next()) {

                Vendedor vendedor = new Vendedor();

                vendedor.setVend_codigo(result.getInt("vend_codigo"));
                vendedor.setVend_nome(result.getString("vend_nome"));
                vendedor.setVend_percentual_comissao(result.getDouble("vend_percentual_comissao"));

                vendedores.add(vendedor);
            }
            return vendedores;

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }
}