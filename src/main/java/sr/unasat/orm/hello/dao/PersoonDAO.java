package sr.unasat.orm.hello.dao;

import sr.unasat.orm.hello.entities.Persoon;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class PersoonDAO {
    private EntityManager entityManager;

    public PersoonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Persoon> retrievePersoonList() {
        entityManager.getTransaction().begin();
        String jpql = "select s from Persoon s";
        TypedQuery<Persoon> query = entityManager.createQuery(jpql, Persoon.class);
        List<Persoon> persoonList = query.getResultList();
        entityManager.getTransaction().commit();
        return persoonList;
    }

    public Persoon findByName(String name) {
        entityManager.getTransaction().begin();
        String jpql = "select s from Persoon s where s.naam = :name";
        //String jpql = "select s from Persoon s where s.naam = ?1";
        TypedQuery<Persoon> query = entityManager.createQuery(jpql, Persoon.class);
        Persoon persoon = query.setParameter("name", name).getSingleResult();
        //Persoon persoon = query.setParameter(1, name).getSingleResult();
        entityManager.getTransaction().commit();
        return persoon;
    }

    public Persoon insertPersoon(Persoon persoon) {
        entityManager.getTransaction().begin();
        entityManager.persist(persoon);
        entityManager.getTransaction().commit();
        return persoon;
    }

    public int updatePersoonAdres(Persoon persoon) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Persoon p SET p.adres = :adres where p.id = :id");
        query.setParameter("id", persoon.getId());
        query.setParameter("adres", persoon.getAdres());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int deletePersoonByName(String name) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Persoon p WHERE  p.naam = :name");
        query.setParameter("name", name);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

}
