package controller;

import model.Estoque;
import model.Produto;
import service.csvService.Estoque.EscritorCSV;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EstoqueController {
    private Estoque estoque;
    private EscritorCSV escritorCSV;

    public EstoqueController(Estoque estoque, EscritorCSV escritorCSV) {
        this.estoque = estoque;
        this.escritorCSV = escritorCSV;
    }

    public void escreverNovoCSV() {
        List<String> produtosString = estoque.getProdutos().stream().map(this::produtoParaCSV).toList();
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

    public void cadastraProduto(String id, String nomeProduto, String lote, LocalDate validade, int quantidade) {

        if (quantidade <= 0) {
            System.out.println("Quantidade não pode ser menor ou igual a zero!");
            return; // Exit the method gracefully
        }

        boolean produtoExists = estoque.getProdutos().stream()
                .anyMatch(p -> p.getLote().equals(lote));

        if (produtoExists) {
            System.out.println("Já existe um produto com esse lote!");
            return;
        }

        int quantidadeMaximaPorLote = estoque.getQuantidadeMaximaPorLote();


        while (quantidade > 0) {
            int quantidadeAAdicionar = Math.min(quantidade, quantidadeMaximaPorLote);

            for (Produto produto : estoque.getProdutos()) {
                if (Objects.equals(produto.getId(), id)) {
                    nomeProduto = produto.getNomeProduto();
                    break;
                }
            }
            Produto novoProduto = new Produto(id, nomeProduto, lote, validade, String.valueOf(quantidadeAAdicionar));
            estoque.getProdutos().add(novoProduto);
            quantidade -= quantidadeAAdicionar;
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

    public void renomearProduto(String idProduto, String novoNome) {
        List<Produto> produtos = estoque.getProdutos();
        boolean nomeAlterado = false;
        boolean nomeIgual = false;
        for (Produto produto : produtos) {
            if (Objects.equals(produto.getId(), idProduto)) {
                produto.setNomeProduto(novoNome);
                nomeAlterado = true;
            }
            if(produto.getNomeProduto() == novoNome){
                nomeIgual = true;
                break;
            }
        }
        if(nomeIgual){
            System.out.println("Nome igual ao anterior. Operação cancelada!");
            return;
        }
        System.out.println(nomeAlterado? "Nome produto alterado com sucesso!": "Não há produtos com essa ID");
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

