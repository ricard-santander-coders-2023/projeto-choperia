package service;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class ListaDeArquivos {
    public static String getUltimoArquivo() {
        File diretorio = new File("arquivos");
        String[] conteudo = diretorio.list();
        Optional<Integer> teste = Arrays.stream(Objects.requireNonNull(conteudo)).map(dir -> Integer.parseInt(dir.substring(5,dir.length()-4))).max(Integer::compare);
        return teste.map(integer -> "file_" + integer + ".csv").orElse(null);
    }
}
