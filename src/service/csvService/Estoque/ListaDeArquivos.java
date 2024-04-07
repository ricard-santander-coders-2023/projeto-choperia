package service.csvService.Estoque;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class ListaDeArquivos {
    public static Integer getUltimoNumArquivo() {
        File diretorio = new File("arquivos/estoque");
        String[] conteudo = diretorio.list();
        Optional<Integer> numArquivo = Arrays.stream(Objects.requireNonNull(conteudo)).map(dir -> Integer.parseInt(dir.substring(8,dir.length()-4))).max(Integer::compare);
        return numArquivo.orElse(0);
    }

    public static String getDiretorioFormatado(int ultimoNumArquivo) {
        return "arquivos/estoque/estoque_"+ ultimoNumArquivo +".csv";
    }
}
