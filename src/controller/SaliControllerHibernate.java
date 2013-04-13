/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import saliSql.*;

/**
 *
 * @author Kone
 */
public class SaliControllerHibernate implements SaliController {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    private SaliUser currentUser;
    private String errorMessage;

    
    public SaliControllerHibernate() {
         sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
         session = sessionFactory.openSession();
         transaction = null;
         currentUser = null;
    }
    
    public String getError() {
        return errorMessage;
    }
    
    @Override
    public boolean verifyUser(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<SaliLog> getUserLog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUserFullName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getUserHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getUserWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getUserBMI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SaliWeekProgram getUserWeekProgram() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SaliLogRow getLogAttribute(int reps, int sets, float weight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUserFullName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUserHeight(float height) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUserWeight(float weight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUserWeekProgram(SaliWeekProgram weekProgram) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNewUserLog(SaliLog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addNewProgram(String name, Set<SaliActivity> iSet) {
        Query query = session.createQuery("select id from SaliProgram where name='"+name+"'");
        if (query.uniqueResult() != null) {
            errorMessage = "T\u00E4m\u00E4n niminen p\u00E4iv\u00E4ohjelma on jo olemassa.";
            return false;
        }
        else {
            transaction = session.beginTransaction();
            SaliProgram newItem = new SaliProgram(0, name);
            newItem.setActivities(iSet);
            session.saveOrUpdate(newItem);
            transaction.commit();
            if (transaction.wasCommitted()) {
                return true;
            }
            else {
                errorMessage = "Tietoa ei voitu tallentaa. Yrit\u00E4 hetken kuluttua uudelleen.";
                return false;
            }
        }
    }

    @Override
    public boolean addNewWeekProgram(String name, Set<SaliProgram> iSet) {
        Query query = session.createQuery("select id from SaliWeekProgram where name='"+name+"'");
        if (query.uniqueResult() != null) {
            errorMessage = "T\u00E4m\u00E4n niminen viikko-ohjelma on jo olemassa.";
            return false;
        }
        else {
            transaction = session.beginTransaction();
            SaliWeekProgram newItem = new SaliWeekProgram(0, name);
            newItem.setPrograms(iSet);
            session.saveOrUpdate(newItem);
            transaction.commit();
            if (transaction.wasCommitted()) {
                return true;
            }
            else {
                errorMessage = "Tietoa ei voitu tallentaa. Yrit\u00E4 hetken kuluttua uudelleen.";
                return false;
            }
        }
    }

    @Override
    public boolean addNewActivity(String name, String description, int defaultAmountOfReps, Set<SaliMuscleGroup> iSet) {
        Query query = session.createQuery("select id from SaliActivity where name='"+name+"'");
        if (query.uniqueResult() != null) {
            errorMessage = "T\u00E4m\u00E4n niminen aktiviteetti on jo olemassa.";
            return false;
        }
        else {
            transaction = session.beginTransaction();
            SaliActivity newItem = new SaliActivity(0, name, description, defaultAmountOfReps);
            newItem.setSaliMuscleGroups(iSet);
//            for (SaliMuscleGroup i : mList) {
//                newItem.addSaliMuscleGroup(i);
//            }
            session.saveOrUpdate(newItem);
            transaction.commit();
            if (transaction.wasCommitted()) {
                return true;
            }
            else {
                errorMessage = "Tietoa ei voitu tallentaa. Yrit\u00E4 hetken kuluttua uudelleen.";
                return false;
            }
        }
    }

    @Override
    public void addNewMuscleGroup(SaliMuscleGroup muscleGroup) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Set<SaliMuscleGroup> getMuscleGroups() {
        Criteria criteria = session.createCriteria(SaliMuscleGroup.class);
        List<SaliMuscleGroup> results = criteria.list();
        Hibernate.initialize(results);
        Set<SaliMuscleGroup> returnSet = new HashSet<>();
        for (SaliMuscleGroup i : results)
        {
            returnSet.add(i);
        }
        return returnSet;
    }

    @Override
    public Set<SaliProgram> getPrograms() {
        Criteria criteria = session.createCriteria(SaliProgram.class);
        List<SaliProgram> results = criteria.list();
        Hibernate.initialize(results);
        Set<SaliProgram> returnSet = new HashSet<>();
        for (SaliProgram i : results)
        {
            returnSet.add(i);
        }
        return returnSet;
    }
    
    /*
     * Can't seem to get this to work.. :(
    public <T> Set<T> getAllItems(T classType) {
        Criteria criteria = session.createCriteria(classType.getClass());
        List<T> results = criteria.list();
        Hibernate.initialize(results);
        Set<T> returnSet = new HashSet<>();
        System.out.println(results.size());
        for (T i : results)
        {
            returnSet.add(i);
        }
        return returnSet;
    }
    */

    @Override
    public Set<SaliWeekProgram> getWeekPrograms() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<SaliActivity> getActivities() {
        Criteria criteria = session.createCriteria(SaliActivity.class);
        List<SaliActivity> results = criteria.list();
        Hibernate.initialize(results);
        Set<SaliActivity> returnSet = new HashSet<>();
        for (SaliActivity i : results)
        {
            returnSet.add(i);
        }
        return returnSet;
    }
}
