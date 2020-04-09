package app;

import java.util.Date;

import dao.ClienteDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import dao.ProdutoMovimentacaoDao;
import dao.VendedorDao;
import database.DatabaseConnection;
import facade.PedidoFacade;
import models.Cliente;
import models.Pedido;
import models.Produto;
import models.Vendedor;

public class App {
    public static void main(String[] args) throws Exception {

        Vendedor vendedor = new Vendedor();
        // Pedido pedido = new Pedido();
        // Produto produto = new Produto();

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.recover(1);
        // System.out.println(cliente);

        PedidoDao pedidoDao = new PedidoDao();
        Pedido pedido = pedidoDao.recover(1);
        pedido.setPed_data("2020-04-09 11:06:03");
        // System.out.println(pedido);

        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = produtoDao.recover(1);
        // System.out.println(produto);

        // ===================================================================================================
        // Clliente
        // cliente.setCli_codigo(1);
        // cliente.setCli_nome("Marcos Oliveira");
        // cliente.setCli_cpf("123.123.123-33");
        // cliente.setCli_ultima_compra(new Date());

        // // ===================================================================================================
        // // Vendedor
        // vendedor.setVend_codigo(1);
        // vendedor.setVend_nome("Welles");
        // vendedor.setVend_percentual_comissao(5.00);

        // // ===================================================================================================
        // // Pedido
        // pedido.setPed_codigo(1);;
        // pedido.setPed_data(new Date());
        // pedido.setPed_observacao("Compra Sei Lá");
        // pedido.setPed_cod_cliente(1);
        // pedido.setPed_cod_vendedor(1);

        // // ===================================================================================================
        // // Produto
        // produto.setProd_codigo(1);
        // produto.setProd_descricao("HeadSet Corsair HS50");
        // produto.setProd_saldo(50);
        // produto.setProd_unidade("uni");


        PedidoFacade pedidoFacade = new PedidoFacade();

        // pedidoFacade.fazerPedido(cliente, vendedor, pedido, produto);

          pedidoFacade.desfazerPedido(produto, pedido, cliente);
    }
}