package dev.patika.librarymanagementsystem;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "author_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "author_name", nullable = false)
    private String name;

    @Column(name = "author_birthDate")
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Column(name = "author_country")
    private String country;


    @OneToMany(mappedBy = "author")
    private List<Book> book;


    public Author() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }



}
