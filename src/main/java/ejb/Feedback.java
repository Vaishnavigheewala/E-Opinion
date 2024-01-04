/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f"),
    @NamedQuery(name = "Feedback.findByFId", query = "SELECT f FROM Feedback f WHERE f.fId = :fId"),
    @NamedQuery(name = "Feedback.findByEmailid", query = "SELECT f FROM Feedback f WHERE f.emailid = :emailid"),
    @NamedQuery(name = "Feedback.findByFText", query = "SELECT f FROM Feedback f WHERE f.fText = :fText"),
    @NamedQuery(name = "Feedback.findByUsername", query = "SELECT f FROM Feedback f WHERE f.username = :username")})
public class Feedback implements Serializable {

    @Size(max = 250)
    @Column(name = "emailid")
    private String emailid;
    @Size(max = 255)
    @Column(name = "f_text")
    private String fText;
    @Size(max = 250)
    @Column(name = "username")
    private String username;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_id")
    private Integer fId;

    public Feedback() {
    }

    public Feedback(Integer fId) {
        this.fId = fId;
    }

    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }


    public String getFText() {
        return fText;
    }

    public void setFText(String fText) {
        this.fText = fText;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fId != null ? fId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.fId == null && other.fId != null) || (this.fId != null && !this.fId.equals(other.fId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Feedback[ fId=" + fId + " ]";
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
