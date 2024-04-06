package controller;

import model.Estoque;
import model.Produto;
import service.csvService.EscritorCSV;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
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
        return String.format("%s,%s,%s,%s,%d",
                produto.getId(),
                produto.getNomeProduto(),
                produto.getLote(),
                produto.getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                produto.getQuantidade());
    }

    public void aumentaEstoque(String idProduto, String lote, int quantidade) {

        List<Produto> produtos = estoque.getProdutos().stream()
                .filter(p -> p.getId().equals(idProduto) && p.getLote().equals(lote))
                .sorted(Comparator.comparing(Produto::getValidade))
                .toList();

        for (Produto produto : produtos) {
            if (quantidade == 0) {
                break;
            }
            int diff = produto.getQuantidadeMaxima() - produto.getQuantidade();
            int quantityToAdd = Math.min(diff, quantidade);
            produto.setQuantidade(String.valueOf(produto.getQuantidade() + quantityToAdd));
            quantidade -= quantityToAdd;
        }
    }


    public void diminuiEstoque(String idProduto, int quantidade) {
        List<Produto> produtos = estoque.getProdutos().stream()
                .filter(p -> p.getId().equals(idProduto))
                .sorted(Comparator.comparing(Produto::getValidade).thenComparing(Produto::getLote))
                .toList();


        for (Produto produto : produtos) {
            int quantidadeTotalDisponivel = produtos.stream().mapToInt(Produto::getQuantidade).sum();
            if (quantidadeTotalDisponivel < quantidade) {
                System.out.println(("Quantidade insuficiente em estoque.\nRestante: " + produtos.stream().mapToInt(Produto::getQuantidade).sum()) + " litros");
                break;
            }
            int quantidadeDisponivel = produto.getQuantidade();
            if (quantidadeDisponivel >= quantidade) {
                produto.setQuantidade(String.valueOf(quantidadeDisponivel - quantidade));
                return;
            } else if (quantidadeDisponivel > 0) {
                produto.setQuantidade(String.valueOf(0));
                quantidade -= quantidadeDisponivel;
            }
        }
    }

    public void verificaValidade() {
        LocalDate dataAtual = LocalDate.now();
        List<Produto> produtosParaRemover = estoque.getProdutos().stream()
                .filter(p -> p.getValidade().minusDays(20).isBefore(dataAtual))
                .toList();

        for (Produto produto : produtosParaRemover) {
            if (produto.getValidade().isBefore(dataAtual)) {
                System.out.println("REMOVIDO ==> " + produto.getId() + " - " + produto.getLote() + " - " + produto.getQuantidade());
                diminuiEstoque(produto.getId(), produto.getQuantidade());
//                System.out.println("Produto expirado: \n" + produtoParaCSV(produto));
            } else {
                System.out.println("Produto com lote próximo ao vencimento: \n" + produtoParaCSV(produto));
            }
        }
    }

}

