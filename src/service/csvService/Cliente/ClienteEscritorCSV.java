package service.csvService.Cliente;

import model.Cliente;
import service.csvService.Estoque.ListaDeArquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteEscritorCSV {
    public void escreverArquivo(List<String> clientes) {
        String cabecalho = "ID,Nome,Documento,Tipo";

        List<String> linhas = new ArrayList<>(clientes.stream().toList());

        linhas.sort(Comparator.comparing((String linha) -> linha.split(",")[1]));

        linhas.add(0, cabecalho);

        Path caminho = Path.of(ListaDeArquivos.getDiretorioFormatado(0));

        try {
            Files.createFile(caminho);
            Files.write(caminho, linhas);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
