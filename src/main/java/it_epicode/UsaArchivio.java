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
        Libro libro = new Libro();
        Utente utente = new Utente();

        //Aggiungi un utente
        utente.setNome("Giulio");
        utente.setCognome("Lefante");
        utente.setDataNascita(LocalDate.of(2000,04,23));
        utente.setNumeroTessera("363583585426");

        archivioDAO.salvaUtente(utente);

        // Aggiunta di un libro
        libro.setTitolo("giunto alla fine");
        libro.setISBN("3564-3562-6866");
        libro.setNumeropagine(50);
        libro.setAnnoPubblicazione(LocalDate.of(2020,12,13));
        libro.setAuthor("Lorenzo Nicchia");
        libro.setGenere(Genere.FANTASY);

        archivioDAO.aggiungiAllCatalogo(libro);


        // Aggiunta di una rivista
        rivista.setTitolo("Il Giornalino");
        rivista.setISBN("3436-6854-5855");
        rivista.setNumeropagine(20);
        rivista.setPeriodicita(Periodicita.SETTIMANALE);
        rivista.setAnnoPubblicazione(LocalDate.of(2000,01,23));

        archivioDAO.salvaRivista(rivista);


        // Ricerca per ISBN
        Catalogo libroTrovato = archivioDAO.ricercaPerISBN(3436-6534-5875);
        System.out.println("Libro trovato: " + libroTrovato);

        // Ricerca per autore
        List<Catalogo> libriPerAutore = archivioDAO.getRicercaPerAutore("Lorenzo Nicchia");
        System.out.println("Libri per autore: " + libriPerAutore);

        // Ricerca di tutti i prestiti scaduti e non ancora restituiti
        List<Catalogo> prestitiScaduti = archivioDAO.getRicercaElementiInPrestito("1734763457445632");
        System.out.println("Prestiti scaduti: " + prestitiScaduti);

        // Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
        List<Catalogo> elementiInPrestito = archivioDAO.getRicercaElementiInPrestito("1734763457445632");
        System.out.println("Elementi attualmente in prestito per utente " + utente.getNumeroTessera() + ":");
        for (Catalogo c : elementiInPrestito) {
            System.out.println(c.getTitolo());
        }
        System.out.println("L'elemento con l'ISBN" + libro.getISBN() + "è stato cancellato");
        archivioDAO.rimuoviElementoCatalogo(3436-6534-5875);
    }
}
