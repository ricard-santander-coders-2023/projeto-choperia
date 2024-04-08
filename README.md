  ______  
 /       \ 
 | ADA   | 
 | CHOPP | 
 \______/

# Sistema de Gerenciamento de Estoque e Clientes

Este sistema fornece uma solução completa para o gerenciamento de estoque de produtos e cadastro de clientes, permitindo operações como adição, remoção, e atualização de produtos e clientes, além da geração de relatórios em formato CSV.

## EstoqueController

O `EstoqueController` gerencia as operações relacionadas ao estoque de produtos, incluindo a adição e remoção de produtos, alteração de quantidade, e verificação de produtos próximos do vencimento.

### Métodos Disponíveis

- `escreverNovoCSV()`: Gera um novo arquivo CSV com os detalhes de todos os produtos no estoque.
- `adicionarProduto(String id, String nomeProduto, String lote, LocalDate validade, int quantidade)`: Adiciona um novo produto ao estoque, respeitando a quantidade máxima por lote.
- `removerProduto(String id, String lote)`: Remove um produto específico do estoque.
- `removerTodosProdutos()`: Limpa o estoque, removendo todos os produtos.
- `alterarQuantidadeDoProduto(String idProduto, int quantidade)`: Altera a quantidade disponível de um produto específico.
- `verProdutos()`: Exibe todos os produtos disponíveis no estoque.
- `renomearProduto(String idProduto, String novoNome)`: Renomeia um produto no estoque.
- `removerProdutosVencidos()`: Remove produtos vencidos do estoque e alerta sobre produtos próximos do vencimento.

## ClienteController

O `ClienteController` administra as operações relacionadas ao cadastro de clientes, como adição, remoção, e atualização de informações do cliente.

### Métodos Disponíveis

- `escreverNovoCSV()`: Gera um novo arquivo CSV com os detalhes de todos os clientes cadastrados.
- `cadastraCliente(String nome, String documento)`: Adiciona um novo cliente ao sistema.
- `removeCliente(String documento)`: Remove um cliente específico do sistema.
- `renomearCliente(String documento, String novoNome)`: Altera o nome de um cliente cadastrado.

## Uso

Para utilizar esses controllers, é necessário instanciar os objetos `Estoque` e `CadastroClientes`, junto com as classes de serviço `EscritorCSV` e `ClienteEscritorCSV`, respectivamente. Após a instância, você pode chamar os métodos disponíveis conforme a necessidade do seu sistema.
