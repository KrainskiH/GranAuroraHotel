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
    if (cpf == null) return null;
    cpf = cpf.trim();
    for (Cliente cliente : listaDeClientes) {
        if (cliente.getCpf() != null && cliente.getCpf().trim().equalsIgnoreCase(cpf)) {
            return cliente;
        }
    }
    return null;
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