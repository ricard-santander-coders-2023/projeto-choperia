package model;

import service.csvService.IFormatadorDados;
import service.csvService.ILeitorCSV;
import service.csvService.ListaDeArquivos;

import java.io.IOException;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;


    public Estoque(ILeitorCSV leitorCSV, IFormatadorDados formatadorDados) {
        inicializarDados(leitorCSV,formatadorDados);
    }

    public void inicializarDados(ILeitorCSV leitorCSV, IFormatadorDados formatadorDados) {
        String diretorio = ListaDeArquivos.getDiretorioFormatado(ListaDeArquivos.getUltimoNumArquivo());
        try {
            List<String> dadosBrutos = leitorCSV.lerArquivo(diretorio);
            produtos = formatadorDados.transformarCSVParaProdutos(dadosBrutos);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
