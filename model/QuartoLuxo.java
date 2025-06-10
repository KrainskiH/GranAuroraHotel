package model;

public class QuartoLuxo extends Quarto {
   private static final double PRECO_DIARIA = 450.00;
public QuartoLuxo(int numero) {
    super(numero);
    }
    @Override
    public String getTipo() {
        return "Luxo";
    }
    @Override
    public String getDescricao() {
        return "Suíte de luxo com cama king-size, ar-condicionado, TV 50\, frigobar, mobilia sofisticada e elegante, um banheiro exclusivo e refinado com banheira de hidromassagem.";
    }
    @Override
    public double getPrecoDiaria() {
        return PRECO_DIARIA;
    }
}
