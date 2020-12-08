package sr.unasat.orm.hello.dao;

import sr.unasat.orm.hello.entities.Celebrity;
import sr.unasat.orm.hello.entities.Persoon;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CelebrityDAO {
    private EntityManager entityManager;

    public CelebrityDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //Retrieve
    public List<Celebrity> retrieveCelebrityList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Celebrity c";
        TypedQuery<Celebrity> query = entityManager.createQuery(jpql, Celebrity.class);
        List<Celebrity> celebrityList = query.getResultList();
        entityManager.getTransaction().commit();
        return retrieveCelebrityList();
    }
    //find
    public Celebrity findByName(String celebrityName) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Celebrity c where c.celebrityName = :celebrityname";
        //String jpql = "select s from Persoon s where s.naam = ?1";
        TypedQuery<Celebrity> query = entityManager.createQuery(jpql, Celebrity.class);
        Celebrity celebrity = query.setParameter("celebrityname", celebrityName).getSingleResult();
        //Persoon persoon = query.setParameter(1, name).getSingleResult();
        entityManager.getTransaction().commit();
        return celebrity;
    }
    //insert
    public Celebrity insertCelebrity(Celebrity celebrity) {
        entityManager.getTransaction().begin();
        entityManager.persist(celebrity);
        entityManager.getTransaction().commit();
        return celebrity;
    }
    //update
    public int updatePseudonym(Celebrity celebrity) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Celebrity c SET c.pseydonym = :pseudonym where c.id = :id");
        query.setParameter("id", celebrity.getId());
        query.setParameter("pseudonym", celebrity.getPseydonym());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }
    //delete
    public int deleteCelebrityByName(String name) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Persoon p WHERE  p.naam = :name");
        query.setParameter("name", name);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

}
