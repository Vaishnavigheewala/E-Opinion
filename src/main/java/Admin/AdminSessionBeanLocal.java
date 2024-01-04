/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Admin;

import ejb.*;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;


@Local
public interface AdminSessionBeanLocal {

    //Survey
    public Collection<Survey> findallsurvey();

    public Survey findSurveyBysid(Integer sid);

    public void InsertSurvey(String sname, String stitle, String stype, String s_status, Integer stotal, Date date);

    public void DeleteSurvey(Integer sid);

    public void UpdateSurveyActive(Integer sid, String s_status);

    public String UpdateSurvey(String sname, String stitle, String stype, Integer sid);

    public Integer getSurveyCounts();

    public Integer getUserCounts();

    public Integer getQuestionCounts();

    public Collection<RegisterMaster> findalluser();

    public RegisterMaster finduserBysid(String emailid);

    public Collection<Question> findallQuestion();

    public Question findQuestionByqid(Integer qid);

    public void InsertQuestion(String q_title, String sname, String option1, String option2, String option3, String option4, String option5, Date date);

    public Collection<Feedback> findallFeedback();

    public void DeleteQuestion(Integer qid);

   
}
