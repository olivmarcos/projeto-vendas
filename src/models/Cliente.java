package models;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Cliente {
    private int cli_codigo;
    private String cli_nome;
    private String cli_cpf;
    private String cli_ultima_compra;

    public int getCli_codigo() {
        return this.cli_codigo;
    }

    public void setCli_codigo(int cli_codigo) {
        this.cli_codigo = cli_codigo;
    }

    public String getCli_nome() {
        return this.cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public String getCli_cpf() {
        return this.cli_cpf;
    }

    public void setCli_cpf(String cli_cpf) {
        this.cli_cpf = cli_cpf;
    }

    public String getCli_ultima_compra() {
        return this.cli_ultima_compra;
    }

    public void setCli_ultima_compra(Date cli_ultima_compra) {
        String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cli_ultima_compra);
        this.cli_ultima_compra = data;
    }

    public void setCli_ultima_compra(String cli_ultima_compra) {
        this.cli_ultima_compra = cli_ultima_compra;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return cli_codigo == cliente.cli_codigo && Objects.equals(cli_nome, cliente.cli_nome)
                && Objects.equals(cli_cpf, cliente.cli_cpf)
                && Objects.equals(cli_ultima_compra, cliente.cli_ultima_compra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cli_codigo, cli_nome, cli_cpf, cli_ultima_compra);
    }

    @Override
//    public String toString() {
//        return "{" + " cli_codigo='" + getCli_codigo() + "'" + ", cli_nome='" + getCli_nome() + "'" + ", cli_cpf='"
//                + getCli_cpf() + "'" + ", cli_ultima_compra='" + getCli_ultima_compra() + "'" + "}";
//    }
    
        public String toString() {
        return this.getCli_codigo() + " - " + this.getCli_nome();
    }

    public String[] toVetor() {
        String vetor[] = new String[4];
        vetor[0] = String.valueOf(getCli_codigo());
        vetor[1] = getCli_nome();
        vetor[2] = getCli_cpf();
        vetor[3] = getCli_ultima_compra();

        return vetor;
    }

    public void vetorTo(String[] dados) throws ParseException {
        this.setCli_codigo(Integer.parseInt(dados[0]));
        this.setCli_nome(dados[1]);
        this.setCli_cpf(dados[2]);
        this.setCli_ultima_compra(new SimpleDateFormat().parse(dados[3]));
    }
}