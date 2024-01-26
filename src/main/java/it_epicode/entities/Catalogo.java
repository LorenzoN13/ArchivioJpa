package it_epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rivista")
@NamedQuery(name = "getRicercaPerAnnoPubblicazione", query = "select r from Rivista r where r.annoPubblicazione = :anno")
@NamedQuery(name = "getRicercaPerAutore", query = "SELECT r FROM Rivista r WHERE r.autore = :autore")
@NamedQuery(name = "getRicercaPerTitolo", query = "SELECT r FROM Rivista r WHERE LOWER(r.titolo) LIKE LOWER(:titolo)")
@NamedQuery(name = "getRicercaElementiInPrestito", query = "SELECT p.elementoPrestato FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL")
public class Rivista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String ISBN;
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private LocalDate annoPubblicazione;
    private int numeropagine;

    public Rivista() {
    }


    public String getISBN() {
        return ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeropagine() {
        return numeropagine;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public void setNumeropagine(int numeropagine) {
        this.numeropagine = numeropagine;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "ISBN='" + ISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeropagine=" + numeropagine +
                ", periodicita=" + periodicita +
                '}';
    }
}
