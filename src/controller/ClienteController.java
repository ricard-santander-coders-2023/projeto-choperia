package controller;

import model.CadastroClientes;
import model.Cliente;
import service.csvService.Cliente.ClienteEscritorCSV;

import java.util.List;
import java.util.Objects;

public class ClienteController {
    private CadastroClientes clientes;
    private ClienteEscritorCSV clienteEscritorCSV;

    public ClienteController(CadastroClientes clientes, ClienteEscritorCSV clienteEscritorCSV) {
        this.clientes = clientes;
        this.clienteEscritorCSV = clienteEscritorCSV;
    }

    public void escreverNovoCSV() {
        List<String> clientesString = clientes.getClientes().stream().map(this::clienteParaCSV).toList();
        clienteEscritorCSV.escreverArquivo(clientesString);
    }

    private String clienteParaCSV(Cliente cliente) {
        return String.format("%d,%s,%s,%s",
                cliente.getId(),
                cliente.getNome(),
                cliente.getDocumento(),
                cliente.getTipo());
    }

    public void cadastraCliente(String nome, String documento) {
        for (Cliente cliente : clientes.getClientes()) {

            if (Objects.equals(cliente.getDocumento(), documento)) {
                System.out.println("Já existe um cliente com esse documento!" + cliente);
                break;
            }
        }
        clientes.getClientes().add(new Cliente(nome, documento));
    }

    public void removeCliente(String documento) {
        clientes.getClientes().removeIf(cliente -> Objects.equals(cliente.getDocumento(), documento));
    }

    public void renomearCliente(String documento, String novoNome) {
        List<Cliente> cadastroClientes = clientes.getClientes();
        boolean nomeAlterado = false;


        for (Cliente cliente : cadastroClientes) {
            if (Objects.equals(cliente.getDocumento(), documento)) {
                cliente.setNome(novoNome);
                nomeAlterado = true;
                break;
            }
        }
        System.out.println(nomeAlterado ? "Nome do cliente alterado com sucesso!" : "Não há cliente com esse documento.");
    }

}
