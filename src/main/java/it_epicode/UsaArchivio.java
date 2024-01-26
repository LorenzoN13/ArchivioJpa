package it_epicode;

import it_epicode.dao.ArchivioDAO;
import it_epicode.entities.*;

import java.time.LocalDate;
import java.util.List;

public class UsaArchivio {
    public static void main(String[] args) {
        ArchivioDAO archivioDAO = new ArchivioDAO();
        Catalogo catalogo = new Catalogo();
        Rivista rivista = new Rivista();
        Libro libro =new Libro();
        Utente utente = new Utente();

        //Aggiungi un utente
        utente.setNome("Andrea");
        utente.setCognome("Rossi");
        utente.setDataNascita(LocalDate.of(2000,06,23));
        utente.setNumeroTessera("363456545561");

        archivioDAO.salvaUtente(utente);

        // Aggiunta di un libro
        libro.setTitolo("Titolo della rivista");
        libro.setISBN("9876-5432-1432");
        libro.setNumeropagine(50);
        libro.setAnnoPubblicazione(LocalDate.of(2000,02,13));
        libro.setAuthor("Lorenzo Nicchia");
        libro.setGenere(Genere.FANTASCENZA);

        archivioDAO.aggiungiAllCatalogo(libro);


        // Aggiunta di una rivista
        rivista.setTitolo("La rivista");
        rivista.setISBN("3455-6364-5343");
        rivista.setNumeropagine(20);
        rivista.setPeriodicita(Periodicita.SETTIMANALE);
        rivista.setAnnoPubblicazione(LocalDate.of(2024,01,23));

        archivioDAO.salvaRivista(rivista);


        // Ricerca per ISBN
        Catalogo libroTrovato = archivioDAO.ricercaPerISBN("3455-6364-5343");
        System.out.println("Libro trovato: " + libroTrovato);

        // Ricerca per autore
        List<Catalogo> libriPerAutore = archivioDAO.getRicercaPerAutore("Lorenzo Nicchia");
        System.out.println("Libri per autore: " + libriPerAutore);

        // Ricerca di tutti i prestiti scaduti e non ancora restituiti
        List<Catalogo> prestitiScaduti = archivioDAO.getRicercaElementiInPrestito("2267345664344");
        System.out.println("Prestiti scaduti: " + prestitiScaduti);

        // Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
        List<Catalogo> elementiInPrestito = archivioDAO.getRicercaElementiInPrestito("64465764464634");
        System.out.println("Elementi attualmente in prestito per utente" + utente.getNumeroTessera() + ":");
        for (Catalogo c : elementiInPrestito) {
            System.out.println(c.getTitolo());
        }
    }
}
