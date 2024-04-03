import controller.EstoqueController;
import model.Estoque;
import service.csvService.*;

public class Main {
    public static void main(String[] args) {
        ILeitorCSV leitorCSV = new LeitorCSV();
        IFormatadorDados formatadorDados = new FormatadorDados();
        EscritorCSV escritorCSV = new EscritorCSV();

        Estoque estoque = new Estoque(leitorCSV,formatadorDados);
        EstoqueController estoqueController = new EstoqueController(estoque, escritorCSV);

        estoqueController.escreverNovoCSV();
    }
}