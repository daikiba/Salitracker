/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliSql;

import java.io.Serializable;
import java.security.MessageDigest;
import javax.persistence.*;
import nicotricks.Hasher;

/**
 *
 * @author Kone
 */
@Entity
@Table(name="saliuser")
public class SaliUser implements Serializable {
    private int id;
    private String username;
    private String password;
    private String fullName;
    private float userWeight;
    private float userLength;

    public SaliUser() { }
    
    public SaliUser(int id, String username, String password, String fullName,
            float userWeight, float userLength) throws Exception {
        try {
            this.password = Hasher.getMD5String(password);
        }
        catch(Exception ex) {
            throw ex;
        }
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.userWeight = userWeight;
        this.userLength = userLength;
    }
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(unique = true, nullable = false, length = 28)
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false, name = "passwd")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(float userWeight) {
        this.userWeight = userWeight;
    }

    public float getUserLength() {
        return userLength;
    }

    public void setUserLength(float userLength) {
        this.userLength = userLength;
    }
}
