package service.csvService.Estoque;

import model.Produto;
import service.csvService.IFormatadorDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class FormatadorDados implements IFormatadorDados<Produto> {
    @Override
    public List<Produto> transformarCSVParaDados(List<String> dadosBrutos) {
        return dadosBrutos.stream().skip(1)
                .map(linha -> linha.split(","))
                .filter(arr -> arr.length == 5)
                .map(arr -> new Produto(arr[0],arr[1],arr[2],formatarData(arr[3]),arr[4]))
                .collect(Collectors.toList());
    }

    private LocalDate formatarData(String dataString) {
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataString,formatadorData);
    }
}
