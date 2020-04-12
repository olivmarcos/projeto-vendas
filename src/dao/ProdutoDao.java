package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseConnection;
import models.Produto;

public class ProdutoDao {

    private Connection myConnection;

    public ProdutoDao() throws SQLException {
        myConnection = DatabaseConnection.getConexaoSingleton();
    }

    public ProdutoDao(Connection conn) {
        myConnection = conn;
    }

    public boolean insert(Produto produto) {

        String sql = "INSERT INTO TBL_PRODUTO(prod_descricao, prod_saldo, prod_unidade) VALUES (?, ?, ?)";

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setString(1, produto.getProd_descricao());
            pst.setDouble(2, produto.getProd_saldo());
            pst.setString(3, produto.getProd_unidade());

            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o registro " + e.getMessage());
        }
        return false;
    }

    public Produto recover(int id) {

        String sql = "SELECT prod_codigo, prod_descricao, prod_saldo, prod_unidade FROM TBL_PRODUTO WHERE prod_codigo = ?";

        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            result.next();

            Produto produto = new Produto();

            produto.setProd_codigo(result.getInt("prod_codigo"));
            produto.setProd_descricao(result.getString("prod_descricao"));
            produto.setProd_saldo(result.getInt("prod_saldo"));
            produto.setProd_unidade(result.getString("prod_unidade"));

            return produto;
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar o registro " + e.getMessage());
            return null;
        }
    }

    public void update(Produto produto) {
        String sql = "UPDATE TBL_PRODUTO SET prod_descricao = ?, prod_saldo = ?, prod_unidade = ? WHERE prod_codigo = ?";
        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setString(1, produto.getProd_descricao());
            pst.setDouble(2, produto.getProd_saldo());
            pst.setString(3, produto.getProd_unidade());
            pst.setInt(4, produto.getProd_codigo());


            pst.executeUpdate();
        } catch (SQLException err) {
            System.err.println("Erro ao atualizar o objeto: " + err.getMessage());
        }
    }

    public boolean delete(int id) {

        String sql = "DELETE FROM TBL_PRODUTO WHERE prod_codigo = ?";

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

    public ArrayList<Produto> recoverAll() {
        String sql = "SELECT prod_codigo, prod_descricao, prod_saldo, prod_unidade FROM TBL_PRODUTO";
        ArrayList<Produto> produtos = new ArrayList<Produto>();

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);

            ResultSet result = pst.executeQuery();

            while (result.next()) {

                Produto produto = new Produto();

                produto.setProd_codigo(result.getInt("prod_codigo"));
                produto.setProd_descricao(result.getString("prod_descricao"));
                produto.setProd_saldo(result.getInt("prod_saldo"));
                produto.setProd_unidade(result.getString("prod_unidade"));

                produtos.add(produto);
            }
            return produtos;

        } catch (SQLException ex) {

            System.err.println("Erro ao buscar todos os produtos: " + ex.getMessage());
        }
        return null;
    }
}