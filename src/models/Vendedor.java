package models;

public class Vendedor {

    private int vend_codigo;
    private String vend_nome;
    private Double vend_percentual_comissao;

    public int getVend_codigo() {
        return this.vend_codigo;
    }

    public void setVend_codigo(int vend_codigo) {
        this.vend_codigo = vend_codigo;
    }

    public String getVend_nome() {
        return this.vend_nome;
    }

    public void setVend_nome(String vend_nome) {
        this.vend_nome = vend_nome;
    }

    public Double getVend_percentual_comissao() {
        return this.vend_percentual_comissao;
    }

    public void setVend_percentual_comissao(Double vend_percentual_comissao) {
        this.vend_percentual_comissao = vend_percentual_comissao;
    }

    @Override
    public String toString() {
        return "{" +
            " vend_codigo='" + getVend_codigo() + "'" +
            ", vend_nome='" + getVend_nome() + "'" +
            ", vend_percentual_comissao='" + getVend_percentual_comissao() + "'" +
            "}";
    }

    public String[] toVetor() {
        String vetor[] = new String[3];
        vetor[0] = String.valueOf(getVend_codigo());
        vetor[1] = getVend_nome();
        vetor[2] = String.valueOf(getVend_percentual_comissao());

        return vetor;
    }

    public void vetorTo(String[] dados) {
        this.setVend_codigo(Integer.parseInt(dados[0]));
        this.setVend_nome(dados[1]);
        this.setVend_percentual_comissao(Double.parseDouble(dados[2]));
    }
}