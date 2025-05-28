import java.io.*;
import java.util.Vector;

/**
 * Implementazione concreta di DinosauroDAO.
 */
public class DinosauroDAOImpl implements DinosauroDAO {

    private Vector<Dinosauro> dinosauri = new Vector<>();
    private final String FILE_NAME = "Dinosauri.dat";

    @Override
    public void aggiungiDinosauro(Dinosauro d) {
        dinosauri.add(d);
    }

    @Override
    public void save() {
        try {
            FileOutputStream f2 = new FileOutputStream(FILE_NAME);
            ObjectOutputStream fOUT = new ObjectOutputStream(f2);
            for(int i = 0; i < dinosauri.size();i++){
				fOUT.writeObject(dinosauri.elementAt(i));
			}
            fOUT.close();
            f2.close();
            System.out.println("Dinosauri salvati su file.");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio: " + e.getMessage());
        }
    }

    @Override
    public void caricaDinosauri() {
        try {
            FileInputStream f1 = new FileInputStream(FILE_NAME);
            ObjectInputStream fIN = new ObjectInputStream(f1);
			Dinosauro p;
			boolean uscita = false;
            while(!uscita){
				try{
					p = (Dinosauro) fIN.readObject();
					dinosauri.add(p);
				}catch(EOFException e){
					uscita = true;
				}
			}
            fIN.close();
            f1.close();
            System.out.println("Dinosauri caricati da file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore durante il caricamento: " + e.getMessage());
        }
    }

    @Override
    public Dinosauro findById(int id) {
        for (Dinosauro d : dinosauri) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (Dinosauro d : dinosauri) {
            if (d.getId() == id) {
                dinosauri.remove(d.getId());
            }
        }
        System.out.println("Dinosauro eliminato con ID: " + id);
    }

    @Override
    public Vector<Dinosauro> getDinosauri() {
        return dinosauri;
    }
}
