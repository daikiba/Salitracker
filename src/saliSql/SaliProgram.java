/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliSql;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Kone
 */
@Entity
@Table(name="program")
public class SaliProgram implements Serializable {
    private int id;
    private String programName;
    private Set<SaliActivity> activities = new HashSet<SaliActivity>();
    
    public SaliProgram() { }
    
    public SaliProgram(int id, String programName) {
        this.programName = programName;
    }
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @ManyToMany
    public Set<SaliActivity> getActivities() {
        return activities;
    }

    public void setActivities(Set<SaliActivity> activities) {
        this.activities = activities;
    }
    
    public void addActivity(SaliActivity activity) {
        activities.add(activity);
    }
}
