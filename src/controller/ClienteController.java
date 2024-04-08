package controller;

import model.CadastroClientes;
import model.Cliente;
import service.csvService.Cliente.ClienteEscritorCSV;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Optional<Cliente> clienteExistente = clientes.getClientes().stream()
                .filter(cliente -> Objects.equals(cliente.getDocumento(), documento))
                .findFirst();

        if (clienteExistente.isPresent()) {
            System.out.println("Já existe um cliente com esse documento!" + clienteExistente.get());
            return;
        }

        clientes.getClientes().add(new Cliente(nome, documento));
        System.out.println("Cliente cadastrado com sucesso.");
    }

    public void removeCliente(String documento) {
        clientes.getClientes().removeIf(cliente -> Objects.equals(cliente.getDocumento(), documento));
    }

    public void renomearCliente(String documento, String novoNome) {
        Optional<Cliente> clienteOptional = clientes.getClientes().stream()
                .filter(cliente -> Objects.equals(cliente.getDocumento(), documento))
                .findFirst();

        if (clienteOptional.isEmpty()) {
            System.out.println("Não há cliente com esse documento.");
            return;
        }

        clienteOptional.get().setNome(novoNome);
        System.out.println("Nome do cliente alterado com sucesso!");
    }

}
