/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "survey")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Survey.findAll", query = "SELECT s FROM Survey s"),
    @NamedQuery(name = "Survey.findBySid", query = "SELECT s FROM Survey s WHERE s.sid = :sid"),
    @NamedQuery(name = "Survey.findBySname", query = "SELECT s FROM Survey s WHERE s.sname = :sname"),
    @NamedQuery(name = "Survey.findByStitle", query = "SELECT s FROM Survey s WHERE s.stitle = :stitle"),
    @NamedQuery(name = "Survey.findByStype", query = "SELECT s FROM Survey s WHERE s.stype = :stype"),
    @NamedQuery(name = "Survey.findBySStatus", query = "SELECT s FROM Survey s WHERE s.sStatus = :sStatus"),
    @NamedQuery(name = "Survey.findByStotal", query = "SELECT s FROM Survey s WHERE s.stotal = :stotal"),
    @NamedQuery(name = "Survey.findByDate", query = "SELECT s FROM Survey s WHERE s.date = :date")})
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sid")
    private Integer sid;
    @Size(max = 255)
    @Column(name = "sname")
    private String sname;
    @Size(max = 255)
    @Column(name = "stitle")
    private String stitle;
    @Size(max = 255)
    @Column(name = "stype")
    private String stype;
    @Size(max = 50)
    @Column(name = "s_status")
    private String sStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stotal")
    private int stotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Survey() {
    }

    public Survey(Integer sid) {
        this.sid = sid;
    }

    public Survey(Integer sid, int stotal, Date date) {
        this.sid = sid;
        this.stotal = stotal;
        this.date = date;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getSStatus() {
        return sStatus;
    }

    public void setSStatus(String sStatus) {
        this.sStatus = sStatus;
    }

    public int getStotal() {
        return stotal;
    }

    public void setStotal(int stotal) {
        this.stotal = stotal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sid != null ? sid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Survey)) {
            return false;
        }
        Survey other = (Survey) object;
        if ((this.sid == null && other.sid != null) || (this.sid != null && !this.sid.equals(other.sid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Survey[ sid=" + sid + " ]";
    }
    
}
