/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package MyBeans;

import Admin.AdminSessionBeanLocal;
import Client.AdminClient;
import User.UserSessionBeanLocal;
import ejb.Feedback;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hp
 */
@Named(value = "feedbackManagedBean")
@SessionScoped
public class FeedbackManagedBean implements Serializable {

    @EJB
    private AdminSessionBeanLocal asb;
    
    @EJB
    private UserSessionBeanLocal usb;
    
    AdminClient admin = new AdminClient();
    Response res;
    Feedback obj = new Feedback();
    
    Integer f_id;
    String emailid,f_text,username;

    public UserSessionBeanLocal getUsb() {
        return usb;
    }

    public void setUsb(UserSessionBeanLocal usb) {
        this.usb = usb;
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

    public Feedback getObj() {
        return obj;
    }

    public void setObj(Feedback obj) {
        this.obj = obj;
    }

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getF_text() {
        return f_text;
    }

    public void setF_text(String f_text) {
        this.f_text = f_text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    


    public AdminSessionBeanLocal getAsb() {
        return asb;
    }

    public void setAsb(AdminSessionBeanLocal asb) {
        this.asb = asb;
    }
    
    
    public FeedbackManagedBean() {
    }
    
    public Collection<Feedback> findallFeedback() {
        return this.asb.findallFeedback();
    }
    
     public String InsertFeedback() {
        this.usb.InsertFeedback(emailid, f_text, username);
//        this.admin.InsertDepartment(this.deptName, this.isActive);
        return "/AdminSide/Thanku.xhtml?faces-redirect=true";
    }
    
}
