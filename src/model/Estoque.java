package model;

import service.csvService.IFormatadorDados;
import service.csvService.ILeitorCSV;
import service.csvService.Estoque.ListaDeArquivos;

import java.io.IOException;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;


    private static final int QUANTIDADE_MAXIMA_POR_LOTE = 15;

    public static int getQuantidadeMaximaPorLote() {
        return QUANTIDADE_MAXIMA_POR_LOTE;
    }

    public Estoque(ILeitorCSV leitorCSV, IFormatadorDados formatadorDados) {
        inicializarDados(leitorCSV,formatadorDados);
    }

    public void inicializarDados(ILeitorCSV leitorCSV, IFormatadorDados formatadorDados) {
        String diretorio = ListaDeArquivos.getDiretorioFormatado(ListaDeArquivos.getUltimoNumArquivo());
        try {
            List<String> dadosBrutos = leitorCSV.lerArquivo(diretorio);
            produtos = formatadorDados.transformarCSVParaDados(dadosBrutos);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
