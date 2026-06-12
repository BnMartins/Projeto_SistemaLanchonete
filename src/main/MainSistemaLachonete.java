package main;

import dominio.CategoriaProduto;
import dominio.Cliente;
import dominio.ItemPedido;
import dominio.Pedido;
import dominio.Produto;
import servico.ClienteService;
import servico.PedidoService;
import servico.ProdutoService;

import java.util.Scanner;

public class MainSistemaLachonete {
    public static void main(String[] args) throws InterruptedException {
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService();
        CategoriaProduto categoriaProduto;
        int proximoIdCliente = 1;
        int proximoIdProduto = 1;
        int proximoIdPedido = 1;

        while (true) {
            Scanner usuario = new Scanner(System.in);
            System.out.println("========== Lanches BN ==========");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Fazer Pedido");
            System.out.println("4 - Adicionar itens ao pedido");
            System.out.println("5 - Finalizar pedido");
            System.out.println("6 - Listar Pedidos");
            System.out.println("7 - Ver Faturamento");
            System.out.println("0 - Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma das opÃ§Ãµes: ");
            int opcao = usuario.nextInt();
            usuario.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Abrindo cadastro Cliente...");
                    Thread.sleep(500);
                    System.out.print("Digite o nome do cliente: ");
                    String nome = usuario.next();
                    Thread.sleep(500);
                    System.out.print("Digite o Telefone do cliente: ");
                    String telefone = usuario.next();
                    Thread.sleep(500);
                    Cliente cliente = new Cliente(proximoIdCliente, nome, telefone);
                    int idCliente = proximoIdCliente;
                    proximoIdCliente++;
                    if (clienteService.cadastraCliente(cliente)) {
                        System.out.println("Id do Cliente: " + idCliente + " | Nome: " + nome + " | Telefone: " + telefone);
                    }
                    Thread.sleep(500);
                    break;
                case 2:
                    System.out.println("Abrindo cadastro do Produto...");
                    Thread.sleep(500);
                    System.out.print("Digite o nome do Produto: ");
                    String nomeProduto = usuario.nextLine();
                    Thread.sleep(500);
                    System.out.print("Digite o PreÃ§o do Produto: ");
                    double preco = usuario.nextDouble();
                    Thread.sleep(500);
                    System.out.println("Categoria do Produto");
                    System.out.println("(1) Lanche");
                    System.out.println("(2) Bebida");
                    System.out.println("(3) Sobremesa");
                    System.out.print("Qual a Categoria do Produto: ");
                    int categoria = usuario.nextInt();
                    if (categoria == 1) {
                        categoriaProduto = CategoriaProduto.LANCHE;
                    } else if (categoria == 2) {
                        categoriaProduto = CategoriaProduto.BEBIDA;
                    } else if (categoria == 3) {
                        categoriaProduto = CategoriaProduto.SOBREMESA;
                    } else {
                        System.out.println("OpÃ§Ã£o Invalida! Escolha uma opÃ§Ã£o Valida.");
                        break;
                    }
                    Produto produto = new Produto(proximoIdProduto, nomeProduto, preco, categoriaProduto);
                    int idProduto = proximoIdProduto;
                    proximoIdProduto++;
                    if (produtoService.cadastrarProduto(produto)) {
                        System.out.println("Id do Produto: " + idProduto + " | Nome: " + nomeProduto +
                                " | PreÃ§o: " + preco + " | Categoria: " + categoriaProduto);
                    }
                    Thread.sleep(500);
                    break;
                case 3:
                    System.out.println("ComeÃ§ando Pedido...");
                    clienteService.listarClientes();
                    System.out.print("Selecione o id do Cliente que quer comeÃ§ar o pedido: ");
                    int idClientePedido = usuario.nextInt();
                    Cliente clientePedido = clienteService.buscarClientePorId(idClientePedido);
                    if (clientePedido != null) {
                        Pedido pedido = new Pedido(proximoIdPedido, clientePedido);
                        pedidoService.criarPedido(pedido);
                        proximoIdPedido++;
                    } else {
                        System.out.println("Cliente nÃ£o encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Abrindo Menu de Pedidos...");
                    Thread.sleep(500);
                    pedidoService.listarPedidos();
                    Thread.sleep(500);
                    System.out.print("Escolha o id do pedido que quer adicionar produtos: ");
                    int addPedido = usuario.nextInt();
                    Pedido pedidoAtual = pedidoService.buscarPedidoPorId(addPedido);
                    if (pedidoAtual == null) {
                        System.out.println("Pedido nÃ£o encontrado");
                        break;
                    }
                    if (pedidoAtual.isFinalizado()) {
                        System.out.println("NÃ£o Ã© possÃ­vel adicionar itens a um pedido jÃ¡ finalizado!");
                        break;
                    }
                    produtoService.listarProdutos();
                    Thread.sleep(500);
                    System.out.print("Escolha o id do produto que quer adicionar ao pedido: ");
                    int addProduto = usuario.nextInt();
                    Produto produtoEscolhido = produtoService.buscarProdutoPorId(addProduto);
                    if (produtoEscolhido == null) {
                        System.out.println("Produto nÃ£o encontrado");
                        break;
                    }
                    System.out.print("Escolha a quantidade do Produto que quer adicionar no Pedido: ");
                    int quantidade = usuario.nextInt();
                    if (quantidade <= 0) {
                        System.out.println("Quantidade invÃ¡lida!");
                        break;
                    }
                    ItemPedido itemPedido = new ItemPedido(produtoEscolhido, quantidade);
                    pedidoAtual.adicionarItem(itemPedido);
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 5:
                    System.out.println("Abrindo Menu de Pedidos...");
                    pedidoService.listarPedidos();
                    Thread.sleep(500);
                    System.out.print("Deseja finalizar qual Pedido? ");
                    int finalizarPedido = usuario.nextInt();
                    usuario.nextLine();
                    Pedido pedidoFinalizar = pedidoService.buscarPedidoPorId(finalizarPedido);
                    if (pedidoFinalizar == null) {
                        System.out.println("Pedido nÃ£o encontrado!");
                        break;
                    }
                    System.out.println("Deseja finalizar o Pedido " + finalizarPedido + "? (sim/nÃ£o)");
                    String resposta = usuario.nextLine();
                    if (resposta.equalsIgnoreCase("sim")) {
                        pedidoFinalizar.finalizarPedido();
                        System.out.println("Total do pedido: R$ " + String.format("%.2f", pedidoFinalizar.calcularTotal()));
                    } else if (resposta.equalsIgnoreCase("nÃ£o") || resposta.equalsIgnoreCase("nao")) {
                        System.out.println("Pedido nÃ£o finalizado...");
                    } else {
                        System.out.println("Resposta invÃ¡lida!");
                    }
                    break;
                case 6:
                    System.out.println("Abrindo Lista de Pedidos Finalizados");
                    Thread.sleep(500);
                    pedidoService.pedidoFinalizado();
                    break;
                case 7:
                    System.out.println("Abrindo o Faturamento da Lanchonete!");
                    Thread.sleep(500);
                    double faturamento = pedidoService.calcularFaturamento();
                    System.out.println("Faturamento total (pedidos finalizados): R$ " + String.format("%.2f", faturamento));
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("OpÃ§Ã£o Invalida! Escolha uma opÃ§Ã£o Valida!");
            }
        }
    }
}