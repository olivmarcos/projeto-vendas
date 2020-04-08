package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseConnection;
import models.ProdutoMovimentacao;

public class ProdutoMovimentacaoDao {

    private Connection myConnection;

    public ProdutoMovimentacaoDao() throws SQLException {
        myConnection = DatabaseConnection.getConexaoSingleton();
    }

    public ProdutoMovimentacaoDao(Connection conn) {
        myConnection = conn;
    }

    public boolean insert(ProdutoMovimentacao produtoMovimentacao) {

        String sql = "INSERT INTO TBL_PRODUTO_MOVIMENTACAO(prodm_data, prodm_descricao, prodm_cod_produto) VALUES (?, ?, ?)";

        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setString(1, produtoMovimentacao.getProdm_data());
            pst.setString(2, produtoMovimentacao.getProdm_descricao());
            pst.setInt(3, produtoMovimentacao.getProdm_cod_produto());

            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o registro " + e.getMessage());
        }
        return false;
    }

    public ProdutoMovimentacao recover(int id) {

        String sql = "SELECT prodm_codigo, prodm_data, prodm_descricao, prodm_cod_produto FROM TBL_PRODUTO_MOVIMENTACAO WHERE prodm_codigo = ?";

        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            result.next();

            ProdutoMovimentacao produtoMovimentacao = new ProdutoMovimentacao();

            produtoMovimentacao.setProdm_codigo(result.getInt("prodm_codigo"));
            produtoMovimentacao.setProdm_data(result.getDate("prodm_data"));
            produtoMovimentacao.setProdm_descricao(result.getString("prodm_descricao"));
            produtoMovimentacao.setProdm_cod_produto(result.getInt("prodm_cod_produto"));

            return produtoMovimentacao;
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar o registro " + e.getMessage());
            return null;
        }
    }

    public void update(ProdutoMovimentacao produtoMovimentacao) {
        String sql = "UPDATE TBL_PRODUTO_MOVIMENTACAO SET prodm_data = ?, prodm_descricao = ?, prodm_cod_produto = ? WHERE prodm_codigo = ?";
        try {

            PreparedStatement pst = myConnection.prepareStatement(sql);

            pst.setString(1, produtoMovimentacao.getProdm_data());
            pst.setString(2, produtoMovimentacao.getProdm_descricao());
            pst.setInt(3, produtoMovimentacao.getProdm_cod_produto());

            pst.executeUpdate();
        } catch (SQLException err) {
            System.err.println("Erro ao atualizar o objeto: " + err.getMessage());
        }
    }

    public boolean delete(int id) {

        String sql = "DELETE FROM TBL_PRODUTO_MOVIMENTACAO WHERE prod_codigo = ?";

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

    public ArrayList<ProdutoMovimentacao> recoverAll() {
        String sql = "SELECT prodm_codigo, prodm_data, prodm_descricao, prodm_cod_produto FROM TBL_PRODUTO_MOVIMENTACAO";
        ArrayList<ProdutoMovimentacao> produtosMovimentacao = new ArrayList<ProdutoMovimentacao>();

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);

            ResultSet result = pst.executeQuery();

            while (result.next()) {

                ProdutoMovimentacao produtoMovimentacao = new ProdutoMovimentacao();

                produtoMovimentacao.setProdm_codigo(result.getInt("prodm_codigo"));
                produtoMovimentacao.setProdm_data(result.getDate("prodm_data"));
                produtoMovimentacao.setProdm_descricao(result.getString("prodm_descricao"));
                produtoMovimentacao.setProdm_cod_produto(result.getInt("prodm_cod_produto"));

                produtosMovimentacao.add(produtoMovimentacao);
            }
            return produtosMovimentacao;

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }
}