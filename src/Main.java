import controller.ClienteController;
import controller.EstoqueController;
import model.CadastroClientes;
import model.Estoque;
import service.csvService.Cliente.ClienteEscritorCSV;
import service.csvService.Cliente.ClienteFormatadorDados;
import service.csvService.Cliente.ClienteLeitorCSV;
import service.csvService.Estoque.EscritorCSV;
import service.csvService.Estoque.FormatadorDados;
import service.csvService.Estoque.LeitorCSV;

public class Main {
    public static void main(String[] args) {
        LeitorCSV leitorCSV = new LeitorCSV();
        ClienteLeitorCSV clientesCSV = new ClienteLeitorCSV();

        FormatadorDados formatadorDados = new FormatadorDados();
        ClienteFormatadorDados clientesFormatados = new ClienteFormatadorDados();

        EscritorCSV escritorCSV = new EscritorCSV();
        ClienteEscritorCSV clienteEscritorCSV = new ClienteEscritorCSV();

        Estoque estoque = new Estoque(leitorCSV, formatadorDados);
        CadastroClientes clientes = new CadastroClientes(clientesCSV, clientesFormatados);


//        System.out.println(clientes.getClientes());

        EstoqueController estoqueController = new EstoqueController(estoque, escritorCSV);
        ClienteController clienteController = new ClienteController(clientes, clienteEscritorCSV);

        clienteController.cadastraCliente("Boteco do Zé", "11231313131200");
        clienteController.cadastraCliente("Sr Juca", "88822244466");
//
//        estoqueController.renomearProduto("A01", "Ada Pielsen");


//        estoqueController.cadastraProduto("A01","aaaa", "L0031", LocalDate.now(), 35); //String id, String nomeProduto, String lote, LocalDate validade, int quantidade
//        estoqueController.verificaValidade();

//        estoqueController.diminuiEstoque("A01", 15);
//        estoqueController.diminuiEstoque("A01", 35);
//        estoqueController.diminuiEstoque("A01", 35);

//        estoqueController.escreverNovoCSV();
        clienteController.escreverNovoCSV();
    }
}