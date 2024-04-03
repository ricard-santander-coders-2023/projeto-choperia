import model.Estoque;
import service.FormatadorDados;
import service.LeitorCSV;

public class Main {
    public static void main(String[] args) {
        LeitorCSV leitorCSV = new LeitorCSV();
        FormatadorDados formatadorDados = new FormatadorDados();

        Estoque estoque = new Estoque(leitorCSV,formatadorDados);

        System.out.println(estoque.getProdutos());
    }
}