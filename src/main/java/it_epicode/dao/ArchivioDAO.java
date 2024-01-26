package it_epicode.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it_epicode.entities.Prestito;
import it_epicode.entities.Catalogo;
import it_epicode.entities.Rivista;
import it_epicode.entities.Utente;

import javax.persistence.*;
import javax.transaction.Transactional;

public class ArchivioDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ArchivioDAO(){
        emf = Persistence.createEntityManagerFactory("archvioJpa");
        em = emf.createEntityManager();
    }
    public void aggiungiAllCatalogo(Catalogo catalogo){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(catalogo);
        et.commit();
    }

    public void salvaUtente(Utente u){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(u);

        et.commit();
    }

    public void salvaRivista(Rivista r){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(r);

        et.commit();
    }

    public void rimuoviElementoCatalogo(int ISBN){
        EntityTransaction et = em.getTransaction();
        et.begin();

        Catalogo catalogo = em.find(Catalogo.class,ISBN);
        if(catalogo != null){
           em.remove(catalogo);
        }
        et.commit();
    }

    public Catalogo ricercaPerISBN(int ISBN) {
        return em.find(Catalogo.class, ISBN);
    }

    public Catalogo ricercaPerNumeroTessara(int numeroTessera){
        return em.find(Catalogo.class,numeroTessera);
    }

    public List<Catalogo> getRicercaPerAnnoPubblicazione(Catalogo anno) {
        Query query = em.createNamedQuery("getRicercaPerAnnoPubblicazione");
        query.setParameter("anno", anno);
        return query.getResultList();
    }
    public List<Catalogo> getRicercaPerAutore(String autore) {
        Query query = em.createNamedQuery("getRicercaPerAutore");
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<Catalogo> getRicercaPerTitolo(String titolo) {
        Query query = em.createNamedQuery("getRicercaPerTitolo");
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }

    public List<Catalogo> getRicercaElementiInPrestito(String numeroTessera) {
        Query query = em.createNamedQuery("getRicercaElementiInPrestito");
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    public List<Prestito> getRicercaPrestitiScaduti() {
        Query query = em.createNamedQuery("getRicercaPrestitiScaduti");
        query.setParameter("dataCorrente", new Date());
        return query.getResultList();
    }

    public void close(){
        em.close();
        emf.close();
    }
}
