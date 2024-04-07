package service.csvService;

import java.util.List;

public interface IFormatadorDados<T> {
    List<T> transformarCSVParaDados(List<String> dadosBrutos);
}
