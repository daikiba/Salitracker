/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliswing;

import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import saliSql.*;

/**
 *
 * @author Kone
 */
public class SaliSwing {

    public static void main(String[] args) {

        SessionFactory istuntotehdas = new AnnotationConfiguration().configure().buildSessionFactory();
        Session istunto = istuntotehdas.openSession();

        Transaction transaktio = null;

        try {
            transaktio = istunto.beginTransaction();
            
            SaliUser user = null;
            
            try {
                user = new SaliUser(0, "nico", "jee", "Nico jee", 75f, 187f);
            }
            catch(Exception ex) { ex.toString(); }
            
            SaliActivity VatsaAct = new SaliActivity(0, "Nicon vatsatreeni", "Vatsalihaspenkkiin ja veivaamaan kunnes on hapokas olo!", 100);
            SaliActivity penkkiAct = new SaliActivity(0, "Penkki", "Se perinteinen", 10);
            SaliLogAttribute vatsaAtr = new SaliLogAttribute(0, 0, 100, 1);
            SaliLogAttribute penkkiAtr = new SaliLogAttribute(0, 60, 15, 3);
            SaliLogAttribute penkkiAtr2 = new SaliLogAttribute(0, 70, 10, 1);
            
            SaliLogRow row1 = new SaliLogRow(0, VatsaAct, vatsaAtr);
            SaliLogRow row2 = new SaliLogRow(0, penkkiAct, penkkiAtr);
            SaliLogRow row3 = new SaliLogRow(0, penkkiAct, penkkiAtr2);
            
            String[] mgroups = {"Hauis","Ojentaja","Hartiat","Rinta","Selka","Vatsa", "Jalat"};
            
            SaliMuscleGroup[] mg = new SaliMuscleGroup[mgroups.length];
            for (int i = 0; i < mgroups.length; i++) {
                mg[i] = new SaliMuscleGroup(0, mgroups[i]);
                istunto.saveOrUpdate(mg[i]);
            }
            
            SaliLog log = new SaliLog(0, user, new Date());
            
            log.addLogrow(row1);
            log.addLogrow(row2);
            log.addLogrow(row3);
            
            istunto.saveOrUpdate(user);
            istunto.saveOrUpdate(VatsaAct);
            istunto.saveOrUpdate(penkkiAct);
            istunto.saveOrUpdate(vatsaAtr);
            istunto.saveOrUpdate(penkkiAtr);
            istunto.saveOrUpdate(penkkiAtr2);
            istunto.saveOrUpdate(row1);
            istunto.saveOrUpdate(row2);
            istunto.saveOrUpdate(row3);
            istunto.saveOrUpdate(log);
            

            transaktio.commit();
        } catch (Exception e) {
            if (transaktio != null & transaktio.isActive()) {
                try {
                    transaktio.rollback();
                } catch (HibernateException e1) {
                    System.err.println("Tapahtuman " +
                            "peruutus epäonnistui.");
                }
            }
            e.printStackTrace();
        } finally {
            istunto.close();
        }
    }
}
