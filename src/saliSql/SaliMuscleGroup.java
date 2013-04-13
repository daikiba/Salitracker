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
@Table(name="musclegroup")
public class SaliMuscleGroup implements Serializable {
    private int id;
    private String muscleGroup;

    public SaliMuscleGroup() { }
    
    public SaliMuscleGroup(int id, String muscleGroup) {
        this.id = id;
        this.muscleGroup = muscleGroup;
    }
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(unique = true)
    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }
    
    @Override
    public String toString() {
        return muscleGroup;
    }
}
