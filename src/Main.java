package main;

import model.Estoque;
import service.csvService.CSVReader;
import service.csvService.CSVWriter;
import service.csvService.DataFormatter;
import controller.EstoqueController;

public class Main {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        DataFormatter dataFormatter = new DataFormatter();
        CSVWriter csvWriter = new CSVWriter();

        Estoque stock = new Estoque(csvReader, dataFormatter);
        EstoqueController stockController = new EstoqueController(stock, csvWriter);

        stockController.writeNewCSV();
    }
}
