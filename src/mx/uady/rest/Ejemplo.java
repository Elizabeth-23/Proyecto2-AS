/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uady.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author eduardordgz
 */
@Path("/ejemplo")
public class Ejemplo {
    
    @GET
    @Path("/uno")
    public String primerEjemplo() {
        return "DOS";
    }
    @GET
    @Path("/dos")
    public String segundoEjemplo(){
        return "TRES";
    }
    @GET
    @Path("/suma")    
    public int suma(@QueryParam("operador1") int operador1,@QueryParam("operador2")  int operador2){
        
        return operador1 + operador2;
    }
    @GET
    @Path("/resta")    
    public int resta(@QueryParam("operador1") int operador1,@QueryParam("operador2")  int operador2){
        
        return operador1 - operador2;
    }
    @GET
    @Path("/division")    
    public double division(@QueryParam("operador1") double operador1,@QueryParam("operador2")  double operador2){
        
        if (operador2==0) {
            throw new RuntimeException();
        }else{
            return operador1 / operador2;
        }   
    }
    
    
    
}
