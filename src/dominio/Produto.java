package dominio;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private CategoriaProduto categoria;

    public Produto(int id, String nome, double preco, CategoriaProduto categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Id: " + id + " | Nome: " + nome + " | Preço: R$ " + String.format("%.2f", preco) 
        + " | Categoria: " + categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }
}
