/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package MyBeans;

import User.UserSessionBeanLocal;
import ejb.Question;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import record.KeepRecord;

/**
 *
 * @author Hp
 */
@Named(value = "answerManagedBean")
@SessionScoped
public class AnswerManagedBean implements Serializable {

    /**
     * Creates a new instance of AnswerManagedBean
     */
    Integer qid ;
    String answer1,answer2,answer3,answer4,answer5 , emailid;
    @EJB
    UserSessionBeanLocal usb;
    Question currentQuestion;
    
        private String selectedOption;

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
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

    public UserSessionBeanLocal getUsb() {
        return usb;
    }

    public void setUsb(UserSessionBeanLocal usb) {
        this.usb = usb;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
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
   
    public AnswerManagedBean() {
    }
    

//    public Collection<Question> findAllQuestion() {
//        return this.usb.findAllQuestion();
//    }
    
    public String Answer() {
        this.usb.Answer(emailid, answer1, answer2,answer3,answer4,answer5);
        this.usb.processSelectedOption(selectedOption);
//        this.admin.InsertDepartment(this.deptName, this.isActive);
        return "/AdminSide/Thanku.xhtml?faces-redirect=true";
    }
}
