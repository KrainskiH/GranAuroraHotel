package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Quarto; 
import model.QuartoLuxo;
import model.QuartoSimples;
import model.QuartoStandard;

public class QuartoService {
    private List<Quarto> quartos = new ArrayList<>();

    public void atualizarQuarto(Quarto quartoAtualizado) {
    for (int i = 0; i < quartos.size(); i++) {
        if (quartos.get(i).getNumero() == quartoAtualizado.getNumero()) {
            quartos.set(i, quartoAtualizado);
            return;
        }
    }
}

public QuartoService() {
    quartos.add(new QuartoSimples(101));
    quartos.add(new QuartoSimples(102));
    quartos.add(new QuartoStandard(201));
    quartos.add(new QuartoStandard(202));
    quartos.add(new QuartoLuxo(301));
    }
public List<Quarto> listarTodosOsQuartos() {
    return quartos;
    }
public List<Quarto> listarQuartosDisponiveis() {
    return quartos.stream()
        .filter(q -> !q.isOcupado())
        .collect(Collectors.toList());
    }

public Quarto buscarQuartoPorNumero(int numero) {
    for (Quarto quarto : quartos) {
    if (quarto.getNumero() == numero) {
    return quarto;
            }
        }
        
    return null; // Retorna null se não encontrar
    }
}
