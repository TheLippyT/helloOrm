package sr.unasat.orm.hello.app;

import sr.unasat.orm.hello.config.JPAConfiguration;
import sr.unasat.orm.hello.dao.*;
import sr.unasat.orm.hello.entities.KkfNummer;
import sr.unasat.orm.hello.entities.Onderneming;
import sr.unasat.orm.hello.entities.Persoon;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        PersoonDAO persoonDAO = new PersoonDAO(JPAConfiguration.getEntityManager());
        OndernemingDAO ondernemingDAO = new OndernemingDAO(JPAConfiguration.getEntityManager());
        KkfNummerDAO kkfnummerDAO = new KkfNummerDAO(JPAConfiguration.getEntityManager());
        CharityDAO charityDAO = new CharityDAO((JPAConfiguration.getEntityManager()));
        CelebrityDAO celebrityDAO = new CelebrityDAO(JPAConfiguration.getEntityManager());
        //INSERTS
        Persoon p1 = new Persoon(null, "Micheal Jordan", "Tibitistraat 47", LocalDate.of(1985, 1, 1));
        persoonDAO.insertPersoon(p1);
        Persoon p2 = new Persoon(null, "John Wayne", "Slabladstraat 58", LocalDate.of(1985, 1, 1));
        persoonDAO.insertPersoon(p2);
        Persoon p3 = new Persoon(null, "John Wick", "Titoniastraat 95", LocalDate.of(1985, 1, 1));
        persoonDAO.insertPersoon(p3);
        KkfNummer kkfNummer = new KkfNummer(null, (long) 12345);
        kkfnummerDAO.insertKkfNummer(kkfNummer);

        //SELECT ALL
        List<Persoon> persoonList = persoonDAO.retrievePersoonList();
        persoonList.stream().forEach(System.out::println);
        List<KkfNummer> kkfnummerList = kkfnummerDAO.retrieveKkfnummerList();
        kkfnummerList.stream().forEach(System.out::println);

        //SELECT ONE
        Persoon foundPersoon = persoonDAO.findByName("Micheal Jordan");

        //UPDATE ONE
        foundPersoon.setAdres("UCLA Avenue");
        persoonDAO.updatePersoonAdres(foundPersoon);
        Persoon persoon = persoonDAO.findByName("Micheal Jordan");
        System.out.println(persoon);

        //DELETE ONE
        persoonDAO.deletePersoonByName("Micheal Jordan");
        persoonDAO.deletePersoonByName("John Wayne");
        persoonDAO.deletePersoonByName("John Wick");

        Onderneming onderneming = new Onderneming(null, "Kwie Kwie n.v.", "Kwie Kwie straat", LocalDate.of(2020, 03, 15), (long) 43, foundPersoon);
        ondernemingDAO.insertOnderneming(onderneming);
        KkfNummer kkfNummer2 = new KkfNummer((long) 2, (long) 144541);
        kkfnummerDAO.insertKkfNummer(kkfNummer2);


        Onderneming foundOnderneming = ondernemingDAO.findByName("Kwie Kwie n.v.");
        System.out.println(foundOnderneming);
        System.out.println(foundOnderneming.getEigenaar());


        ondernemingDAO.deleteOndernemingByName("Kwie Kwie n.v.");
        persoonDAO.deletePersoonByName("Micheal Jordan");

        JPAConfiguration.shutdown();
    }
}
