/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package MyBeans;

import Admin.AdminSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Hp
 */
@Named(value = "dashboardManagedBeans")
@SessionScoped
public class DashboardManagedBeans implements Serializable {

    /**
     * Creates a new instance of DashboardManagedBeans
     */
        @EJB AdminSessionBeanLocal asb;

    public AdminSessionBeanLocal getAsb() {
        return asb;
    }

    public void setAsb(AdminSessionBeanLocal asb) {
        this.asb = asb;
    }
        
        

    public DashboardManagedBeans() {
    }
    public Integer surveyCounts(){
         return this.asb.getSurveyCounts();
     }
     
    public Integer userCounts(){
         return this.asb.getUserCounts();
     }
    
     public Integer questionCounts(){
         return this.asb.getQuestionCounts();
     }
     
    
}
