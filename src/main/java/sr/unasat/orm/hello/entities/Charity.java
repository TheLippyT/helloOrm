package sr.unasat.orm.hello.entities;

import org.hibernate.mapping.Set;

import javax.persistence.*;

@Entity
public class Charity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column
    private String charityName;
    @ManyToMany(mappedBy = "charity")
    Celebrity celebrity;

    public Charity() {
    }

    public Charity(Long id, String charityName, Celebrity celebrity) {
        this.id = id;
        this.charityName = charityName;
        this.celebrity = celebrity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
    }

    @Override
    public String toString() {
        return "Charity{" +
                "id=" + id +
                ", charityName='" + charityName + '\'' +
                ", celebrity=" + celebrity +
                '}';
    }
}
