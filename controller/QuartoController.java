package controller;

import model.Quarto; 
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import service.QuartoService;

public class QuartoController {
    private QuartoService quartoService = new QuartoService();
public void gerenciarQuartos(Scanner scanner) {
    int opcao = -1;
    do {
        System.out.println("\n-- Menu de Quartos --");
        System.out.println("1 - Listar Todos os Quartos");
        System.out.println("2 - Listar Quartos Disponíveis");
        System.out.println("3 - Ver Detalhes de um Quarto");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    try {
        opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
    switch (opcao) {
        case 1:
        listarTodosOsQuartos();
        break;
        case 2:
        listarQuartosDisponiveis();
        break;
        case 3:
        verDetalhesQuarto(scanner);
        break;
        case 0:
        System.out.println("Voltando ao menu principal...");
        break;
        default:
        System.out.println("Opção inválida. Tente novamente.");
                }
     } catch (InputMismatchException e) {
        System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
        scanner.nextLine();
        opcao = -1;
            }
    } while (opcao != 0);
     }
    private void listarTodosOsQuartos() {
        System.out.println("\n-- Lista de Todos os Quartos --");
        List<Quarto> quartos = quartoService.listarTodosOsQuartos();
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado no sistema.");
        } else {
            quartos.forEach(System.out::println); //Usa o método toString() do Quarto
        }
    }
    private void listarQuartosDisponiveis() {
        System.out.println("\n-- Quartos Disponíveis --");
        List<Quarto> quartosDisponiveis = quartoService.listarQuartosDisponiveis();
        if (quartosDisponiveis.isEmpty()) {
            System.out.println("Não há quartos disponíveis no momento.");
        } else {
            quartosDisponiveis.forEach(System.out::println);
        }
    }
    private void verDetalhesQuarto(Scanner scanner) {
        System.out.println("\n-- Detalhes do Quarto --");
        System.out.print("Digite o número do quarto que deseja ver: ");
    try {
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        Quarto quarto = quartoService.buscarQuartoPorNumero(numero);

        if (quarto == null) {
            System.out.println("Erro: Quarto com o número " + numero + " não encontrado.");
        } else {
            System.out.println("\nDetalhes do Quarto " + quarto.getNumero() + ":");
            System.out.println("Tipo: " + quarto.getTipo());
            System.out.println("Status: " + (quarto.isOcupado() ? "Ocupado" : "Disponível"));
            System.out.printf("Preço da Diária: R$ %.2f\n", quarto.getPrecoDiaria());
            System.out.println("Descrição: " + quarto.getDescricao());
        }
     } catch (InputMismatchException e) {
            System.out.println("Erro: Por favor, digite um número válido para o quarto.");
            scanner.nextLine(); // Limpa a entrada inválida
        }
    }
}
