/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package RestAPI;

import User.UserSessionBeanLocal;
import ejb.Question;
import ejb.Survey;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Hp
 */
@Path("user")
@RequestScoped
public class UserResource {

    @Context
    private UriInfo context;
    
        @EJB UserSessionBeanLocal usb;


    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }
    
    @POST
    @Path("Register/{username}/{password}/{emailid}/{address}/{pincode}/{city}/{contact_number}/{date}")
    public void Register(@PathParam("username") String username, @PathParam("password") String password,@PathParam("emailid") String emailid,@PathParam("address") String address,@PathParam("pincode") Integer pincode,@PathParam("city") String city,@PathParam("contact_number") Integer contact_number,@PathParam("date") Date date ) {
        usb.Register(username,password,emailid,address,pincode,city,contact_number,date);
    }
    
    @GET
    @Path("findallsurvey")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Survey> findallsurvey() {
        return usb.findallsurvey();
    }
    
    
    //Feedback
    
    @POST
    @Path("InsertFeedback/{emailid}/{f_text}/{username}")
    public void InsertFeedback(@PathParam("emailid") String emailid, @PathParam("f_text") String f_text,@PathParam("username") String username ) {
        usb.InsertFeedback(emailid, f_text, username);
    }
    

    /**
     * Retrieves representation of an instance of RestAPI.UserResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UserResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
