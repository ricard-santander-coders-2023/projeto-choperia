package service;

import model.Produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class FormatadorDados implements IFormatadorDados{
    @Override
    public List<Produto> transformarDados(List<String> dadosBrutos) {
        return dadosBrutos.stream().skip(1)
                .map(linha -> linha.split(","))
                .filter(arr -> arr.length == 4)
                .map(arr -> new Produto(arr[0],arr[1],arr[2],formatarData(arr[3])))
                .collect(Collectors.toList());
    }

    private LocalDate formatarData(String dataString) {
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataString,formatadorData);
    }
}
