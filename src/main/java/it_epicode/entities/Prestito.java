package it_epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prestito")
@NamedQuery(name = "getRicercaPrestitiScaduti", query = "SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < :dataCorrente AND p.dataRestituzioneEffettiva IS NULL")
@NamedQuery(name = "getRicercaElementiInPrestito", query = "SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL")

public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_fk")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "rivistaprestito_fk")
    private RivistaInPrestito rivistaInPrestito;

    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;

    @Column(name = "data_restituzione_prevista")
    private LocalDate dataRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    public Prestito() {
    }

    public Prestito(Long id, Utente utente, RivistaInPrestito rivistaInPrestito, LocalDate dataInizioPrestito,
                    LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
        this.id = id;
        this.utente = utente;
        this.rivistaInPrestito = rivistaInPrestito;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public RivistaInPrestito getRivistaInPrestito() {
        return rivistaInPrestito;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setRivistaInPrestito(RivistaInPrestito rivistaInPrestito) {
        this.rivistaInPrestito = rivistaInPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", rivistaInPrestito=" + rivistaInPrestito +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
