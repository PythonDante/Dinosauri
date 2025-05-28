import java.util.Scanner;
import java.util.Vector;

/**
 * Classe principale per la gestione dei dinosauri.
 */
public class Main {
    public static void main(String[] args) {
        DinosauroDAO dinosauroDAO = new DinosauroDAOImpl();

        // Carica i dati all'avvio
        dinosauroDAO.caricaDinosauri();

        int scelta;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Aggiungi dinosauro");
            System.out.println("2. Cerca dinosauro per ID");
            System.out.println("3. Mostra tutti i dinosauri");
            System.out.println("4. Elimina dinosauro per ID");
            System.out.println("5. Salva su file");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            scelta = ChiediDati.ChiediIntero("");

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci ID dinosauro: ");
                    int id = ChiediDati.ChiediIntero("");
                    System.out.print("Inserisci nome dinosauro: ");
                    String nome = ChiediDati.ChiediStringa("");
                    Dinosauro d = new Dinosauro(id, nome);
                    dinosauroDAO.aggiungiDinosauro(d);
                    break;

                case 2:
                    System.out.print("Inserisci ID da cercare: ");
                    int idRicerca = ChiediDati.ChiediIntero("");
                    Dinosauro trovato = dinosauroDAO.findById(idRicerca);
                    if (trovato != null) {
                        System.out.println("Dinosauro trovato: " + trovato.getName());
                    } else {
                        System.out.println("Dinosauro non trovato.");
                    }
                    break;

                case 3:
                    Vector<Dinosauro> tutti = dinosauroDAO.getDinosauri();
                    if (tutti.isEmpty()) {
                        System.out.println("Nessun dinosauro presente.");
                    } else {
                        System.out.println("Lista di tutti i dinosauri:");
                        for (Dinosauro din : tutti) {
                            System.out.println("ID: " + din.getId() + ", Nome: " + din.getName());
                        }
                    }
                    break;

                case 4:
                    System.out.print("Inserisci ID da eliminare: ");
                    int idDel = ChiediDati.ChiediIntero("");
                    dinosauroDAO.delete(idDel);
                    break;

                case 5:
                    dinosauroDAO.save();
                    break;

                case 0:
                    dinosauroDAO.save(); // salvataggio automatico in uscita
                    System.out.println("Uscita dal programma.");
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
            }

        } while (scelta != 0);
    }
}
