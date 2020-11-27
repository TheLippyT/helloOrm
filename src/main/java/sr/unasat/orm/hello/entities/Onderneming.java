package sr.unasat.orm.hello.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Onderneming {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(length = 50, unique = true)
    private String naam;
    private String adres;
    private LocalDate oprichtingsdatum;
    private String kkfnummer;
    @ManyToOne
    @JoinColumn(name = "persoon_id", nullable = false)
    Persoon eigenaar;

    public Onderneming() {
    }

    public Onderneming(Long id, String naam, String adres, LocalDate oprichtingsdatum, String kkfnummer, Persoon eigenaar) {
        this.id = id;
        this.naam = naam;
        this.adres = adres;
        this.oprichtingsdatum = oprichtingsdatum;
        this.kkfnummer = kkfnummer;
        this.eigenaar = eigenaar;
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getAdres() {
        return adres;
    }

    public LocalDate getOprichtingsdatum() {
        return oprichtingsdatum;
    }

    public String getKkfnummer() {
        return kkfnummer;
    }

    public Persoon getEigenaar() {
        return eigenaar;
    }

    @Override
    public String toString() {
        return "Onderneming{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", adres='" + adres + '\'' +
                ", oprichtingsdatum=" + oprichtingsdatum +
                ", kkfnummer='" + kkfnummer + '\'' +
                '}';
    }
}
