package sr.unasat.orm.hello.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Persoon {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(length = 50, unique = true)
    private String naam;
    private String adres;
    private LocalDate geboortedatum;

    public Persoon(Long id, String naam, String adres, LocalDate geboortedatum) {
        this.id = id;
        this.naam = naam;
        this.adres = adres;
        this.geboortedatum = geboortedatum;
    }

    public Persoon() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }


    @Override
    public String toString() {
        return "Persoon{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", adres='" + adres + '\'' +
                ", geboortedatum=" + geboortedatum +
                '}';
    }
}
