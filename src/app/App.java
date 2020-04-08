package app;

import java.util.Date;

import dao.ClienteDao;
import dao.PedidoDao;
import dao.VendedorDao;
import database.DatabaseConnection;
import facade.PedidoFacade;
import models.Cliente;
import models.Pedido;
import models.Produto;
import models.Vendedor;

public class App {
    public static void main(String[] args) throws Exception {

        Cliente cliente = new Cliente();
        Vendedor vendedor = new Vendedor();
        Pedido pedido = new Pedido();
        Produto produto = new Produto();

        // ===================================================================================================
        // Clliente
        cliente.setCli_codigo(1);
        cliente.setCli_nome("Marcos Oliveira");
        cliente.setCli_cpf("123.123.123-33");
        cliente.setCli_ultima_compra(new Date());

        // ===================================================================================================
        // Vendedor
        vendedor.setVend_codigo(1);
        vendedor.setVend_nome("Welles");
        vendedor.setVend_percentual_comissao(5.00);

        // ===================================================================================================
        // Pedido
        pedido.setPed_codigo(13);;
        pedido.setPed_data(new Date());
        pedido.setPed_observacao("Compra Sei Lá");
        pedido.setPed_cod_cliente(1);
        pedido.setPed_cod_vendedor(1);

        // ===================================================================================================
        // Produto
        produto.setProd_codigo(1);
        produto.setProd_descricao("HeadSet Corsair HS50");
        produto.setProd_saldo(50);
        produto.setProd_unidade("uni");


        PedidoFacade fazerPedido = new PedidoFacade();

        fazerPedido.pedido(cliente, vendedor, pedido, produto);
    }
}