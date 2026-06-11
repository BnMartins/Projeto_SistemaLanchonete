package dominio;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private Cliente cliente;
    private ArrayList<ItemPedido> itens = new ArrayList<>();
    private boolean finalizado;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public void adicionarItem(ItemPedido item){
        for (ItemPedido itemExistente : itens) {
            if (itemExistente.getProduto().getId() == item.getProduto().getId()){
                int soma = item.getQuantidade() + itemExistente.getQuantidade();
                itemExistente.setQuantidade(soma);
                return;
            }
        }
        itens.add(item);
    }

    public double calcularTotal(){
        double valorPedido = 0;
        for (ItemPedido itensPedido : itens) {
            valorPedido += itensPedido.calcularSubTotal();
        }
        return valorPedido;
    }

    public void finalizarPedido(){
        if (itens.isEmpty()){
            System.out.println("O Pedido não pode ser finalizado!");
            return;
        }else if (finalizado){
            System.out.println("Esse Pedido já foi finalizado...");
            return;
        }
        finalizado = true;
    }

    @Override
    public String toString() {
        return "Pedido #" + id +
                " | Cliente: " + cliente.getNome() +
                " | Quantidade de Itens: " + itens.size() +
                " | Total: " + calcularTotal() +
                " | Finalizado: " + finalizado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
