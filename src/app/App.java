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

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.recover(1);
        
        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = produtoDao.recover(1);

        VendedorDao vendedorDao = new VendedorDao();
        Vendedor vendedor = vendedorDao.recover(1);

        // Pedido
        // Pedido pedido = new Pedido();
        // pedido.setPed_data(new Date());
        // pedido.setPed_observacao("Compra do produto  " + produto.getProd_descricao()  + " do vendedor "  + vendedor.getVend_nome() + " na data " + pedido.getPed_data());
        // pedido.setPed_cod_cliente(1);
        // pedido.setPed_cod_vendedor(1);

        PedidoDao pedidoDao = new PedidoDao();
        Pedido pedido = pedidoDao.recover(2);

        PedidoFacade pedidoFacade = new PedidoFacade();
        // pedidoFacade.fazerPedido(cliente, vendedor, pedido, produto);

        pedidoFacade.desfazerPedido(produto, pedido, cliente);

    }
}