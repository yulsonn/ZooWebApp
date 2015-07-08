package com.jscomp.zooweb.repository;

import com.jscomp.zooweb.domain.Cage;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CageRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Add given in parameter Cage object to cage table.
     *
     * @param cage
     * */
    public void addCage(Cage cage){
        this.sessionFactory.getCurrentSession().save(cage);
    }

    /**
     * Returns Cage object from cage table, selected by given parameter id.
     *
     * @param id
     * @return      cage by id
     * */
    public Cage getCage(Integer id){
        Cage result = (Cage)this.sessionFactory.getCurrentSession().get(Cage.class, id);
        return result;
    }

    /**
     * Updates selected Cage object in cage table.
     *
     * @param cage
     * */
    public void updateCage(Cage cage){
        this.sessionFactory.getCurrentSession().update(cage);
    }

    /**
     * Deletes Cage object from cage table, selected by given parameter id.
     *
     * @param id
     * */
    public void deleteCage(Integer id){
        Cage cage = (Cage)this.sessionFactory.getCurrentSession().load(Cage.class, id);
        if (null!=cage){
            this.sessionFactory.getCurrentSession().delete(cage);
        }
    }

    /**
     * Returns List of all Cage objects from cage table.
     *
     * @return  List id Cage objects
     * */
    public List<Cage> getCageList(){
        List<Cage> cages = sessionFactory.getCurrentSession().createCriteria(Cage.class).list();
        return cages;
    }
}
