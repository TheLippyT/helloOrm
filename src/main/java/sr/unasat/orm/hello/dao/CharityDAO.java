package sr.unasat.orm.hello.dao;

import sr.unasat.orm.hello.entities.Charity;
import sr.unasat.orm.hello.entities.Persoon;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CharityDAO {
    private EntityManager entityManager;

    public CharityDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //Retrieve
    public List<Persoon> retrieveCharityList() {
        entityManager.getTransaction().begin();
        String jpql = "select s from Persoon s";
        TypedQuery<Persoon> query = entityManager.createQuery(jpql, Persoon.class);
        List<Persoon> persoonList = query.getResultList();
        entityManager.getTransaction().commit();
        return persoonList;
    }
    //find
    public Charity findByName(String charityName) {
        entityManager.getTransaction().begin();
        String jpql = "select ch from Charity ch where ch.charityName = :charityname";
        //String jpql = "select s from Persoon s where s.naam = ?1";
        TypedQuery<Charity> query = entityManager.createQuery(jpql, Charity.class);
        Charity charity = query.setParameter("charityname", charityName).getSingleResult();
        //Persoon persoon = query.setParameter(1, name).getSingleResult();
        entityManager.getTransaction().commit();
        return charity;
    }
    //insert
    public Charity insertCharity(Charity charity) {
        entityManager.getTransaction().begin();
        entityManager.persist(charity);
        entityManager.getTransaction().commit();
        return charity;
    }
    //update
    public int updateCharityGoal(Charity charity) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Charity ch SET ch.charityGoal = :charitygoal where ch.id = :id");
        query.setParameter("id", charity.getId());
        query.setParameter("charitygoal", charity.getCharityGoal());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }
    //delete
    public int deleteCharityByName(String charityname) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Charity ch WHERE  ch.charityName = :charityname");
        query.setParameter("charityname", charityname);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

}
