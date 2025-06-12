package model;

public abstract class Quarto {

    protected int numero;
    protected boolean ocupado = false;

    public Quarto(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        this.ocupado = true;
    }

    public void desocupar() {
        this.ocupado = false;
    }

    public abstract String getTipo();
    public abstract String getDescricao();
    public abstract double getPrecoDiaria();

@Override
public String toString() {
    return String.format(
        "%s - Número: %d | Status: %s | R$ %.2f | %s",
        getTipo(),
        numero,
        ocupado ? "Ocupado" : "Disponível",
        getPrecoDiaria(),
        getDescricao()
    );
   }
}
