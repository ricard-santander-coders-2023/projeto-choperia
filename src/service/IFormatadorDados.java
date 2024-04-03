package service;

import model.Produto;

import java.util.List;

public interface IFormatadorDados {
    List<Produto> transformarDados(List<String> dadosBrutos);
}
