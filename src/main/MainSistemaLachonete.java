package main;

import dominio.CategoriaProduto;
import dominio.Cliente;
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
        while (true){
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
                    proximoIdCliente++;
                    System.out.println("Cliente "+ nome +" cadastrado!");
                    Thread.sleep(500);
                    System.out.println("Id do Cliente: "+proximoIdCliente+" | Nome: "+nome+" | Telefone: "+ telefone);
                    Thread.sleep(500);
                    if (clienteService.cadastraCliente(cliente)){
                        System.out.println("Cliente "+ nome + "cadastrado!");
                    }
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
                    proximoIdProduto++;
                    System.out.println("Cliente "+ nomeProduto +" cadastrado!");
                    Thread.sleep(500);
                    System.out.println("Id do Produto: "+proximoIdProduto+" | Nome: "+nomeProduto+
                            " | Preço: "+preco+ "| Categoria do Produto: "+categoriaProduto);
                    Thread.sleep(500);
                    if (produtoService.cadastrarProduto(produto)){
                        System.out.println("Produto "+ nomeProduto +" cadastrado!");
                    }
                    Thread.sleep(500);
                    break;
                case 3:
                    int adicionar;
                    System.out.println("Começando Pedido...");
                    clienteService.listarClientes();
                    System.out.println("Selecione o id do Cliente que quer começar o pedido: ");
                    adicionar = usuario.nextInt();
                    Cliente cliente1 = clienteService.buscarClientePorId(adicionar);
                    if (cliente1 != null){
                        Pedido pedido = new Pedido(proximoIdPedido, cliente1);
                        pedidoService.criarPedido(pedido);
                        proximoIdPedido++;
                    }
                    System.out.println("Cliente não encontrado");
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

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
