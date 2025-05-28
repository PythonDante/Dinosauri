import java.io.Serializable;

/**
 * Classe che rappresenta un Dinosauro con ID e nome.
 * <p>Supporta la serializzazione.</p>
 */
public class Dinosauro implements Serializable {
	private int id;
    private String name;

    public Dinosauro(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
