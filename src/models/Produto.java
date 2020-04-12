package models;

public class Produto {

    private int prod_codigo;
    private String prod_descricao;
    private int prod_saldo;
    private String prod_unidade;

    public int getProd_codigo() {
        return this.prod_codigo;
    }

    public void setProd_codigo(int prod_codigo) {
        this.prod_codigo = prod_codigo;
    }

    public String getProd_descricao() {
        return this.prod_descricao;
    }

    public void setProd_descricao(String prod_descricao) {
        this.prod_descricao = prod_descricao;
    }

    public int getProd_saldo() {
        return this.prod_saldo;
    }

    public void setProd_saldo(int prod_saldo) {
        this.prod_saldo = prod_saldo;
    }

    public String getProd_unidade() {
        return this.prod_unidade;
    }

    public void setProd_unidade(String prod_unidade) {
        this.prod_unidade = prod_unidade;
    }

    @Override
//    public String toString() {
//        return "{"
//                + " prod_codigo='" + getProd_codigo() + "'"
//                + ", prod_descricao='" + getProd_descricao() + "'"
//                + ", prod_saldo='" + getProd_saldo() + "'"
//                + ", prod_unidade='" + getProd_unidade() + "'"
//                + "}";
//    }

    public String toString() {
        return this.getProd_codigo() + " - " + this.getProd_descricao() + " - Estoque: " + getProd_saldo();
    }

    public String[] toVetor() {
        String vetor[] = new String[4];
        vetor[0] = String.valueOf(getProd_codigo());
        vetor[1] = getProd_descricao();
        vetor[2] = String.valueOf(getProd_saldo());
        vetor[3] = String.valueOf(getProd_unidade());

        return vetor;
    }

    public void vetorTo(String[] dados) {
        this.setProd_codigo(Integer.parseInt(dados[0]));
        this.setProd_descricao(dados[1]);
        this.setProd_saldo(Integer.parseInt(dados[2]));
        this.setProd_unidade(dados[3]);
    }
}
