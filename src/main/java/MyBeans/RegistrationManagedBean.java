/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package MyBeans;

//import Client.AdminClient;
import User.UserSessionBeanLocal;
import ejb.RegisterMaster;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hp
 */
@Named(value = "registrationManagedBean")
@RequestScoped
public class RegistrationManagedBean {
    
    @EJB
    private UserSessionBeanLocal usb;
    
    @Resource
    private UserTransaction utx;

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em; 
    
    //AdminClient admin = new AdminClient();
    Response res;
    RegisterMaster obj = new RegisterMaster();
    
    Integer pincode,contact_number,grp_id;
    String username,password,emailid,address,city;
    Date date;

    Collection<RegisterMaster> Register;
    GenericType<Collection<RegisterMaster>> gUsers;
    
    public RegistrationManagedBean() {
        
        Register = new ArrayList<>();
        gUsers = new GenericType<Collection<RegisterMaster>>(){
        };
        }

    public UserSessionBeanLocal getUsb() {
        return usb;
    }

    public void setUsb(UserSessionBeanLocal usb) {
        this.usb = usb;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public RegisterMaster getObj() {
        return obj;
    }

    public void setObj(RegisterMaster obj) {
        this.obj = obj;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public Integer getContact_number() {
        return contact_number;
    }

    public void setContact_number(Integer contact_number) {
        this.contact_number = contact_number;
    }

    public Integer getGrp_id() {
        return grp_id;
    }

    public void setGrp_id(Integer grp_id) {
        this.grp_id = grp_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<RegisterMaster> getRegister() {
        return Register;
    }

    public void setRegister(Collection<RegisterMaster> Register) {
        this.Register = Register;
    }

    public GenericType<Collection<RegisterMaster>> getgUsers() {
        return gUsers;
    }

    public void setgUsers(GenericType<Collection<RegisterMaster>> gUsers) {
        this.gUsers = gUsers;
    }
    
    public String Register(){
        this.usb.Register(username,password,emailid,address,pincode,city,contact_number,date);
        return "Login.html";
    }

}
    

