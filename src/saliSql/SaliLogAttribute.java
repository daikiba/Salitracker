/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliSql;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Kone
 */
@Entity
@Table(name="salilogattribute")
public class SaliLogAttribute implements Serializable {
    private int id;
    private float weight;
    private int reps;
    private int repSets;

    public SaliLogAttribute() { }
    
    public SaliLogAttribute(int id, float weight, int reps, int repSets) {
        this.id = id;
        this.weight = weight;
        this.reps = reps;
        this.repSets = repSets;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getRepSets() {
        return repSets;
    }

    public void setRepSets(int repSets) {
        this.repSets = repSets;
    }
}
