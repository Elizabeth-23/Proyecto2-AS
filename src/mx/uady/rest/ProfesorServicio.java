/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uady.rest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author a16016773
 */
@Path ("/profesores")
public class ProfesorServicio {
    
    public static HashMap<String,Profesor> profesores = new HashMap<>();
    Date date = new Date();
    DateFormat hourdateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String variable = hourdateFormat.format(date);
    
    @GET
    @Path("/listar")
    public HashMap<String,Profesor> listar() throws IOException{
        
        Logger info = Logger.getInstance(variable, "INFO");
        Logger listar = Logger.getInstance(variable, "Listar Profesores");
        Archivo guardar = new Archivo();
        guardar.guardarArchivo(Logger.logger);
        
        return profesores;
    }
    
    @GET
    @Path("/crear") 
    public Profesor crearProfesor(
            @QueryParam("identificador") String id,
            @QueryParam("nombre") String nombre,
            @QueryParam("horastrabajadas") int horasTrabajadas) throws IOException{
        
        Profesor profesor = new Profesor();
        //Se verifica que no eexista la misma matricula
        if (profesores.containsKey(id)) {
            Logger error = Logger.getInstance(variable, "ERROR");
            Archivo guardar = new Archivo();
            guardar.guardarArchivo(Logger.logger);
            throw new RuntimeException("La matricula ya esta registrada");
                        
        }
        else{
            //La longitud debe ser menos o igual a 10 caracteres
            if (id.length() <= 10) {
                System.out.println("El identificador ingresado es correcta");
                Logger debug = Logger.getInstance(variable, "DEBUG");
                Archivo guardar = new Archivo();
                guardar.guardarArchivo(Logger.logger);
                
                //Las horas trabajadas deben de ser mayor o igual a 0
                if (horasTrabajadas >= 0) {
                    System.out.println("El numero de horas trabajadas es correcto.");
                    Logger debug1 = Logger.getInstance(variable, "DEBUG");
                    Archivo guardar1 = new Archivo();
                    guardar1.guardarArchivo(Logger.logger);
                    
                    //Se guardan los valores ingresados del profesor
                    profesor.setId(id);
                    profesor.setNombre(nombre);
                    profesor.setHorasTrabajadas(horasTrabajadas);

                    Logger info = Logger.getInstance(variable, "INFO");
                    Logger crear = Logger.getInstance(variable, "Crear Profesor");
                    Archivo guardar2 = new Archivo();
                    guardar2.guardarArchivo(Logger.logger);

                    profesores.put(id, profesor);
                                        
                }
                else{
                    System.out.println("El número de horas trabajadas debe ser mayor o igual a 0.");
                    Logger error = Logger.getInstance(variable, "ERROR");
                    Archivo guardar3 = new Archivo();
                    guardar3.guardarArchivo(Logger.logger);
                }
            }else{
                System.out.println("El identificador debe ser de maximo 10 caracteres.");
                Logger error = Logger.getInstance(variable, "ERROR");
                Archivo guardar = new Archivo();
                guardar.guardarArchivo(Logger.logger);
            }
        
        }
        return profesor;
    }
    
    @GET
    @Path("/eliminar")
    public String eliminarProfesor(@QueryParam("identificador") String id) throws IOException{
        
        if (!profesores.containsKey(id)) {
            Logger error = Logger.getInstance(variable, "ERROR");
            Archivo guardar = new Archivo();
            guardar.guardarArchivo(Logger.logger);
            return "no existe matricula";
            
        }
        
        profesores.remove(id);
        Logger info = Logger.getInstance(variable, "INFO");
        Logger eliminar = Logger.getInstance(variable, "Eliminar Profesor");
        Archivo guardar = new Archivo();
        guardar.guardarArchivo(Logger.logger);
        return "Se elimino profesor";
    }
}
