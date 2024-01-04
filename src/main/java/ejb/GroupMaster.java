/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "group_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupMaster.findAll", query = "SELECT g FROM GroupMaster g"),
    @NamedQuery(name = "GroupMaster.findByGrpId", query = "SELECT g FROM GroupMaster g WHERE g.grpId = :grpId"),
    @NamedQuery(name = "GroupMaster.findByGrpName", query = "SELECT g FROM GroupMaster g WHERE g.grpName = :grpName")})
public class GroupMaster implements Serializable {

    @Size(max = 255)
    @Column(name = "grp_name")
    private String grpName;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "grp_id")
    private Integer grpId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grpId")
    private Collection<RegisterMaster> registerMasterCollection;

    public GroupMaster() {
    }

    public GroupMaster(Integer grpId) {
        this.grpId = grpId;
    }

    public Integer getGrpId() {
        return grpId;
    }

    public void setGrpId(Integer grpId) {
        this.grpId = grpId;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    @XmlTransient
    public Collection<RegisterMaster> getRegisterMasterCollection() {
        return registerMasterCollection;
    }

    public void setRegisterMasterCollection(Collection<RegisterMaster> registerMasterCollection) {
        this.registerMasterCollection = registerMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grpId != null ? grpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupMaster)) {
            return false;
        }
        GroupMaster other = (GroupMaster) object;
        if ((this.grpId == null && other.grpId != null) || (this.grpId != null && !this.grpId.equals(other.grpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.GroupMaster[ grpId=" + grpId + " ]";
    }

//    public String getGrpName() {
//        return grpName;
//    }
//
//    public void setGrpName(String grpName) {
//        this.grpName = grpName;
//    }


}
