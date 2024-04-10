package view;

import controller.EstoqueController;
import model.Estoque;
import service.csvService.Estoque.EscritorCSV;
import service.csvService.Estoque.FormatadorDados;
import service.csvService.Estoque.LeitorCSV;

import java.util.ArrayList;
import java.util.Arrays;

import static utils.EntraValores.entradaInt;

public class Menu {

    static int opcao;


    static ArrayList<String> opcoesMenu = new ArrayList<>(Arrays.asList(
            "CLIENTES",
            "VENDAS",
            "ESTOQUE"));

    static ArrayList<String> opcoesMenuCliente = new ArrayList<>(Arrays.asList(
            "Cadastrar Cliente",
            "Alterar Cliente",
            "Buscar Cliente",
            "Listar Cliente"
    ));

    static ArrayList<String> opcoesMenuVendas = new ArrayList<>(Arrays.asList(
            "Lancar Venda",
            "Buscar Venda",
            "Listar Vendas"

    ));

    static ArrayList<String> opcoesMenuEstoque = new ArrayList<>(Arrays.asList(
            "Cadastrar Produto",
            "Remover Produto",
            "Renomear Produto",
            "Buscar Produto",
            "Alterar Quantidade",
            "Listar Produtos",
            "Remover Produtos Vencidos",
            "Zerar Produtos"
    ));

    public static void menuPrincipal() {
        limpaTela();

        System.out.println("------------- MENU -------------");
        for (int i = 0; i < opcoesMenu.size(); i++) {

            System.out.println("|    " + (i + 1) + " - " + String.format("%-21s", opcoesMenu.get(i)) + " |");


        }
        System.out.println("|    " + "0" + " - " + String.format("%-21s", "SAIR") + " |");
        System.out.println("--------------------------------");
        opcao = entradaInt("Escolha a opcao: ");
        switch (opcao) {
            case 1:
                menuClientes();
                break;
            case 2:
                menuVendas();
                break;
            case 3:
                menuEstoque();
                break;
            case 0:
                sair();
                break;
            default:
                System.out.println("Opcao invalida!");
                try {
                    Thread.sleep(3000);
                    limpaTela();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                break;
        }
    }


    public static void limpaTela() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println();
//        System.out.print("\n".repeat(50));
    }

    public static void sair() {
        System.out.println("Saindo do programa...");
        System.exit(0);
    }

    public static void menuClientes() {
        menuBase(MenuCliente.class, opcoesMenuCliente, "CLIENTE");
        menuClientes();

    }

    public static void menuVendas() {
        menuBase(MenuEstoque.class, opcoesMenuVendas, "VENDAS");
        menuVendas();
    }

    public static void menuEstoque() {
        menuBase(MenuVenda.class, opcoesMenuEstoque, "ESTOQUE");
        menuEstoque();
    }

    public static <T extends Enum<T> & OpcaoMenu> void menuBase(Class<T> enumClass, ArrayList<String> opcoes, String titulo) {
        T[] values = enumClass.getEnumConstants();

        System.out.printf("------------ %s ------------%n" +
                "", titulo);
        for (int i = 0; i < values.length; i++) {
            System.out.println("|    " + (i + 1) + " - " + String.format("%-22s", opcoes.get(i)) + " |");
        }
        System.out.println("|    " + (values.length + 1) + " - " + String.format("%-22s", "Menu Principal") + " |");
        System.out.println("|    " + "0" + " - " + String.format("%-22s", "SAIR") + " |");
        System.out.println("---------------------------------");
        opcao = entradaInt("Escolha a opcao: ");
        if (opcao == 0) sair();
        if (opcao == values.length + 1) {
            menuPrincipal();
            return;
        }
        if (opcao >= 1 && opcao <= values.length) {
            values[opcao - 1].executar();
        } else {
            System.out.println("Opcao invalida!");
            try {
                Thread.sleep(3000);
                limpaTela();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

