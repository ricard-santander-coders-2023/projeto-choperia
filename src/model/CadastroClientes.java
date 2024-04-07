package model;

import service.csvService.Cliente.ClienteListaDeArquivos;
import service.csvService.IFormatadorDados;
import service.csvService.ILeitorCSV;

import java.io.IOException;
import java.util.List;

public class CadastroClientes {

        private List<Cliente> clientes;

        public CadastroClientes(ILeitorCSV leitorCSV, IFormatadorDados<Cliente> formatadorDados) {
            inicializarDados(leitorCSV,formatadorDados);
        }

        public void inicializarDados(ILeitorCSV leitorCSV, IFormatadorDados<Cliente> formatadorDados) {
            String diretorio = ClienteListaDeArquivos.getDiretorioFormatado();
            try {
                List<String> dadosBrutos = leitorCSV.lerArquivo(diretorio);
                clientes = formatadorDados.transformarCSVParaDados(dadosBrutos);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        public List<Cliente> getClientes() {
            return clientes;
        }
    }


