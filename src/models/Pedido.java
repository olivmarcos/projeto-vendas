package models;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Pedido {
    private int ped_codigo;
    private String ped_data;
    private String ped_observacao;
    private int ped_cod_cliente;
    private int ped_cod_vendedor;
    
    public int getPed_codigo() {
        return this.ped_codigo;
    }

    public void setPed_codigo(int ped_codigo) {
        this.ped_codigo = ped_codigo;
    }

    public String getPed_data() {
        return this.ped_data;
    }

    public void setPed_data(Date ped_data) {
        String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ped_data);
        this.ped_data = data;
    }

    public void setPed_data(String ped_data) {
        this.ped_data = ped_data;
    }

    public String getPed_observacao() {
        return this.ped_observacao;
    }

    public void setPed_observacao(String ped_observacao) {
        this.ped_observacao = ped_observacao;
    }

    public int getPed_cod_cliente() {
        return this.ped_cod_cliente;
    }

    public void setPed_cod_cliente(int ped_cod_cliente) {
        this.ped_cod_cliente = ped_cod_cliente;
    }

    public int getPed_cod_vendedor() {
        return this.ped_cod_vendedor;
    }

    public void setPed_cod_vendedor(int ped_cod_vendedor) {
        this.ped_cod_vendedor = ped_cod_vendedor;
    }

    @Override
    public String toString() {
        return "{" +
            " ped_codigo='" + getPed_codigo() + "'" +
            ", ped_data='" + getPed_data() + "'" +
            ", ped_observacao='" + getPed_observacao() + "'" +
            ", ped_cod_cliente='" + getPed_cod_cliente() + "'" +
            ", ped_cod_vendedor='" + getPed_cod_vendedor() + "'" +
            "}";
    }

    public String[] toVetor() {
        String vetor[] = new String[5];
        vetor[0] = String.valueOf(getPed_codigo());
        vetor[1] = getPed_data();
        vetor[2] = getPed_observacao();
        vetor[3] = String.valueOf(getPed_cod_cliente());
        vetor[4] = String.valueOf(getPed_cod_vendedor());

        return vetor;
    }

    public void vetorTo(String[] dados) throws ParseException {
        this.setPed_codigo(Integer.parseInt(dados[0]));
        this.setPed_data(new SimpleDateFormat().parse(dados[1]));
        this.setPed_observacao(dados[2]);
        this.setPed_cod_cliente(Integer.parseInt(dados[3]));
        this.setPed_cod_vendedor(Integer.parseInt(dados[4]));
    }

}