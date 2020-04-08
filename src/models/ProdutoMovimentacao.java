package models;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProdutoMovimentacao {

    private int prodm_codigo;
    private String prodm_data;
    private String prodm_descricao;
    private int prodm_cod_produto;

    public int getProdm_codigo() {
        return this.prodm_codigo;
    }

    public void setProdm_codigo(int prodm_codigo) {
        this.prodm_codigo = prodm_codigo;
    }

    public String getProdm_data() {
        return this.prodm_data;
    }

    public void setProdm_data(Date prodm_data) {
        String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(prodm_data);
        this.prodm_data = data;
    }

    public void setProdm_data(String prodm_data) {
        this.prodm_data = prodm_data;
    }

    public String getProdm_descricao() {
        return this.prodm_descricao;
    }

    public void setProdm_descricao(String prodm_descricao) {
        this.prodm_descricao = prodm_descricao;
    }

    public int getProdm_cod_produto() {
        return this.prodm_cod_produto;
    }

    public void setProdm_cod_produto(int prodm_cod_produto) {
        this.prodm_cod_produto = prodm_cod_produto;
    }

    @Override
    public String toString() {
        return "{" + " prodm_codigo='" + getProdm_codigo() + "'" + ", prodm_data='" + getProdm_data() + "'"
                + ", prodm_descricao='" + getProdm_descricao() + "'" + ", prodm_cod_produto='" + getProdm_cod_produto()
                + "'" + "}";
    }

    public String[] toVetor() {
        String vetor[] = new String[4];
        vetor[0] = String.valueOf(getProdm_codigo());
        vetor[1] = getProdm_data();
        vetor[2] = getProdm_descricao();
        vetor[3] = String.valueOf(getProdm_cod_produto());

        return vetor;
    }

    public void vetorTo(String[] dados) throws ParseException {
        this.setProdm_codigo(Integer.parseInt(dados[0]));
        this.setProdm_data(new SimpleDateFormat().parse(dados[1]));
        this.setProdm_descricao(dados[2]);
        this.setProdm_cod_produto(Integer.parseInt(dados[3]));
    }
}