package utils;

import model.Reserva;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArquivoUtil {

    private static final String ARQUIVO_RESERVAS = "reservas.txt";

    public static void salvarReservas(List<Reserva> reservas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_RESERVAS))) {
            for (Reserva r : reservas) {
                writer.write(r.getId() + ";" + r.getCpfCliente() + ";" + r.getIdQuarto() + ";" + 
                             r.getDataEntrada() + ";" + r.getDataSaida());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar reservas: " + e.getMessage());
        }
    }
}
