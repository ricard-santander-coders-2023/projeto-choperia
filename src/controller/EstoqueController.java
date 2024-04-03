package controller;

import model.Estoque;
import model.Produto;
import service.csvService.EscritorCSV;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class EstoqueController {
    private Estoque estoque;
    private EscritorCSV escritorCSV;

    public EstoqueController(Estoque estoque, EscritorCSV escritorCSV) {
        this.estoque = estoque;
        this.escritorCSV = escritorCSV;
    }

    public void escreverNovoCSV() {
        List<String> produtosString = estoque.getProdutos().stream().map(this::produtoParaCSV).collect(Collectors.toList());
        escritorCSV.escreverArquivo(produtosString);
    }

    private String produtoParaCSV(Produto produto) {
        return String.format("%s,%s,%s,%s",
                produto.getId(),
                produto.getFabricante(),
                produto.getLote(),
                produto.getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

}
