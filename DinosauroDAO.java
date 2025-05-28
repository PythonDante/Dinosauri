import java.util.Vector;

/**
 * Interfaccia DAO per la gestione dei dinosauri.
 */
public interface DinosauroDAO {

    void save();

    void aggiungiDinosauro(Dinosauro d);

    Dinosauro findById(int id);

    void delete(int id);

    Vector<Dinosauro> getDinosauri();

    void caricaDinosauri();
}
