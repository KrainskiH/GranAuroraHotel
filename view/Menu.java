package view;

import controller.ClienteController;
import controller.QuartoController;
import controller.ReservaController;
import java.util.InputMismatchException; // Importar a exceção
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final ClienteController clienteController = new ClienteController();
    private final QuartoController quartoController = new QuartoController();
    private final ReservaController reservaController = new ReservaController();

    /**
     * Exibe o menu principal e gerencia a navegação do usuário.
     */
    public void exibirMenu() {
        int opcao = -1;

        do {
            System.out.println("\n====== GranAuroraHotel ======");
            System.out.println("1 - Gerenciar Clientes");
            System.out.println("2 - Gerenciar Quartos");
            System.out.println("3 - Gerenciar Reservas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // limpa o buffer do newline

                switch (opcao) {
                    case 1:
                        menuClientes();
                        break;
                    case 2:
                        menuQuartos();
                        break;
                    case 3:
                        menuReservas();
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema... Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); // Limpa a entrada inválida do buffer
                opcao = -1; // Reseta a opção para garantir a continuidade do loop
            }

        } while (opcao != 0);

        scanner.close(); // Boa prática: fechar o scanner ao final do uso
    }

    /**
     * Direciona para o submenu de gerenciamento de clientes.
     */
    private void menuClientes() {
        clienteController.gerenciarClientes(scanner);
    }

    /**
     * Direciona para o submenu de gerenciamento de quartos.
     */
    private void menuQuartos() {
        quartoController.gerenciarQuartos(scanner);
    }

    /**
     * Direciona para o submenu de gerenciamento de reservas.
     */
    private void menuReservas() {
        reservaController.gerenciarReservas(scanner);
    }
}