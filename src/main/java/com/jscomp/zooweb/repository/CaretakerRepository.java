package com.jscomp.zooweb.repository;

import com.jscomp.zooweb.domain.Caretaker;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CaretakerRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Add given in parameter Caretaker object to caretaker table.
     *
     * @param caretaker
     * */
    public void addCaretaker(Caretaker caretaker){
        this.sessionFactory.getCurrentSession().save(caretaker);
    }

    /**
     * Returns Caretaker object from caretaker table, selected by given parameter id.
     *
     * @param id
     * @return      caretaker by id
     * */
    public Caretaker getCaretaker(Integer id){
        Caretaker result = (Caretaker)this.sessionFactory.getCurrentSession().get(Caretaker.class, id);
        return result;
    }

    /**
     * Updates selected Cage object in caretaker table.
     *
     * @param caretaker
     * */
    public void updateCaretaker(Caretaker caretaker){
        this.sessionFactory.getCurrentSession().update(caretaker);
    }

    /**
     * Deletes Caretaker object from caretaker table, selected by given parameter id.
     *
     * @param id
     * */
    public void deleteCaretaker(Integer id){
        Caretaker caretaker = (Caretaker)this.sessionFactory.getCurrentSession().load(Caretaker.class, id);
        if (null!=caretaker){
            this.sessionFactory.getCurrentSession().delete(caretaker);
        }
    }

    /**
     * Returns List of all Caretaker objects from caretaker table.
     *
     * @return  List id Caretaker objects
     * */
    public List<Caretaker> getCaretakerList(){
        return this.sessionFactory.getCurrentSession().createQuery("from Caretaker").list();
    }
}
