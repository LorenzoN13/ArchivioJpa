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
        utente.setNumeroTessera("343574256251");

        archivioDAO.salvaUtente(utente);

        // Aggiunta di un libro
        libro.setTitolo("Titolo rivista");
        libro.setISBN("7355-5422-2452");
        libro.setNumeropagine(50);
        libro.setAnnoPubblicazione(LocalDate.of(2000,12,13));
        libro.setAuthor("Lorenzo Nicchia");
        libro.setGenere(Genere.FANTASCENZA);

        archivioDAO.aggiungiAllCatalogo(libro);


        // Aggiunta di una rivista
        rivista.setTitolo("Il Giornalino");
        rivista.setISBN("3456-6834-5463");
        rivista.setNumeropagine(20);
        rivista.setPeriodicita(Periodicita.SETTIMANALE);
        rivista.setAnnoPubblicazione(LocalDate.of(2020,01,23));

        archivioDAO.salvaRivista(rivista);


        // Ricerca per ISBN
        Catalogo libroTrovato = archivioDAO.ricercaPerISBN(3455-6364-5343);
        System.out.println("Libro trovato: " + libroTrovato);

        // Ricerca per autore
        List<Catalogo> libriPerAutore = archivioDAO.getRicercaPerAutore("Lorenzo Nicchia");
        System.out.println("Libri per autore: " + libriPerAutore);

        // Ricerca di tutti i prestiti scaduti e non ancora restituiti
        List<Catalogo> prestitiScaduti = archivioDAO.getRicercaElementiInPrestito("124563424356");
        System.out.println("Prestiti scaduti: " + prestitiScaduti);

        // Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
        List<Catalogo> elementiInPrestito = archivioDAO.getRicercaElementiInPrestito("2835473467732");
        System.out.println("Elementi attualmente in prestito per utente" + utente.getNumeroTessera() + ":");
        for (Catalogo c : elementiInPrestito) {
            System.out.println(c.getTitolo());
        }
    }
}
