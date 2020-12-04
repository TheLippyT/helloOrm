package sr.unasat.orm.hello.entities;

import javax.persistence.*;

@Entity
public class KkfNummer {
    //when do you use serialVersionID?

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column
    private Long kkfNummer;



    public KkfNummer(Long id, Long kkfNummer) {
        Id = id;
        this.kkfNummer = kkfNummer;
    }

    public KkfNummer() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getKkfNummer() {
        return kkfNummer;
    }

    public void setKkfNummer(Long kkfNummer) {
        this.kkfNummer = kkfNummer;
    }



    @Override
    public String toString() {
        return "KkfNummer{" +
                "Id=" + Id +
                ", kkfNummer=" + kkfNummer +
                '}';
    }
}
