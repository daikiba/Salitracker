/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliSql;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Kone
 */

@Entity
@Table(name="salilog")
public class SaliLog implements Serializable {
    private int id;
    private SaliUser saliUser;
    private Set<SaliLogRow> logrows = new HashSet<>();
    private Date logDate;

    public SaliLog() { }
    
    public SaliLog(int id, SaliUser saliUser, Date logDate) {
        this.id = id;
        this.saliUser = saliUser;
        this.logDate = logDate;
    }
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    public SaliUser getSaliUser() {
        return saliUser;
    }

    public void setSaliUser(SaliUser saliUser) {
        this.saliUser = saliUser;
    }

    @OneToMany
    public Set<SaliLogRow> getLogrows() {
        return logrows;
    }

    public void setLogrows(Set<SaliLogRow> logrows) {
        this.logrows = logrows;
    }
    
    public void addLogrow(SaliLogRow logrow) {
        logrows.add(logrow);
    }
    
    @Temporal(TemporalType.DATE)
    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
}
