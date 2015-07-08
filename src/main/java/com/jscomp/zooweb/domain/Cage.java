package com.jscomp.zooweb.domain;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.Set;

@Entity
@Table(name = "cage")
public class Cage {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "number")
    @Digits(integer = 5, fraction = 0, message = "only numbers")
    private Integer number;

    @Column(name = "description", length = 255)
    private String description;

    @OneToMany(mappedBy = "cage")
    private Set<Animal> animals;

    public Cage() {
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Cage " + number + ", " + description;
    }
}
