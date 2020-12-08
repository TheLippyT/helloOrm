package sr.unasat.orm.hello.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Celebrity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column
    private String celebrityName;
    private String pseydonym;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "celebrity_charity", joinColumns ={@JoinColumn(referencedColumnName = "id")}
    , inverseJoinColumns ={@JoinColumn(referencedColumnName = "id")})
    Charity charity;

    public Celebrity(Long id, String celebrity, Charity charity) {
        this.id = id;
        this.celebrityName = celebrity;
        this.charity = charity;
    }

    public Celebrity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCelebrityName() {
        return celebrityName;
    }

    public void setCelebrityName(String celebrity) {
        this.celebrityName = celebrity;
    }

    public Charity getCharity() {
        return charity;
    }

    public void setCharity(Charity charity) {
        this.charity = charity;
    }

    public String getPseydonym() {
        return pseydonym;
    }

    public void setPseydonym(String pseydonym) {
        this.pseydonym = pseydonym;
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "id=" + id +
                ", celebrityName='" + celebrityName + '\'' +
                ", pseydonym='" + pseydonym + '\'' +
                ", charity=" + charity +
                '}';
    }
}
