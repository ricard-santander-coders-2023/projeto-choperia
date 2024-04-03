package model;

import service.IFormatadorDados;
import service.ILeitorCSV;

import java.io.IOException;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque(ILeitorCSV leitorCSV, IFormatadorDados formatadorDados) {
        inicializarDados(leitorCSV,formatadorDados);
    }

    public void inicializarDados(ILeitorCSV leitorCSV, IFormatadorDados formatadorDados) {
        String diretorio = "arquivos/file_1.csv";
        try {
            List<String> dadosBrutos = leitorCSV.lerArquivo(diretorio);
            produtos = formatadorDados.transformarDados(dadosBrutos);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
