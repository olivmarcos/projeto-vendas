package models;

public class VendedorComissao {

    private int vnc_codigo;
    private Double vnc_comissao;
    private int vnc_cod_vendedor;
    private int vnc_cod_pedido;

    public int getVnc_codigo() {
        return this.vnc_codigo;
    }

    public void setVnc_codigo(int vnc_codigo) {
        this.vnc_codigo = vnc_codigo;
    }

    public Double getVnc_comissao() {
        return this.vnc_comissao;
    }

    public void setVnc_comissao(Double vnc_comissao) {
        this.vnc_comissao = vnc_comissao;
    }

    public int getVnc_cod_vendedor() {
        return this.vnc_cod_vendedor;
    }

    public void setVnc_cod_vendedor(int vnc_cod_vendedor) {
        this.vnc_cod_vendedor = vnc_cod_vendedor;
    }

    public int getVnc_cod_pedido() {
        return this.vnc_cod_pedido;
    }

    public void setVnc_cod_pedido(int vnc_cod_pedido) {
        this.vnc_cod_pedido = vnc_cod_pedido;
    }

    @Override
    public String toString() {
        return "{" +
            " vnc_codigo='" + getVnc_codigo() + "'" +
            ", vnc_comissao='" + getVnc_comissao() + "'" +
            ", vnc_cod_vendedor='" + getVnc_cod_vendedor() + "'" +
            ", vnc_cod_pedido='" + getVnc_cod_pedido() + "'" +
            "}";
    }

    public String[] toVetor() {
        String vetor[] = new String[4];
        vetor[0] = String.valueOf(getVnc_codigo());
        vetor[1] = String.valueOf(getVnc_comissao());
        vetor[2] = String.valueOf(getVnc_cod_vendedor());
        vetor[3] = String.valueOf(getVnc_cod_pedido());

        return vetor;
    }

    public void vetorTo(String[] dados) {
        this.setVnc_codigo(Integer.parseInt(dados[0]));
        this.setVnc_comissao(Double.parseDouble(dados[1]));
        this.setVnc_cod_vendedor(Integer.parseInt(dados[2]));
        this.setVnc_cod_pedido(Integer.parseInt(dados[3]));
    }
}