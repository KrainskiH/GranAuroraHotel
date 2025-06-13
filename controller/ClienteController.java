package controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import model.Cliente;
import service.ClienteService;

public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void gerenciarClientes(Scanner scanner) {
        int opcao = -1;

        do {
            System.out.println("\n--- Menu de Clientes ---");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Remover Cliente");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarCliente(scanner);
                        break;
                    case 2:
                        listarClientes();
                        break;
                    case 3:
                        atualizarCliente(scanner);
                        break;
                    case 4:
                        removerCliente(scanner);
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

    private void cadastrarCliente(Scanner scanner) {
        System.out.println("\n--- Cadastro de Novo Cliente ---");

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        String cpf = lerInputNumericoValidado(scanner, "Digite o CPF (11 dígitos, somente números): ", 11);

        if (clienteService.buscarPorCpf(cpf) != null) {
            System.out.println("Erro: Já existe um cliente cadastrado com este CPF.");
            return;
        }

        String telefone = lerInputNumericoValidado(scanner, "Digite o telefone (11 dígitos com DDD, somente números): ", 11);

        Cliente novoCliente = new Cliente(nome, cpf, telefone);
        clienteService.salvar(novoCliente);

        System.out.println("Cliente '" + nome + "' cadastrado com sucesso!");
    }

    private void listarClientes() {
        System.out.println("\n--- Lista de Clientes Cadastrados ---");
        List<Cliente> clientes = clienteService.listarTodos();

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado no momento.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    private void atualizarCliente(Scanner scanner) {
        System.out.println("\n--- Atualização de Cliente ---");
        String cpf = lerInputNumericoValidado(scanner, "Digite o CPF do cliente que deseja atualizar (11 dígitos): ", 11);

        Cliente clienteExistente = clienteService.buscarPorCpf(cpf);

        if (clienteExistente == null) {
            System.out.println("Erro: Cliente com CPF " + cpf + " não encontrado.");
            return;
        }

        System.out.println("Dados atuais: " + clienteExistente);

        System.out.print("Digite o novo nome do cliente: ");
        String novoNome = scanner.nextLine();

        String novoTelefone = lerInputNumericoValidado(scanner, "Digite o novo telefone (11 dígitos com DDD): ", 11);

        boolean atualizou = clienteService.atualizar(cpf, novoNome, novoTelefone);

        if (atualizou) {
            System.out.println("Cliente atualizado com sucesso!");
        }
    }

    private void removerCliente(Scanner scanner) {
        System.out.println("\n--- Remoção de Cliente ---");
        String cpf = lerInputNumericoValidado(scanner, "Digite o CPF do cliente que deseja remover (11 dígitos): ", 11);

        boolean removeu = clienteService.removerPorCpf(cpf);

        if (removeu) {
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Erro: Cliente com CPF " + cpf + " não encontrado.");
        }
    }

    private String lerInputNumericoValidado(Scanner scanner, String prompt, int tamanhoExato) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();

            if (input.length() != tamanhoExato) {
                System.out.println("Erro: A entrada deve ter exatamente " + tamanhoExato + " dígitos. Tente novamente.");
                continue;
            }
            if (!input.matches("\\d+")) {
                System.out.println("Erro: A entrada deve conter apenas números. Tente novamente.");
                continue;
            }
            break;
        }
        return input;
    }
}