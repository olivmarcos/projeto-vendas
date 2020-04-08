package models;

public class PedidoProduto {

    private int pedp_codigo;
    private int pedp_quantidade;
    private Double pedp_valor;
    private Double pedp_valor_total;
    private int pedp_cod_produto;
    private int pedp_cod_pedido;

    public int getPedp_codigo() {
        return this.pedp_codigo;
    }

    public void setPedp_codigo(int pedp_codigo) {
        this.pedp_codigo = pedp_codigo;
    }

    public int getPedp_quantidade() {
        return this.pedp_quantidade;
    }

    public void setPedp_quantidade(int pedp_quantidade) {
        this.pedp_quantidade = pedp_quantidade;
    }

    public Double getPedp_valor() {
        return this.pedp_valor;
    }

    public void setPedp_valor(Double pedp_valor) {
        this.pedp_valor = pedp_valor;
    }

    public Double getPedp_valor_total() {
        return this.pedp_valor_total;
    }

    public void setPedp_valor_total(Double pedp_valor_total) {
        this.pedp_valor_total = pedp_valor_total;
    }

    public int getPedp_cod_produto() {
        return this.pedp_cod_produto;
    }

    public void setPedp_cod_produto(int pedp_cod_produto) {
        this.pedp_cod_produto = pedp_cod_produto;
    }

    public int getPedp_cod_pedido() {
        return this.pedp_cod_pedido;
    }

    public void setPedp_cod_pedido(int pedp_cod_pedido) {
        this.pedp_cod_pedido = pedp_cod_pedido;
    }

    @Override
    public String toString() {
        return "{" +
            " pedp_codigo='" + getPedp_codigo() + "'" +
            ", pedp_quantidade='" + getPedp_quantidade() + "'" +
            ", pedp_valor='" + getPedp_valor() + "'" +
            ", pedp_valor_total='" + getPedp_valor_total() + "'" +
            ", pedp_cod_produto='" + getPedp_cod_produto() + "'" +
            ", pedp_cod_pedido='" + getPedp_cod_pedido() + "'" +
            "}";
    }

    public String[] toVetor() {
        String vetor[] = new String[6];
        vetor[0] = String.valueOf(getPedp_codigo());
        vetor[1] = String.valueOf(getPedp_quantidade());
        vetor[2] = String.valueOf(getPedp_valor());
        vetor[3] = String.valueOf(getPedp_valor_total());
        vetor[4] = String.valueOf(getPedp_cod_produto());
        vetor[5] = String.valueOf(getPedp_cod_pedido());

        return vetor;
    }

    public void vetorTo(String[] dados) {
        this.setPedp_codigo(Integer.parseInt(dados[0]));
        this.setPedp_quantidade(Integer.parseInt(dados[1]));
        this.setPedp_valor(Double.parseDouble(dados[2]));
        this.setPedp_valor_total(Double.parseDouble(dados[3]));
        this.setPedp_cod_produto(Integer.parseInt(dados[4]));
        this.setPedp_cod_pedido(Integer.parseInt(dados[5]));
    }
}