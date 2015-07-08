package com.jscomp.zooweb.domain;

import com.jscomp.zooweb.validation.annotation.UniqueAnimalName;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "animal")
public class Animal{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", length = 55, unique = true, nullable = false)
    @UniqueAnimalName(message = "Such name already exists!")
    private String name;

    @Column(name = "type", length = 30)
    private String type;

    @Column(name = "age")
    @Min(value = 0, message = "Must be more then 0")
    @Max(value = 100, message = "Must be less then 100")
    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cage_id", referencedColumnName = "id")
    private Cage cage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "caretaker_id", referencedColumnName = "id")
    private Caretaker caretaker;

    public Animal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    public Caretaker getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

}
