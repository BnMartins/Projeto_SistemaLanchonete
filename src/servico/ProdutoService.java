package servico;

import dominio.Produto;

import java.util.ArrayList;

public class ProdutoService {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public boolean cadastrarProduto(Produto produto) {
        for (Produto produtoExistente : produtos) {
            if (produtoExistente.getId() == produto.getId()) {
                System.out.println("Produto " + produto.getNome() + " já Existente. Logo não foi cadastrado!!");
                return false;
            }
        }
        produtos.add(produto);
        System.out.println("Produto " + produto.getNome() + " cadastrado com sucesso!");
        return true;
    }

    public void listarProdutos(){
        if (produtos.isEmpty()){
            System.out.println("Lista de Produtos Vazia!");
            return;
        }
        for (Produto addProduto : produtos){
            System.out.println(addProduto);
        }
    }

    public Produto buscarProdutoPorId(int id){
        for (Produto produto : produtos){
            if (produto.getId() == id){
                return produto;
            }
        }
        return null;
    }
}
