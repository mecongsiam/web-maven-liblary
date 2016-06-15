package by.htp.liblary.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_book")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private int year;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "auther_pool", joinColumns = {
            @JoinColumn(name = "id_book")
    }, inverseJoinColumns = {@JoinColumn(name = "id_auther")})
    private Set<Auther> authers;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public Set<Auther> getAuthers() {
        return authers;
    }

    public void setAuthers(Set<Auther> authers) {
        this.authers = authers;
    }
}
