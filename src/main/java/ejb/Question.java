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
import javax.persistence.Lob;
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
@Table(name = "question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByQid", query = "SELECT q FROM Question q WHERE q.qid = :qid"),
    @NamedQuery(name = "Question.findByQTitle", query = "SELECT q FROM Question q WHERE q.qTitle = :qTitle"),
    @NamedQuery(name = "Question.findBySname", query = "SELECT q FROM Question q WHERE q.sname = :sname"),
    @NamedQuery(name = "Question.findByOption1", query = "SELECT q FROM Question q WHERE q.option1 = :option1"),
    @NamedQuery(name = "Question.findByOption2", query = "SELECT q FROM Question q WHERE q.option2 = :option2"),
    @NamedQuery(name = "Question.findByOption3", query = "SELECT q FROM Question q WHERE q.option3 = :option3"),
    @NamedQuery(name = "Question.findByOption4", query = "SELECT q FROM Question q WHERE q.option4 = :option4"),
    @NamedQuery(name = "Question.findByDate", query = "SELECT q FROM Question q WHERE q.date = :date")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "qid")
    private Integer qid;
    @Size(max = 255)
    @Column(name = "q_title")
    private String qTitle;
    @Size(max = 255)
    @Column(name = "sname")
    private String sname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "option1")
    private String option1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "option2")
    private String option2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "option3")
    private String option3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "option4")
    private String option4;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "option5")
    private String option5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Question() {
    }

    public Question(Integer qid) {
        this.qid = qid;
    }

    public Question(Integer qid, String option1, String option2, String option3, String option4, String option5, Date date) {
        this.qid = qid;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.date = date;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQTitle() {
        return qTitle;
    }

    public void setQTitle(String qTitle) {
        this.qTitle = qTitle;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
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
        hash += (qid != null ? qid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.qid == null && other.qid != null) || (this.qid != null && !this.qid.equals(other.qid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Question[ qid=" + qid + " ]";
    }
    
}
