package service.csvService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeitorCSV implements ILeitorCSV{
    @Override
    public List<String> lerArquivo(String diretorio) throws IOException {
        try (Stream<String> lines = Files.lines(Path.of(diretorio))) {
            return lines.collect(Collectors.toList());
        }
    }
}
