package service.csvService.Estoque;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EscritorCSV {
    public void escreverArquivo(List<String> linhas) {
        String cabecalho = "id,nome_produto,lote,validade, quantidade";

        List<String> linhasFiltradas = linhas.stream()
                .filter(linha -> !linha.endsWith(",0") && !linha.endsWith(",0\n"))
                .collect(Collectors.toList());

        linhasFiltradas.sort(Comparator.comparing((String linha) -> linha.split(",")[0])
                .thenComparing((String linha) -> linha.split(",")[2]));

        linhasFiltradas.add(0,cabecalho);

        Path caminho = caminhoNovoArquivo();


        try {
            Files.createFile(caminho);
            Files.write(caminho,linhasFiltradas);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Path caminhoNovoArquivo() {
        int novoNumArquivo = ListaDeArquivos.getUltimoNumArquivo();
        return Path.of(ListaDeArquivos.getDiretorioFormatado(++novoNumArquivo));
    }
}
