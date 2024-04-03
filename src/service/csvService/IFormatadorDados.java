package service.csvService;

import model.Produto;

import java.util.List;

public interface IFormatadorDados {
    List<Produto> transformarCSVParaProdutos(List<String> dadosBrutos);

}
