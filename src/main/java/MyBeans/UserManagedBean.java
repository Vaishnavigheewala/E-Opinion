/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package MyBeans;

import Admin.AdminSessionBeanLocal;
import ejb.*;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Hp
 */
@Named(value = "userManagedBean")
@RequestScoped
public class UserManagedBean {

    @EJB
    private AdminSessionBeanLocal asb;
    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
    }
    
    public Collection<RegisterMaster> findalluser() {
        return this.asb.findalluser();
    }
    
}
