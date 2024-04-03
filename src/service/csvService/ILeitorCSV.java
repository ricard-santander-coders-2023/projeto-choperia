package service.csvService;

import java.io.IOException;
import java.util.List;

public interface ILeitorCSV {
    List<String> lerArquivo(String diretorio) throws IOException;
}
