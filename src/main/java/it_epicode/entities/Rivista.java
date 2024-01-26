package it_epicode.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "rivista")
public class Rivista extends Catalogo{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista(){

    }
    public Rivista(int id, String ISBN, String titolo, LocalDate annoPubblicazione, int numeropagine, Periodicita periodicita) {
        super(id, ISBN, titolo, annoPubblicazione, numeropagine);
        this.periodicita = periodicita;
    }
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                '}';
    }
}
