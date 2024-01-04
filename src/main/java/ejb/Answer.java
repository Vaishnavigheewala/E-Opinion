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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "answer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a"),
    @NamedQuery(name = "Answer.findByAid", query = "SELECT a FROM Answer a WHERE a.aid = :aid"),
    @NamedQuery(name = "Answer.findByQid", query = "SELECT a FROM Answer a WHERE a.qid = :qid"),
    @NamedQuery(name = "Answer.findByEmailid", query = "SELECT a FROM Answer a WHERE a.emailid = :emailid"),
    @NamedQuery(name = "Answer.findByAnswer1", query = "SELECT a FROM Answer a WHERE a.answer1 = :answer1"),
    @NamedQuery(name = "Answer.findByAnswer2", query = "SELECT a FROM Answer a WHERE a.answer2 = :answer2"),
    @NamedQuery(name = "Answer.findByAnswer3", query = "SELECT a FROM Answer a WHERE a.answer3 = :answer3"),
    @NamedQuery(name = "Answer.findByAnswer4", query = "SELECT a FROM Answer a WHERE a.answer4 = :answer4"),
    @NamedQuery(name = "Answer.findByAnswer5", query = "SELECT a FROM Answer a WHERE a.answer5 = :answer5")})
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aid")
    private Integer aid;
    @Column(name = "qid")
    private Integer qid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "emailid")
    private String emailid;
    @Size(max = 255)
    @Column(name = "answer1")
    private String answer1;
    @Size(max = 255)
    @Column(name = "answer2")
    private String answer2;
    @Size(max = 255)
    @Column(name = "answer3")
    private String answer3;
    @Size(max = 255)
    @Column(name = "answer4")
    private String answer4;
    @Size(max = 255)
    @Column(name = "answer5")
    private String answer5;

    public Answer() {
    }

    public Answer(Integer aid) {
        this.aid = aid;
    }

    public Answer(Integer aid, String emailid) {
        this.aid = aid;
        this.emailid = emailid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Answer[ aid=" + aid + " ]";
    }
    
}
