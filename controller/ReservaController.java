package controller;

import java.util.List;
import java.util.Scanner;
import model.Cliente;
import model.Quarto;
import service.ClienteService;
import service.QuartoService;

public class ReservaController {

    private final ClienteService clienteService;
    private final QuartoService quartoService;

    public ReservaController(ClienteService clienteService, QuartoService quartoService) {
        this.clienteService = clienteService;
        this.quartoService = quartoService;
    }

    public void gerenciarReservas(Scanner scanner) {
        int opcao = -1;

        do {
            System.out.println("\n--- Gerenciamento de Reservas ---");
            System.out.println("1 - Fazer Reserva");
            System.out.println("2 - Listar Reservas");
            System.out.println("3 - Cancelar Reserva");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        fazerReserva(scanner);
                        break;
                    case 2:
                        listarReservas();
                        break;
                    case 3:
                        cancelarReserva(scanner);
                        break;
                    case 0:
                        System.out.println("Voltando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }

        } while (opcao != 0);
    }

    private void fazerReserva(Scanner scanner) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = clienteService.buscarPorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado. Certifique-se de que o CPF está correto e o cliente foi cadastrado.");
            return;
        }

        List<Quarto> disponiveis = quartoService.listarQuartosDisponiveis();

        if (disponiveis.isEmpty()) {
            System.out.println("Não há quartos disponíveis no momento.");
            return;
        }

        System.out.println("\n--- Quartos Disponíveis ---");
        for (Quarto q : disponiveis) {
            System.out.println("Número: " + q.getNumero() + " - Tipo: " + q.getClass().getSimpleName());
        }

        System.out.print("Digite o número do quarto que deseja reservar: ");
        int numero = Integer.parseInt(scanner.nextLine());

        Quarto quarto = quartoService.buscarQuartoPorNumero(numero);

        if (quarto == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }

        if (quarto.isOcupado()) {
            System.out.println("Este quarto já está ocupado.");
            return;
        }

        quarto.ocupar();
        quartoService.atualizarQuarto(quarto);
        System.out.println("Reserva realizada com sucesso para o cliente " + cliente.getNome() + " no quarto " + numero + ".");
    }

    private void listarReservas() {
        List<Quarto> quartos = quartoService.listarTodosOsQuartos();
        System.out.println("\n--- Reservas Atuais ---");

        boolean temReserva = false;
        for (Quarto q : quartos) {
            if (q.isOcupado()) {
                System.out.println("Quarto " + q.getNumero() + " - Ocupado");
                temReserva = true;
            }
        }

        if (!temReserva) {
            System.out.println("Nenhuma reserva realizada.");
        }
    }

    private void cancelarReserva(Scanner scanner) {
        System.out.print("Digite o número do quarto que deseja cancelar a reserva: ");
        int numero = Integer.parseInt(scanner.nextLine());

        Quarto quarto = quartoService.buscarQuartoPorNumero(numero);

        if (quarto == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }

        if (!quarto.isOcupado()) {
            System.out.println("Este quarto já está disponível. Não há reserva para cancelar.");
            return;
        }

        quarto.desocupar();
        quartoService.atualizarQuarto(quarto);
        System.out.println("Reserva do quarto " + numero + " cancelada com sucesso.");
    }
}
