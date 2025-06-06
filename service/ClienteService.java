package service;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteService {

    private List<Cliente> listaDeClientes = new ArrayList<>();

    public void salvar(Cliente cliente) {
        listaDeClientes.add(cliente);
    }

    public List<Cliente> listarTodos() {
        return listaDeClientes;
    }
     public Cliente buscarPorCpf(String cpf) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente; // Retorna o cliente encontrado
            }
        }
        return null; // Retorna null se o loop terminar sem encontrar
    }

    public boolean atualizar(String cpf, String novoNome, String novoTelefone) {
        Cliente clienteParaAtualizar = buscarPorCpf(cpf);

        if (clienteParaAtualizar != null) {
            // Se encontrou o cliente, atualiza seus dados
            clienteParaAtualizar.setNome(novoNome);
            clienteParaAtualizar.setTelefone(novoTelefone);
            return true; // Sucesso
        }
        
        return false; // Cliente não encontrado
    }

 
    public boolean removerPorCpf(String cpf) {
        return listaDeClientes.removeIf(cliente -> cliente.getCpf().equals(cpf));
    }
}