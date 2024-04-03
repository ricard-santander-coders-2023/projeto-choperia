import model.Estoque;
import service.FormatadorDados;
import service.IFormatadorDados;
import service.ILeitorCSV;
import service.LeitorCSV;

public class Main {
    public static void main(String[] args) {
        ILeitorCSV leitorCSV = new LeitorCSV();
        IFormatadorDados formatadorDados = new FormatadorDados();

        Estoque estoque = new Estoque(leitorCSV,formatadorDados);

        System.out.println(estoque.getProdutos());
    }
}