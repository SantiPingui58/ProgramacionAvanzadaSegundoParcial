package core.dao;

import java.util.List;

import core.models.Detergente;

public interface DetergenteDAO extends ProductoDAO {
    void guardarDetergente(Detergente detergente);
    void eliminarDetergente(int id);
    Detergente buscarDetergentePorId(int id);
    List<Detergente> listarTodosLosDetergentes();
}
