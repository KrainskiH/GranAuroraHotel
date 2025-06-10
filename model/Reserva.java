package controller;

import model.Reserva;
import java.util.ArrayList;

public class ReservaController {
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private int proximoId = 1;

    public void cadastrarReserva(int idCliente, int idQuarto, String entrada, String saida) {
        Reserva r = new Reserva(proximoId, idCliente, idQuarto, entrada, saida);
        reservas.add(r);
        proximoId++;
        System.out.println("Reserva cadastrada com sucesso!");
    }

    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
        } else {
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }

    public Reserva buscarPorId(int id) {
        for (Reserva r : reservas) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public void editarReserva(int id, int novoCliente, int novoQuarto, String novaEntrada, String novaSaida) {
        Reserva r = buscarPorId(id);
        if (r != null) {
            r.setIdCliente(novoCliente);
            r.setIdQuarto(novoQuarto);
            r.setDataEntrada(novaEntrada);
            r.setDataSaida(novaSaida);
            System.out.println("Reserva atualizada com sucesso!");
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    public void excluirReserva(int id) {
        Reserva r = buscarPorId(id);
        if (r != null) {
            reservas.remove(r);
            System.out.println("Reserva excluída com sucesso!");
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }
}
