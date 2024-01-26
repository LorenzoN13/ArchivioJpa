package it_epicode.entities;

import javax.persistence.*;

@Entity
@Table(name = "rivista_prestito")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RivistaInPrestito {
    @Id
    private String ISBN;
    private String titolo;

    public RivistaInPrestito() {
    }

    public RivistaInPrestito(String ISBN, String titolo) {
        this.ISBN = ISBN;
        this.titolo = titolo;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "RivistaInPrestito{" +
                "ISBN='" + ISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                '}';
    }
}
