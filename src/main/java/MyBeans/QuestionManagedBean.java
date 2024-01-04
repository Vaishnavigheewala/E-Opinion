/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package MyBeans;

import Admin.AdminSessionBeanLocal;
import Client.AdminClient;
import Model.QuestionFacade;
import Model.SurveyFacade;
import ejb.Question;
import ejb.Survey;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hp
 */
@Named(value = "questionManagedBean")
@RequestScoped
public class QuestionManagedBean {

    @EJB
    private SurveyFacade surveyFacade;

    @EJB
    private QuestionFacade questionFacade;
    
    @EJB
    private AdminSessionBeanLocal asb;
    
    AdminClient admin = new AdminClient();
    Response res;
    Question obj = new Question();
    GenericType<Question> gsrv;
    Collection<Question> survey;
    GenericType<Collection<Question>> gsurvey;

    Integer qid;
    String q_title, option1, option2, option3,option4,option5,sname;
    Date date;

    public QuestionFacade getQuestionFacade() {
        return questionFacade;
    }

    public void setQuestionFacade(QuestionFacade questionFacade) {
        this.questionFacade = questionFacade;
    }
    
    public SurveyFacade getSurveyFacade() {
        return surveyFacade;
    }

    public void setSurveyFacade(SurveyFacade surveyFacade) {
        this.surveyFacade = surveyFacade;
    }

    public AdminSessionBeanLocal getAsb() {
        return asb;
    }

    public void setAsb(AdminSessionBeanLocal asb) {
        this.asb = asb;
    }

    public AdminClient getAdmin() {
        return admin;
    }

    public void setAdmin(AdminClient admin) {
        this.admin = admin;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Question getObj() {
        return obj;
    }

    public void setObj(Question obj) {
        this.obj = obj;
    }

    public GenericType<Question> getGsrv() {
        return gsrv;
    }

    public void setGsrv(GenericType<Question> gsrv) {
        this.gsrv = gsrv;
    }

    public Collection<Question> getSurvey() {
        return survey;
    }

    public void setSurvey(Collection<Question> survey) {
        this.survey = survey;
    }

    public GenericType<Collection<Question>> getGsurvey() {
        return gsurvey;
    }

    public void setGsurvey(GenericType<Collection<Question>> gsurvey) {
        this.gsurvey = gsurvey;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }   

    public String getQ_title() {
        return q_title;
    }

    public void setQ_title(String q_title) {
        this.q_title = q_title;
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
    
    /**
     * Creates a new instance of QuestionManagedBean
     */
    public QuestionManagedBean() {
    }
    public Collection<Question> findallQuestion() {
        return this.asb.findallQuestion();
    }
    
    public Question findSurveyBysid(Integer sid) {
        gsrv = new GenericType<Question>(){};
        res = admin.findSurveyBysid(Response.class, sid.toString());
        obj = res.readEntity(gsrv);
        return obj;
    }

    public String InsertQuestion() {
        this.asb.InsertQuestion(q_title ,sname,option1,option2, option3, option4 , option5 , date);
//        this.admin.InsertDepartment(this.deptName, this.isActive);
        return "/AdminSide/ViewQuestion.xhtml?faces-redirect=true";
    }
    
    public String DeleteQuestion(Integer qid) {
        this.asb.DeleteQuestion(qid);
//        this.admin.DeleteSurvey(sid.toString());
        return "/AdminSide/ViewQuestion.xhtml?faces-redirect=true";
    }
    
    public String update(Question obj){
        this.obj = obj;
        return "EditQuestion";
    }
    public String update(){
        this.questionFacade.edit(obj);
        this.obj = obj;
        return "ViewQuestion";
    }
    
}
