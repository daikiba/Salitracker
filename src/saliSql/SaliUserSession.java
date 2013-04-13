/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliSql;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Kone
 */
@Entity
@Table(name="saliusersession")
public class SaliUserSession implements Serializable {
    private int id;
    private SaliUser saliUser;
    private int ipAddress;
    private String sessionKey;
    private Date timeStampCreated;

    public SaliUserSession() { }
    
    public SaliUserSession(int id, SaliUser saliUser, int ipAddress, String sessionKey) {
        this.id = id;
        this.saliUser = saliUser;
        this.ipAddress = ipAddress;
        this.sessionKey = sessionKey;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @OneToOne
    public SaliUser getSaliUser() {
        return saliUser;
    }

    public void setSaliUser(SaliUser saliUser) {
        this.saliUser = saliUser;
    }

    public int getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(int ipAddress) {
        this.ipAddress = ipAddress;
    }
    
    public String getSessionKey() {
        return sessionKey;
    }
    
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
    
    @PrePersist
    public void onCreate() {
        timeStampCreated = new Date();
    }
    
    public void setTimeStampCreated(Date date) {
        this.timeStampCreated = date;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sessionstarted", nullable = false)
    public Date getTimeStampCreated() {
        return timeStampCreated;
    }
}
