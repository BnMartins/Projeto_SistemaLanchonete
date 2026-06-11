# 🍔 Sistema Lanchonete (Lanches BN)

Sistema em terminal de gerenciamento de lanchonete desenvolvido em **Java**. O sistema permite gerenciar clientes, produtos, pedidos e faturamento de forma simples e direta pelo console.

---

## 🚀 Funcionalidades

O sistema conta com um menu interativo contendo as seguintes opções:

1. **Cadastrar Cliente:** Permite o registro de novos clientes informando nome e telefone.
2. **Cadastrar Produto:** Cadastro de produtos com nome, preço e categoria (Lanches, Bebidas ou Sobremesas).
3. **Fazer Pedido:** Associa a criação de um pedido a um cliente cadastrado.
4. **Adicionar Itens ao Pedido:** Permite escolher um produto e definir a quantidade para adicioná-lo ao pedido corrente.
5. **Finalizar Pedido:** Calcula o valor final total e encerra o pedido.
6. **Listar Pedidos:** Mostra todos os pedidos registrados e seus respectivos status.
7. **Ver Faturamento:** Exibe a soma total faturada pela lanchonete de todos os pedidos finalizados.

---

## 📁 Estrutura do Projeto

O projeto é estruturado em pacotes seguindo boas práticas de organização:

```text
src/
├── dominio/
│   ├── CategoriaProduto.java  # Enum para categorias (LANCHE, BEBIDA, SOBREMESA)
│   ├── Cliente.java           # Modelo de Cliente (herda de Pessoa)
│   ├── ItemPedido.java        # Representa o produto e quantidade associados
│   ├── Pedido.java            # Modelo contendo regras de negócio do pedido
│   ├── Pessoa.java            # Superclasse abstrata
│   └── Produto.java           # Modelo de Produto
├── servico/
│   ├── ClienteService.java    # Operações de negócio para clientes
│   ├── PedidoService.java     # Operações de negócio para pedidos e faturamento
│   └── ProdutoService.java    # Operações de negócio para produtos
└── main/
    └── MainSistemaLachonete.java  # Ponto de entrada (CLI) do sistema
```

---

## 🛠️ Tecnologias Utilizadas

- **Java JDK (versão 17 ou superior)**
- **Console/Terminal** para interface de usuário (Scanner)

---

## 💻 Como Executar o Projeto

1. Certifique-se de ter o **Java JDK** instalado e configurado no seu PATH.
2. Clone este repositório:
   ```bash
   git clone https://github.com/BnMartins/Projeto_SistemaLanchonete.git
   ```
3. Abra a pasta do projeto na sua IDE favorita (IntelliJ IDEA, Eclipse, VS Code).
4. Execute o arquivo principal localizado em:
   ```text
   src/main/MainSistemaLachonete.java
   ```
5. Siga as instruções que aparecerão no terminal para interagir com o menu.

---

## 📝 Autor

Desenvolvido por **BnMartins**.
