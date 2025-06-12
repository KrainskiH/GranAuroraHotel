package controller;

import utils.Log;
import utils.ArquivoUtil;
import model.Reserva;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservaController {
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private int proximoId = 1;

    public void gerenciarReservas(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu de Reservas ---");
            System.out.println("1 - Cadastrar reserva");
            System.out.println("2 - Listar reservas");
            System.out.println("3 - Editar reserva");
            System.out.println("4 - Excluir reserva");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    System.out.print("ID do quarto: ");
                    int quartoId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Data de entrada: ");
                    String entrada = scanner.nextLine();
                    System.out.print("Data de saída: ");
                    String saida = scanner.nextLine();
                    cadastrarReserva(cpfCliente, quartoId, entrada, saida); 
                    break;
                case 2:
                    listarReservas();
                    break;
                case 3:
                    System.out.print("ID da reserva: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine(); // importante para limpar buffer
                    System.out.print("Novo CPF do cliente: ");
                    String novoCpf = scanner.nextLine(); 
                    System.out.print("Novo ID do quarto: ");
                    int novoQuarto = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nova data de entrada: ");
                    String novaEntrada = scanner.nextLine();
                    System.out.print("Nova data de saída: ");
                    String novaSaida = scanner.nextLine();
                    editarReserva(idEditar, novoCpf, novoQuarto, novaEntrada, novaSaida); 
                    break;
                case 4:
                    System.out.print("ID da reserva a excluir: ");
                    int idExcluir = scanner.nextInt();
                    excluirReserva(idExcluir);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public void cadastrarReserva(String cpfCliente, int idQuarto, String entrada, String saida) { 
        Reserva r = new Reserva(proximoId, cpfCliente, idQuarto, entrada, saida); // ALTERADO
        reservas.add(r);
        System.out.println("Reserva cadastrada com sucesso!");
        Log.registrar("Reserva cadastrada: ID " + r.getId());
        proximoId++;
        ArquivoUtil.salvarReservas(reservas);
    }

    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
        } else {
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }

    public Reserva buscarPorId(int id) {
        for (Reserva r : reservas) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public void editarReserva(int id, String novoCpf, int novoQuarto, String novaEntrada, String novaSaida) { 
        Reserva r = buscarPorId(id);
        if (r != null) {
            r.setCpfCliente(novoCpf); 
            r.setIdQuarto(novoQuarto);
            r.setDataEntrada(novaEntrada);
            r.setDataSaida(novaSaida);
            System.out.println("Reserva atualizada com sucesso!");
            Log.registrar("Reserva editada: ID " + r.getId());
            ArquivoUtil.salvarReservas(reservas);
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    public void excluirReserva(int id) {
        Reserva r = buscarPorId(id);
        if (r != null) {
            reservas.remove(r);
            System.out.println("Reserva excluída com sucesso!");
            Log.registrar("Reserva excluída: ID " + r.getId());
            ArquivoUtil.salvarReservas(reservas);
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }
}
