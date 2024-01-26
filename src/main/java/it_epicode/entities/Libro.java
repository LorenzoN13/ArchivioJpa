package it_epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "libro")
@NamedQuery(name = "getRicercaPerAutore", query = "SELECT l FROM Libro l WHERE l.autore = :autore")
public class Libro extends Catalogo{
    private String autore;
    @Enumerated(EnumType.STRING)
    private Genere genere;

    public Libro(){

    }
    public Libro(int id, String ISBN, String titolo, LocalDate annoPubblicazione, int numeropagine, String autore, Genere genere) {
        super(id, ISBN, titolo, annoPubblicazione, numeropagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setAuthor(String author) {
        this.autore = autore;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "author='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
