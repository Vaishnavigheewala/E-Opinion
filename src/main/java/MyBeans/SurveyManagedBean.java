/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package MyBeans;

import Admin.AdminSessionBeanLocal;
import Client.AdminClient;
import Model.SurveyFacade;
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
@Named(value = "surveyManagedBean")
@RequestScoped
public class SurveyManagedBean {

    @EJB
    private SurveyFacade surveyFacade;

    @EJB
    private AdminSessionBeanLocal asb;
    /**
     * Creates a new instance of SurveyManagedBean
     */
    
    
    AdminClient admin = new AdminClient();
    Response res;
    Survey obj = new Survey();
    GenericType<Survey> gsrv;
    Collection<Survey> survey;
    GenericType<Collection<Survey>> gsurvey;

    Integer sid, stotal;
    String sname, stitle, stype, s_status;
    Date date;

    public SurveyFacade getSurveyFacade() {
        return surveyFacade;
    }

    public void setSurveyFacade(SurveyFacade surveyFacade) {
        this.surveyFacade = surveyFacade;
    }

    public Survey getObj() {
        return obj;
    }

    public void setObj(Survey obj) {
        this.obj = obj;
    }

    
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getStotal() {
        return stotal;
    }

    public void setStotal(Integer stotal) {
        this.stotal = stotal;
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

    public String getS_status() {
        return s_status;
    }

    public void setS_status(String s_status) {
        this.s_status = s_status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public SurveyManagedBean() {
    }
    
    public Collection<Survey> findallsurvey() {
        return this.asb.findallsurvey();
    }
    
    public Survey findSurveyBysid(Integer sid) {
        gsrv = new GenericType<Survey>(){};
        res = admin.findSurveyBysid(Response.class, sid.toString());
        obj = res.readEntity(gsrv);
        return obj;
    }

    public String InsertSurvey() {
        this.asb.InsertSurvey(sname, stitle, stype, s_status, stotal, date);
//        this.admin.InsertDepartment(this.deptName, this.isActive);
        return "/AdminSide/ViewSurvey.xhtml?faces-redirect=true";
    }
    public String DeleteSurvey(Integer sid) {
        this.asb.DeleteSurvey(sid);
//        this.admin.DeleteSurvey(sid.toString());
        return "/AdminSide/ViewSurvey.xhtml?faces-redirect=true";
    }

    public void UpdateSurveyActive(Integer sid, String s_status) {
//        this.asb.UpdateDepartmentActive(id, Active);
        this.admin.UpdateSurveyActive(sid.toString(), this.s_status);
    }

//    public void UpdateSurvey(String sname, String stitle, String stype, Integer sid) {
//        //this.asb.UpdateSurvey(sname, stitle, stype, sid);
//        this.admin.UpdateSurvey(this.sname,this.stitle,this.stype, sid.toString());
//        
//    }
    public String update(Survey obj){
        this.obj = obj;
        return "EditSurvey";
    }
    public String update(){
        this.surveyFacade.edit(obj);
        this.obj = obj;
        return "ViewSurvey";
    }
    
}
