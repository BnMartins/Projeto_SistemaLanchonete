package servico;

import dominio.Pedido;

import java.util.ArrayList;

public class PedidoService {
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public boolean criarPedido(Pedido pedido) {
        for (Pedido pedidoExistente : pedidos) {
            if (pedidoExistente.getId() == pedido.getId()) {
                System.out.println("Pedido nÃ£o criado, pois jÃ¡ existe");
                return false;
            }
        }
        pedidos.add(pedido);
        System.out.println("Pedido criado com sucesso!!");
        return true;
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Lista de Pedido vazia!");
            return;
        }
        for (Pedido addPedido : pedidos) {
            System.out.println(addPedido);
        }
    }

    public void pedidoFinalizado() {
        boolean encontrouFinalizado = false;
        for (Pedido pedido : pedidos) {
            if (pedido.isFinalizado()) {
                System.out.println(pedido);
                encontrouFinalizado = true;
            }
        }
        if (!encontrouFinalizado) {
            System.out.println("Nenhum pedido finalizado encontrado!");
        }
    }

    public Pedido buscarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    public double calcularFaturamento() {
        double valorTotal = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.isFinalizado()) {
                valorTotal += pedido.calcularTotal();
            }
        }
        return valorTotal;
    }
}