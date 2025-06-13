package view;

import controller.ClienteController;
import controller.QuartoController;
import controller.ReservaController;
import service.ClienteService;
import service.QuartoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);

    // Instâncias compartilhadas de serviços
    private final ClienteService clienteService = new ClienteService();
    private final QuartoService quartoService = new QuartoService();

    // Controllers usando as mesmas instâncias de serviço
    private final ClienteController clienteController = new ClienteController(clienteService);
    private final QuartoController quartoController = new QuartoController(); // Supondo que não precisa de serviço
    private final ReservaController reservaController = new ReservaController(clienteService, quartoService);

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
                scanner.nextLine();

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
                scanner.nextLine();
                opcao = -1;
            }

        } while (opcao != 0);

        scanner.close();
    }

    private void menuClientes() {
        clienteController.gerenciarClientes(scanner);
    }

    private void menuQuartos() {
        quartoController.gerenciarQuartos(scanner);
    }

    private void menuReservas() {
        reservaController.gerenciarReservas(scanner);
    }
}