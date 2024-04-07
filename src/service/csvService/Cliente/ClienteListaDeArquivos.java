package service.csvService.Cliente;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class ClienteListaDeArquivos {
    public static Integer getUltimoNumArquivo() {
        File diretorio = new File("arquivos/clientes");
        String[] conteudo = diretorio.list();
        Optional<Integer> numArquivo = Arrays.stream(Objects.requireNonNull(conteudo)).map(dir -> Integer.parseInt(dir.substring(8,dir.length()-4))).max(Integer::compare);
        return numArquivo.orElse(0);
    }

    public static String getDiretorioFormatado() {
        return "arquivos/clientes/clientes.csv";
    }
}
