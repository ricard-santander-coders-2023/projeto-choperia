package view.GerenciaMenu;


import controller.EstoqueController;
import model.Estoque;
import service.csvService.Estoque.EscritorCSV;
import service.csvService.Estoque.FormatadorDados;
import service.csvService.Estoque.LeitorCSV;

import java.time.LocalDate;
import java.util.Scanner;

import static utils.EntraValores.entradaInt;
import static utils.EntraValores.entradaLocalDate;
import static utils.EntraValores.entradaStringNotEmpty;

public class MenuEstoques {
    static Scanner scanner = new Scanner(System.in);

    static LeitorCSV leitorCSV = new LeitorCSV();
    static FormatadorDados formatadorDados = new FormatadorDados();
    static EscritorCSV escritorCSV = new EscritorCSV();
    static Estoque estoque = new Estoque(leitorCSV, formatadorDados);
    static EstoqueController estoqueController = new EstoqueController(estoque, escritorCSV);


    public static void cadastraProduto() {
        String id = entradaStringNotEmpty("Digite ID do produto: ");
        String nomeProduto = entradaStringNotEmpty("Digite nome do produto: ");
        String lote = entradaStringNotEmpty("Digite o lote: ");
        LocalDate validade = entradaLocalDate("Digite data validade (dd-MM-yyyy): ");
        int quantidade = entradaInt("Digite a quantidade total em Litros: ");
        ;

        estoqueController.adicionarProduto(id, nomeProduto, lote, validade, quantidade);

        System.out.println(estoqueController.buscarProduto(id) ? "Produto cadastrado com sucesso!" : "Erro ao cadastrar produto.");
    }

    public static void removerProduto() {
        String id = entradaStringNotEmpty("Digite a ID do produto: ");
        String lote = entradaStringNotEmpty("Digite o lote do produto: ");

        estoqueController.removerProduto(id, lote);

        System.out.println(estoqueController.buscarProduto(lote) ? "Produto removido com sucesso!" : "Erro ao remover produto.");
    }

    public static void buscarProduto() {
        String termoBusca = entradaStringNotEmpty("Digite o termo de busca: ");
        estoqueController.buscarProduto(termoBusca);
    }

    public static void alterarQuantidadeProduto() {
        String id = entradaStringNotEmpty("Digite o ID do produto: ");
        int quantidade = entradaInt("Digite a quantidade em Litros a ser removido: ");

       boolean estoqueAlterado = estoqueController.alterarQuantidadeDoProduto(id, quantidade);

        if (estoqueAlterado) {
            System.out.println("Quantidade alterada com sucesso!: \n");
        }
    }

    public static void listarProdutos() {
        estoqueController.verProdutos();
    }

    public static void zerarEstoque() {
        estoque.getProdutos().clear();
    }

    public static void renomearProduto() {
        String id = entradaStringNotEmpty("Digite a ID do produto: ");
        String novoNome = entradaStringNotEmpty("Digite novo nome do produto: ");

        estoqueController.renomearProduto(id, novoNome);
    }

    public static void removerProdutosVencidos() {
        estoqueController.removerProdutosVencidos();
    }
}
