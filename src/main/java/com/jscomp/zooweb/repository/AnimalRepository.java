package com.jscomp.zooweb.repository;

import com.jscomp.zooweb.domain.Animal;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AnimalRepository {

    @Autowired
    private SessionFactory sessionFactory;
    /**
     * Add given in parameter Animal object to animal table.
     *
     * @param animal
     * */
    public void addAnimal(Animal animal){
        this.sessionFactory.getCurrentSession().save(animal);
    }

    /**
     * Returns Animal object from animal table, selected by given parameter id.
     *
     * @param id
     * @return      animal by id
     * */
    public Animal getAnimal(Integer id){
        Animal result = (Animal)this.sessionFactory.getCurrentSession().get(Animal.class, id);
        return result;
    }

    /**
     * Returns Animal object from animal table, selected by given parameter name.
     * Name is unique in animal table.
     *
     * @param animalName
     * @return              animal by name
     * */
    public Animal getAnimalByName(String animalName){
        Query query = sessionFactory.getCurrentSession().createQuery("from Animal where name=:name");
        query.setParameter("name", animalName);
        Animal animal = (Animal) query.uniqueResult();
        return animal;
    }

    /**
     * Updates selected Animal object in animal table.
     *
     * @param animal
     * */
    public void updateAnimal(Animal animal){
        this.sessionFactory.getCurrentSession().update(animal);
    }

    /**
     * Deletes Animal object in animal table, selected by given parameter id.
     *
     * @param id
     * */
    public void deleteAnimal(Integer id){
        Animal animal = (Animal)this.sessionFactory.getCurrentSession().load(Animal.class, id);
        if (null!=animal){
            this.sessionFactory.getCurrentSession().delete(animal);
        }
    }

    /**
     * Returns List of all Animal objects from animal table.
     *
     * @return  List id Animal objects
     * */
    public List<Animal> getAnimalList(){
        List<Animal> animals = sessionFactory.getCurrentSession().createCriteria(Animal.class).list();
        return animals;
    }
}
