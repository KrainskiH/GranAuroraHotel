package model;

public class Reserva {
    private int id;
    private String cpfCliente;
    private int idQuarto;
    private String dataEntrada;
    private String dataSaida;

   public Reserva(int id, String cpfCliente, int idQuarto, String dataEntrada, String dataSaida) {
        this.id = id;
        this.cpfCliente = cpfCliente;
        this.idQuarto = idQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    @Override
   public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", cpfCliente='" + cpfCliente + '\'' +
                ", idQuarto=" + idQuarto +
                ", entrada='" + dataEntrada + '\'' +
                ", saída='" + dataSaida + '\'' +
                '}';
    }
}
