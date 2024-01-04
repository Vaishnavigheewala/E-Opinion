/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package User;

import ejb.Answer;
import ejb.Feedback;
import ejb.GroupMaster;
import ejb.Question;
import ejb.RegisterMaster;
import ejb.Survey;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hp
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;
    
    
    //Register
    
    @Override
    public void Register(String username, String password, String emailid, String address,Integer pincode, String city, Integer contact_number, Date date) {
        try {
            System.out.println("In Register");
            GroupMaster gm = em.find(GroupMaster.class,2);
            Collection<RegisterMaster> userCollection = gm.getRegisterMasterCollection();
            RegisterMaster user = new RegisterMaster();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmailid(emailid);
            user.setAddress(address);
            user.setPincode(pincode);
            user.setCity(city);
            user.setContactNumber(contact_number);
            user.setDate(date);
            user.setGrpId(gm);
            
            //gm.setGrpName("user");
     
            userCollection.add(user);
            gm.setRegisterMasterCollection(userCollection);
            
            em.persist(user);
            //em.persist(gm);
            
        } catch (Exception e) {
            System.out.println("Error in Register  : "+ e.getMessage());
        }      
    }
    
    //Survey
    @Override
    public Collection<Survey> findallsurvey() {
        return em.createNamedQuery("Survey.findAll").getResultList();
    }
    
    //Question
      @Override
    public void Answer(String emailid, String answer1, String answer2,String answer3, String answer4,String answer5) {
        Answer obj = new Answer();
        obj.setEmailid(emailid);
        obj.setAnswer1(answer1);  
        obj.setAnswer2(answer2);  
        obj.setAnswer3(answer3);  
        obj.setAnswer4(answer4);  
        obj.setAnswer5(answer5);  
        
        //obj.setIsactive("Y");
        em.persist(obj);
    }
    
    public void processSelectedOption(String selectedOption) {
        // Perform actions based on the selected option
        System.out.println("Selected Option: " + selectedOption);
    }
    
    //Feedback
    
    @Override
    public void InsertFeedback(String emailid, String f_text, String username) {
        Feedback obj = new Feedback();
        obj.setEmailid(emailid);
        obj.setFText(f_text);  
        obj.setUsername(username);
        
        //obj.setIsactive("Y");
        em.persist(obj);
    }

}
