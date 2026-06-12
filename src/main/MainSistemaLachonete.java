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
    public static void main(String[] args) throws InterruptedException{
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService();
        CategoriaProduto categoriaProduto;
        int proximoIdCliente = 1;
        int proximoIdProduto = 1;
        int proximoIdPedido = 1;
        try (Scanner usuario = new Scanner(System.in)) {
        while (true){
            System.out.println("========== Lanches BN ==========");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Fazer Pedido");
            System.out.println("4 - Finalizar pedido");
            System.out.println("5 - Listar Pedidos");
            System.out.println("6 - Ver Faturamento");
            System.out.println("0 - Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma das opções: ");
            int opcao = usuario.nextInt();
            usuario.nextLine();
            switch (opcao){
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
                    System.out.println("Cliente "+ nome +" cadastrado!");
                    Thread.sleep(500);
                    System.out.println("Id do Cliente: "+proximoIdCliente+" | Nome: "+nome+" | Telefone: "+ telefone);
                    proximoIdCliente++;
                    Thread.sleep(500);
                    clienteService.cadastraCliente(cliente);
                    Thread.sleep(500);
                    break;
                case 2:
                    System.out.println("Abrindo cadastro do Produto...");
                    Thread.sleep(500);
                    System.out.print("Digite o nome do Produto: ");
                    String nomeProduto = usuario.nextLine();
                    Thread.sleep(500);
                    System.out.print("Digite o Preço do Produto: ");
                    double preco = usuario.nextDouble();
                    Thread.sleep(500);
                    System.out.println("Categoria do Produto");
                    System.out.println("(1) Lanche");
                    System.out.println("(2) Bebida");
                    System.out.println("(3) Sobremesa");
                    System.out.print("Qual a Categoria do Produto: ");
                    int categoria = usuario.nextInt();
                    if (categoria == 1){
                        categoriaProduto = CategoriaProduto.LANCHE;
                    } else if (categoria == 2) {
                        categoriaProduto = CategoriaProduto.BEBIDA;
                    } else if (categoria == 3) {
                        categoriaProduto = CategoriaProduto.SOBREMESA;
                    }else {
                        System.out.println("Opção Invalida! Escolha uma opção Valida.");
                        break;
                    }
                    Produto produto = new Produto(proximoIdProduto, nomeProduto, preco, categoriaProduto);
                    System.out.println("Cliente "+ nomeProduto +" cadastrado!");
                    Thread.sleep(500);
                    System.out.println("Id do Produto: "+proximoIdProduto+" | Nome: "+nomeProduto+
                            " | Preço: "+preco+ "| Categoria do Produto: "+categoriaProduto);
                    proximoIdProduto++;
                    Thread.sleep(500);
                    produtoService.cadastrarProduto(produto);
                    Thread.sleep(500);
                    break;
                case 3: 
                    if (!clienteService.possuiCliente()) {
                        Thread.sleep(500);
                        System.out.println("Nenhum cliente encontrado!");
                        break;
                    }
                    System.out.println("Começando Pedido...");
                    Thread.sleep(500);
                    clienteService.listarClientes();
                    System.out.print("Selecione o id do Cliente que quer começar o pedido: ");
                    int idClientePedido = usuario.nextInt();
                    Cliente clientePedido = clienteService.buscarClientePorId(idClientePedido);
                    if (clientePedido == null) {
                        System.out.println("Cliente não encontrado!");
                        break;
                    }
                    Pedido pedidoAtual = pedidoService.buscarPedidoAbertoPorCliente(clientePedido.getId());
                    if (pedidoAtual == null) {
                        pedidoAtual = new Pedido(proximoIdPedido, clientePedido);
                        pedidoService.criarPedido(pedidoAtual);
                        proximoIdPedido++;
                    } else {
                        System.out.println("Pedido já aberto para esse Cliente! Adicionando itens ao pedido #" + pedidoAtual.getId());
                    }
                    System.out.println("Abrindo Menu de Produtos...");
                    Thread.sleep(500);
                    String resposta1;
                    do {
                        produtoService.listarProdutos();
                        Thread.sleep(500);
                        System.out.print("Escolha o id do Produto que quer adicionar ao Pedido: ");
                        int idProduto = usuario.nextInt();
                        Produto produtoEscolhido = produtoService.buscarProdutoPorId(idProduto);
                        if (produtoEscolhido == null) {
                            System.out.println("Produto não encontrado!");
                            break;
                        }
                        System.out.print("Digite a quantidade do produto: ");
                        int quantidade = usuario.nextInt();
                        usuario.nextLine();
                        if (quantidade <= 0) {
                            System.out.println("Quantidade inválida!");
                            break;
                        }
                        pedidoAtual.adicionarItem(new ItemPedido(produtoEscolhido, quantidade));
                        System.out.println("Produto adicionado com sucesso!");
                        System.out.println("Quer continuar? [Sim/Não]");
                        resposta1 = usuario.nextLine(); 
                    } while (resposta1.equalsIgnoreCase("sim"));
                    Thread.sleep(500);
                    break;
                case 4:
                    System.out.println("Abrindo Menu de Pedidos...");
                    pedidoService.listarPedidos();
                    Thread.sleep(500);
                    System.out.print("Deseja Finalizar qual Pedido?");
                    int finalizarPedido = usuario.nextInt();
                    usuario.nextLine();
                    Pedido pedido = pedidoService.buscarPedidoPorId(finalizarPedido);
                    if (pedido != null) {
                        Thread.sleep(500);
                        System.out.println("Deseja Finalizar o Pedido " + finalizarPedido + "?");
                        String resposta2 = usuario.nextLine();
                        if (resposta2.equalsIgnoreCase("sim")) {
                            Thread.sleep(500);
                            pedido.finalizarPedido();
                        } else if (resposta2.equalsIgnoreCase("não")){
                            Thread.sleep(500);
                            System.out.println("Pedido não Finalizado...");
                            break;
                        }else {
                            Thread.sleep(500);
                            System.out.println("Respota Inválida!");
                        }
                    } else {
                        Thread.sleep(500);
                        System.out.println("Pedido não encontrado!");
                        break;
                    }
                    break;
                case 5:
                    System.out.println("Abrindo Lista de Pedidos");
                    Thread.sleep(500);
                    pedidoService.pedidoFinalizado();
                    System.out.println("=====================");
                    break;
                case 6:
                    System.out.println("Abrindo o Faturamento da Lanchonete!");
                    Thread.sleep(500);
                    double valor = pedidoService.calcularFaturamento();
                    System.out.println("Faturamento da Lanchonete: R$ " + String.format("%.2f", valor));
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção Invalida! Escolha uma opção Valida!");
            }
        }
        }
    }
}