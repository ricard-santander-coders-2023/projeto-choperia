package service.csvService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class EscritorCSV {
    public void escreverArquivo(List<String> linhas) {
        String cabecalho = "id,nome_produto,lote,validade, quantidade";
        linhas.add(0,cabecalho);

        linhas = linhas.stream()
                .filter(linha -> !linha.endsWith(",0") && !linha.endsWith(",0\n"))
                .toList();

        Path caminho = caminhoNovoArquivo();


        try {
            Files.createFile(caminho);
            Files.write(caminho,linhas);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Path caminhoNovoArquivo() {
        int novoNumArquivo = ListaDeArquivos.getUltimoNumArquivo();
        return Path.of(ListaDeArquivos.getDiretorioFormatado(++novoNumArquivo));
    }
}
