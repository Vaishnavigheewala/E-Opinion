/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package User;

import ejb.Question;
import ejb.RegisterMaster;
import ejb.Survey;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Hp
 */
@Local
public interface UserSessionBeanLocal {

    public Collection<Survey> findallsurvey();   

    public void InsertFeedback(String emailid, String f_text, String username);

    public void Register(String username, String password, String emailid, String address, Integer pincode, String city, Integer contact_number, Date date);

    public void Answer(String emailid, String answer1, String answer2, String answer3, String answer4, String answer5);

    public void processSelectedOption(String selectedOption);

   
}
