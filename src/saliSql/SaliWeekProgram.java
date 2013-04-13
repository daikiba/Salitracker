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
@Table(name="weekprogram")
public class SaliWeekProgram implements Serializable {
    private int id;
    private String name;
    private Set<SaliProgram> programs = new HashSet<SaliProgram>();

    public SaliWeekProgram() { }
    
    public SaliWeekProgram(int id, String name) {
        this.id = id;
        this.name = name;
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
    public Set<SaliProgram> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<SaliProgram> programs) {
        this.programs = programs;
    }
}
