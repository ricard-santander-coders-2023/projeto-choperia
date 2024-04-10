package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EntraValores {
    static Scanner scanner = new Scanner(System.in);

    public static int entradaInt(String mensagem) {
        int valor;
        do {
            try {
                System.out.print(mensagem);
                valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida!\nPor favor, digite um numero valido.");
                scanner.nextLine();
            }
        } while (true);
    }

    public static String entradaString(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine();
    }

    public static String entradaStringNotEmpty(String mensagem) {
        String value = "";

        while (value.isEmpty()) {
            System.out.print(mensagem);
            value = scanner.nextLine();
        }

        return value;
    }

    public static double entradaDouble(String mensagem) {
        double valor;
        do {
            try {
                System.out.print(mensagem);
                valor = scanner.nextDouble();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número decimal.");
                scanner.nextLine();
            }
        } while (true);
    }

//    public static TipoVeiculo entradaTipoVeiculo(String mensagem) {
//        System.out.println(mensagem);
//        TipoVeiculo[] tipos = TipoVeiculo.values();
//        System.out.println("----- TIPO VEICULO -----");
//        for (int i = 0; i < tipos.length; i++) {
//            System.out.println((i + 1) + ". " + tipos[i]);
//        }
//
//        int opcao;
//        do {
//            System.out.print("Escolha o tipo: ");
//            opcao = scanner.nextInt();
//        } while (opcao < 1 || opcao > tipos.length);
//
//        return tipos[opcao - 1];
//    }

    public static LocalDateTime entradaLocalDateTime(String mensagem) {
        LocalDateTime dataHora;
        do {
            try {
                System.out.print(mensagem);
                String input = scanner.nextLine().trim();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                if (input.isEmpty()) {
                    dataHora = LocalDateTime.parse(LocalDateTime.now().format(formatter), formatter);
                } else {
                    dataHora = LocalDateTime.parse(input, formatter);
                }
                return dataHora;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, digite a data e hora no formato correto (dd-MM-yyyy HH:mm).");
            }
        } while (true);
    }

    public static LocalDate entradaLocalDate(String mensagem) {
        LocalDate data;
        do {
            try {
                System.out.print(mensagem);
                String input = scanner.nextLine().trim();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Adjust format for LocalDate

                if (input.isEmpty()) {
                    data = LocalDate.now(); // Use current date if input is empty
                } else {
                    data = LocalDate.parse(input, formatter);
                }
                return data;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, digite a data no formato correto (dd-MM-yyyy).");
            }
        } while (true);
    }

    public class FormataString {
        public static String manterApenasNumeros(String value) {
            return value.trim().replaceAll("[^0-9]", "");
        }
    }
}
