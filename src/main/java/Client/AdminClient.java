/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package Client;

import java.util.Date;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.ejb;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        AdminClient client = new AdminClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Hp
 */
public class AdminClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/E-Opinion/resources";

    public AdminClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("admin");
    }

    //Survey
    public <T> T findallsurvey(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findallsurvey");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T findSurveyBysid(Class<T> responseType, String sid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findSurveyBysid/{0}", new Object[]{sid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    public void InsertSurvey(String sname, String stitle, String stype, String s_status, Integer stotal, Date date) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertDepartment/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{sname, stitle, stype, s_status, stotal, date})).request().post(null);
    }
    
    public void DeleteSurvey(String sid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteSurvey/{0}", new Object[]{sid})).request().delete();
    }
    
    public void UpdateSurveyActive(String sid, String s_status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateDepartmentActive/{0}/{1}", new Object[]{sid, s_status})).request().put(null);
    }

    public void UpdateSurvey(String sid, String sname, String stitle, String stype) throws ClientErrorException {
        Entity<?> empty = Entity.text("");
        webTarget.path(java.text.MessageFormat.format("UpdateSurvey/{0}/{1}/{2}/{3}", new Object[]{sid, sname, stitle, stype})).request().put(empty);
    }

    
    public String getHtml() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public void putHtml(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.TEXT_HTML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_HTML));
    }

    public void close() {
        client.close();
    }
    
}
