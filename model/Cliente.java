package model;

public class Cliente {

    // Atributos privados para garantir o encapsulamento.
    private String nome;
    private String cpf;
    private String telefone;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        // Decide um valor padrão para o telefone, já que ele não foi informado.
        this.telefone = "Não informado"; 
    }

    // Métodos Getters e Setters para acessar e modificar os atributos de forma controlada.

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String toString() {
        return "Cliente | Nome: " + nome + ", CPF: " + cpf + ", Telefone: " + telefone;
    }
}