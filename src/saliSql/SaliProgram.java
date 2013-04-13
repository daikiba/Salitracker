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
    private String name;
    private Set<SaliActivity> activities = new HashSet<SaliActivity>();
    
    public SaliProgram() { }
    
    public SaliProgram(int id, String programName) {
        this.name = programName;
    }
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    @Override
    public String toString() {
        return name;
    }
}
