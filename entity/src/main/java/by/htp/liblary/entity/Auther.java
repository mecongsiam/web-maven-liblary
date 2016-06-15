package by.htp.liblary.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by meco on 10.06.2016.
 */
@Entity
public class Auther {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_auther")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "date_of_birth")
    private Date date;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authers")
    private Set<Book> books;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
