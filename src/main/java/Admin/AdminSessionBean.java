/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Admin;

import ejb.*;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class AdminSessionBean implements AdminSessionBeanLocal {

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;
    String grpid;
    
    
    //Survey
    @Override
    public Collection<Survey> findallsurvey() {
        return em.createNamedQuery("Survey.findAll").getResultList();
    }
    
    @Override
    public Survey findSurveyBysid(Integer sid) {
        return em.find(Survey.class, sid);
    }

    @Override
    public void InsertSurvey(String sname, String stitle, String stype, String s_status, Integer stotal, Date date) {
        Survey obj = new Survey();
        obj.setSname(sname);
        obj.setStitle(stitle);  
        obj.setStype(stype);
        obj.setSStatus("Y");
        obj.setStotal(stotal);
        obj.setDate(date);
        //obj.setIsactive("Y");
        em.persist(obj);
    }

    @Override
    public void DeleteSurvey(Integer sid) {
        Survey obj = em.find(Survey.class, sid);
        em.remove(obj);
    }

    @Override
    public void UpdateSurveyActive(Integer sid, String s_status) {
        Survey obj = em.find(Survey.class, sid);
        obj.setSStatus(s_status);
        em.merge(obj);
    }

@Override
    public String UpdateSurvey(String sname, String stitle, String stype, Integer sid) {
        String returnStr;
        try
        {
            Survey obj = em.find(Survey.class, sid);
            obj.setSname(sname);
            obj.setStitle(stitle);  
            obj.setStype(stype);
            em.merge(obj);
            returnStr = "Success";
        }
        catch(Exception err)
        {
            System.out.println(err.getMessage());
            returnStr = "Error";
        }
        return returnStr;
    }
    
    
    //User
    @Override
    public Collection<RegisterMaster> findalluser() {
        return em.createNamedQuery("RegisterMaster.findAll").getResultList();
    }
    
    @Override
    public RegisterMaster finduserBysid(String emailid) {
        return em.find(RegisterMaster.class, emailid);
    }

    
//    @Override
//    public String getgrpIdfromUsername(String username) {
//        Collection<RegisterMaster> user = em.createNamedQuery("RegisterMaster.findByUsername").setParameter("username", username).getResultList();
//        for (RegisterMaster users : user) {
//            grpid = users.getGrpId().toString();
//            System.out.println("User Id is " + grpid);
//        }
//        return grpid;
//    }

    //dashboard
    
    @Override
    public Integer getSurveyCounts() {
            return em.createNamedQuery("Survey.findAll").getResultList().size();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer getUserCounts() {
            return em.createNamedQuery("RegisterMaster.findAll").getResultList().size();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer getQuestionCounts() {
            return em.createNamedQuery("Question.findAll").getResultList().size();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    //Question(admin side)
    @Override
    public Collection<Question> findallQuestion() {
        return em.createNamedQuery("Question.findAll").getResultList();
    }
    
    @Override
    public Question findQuestionByqid(Integer qid) {
        return em.find(Question.class, qid);
    }
        @Override
    public void InsertQuestion(String q_title ,String sname,String option1,String option2, String option3, String option4 , String option5 ,Date date )
    {
        
        Question ques = new Question();
     
        ques.setQTitle(q_title);
        ques.setSname(sname);
        ques.setOption1(option1);
        ques.setOption2(option2);
        ques.setOption3(option3);
        ques.setOption4(option4);
        ques.setOption5(option5);
        ques.setDate(date);
        
        em.persist(ques);
    }
    
    @Override
    public void DeleteQuestion(Integer qid) {
        Question obj = em.find(Question.class, qid);
        em.remove(obj);
    }
    
    //Feedback [AdminSide]
    @Override
    public Collection<Feedback> findallFeedback() {
        return em.createNamedQuery("Feedback.findAll").getResultList();
    }
    
}
    

