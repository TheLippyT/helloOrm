package sr.unasat.orm.hello.dao;

import sr.unasat.orm.hello.entities.Onderneming;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class OndernemingDAO {

    private EntityManager entityManager;

    public OndernemingDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Onderneming> retrieveOndernemingList() {
        entityManager.getTransaction().begin();
        String jpql = "select s from Onderneming s";
        TypedQuery<Onderneming> query = entityManager.createQuery(jpql, Onderneming.class);
        List<Onderneming> ondernemingList = query.getResultList();
        entityManager.getTransaction().commit();
        return ondernemingList;
    }

    public Onderneming findByName(String name) {
        entityManager.getTransaction().begin();
        String jpql = "select s from Onderneming s where s.naam = :name";
        //String jpql = "select s from Onderneming s where s.naam = ?1";
        TypedQuery<Onderneming> query = entityManager.createQuery(jpql, Onderneming.class);
        Onderneming onderneming = query.setParameter("name", name).getSingleResult();
        //Onderneming onderneming = query.setParameter(1, name).getSingleResult();
        entityManager.getTransaction().commit();
        return onderneming;
    }

    public Onderneming insertOnderneming(Onderneming onderneming) {
        entityManager.getTransaction().begin();
        entityManager.persist(onderneming);
        entityManager.getTransaction().commit();
        return onderneming;
    }

    public int updateOndernemingAdres(Onderneming onderneming) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Onderneming p SET p.adres = :adres where p.id = :id");
        query.setParameter("id", onderneming.getId());
        query.setParameter("adres", onderneming.getAdres());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int deleteOndernemingByName(String name) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Onderneming p WHERE  p.naam = :name");
        query.setParameter("name", name);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
}
