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
@Table(name="salilogrow")
public class SaliLogRow implements Serializable {
    private int id;
    private SaliActivity saliActivity;
    private SaliLogAttribute saliLogAttribute;

    public SaliLogRow() { }
    
    public SaliLogRow(int id, SaliActivity saliActivity, SaliLogAttribute saliLogAttribute) {
        this.id = id;
        this.saliActivity = saliActivity;
        this.saliLogAttribute = saliLogAttribute;
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
    public SaliActivity getSaliActivity() {
        return saliActivity;
    }

    public void setSaliActivity(SaliActivity saliActivity) {
        this.saliActivity = saliActivity;
    }

    @ManyToOne
    public SaliLogAttribute getSaliLogAttribute() {
        return saliLogAttribute;
    }

    public void setSaliLogAttribute(SaliLogAttribute saliLogAttribute) {
        this.saliLogAttribute = saliLogAttribute;
    }
}
