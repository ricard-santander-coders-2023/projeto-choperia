package service.csvService.Cliente;

import model.Cliente;
import service.csvService.IFormatadorDados;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteFormatadorDados implements IFormatadorDados<Cliente> {
    @Override
    public List<Cliente> transformarCSVParaDados(List<String> dadosBrutos) {
        return dadosBrutos.stream().skip(1)
                .map(linha -> linha.split(","))
                .filter(arr -> arr.length == 4)
                .map(arr -> ehPessoaFisica(arr[2]) ? new Cliente(arr[1], arr[2]) {
                }: new Cliente(arr[1], arr[2]))
                .collect(Collectors.toList());
    }

    private boolean ehPessoaFisica(String documento) {
        return documento.length() == 11;
    }

}
