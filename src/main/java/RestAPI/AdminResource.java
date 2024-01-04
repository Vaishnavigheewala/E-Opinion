/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package RestAPI;

import Admin.AdminSessionBeanLocal;
import ejb.Feedback;
import ejb.RegisterMaster;
import ejb.Survey;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
//import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;


@Path("admin")
//@RequestScoped
public class AdminResource {
    
    @EJB
    AdminSessionBeanLocal asb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdminResource
     */
    public AdminResource() {
    }

    /**
     * Retrieves representation of an instance of RestAPI.AdminResource
     * @return an instance of java.lang.String
     */
    
    //Survey
    @GET
    @Path("findallsurvey")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Survey> findallsurvey() {
        return asb.findallsurvey();
    }
    
    @GET
    @Path("findSurveyBysid/{sid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Survey findSurveyBysid(@PathParam("sid") Integer sid) {
        return asb.findSurveyBysid(sid);
    }

    @POST
    @Path("InsertSurvey/{sname}/{stitle}/{stype}/{s_status}/{stotal}/{date}")
    public void InsertSurvey(@PathParam("sname") String sname, @PathParam("stitle") String stitle,@PathParam("stype") String stype, @PathParam("s_status") String s_status, @PathParam("stotal") Integer stotal, @PathParam("date") Date date ) {
        asb.InsertSurvey(sname, stitle, stype, s_status, stotal, date);
    }
    
    @DELETE
    @Path("DeleteSurvey/{sid}")
    public void DeleteSurvey(@PathParam("sid") Integer sid) {
        asb.DeleteSurvey(sid);
    }

    @PUT
    @Path("UpdateSurveyActive/{sid}/{s_status}")
    public void UpdateSurveyActive(@PathParam("sid") Integer sid, @PathParam("s_status") String s_status) {
        asb.UpdateSurveyActive(sid, s_status);
    }

    @PUT
    @Path("UpdateSurvey/{sname}/{stitle}/{stype}/{sid}")
    public void UpdateSurvey(@PathParam("sname") String sname,@PathParam("stitle") String stitle,@PathParam("stype") String stype, @PathParam("sid") Integer sid) {
        asb.UpdateSurvey(sname,stitle, stype, sid);
    }

    
    //user[AdminSide]
    @GET
    @Path("findalluser")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<RegisterMaster> findalluser() {
        return asb.findalluser();
    }
    
    //Question[AdminSide]
    @POST
    @Path("InsertQuestion/{q_title}/{sname}/{option1}/{option2}/{option3}/{option4}//{option5}{date}")
    public void InsertQuestion(@PathParam("q_title") String q_title, @PathParam("sname") String sname,@PathParam("option1") String option1, @PathParam("option2") String option2, @PathParam("option3") String option3,@PathParam("option4") String option4,@PathParam("option5") String option5, @PathParam("date") Date date ) {
        asb.InsertQuestion(q_title, sname, option1, option2, option3,option4,option5, date);
    }
    
    
    //Feedback
    @GET
    @Path("findallFeedback")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Feedback> findallFeedback() {
        return asb.findallFeedback();
    }
    
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AdminResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
