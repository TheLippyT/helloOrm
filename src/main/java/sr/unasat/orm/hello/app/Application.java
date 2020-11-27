package sr.unasat.orm.hello.app;

import sr.unasat.orm.hello.config.JPAConfiguration;
import sr.unasat.orm.hello.dao.OndernemingDAO;
import sr.unasat.orm.hello.dao.PersoonDAO;
import sr.unasat.orm.hello.entities.Onderneming;
import sr.unasat.orm.hello.entities.Persoon;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        PersoonDAO persoonDAO = new PersoonDAO(JPAConfiguration.getEntityManager());
        OndernemingDAO ondernemingDAO = new OndernemingDAO(JPAConfiguration.getEntityManager());
        //INSERTS
        Persoon p1 = new Persoon(null, "Micheal Jordan", "Tibitistraat 47", LocalDate.of(1985, 1, 1));
        persoonDAO.insertPersoon(p1);
        Persoon p2 = new Persoon(null, "John Wayne", "Slabladstraat 58", LocalDate.of(1985, 1, 1));
        persoonDAO.insertPersoon(p2);
        Persoon p3 = new Persoon(null, "John Wick", "Titoniastraat 95", LocalDate.of(1985, 1, 1));
        persoonDAO.insertPersoon(p3);

        //SELECT ALL
        List<Persoon> persoonList = persoonDAO.retrievePersoonList();
        persoonList.stream().forEach(System.out::println);

        //SELECT ONE
        Persoon foundPersoon = persoonDAO.findByName("Micheal Jordan");

        //UPDATE ONE
        foundPersoon.setAdres("UCLA Avenue");
        persoonDAO.updatePersoonAdres(foundPersoon);
        Persoon persoon = persoonDAO.findByName("Micheal Jordan");
        System.out.println(persoon);

        //DELETE ONE
        //persoonDAO.deletePersoonByName("Micheal Jordan");
        persoonDAO.deletePersoonByName("John Wayne");
        persoonDAO.deletePersoonByName("John Wick");

        Onderneming onderneming = new Onderneming(null, "Kwie Kwie n.v.", "Kwie Kwie straat", LocalDate.of(2020, 03, 15), "KKF00234", foundPersoon);
        ondernemingDAO.insertOnderneming(onderneming);
        Onderneming foundOnderneming = ondernemingDAO.findByName("Kwie Kwie n.v.");
        System.out.println(foundOnderneming);
        System.out.println(foundOnderneming.getEigenaar());


        ondernemingDAO.deleteOndernemingByName("Kwie Kwie n.v.");
        persoonDAO.deletePersoonByName("Micheal Jordan");

        JPAConfiguration.shutdown();
    }
}
