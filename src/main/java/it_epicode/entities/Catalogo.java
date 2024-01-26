package it_epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "catalogo")
@NamedQuery(name = "getRicercaPerAnnoPubblicazione", query = "SELECT c FROM Catalogo c WHERE c.annoPubblicazione = :anno")
@NamedQuery(name = "getRicercaPerTitolo", query = "SELECT c FROM Catalogo c WHERE LOWER(c.titolo) LIKE LOWER(:titolo)")
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String ISBN;
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private LocalDate annoPubblicazione;
    private int numeropagine;

    public Catalogo() {
    }

    public Catalogo(int id, String ISBN, String titolo, LocalDate annoPubblicazione, int numeropagine) {
        this.id = id;
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeropagine = numeropagine;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Rivista{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeropagine=" + numeropagine +
                '}';
    }
}
