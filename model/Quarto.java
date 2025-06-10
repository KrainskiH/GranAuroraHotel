package model;

public abstract class Quarto {
    
    protected int numero; // 'protected' significa que as classes filhas podem acessar esta variável

    /**
     * Construtor que toda classe filha precisará chamar.
     * @param numero O número de identificação do quarto.
     */
    public Quarto(int numero) {
        this.numero = numero;
    }

    /**
     * Retorna o número do quarto.
     */
    public int getNumero() {
        return numero;
    }

    // MÉTODOS ABSTRATOS
    // Toda classe que herdar de Quarto SERÁ OBRIGADA a implementar estes métodos.

    /**
     * Retorna o tipo do quarto (ex: "Luxo", "Simples").
     */
    public abstract String getTipo();

    /**
     * Retorna a descrição detalhada do quarto.
     */
    public abstract String getDescricao();

    /**
     * Retorna o preço da diária do quarto.
     */
    public abstract double getPrecoDiaria();
}
