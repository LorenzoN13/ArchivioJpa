package it_epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String cognome;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;
    @Column(name = "card_number", unique = true)
    private String numeroTessera;

    public Utente() {
    }

    public Utente(int id, String nome, String cognome, LocalDate dataNascita, String numeroTessera) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroTessera = numeroTessera;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public String getNumeroTessera() {
        return numeroTessera;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setNumeroTessera(String numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", numeroTessera='" + numeroTessera + '\'' +
                '}';
    }
}
