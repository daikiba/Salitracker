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
@Table(name="activity")
public class SaliActivity implements Serializable {
    private int id;
    private String name;
    private String description;
    private int defaultAmountOfReps;
    private Set<SaliMuscleGroup> saliMuscleGroups = new HashSet<SaliMuscleGroup>();

    public SaliActivity() { }
    
    public SaliActivity(int id, String name, String description, int defaultAmountOfReps) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.defaultAmountOfReps = defaultAmountOfReps;
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

    @Column(length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDefaultAmountOfReps() {
        return defaultAmountOfReps;
    }

    public void setDefaultAmountOfReps(int defaultAmountOfReps) {
        this.defaultAmountOfReps = defaultAmountOfReps;
    }

    @ManyToMany
    //@JoinTable(name = "activity_muscle", joinColumns = { @JoinColumn(name = "AID")}, inverseJoinColumns = { @JoinColumn(name = "MID") })
    public Set<SaliMuscleGroup> getSaliMuscleGroups() {
        return saliMuscleGroups;
    }

    public void setSaliMuscleGroups(Set<SaliMuscleGroup> saliMuscleGroups) {
        this.saliMuscleGroups = saliMuscleGroups;
    }
    
    public void addSaliMuscleGroup(SaliMuscleGroup group) {
        saliMuscleGroups.add(group);
    }
    
    public String toString() {
        return name;
    }
}
