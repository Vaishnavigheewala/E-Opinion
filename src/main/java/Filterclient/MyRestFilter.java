package Filterclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author root
 */
import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import jwtrest.TokenProvider;
import record.KeepRecord;



//@Secured

//@WebFilter(filterName = "AuthenticationFilter", urlPatterns = { "/webresources/*" })
@Provider
@PreMatching
public class MyRestFilter implements ClientRequestFilter {
    public static String mytoken;
   // @Inject KeepRecord keepRecord;
    
    public MyRestFilter() {      
       // mytoken = token;
     }
 
    @Override
     public void filter(ClientRequestContext requestContext) throws IOException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
             System.out.println(" In form Auth Client Filter "+ mytoken);
      
       
           requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION,"Bearer "+ KeepRecord.getToken());
      
     // System.out.println(" After cookie header Auth Client Filter "+ mytoken);
   
    }

    
}