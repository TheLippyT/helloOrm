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

    @ManyToOne
    @JoinColumn(name = "persoon_id", nullable = false)
    Persoon eigenaar;
    @OneToOne
    @JoinColumn(name = "kkf_id", nullable = false)
    KkfNummer kkfNummer;

    public Onderneming() {
    }

    public Onderneming(Long id, String naam, String adres, LocalDate oprichtingsdatum, String kkfnummer, Persoon eigenaar) {
        this.id = id;
        this.naam = naam;
        this.adres = adres;
        this.oprichtingsdatum = oprichtingsdatum;
//        this.kkfnummer = kkfnummer;
        this.eigenaar = eigenaar;
    }

    public Onderneming(Long id, String naam, String kwie_kwie_straat, LocalDate of, Long i, Persoon foundPersoon) {
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



    public KkfNummer getKkfNummer() {
        return kkfNummer;
    }

    public void setKkfNummer(KkfNummer kkfNummer) {
        this.kkfNummer = kkfNummer;
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
                ", kkfnummer='" + kkfNummer + '\'' +
                '}';
    }
}
