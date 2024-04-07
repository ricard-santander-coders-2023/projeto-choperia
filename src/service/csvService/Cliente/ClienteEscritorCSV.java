package service.csvService.Cliente;


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

        Path caminho = caminhoNovoArquivo();

        try {
            if(!Files.exists(caminho)) {
                Files.createFile(caminho);
            }
            Files.write(caminho, linhas);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Path caminhoNovoArquivo() {
        return Path.of(ClienteListaDeArquivos.getDiretorioFormatado());
    }
}
