package model;

public class QuartoSimples extends Quarto {
  private static final double PRECO_DIARIA = 120.00;
public QuartoSimples(int numero) {
  super(numero); // Chama o construtor da classe mãe (Quarto)
    }
    @Override
    public String getTipo() {
        return "Simples";
    }
    @Override
    public String getDescricao() {
        return "Quarto simples com uma cama de solteiro, ventilador, mobilia básica e banheiro compartilhado no corredor.";
    }
    @Override
    public double getPrecoDiaria() {
        return PRECO_DIARIA;
    }
}
