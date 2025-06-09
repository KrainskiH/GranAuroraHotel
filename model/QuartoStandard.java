package model;

public class QuartoStandard extends Quarto {

    private static final double PRECO_DIARIA = 200.50;

    public QuartoStandard(int numero) {
        super(numero);
    }

    @Override
    public String getTipo() {
        return "Standard";
    }

    @Override
    public String getDescricao() {
        return "Quarto standard com uma cama de casal, ar-condicionado, TV e banheiro privativo.";
    }

    @Override
    public double getPrecoDiaria() {
        return PRECO_DIARIA;
    }
}