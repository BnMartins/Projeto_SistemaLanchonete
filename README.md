Sistema Lanchonete (Lanches BN)

Sistema em terminal de gerenciamento de lanchonete desenvolvido em **Java**. O sistema permite gerenciar clientes, produtos, pedidos e faturamento de forma simples e direta pelo console, para treinar e colocar em pratica o que eu aprendi até agora no curso de Java do DevDojo(Maratona Java virando no Jiraya)

---

Funcionalidades

O sistema conta com um menu interativo contendo as seguintes opções:

1. **Cadastrar Cliente:** Permite o registro de novos clientes informando nome e telefone.
2. **Cadastrar Produto:** Cadastro de produtos com nome, preço e categoria (Lanches, Bebidas ou Sobremesas).
3. **Fazer Pedido:** Associa a criação de um pedido a um cliente cadastrado.
4. **Adicionar Itens ao Pedido:** Permite escolher um produto e definir a quantidade para adicioná-lo ao pedido corrente.
5. **Finalizar Pedido:** Calcula o valor final total e encerra o pedido.
6. **Listar Pedidos:** Mostra todos os pedidos finalizados e seus respectivos totais.
7. **Ver Faturamento:** Exibe a soma total faturada pela lanchonete de todos os pedidos finalizados.

---

Estrutura do Projeto

O projeto está estruturado em pacotes seguindo boas práticas de organização:

```text
src/
â”œâ”€â”€ dominio/
â”‚   â”œâ”€â”€ CategoriaProduto.java  # Enum para categorias (LANCHE, BEBIDA, SOBREMESA)
â”‚   â”œâ”€â”€ Cliente.java           # Modelo de Cliente (herda de Pessoa)
â”‚   â”œâ”€â”€ ItemPedido.java        # Representa o produto e quantidade associados
â”‚   â”œâ”€â”€ Pedido.java            # Modelo contendo regras de negócio do pedido
â”‚   â”œâ”€â”€ Pessoa.java            # Superclasse abstrata
â”‚   â””â”€â”€ Produto.java           # Modelo de Produto
â”œâ”€â”€ servico/
â”‚   â”œâ”€â”€ ClienteService.java    # Operações de negócio para clientes
â”‚   â”œâ”€â”€ PedidoService.java     # Operações de negócio para pedidos e faturamento
â”‚   â””â”€â”€ ProdutoService.java    # Operações de negócio para produtos
â””â”€â”€ main/
    â””â”€â”€ MainSistemaLachonete.java  # Ponto de entrada (CLI) do sistema
```

---

Conceitos Java Aplicados

Este projeto foi pensado para praticar fundamentos da linguagem:

- **POO:** classes, herança (`Pessoa` â†’ `Cliente`), polimorfismo e encapsulamento
- **Enums:** categorias de produto com `CategoriaProduto`
- **Collections:** `ArrayList` para armazenar clientes, produtos e pedidos em memória
- **Camadas:** separação entre domínio (`dominio`), serviços (`servico`) e entrada (`main`)
- **Regras de negócio:** validação de pedidos vazios, itens duplicados e faturamento apenas de pedidos finalizados

---

Fluxo de Uso Recomendado

1. Cadastre pelo menos um **cliente** e um **produto**
2. Crie um **pedido** vinculado ao cliente
3. **Adicione itens** ao pedido informando produto e quantidade
4. **Finalize o pedido** para registrar o valor
5. Consulte o **faturamento** para ver o total acumulado

---

Tecnologias Utilizadas

- **Java JDK (versÃ£o 17 ou superior)**
- **Console/Terminal** para interface de usuÃ¡rio (Scanner)

---

Como Executar o Projeto

1. Certifique-se de ter o **Java JDK** instalado e configurado no seu PATH.
2. Clone este repositÃ³rio:
   ```bash
   git clone https://github.com/BnMartins/Projeto_SistemaLanchonete.git
   ```
3. Abra a pasta do projeto na sua IDE favorita (IntelliJ IDEA, Eclipse, VS Code).
4. Execute o arquivo principal localizado em:
   ```text
   src/main/MainSistemaLachonete.java
   ```
5. Siga as instruções que aparecerem no terminal para interagir com o menu.

### Compilar e executar pelo terminal

```bash
javac -d out src/dominio/*.java src/servico/*.java src/main/*.java
java -cp out main.MainSistemaLachonete
```

---

Roadmap

Melhorias planejadas para versÃµes futuras:

- [ ] Persistência dos dados em arquivo ou banco de dados
- [ ] Cancelamento de pedidos em andamento
- [ ] Relatório de produtos mais vendidos
- [ ] Interface gráfica com JavaFX ou Swing

---

Autor

Desenvolvido por **BnMartins**.
