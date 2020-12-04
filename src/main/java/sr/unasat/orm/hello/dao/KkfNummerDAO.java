package sr.unasat.orm.hello.dao;

import sr.unasat.orm.hello.entities.KkfNummer;
import sr.unasat.orm.hello.entities.Onderneming;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class KkfNummerDAO {
    private EntityManager entityManager;

    public KkfNummerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<KkfNummer> retrieveKkfnummerList() {
        entityManager.getTransaction().begin();
        String jpql = "select k from KkfNummer k";
        TypedQuery<KkfNummer> query = entityManager.createQuery(jpql, KkfNummer.class);
        List<KkfNummer> kkfNummersList = query.getResultList();
        entityManager.getTransaction().commit();
        return kkfNummersList;
    }
    public KkfNummer findByNumber(Integer kkfnummer) {
        entityManager.getTransaction().begin();
        String jpql = "select k from KkfNummer k where k.kkfNummer = :kkfnummer";
        //String jpql = "select s from Onderneming s where s.naam = ?1";
        TypedQuery<KkfNummer> query = entityManager.createQuery(jpql, KkfNummer.class);
        KkfNummer kkfNummer = query.setParameter("kkfnummer", kkfnummer).getSingleResult();
        //Onderneming onderneming = query.setParameter(1, name).getSingleResult();
        entityManager.getTransaction().commit();
        return kkfNummer;
    }
    public KkfNummer insertKkfNummer(KkfNummer kkfNummer) {
        entityManager.getTransaction().begin();
        entityManager.persist(kkfNummer);
        entityManager.getTransaction().commit();
        return kkfNummer;
    }

//    public int updateOndernemingAdres(Onderneming onderneming) {
//        entityManager.getTransaction().begin();
//        Query query = entityManager.createQuery("UPDATE Onderneming p SET p.adres = :adres where p.id = :id");
//        query.setParameter("id", onderneming.getId());
//        query.setParameter("adres", onderneming.getAdres());
//        int rowsUpdated = query.executeUpdate();
//        System.out.println("entities Updated: " + rowsUpdated);
//        entityManager.getTransaction().commit();
//        return rowsUpdated;
//    }
//
//    public int deleteOndernemingByName(String name) {
//        entityManager.getTransaction().begin();
//        Query query = entityManager.createQuery("DELETE FROM Onderneming p WHERE  p.naam = :name");
//        query.setParameter("name", name);
//        int rowsDeleted = query.executeUpdate();
//        System.out.println("entities deleted: " + rowsDeleted);
//        entityManager.getTransaction().commit();
//        return rowsDeleted;
//    }

}
