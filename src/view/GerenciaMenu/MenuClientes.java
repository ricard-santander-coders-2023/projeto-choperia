package view.GerenciaMenu;

import controller.ClienteController;
import model.CadastroClientes;
import service.csvService.Cliente.ClienteEscritorCSV;
import service.csvService.Cliente.ClienteFormatadorDados;
import service.csvService.Cliente.ClienteLeitorCSV;
import static utils.EntraValores.FormataString.manterApenasNumeros;
import static utils.EntraValores.entradaStringNotEmpty;

public class MenuClientes {

    static ClienteLeitorCSV clientesCSV = new ClienteLeitorCSV();
    static ClienteFormatadorDados clientesFormatados = new ClienteFormatadorDados();
    static  ClienteEscritorCSV clienteEscritorCSV = new ClienteEscritorCSV();
    static CadastroClientes clientes = new CadastroClientes(clientesCSV, clientesFormatados);
    static ClienteController clienteController = new ClienteController(clientes, clienteEscritorCSV);


    public static void cadastraPessoa() {
        String nome = entradaStringNotEmpty("Digite o nome: ");
        String documento = entradaStringNotEmpty("Digite documento: ");
        documento = manterApenasNumeros(documento);

        clienteController.cadastraCliente(nome, documento);

        System.out.println(clienteController.buscarCliente(documento) ? "Cliente cadastrada com sucesso!" : "Não foi possível cadastrar cliente.");
    }


    public static void alteraCliente() {
    }

    public static void buscaCliente() {
    }

    public static void listaPessoas() {
    }
}
