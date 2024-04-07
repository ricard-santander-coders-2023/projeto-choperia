package model;

import service.csvService.CSVReader;
import service.csvService.DataFormatter;
import service.csvService.FileList;

import java.io.IOException;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque(CSVReader csvReader, DataFormatter dataFormatter) {
        inicializarDados(csvReader, dataFormatter);
    }

    public void inicializarDados(CSVReader csvReader, DataFormatter dataFormatter) {
        String directory = FileList.getFormattedDirectory(FileList.getLastFileNumber());
        try {
            List<String> rawData = csvReader.readFile(directory);
            produtos = dataFormatter.transformCSVtoProducts(rawData);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
