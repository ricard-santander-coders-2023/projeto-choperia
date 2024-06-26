package service.csvService.Estoque;

import service.csvService.ILeitorCSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class LeitorCSV implements ILeitorCSV {
    @Override
    public List<String> lerArquivo(String diretorio) throws IOException {
        try (Stream<String> lines = Files.lines(Path.of(diretorio))) {
            return lines.filter(line -> !line.endsWith(",0") && !line.endsWith(",0\n"))
                    .toList();
        }
    }
}
