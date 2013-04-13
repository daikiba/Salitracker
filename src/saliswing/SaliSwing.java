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
            
            
            
            SaliActivity c1 = new SaliActivity(0, "Chest activity 1", "Something fabulous", 10);
            SaliActivity c2 = new SaliActivity(0, "Chest activity 2", "Something fierce", 10);
            SaliActivity c3 = new SaliActivity(0, "Chest activity 3", "Something fun", 10);
            
            SaliActivity back1 = new SaliActivity(0, "Back act", "Be careful when doing this", 20);
            SaliActivity back2 = new SaliActivity(0, "Extreme Back activity", "Focus on the form", 8);
            
            SaliActivity leg = new SaliActivity(0, "Jogging 60 minutes", "Keep up a good sweat", 1);
            
            SaliProgram chestprogram = new SaliProgram(0, "Example Chest Day");
            chestprogram.addActivity(c1);
            chestprogram.addActivity(c2);
            chestprogram.addActivity(c3);
            
            SaliProgram backprogram = new SaliProgram(0, "Example Back Day");
            backprogram.addActivity(back1);
            backprogram.addActivity(back2);
            
            SaliProgram legprogram = new SaliProgram(0, "Example Leg Day");
            legprogram.addActivity(leg);
            
            istunto.saveOrUpdate(c1);
            istunto.saveOrUpdate(c2);
            istunto.saveOrUpdate(c3);
            
            istunto.saveOrUpdate(back1);
            istunto.saveOrUpdate(back2);
            
            istunto.saveOrUpdate(leg);
            
            istunto.saveOrUpdate(chestprogram);
            istunto.saveOrUpdate(backprogram);
            istunto.saveOrUpdate(legprogram);
            
            
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
