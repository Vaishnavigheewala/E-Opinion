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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "register_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegisterMaster.findAll", query = "SELECT r FROM RegisterMaster r"),
    @NamedQuery(name = "RegisterMaster.findByUsername", query = "SELECT r FROM RegisterMaster r WHERE r.username = :username"),
    @NamedQuery(name = "RegisterMaster.findByPassword", query = "SELECT r FROM RegisterMaster r WHERE r.password = :password"),
    @NamedQuery(name = "RegisterMaster.findByEmailid", query = "SELECT r FROM RegisterMaster r WHERE r.emailid = :emailid"),
    @NamedQuery(name = "RegisterMaster.findByAddress", query = "SELECT r FROM RegisterMaster r WHERE r.address = :address"),
    @NamedQuery(name = "RegisterMaster.findByPincode", query = "SELECT r FROM RegisterMaster r WHERE r.pincode = :pincode"),
    @NamedQuery(name = "RegisterMaster.findByCity", query = "SELECT r FROM RegisterMaster r WHERE r.city = :city"),
    @NamedQuery(name = "RegisterMaster.findByContactNumber", query = "SELECT r FROM RegisterMaster r WHERE r.contactNumber = :contactNumber"),
    @NamedQuery(name = "RegisterMaster.findByDate", query = "SELECT r FROM RegisterMaster r WHERE r.date = :date")})
public class RegisterMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 20)
    @Column(name = "password")
    private String password;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "emailid")
    private String emailid;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Column(name = "pincode")
    private Integer pincode;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Column(name = "contact_number")
    private Integer contactNumber;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "grp_id", referencedColumnName = "grp_id")
    @ManyToOne(optional = false)
    private GroupMaster grpId;

    public RegisterMaster() {
    }

    public RegisterMaster(String emailid) {
        this.emailid = emailid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GroupMaster getGrpId() {
        return grpId;
    }

    public void setGrpId(GroupMaster grpId) {
        this.grpId = grpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailid != null ? emailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegisterMaster)) {
            return false;
        }
        RegisterMaster other = (RegisterMaster) object;
        if ((this.emailid == null && other.emailid != null) || (this.emailid != null && !this.emailid.equals(other.emailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.RegisterMaster[ emailid=" + emailid + " ]";
    }

       
}
