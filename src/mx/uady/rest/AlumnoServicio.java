/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uady.rest;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author a16016773
 */
@Path ("/alumnos")
public class AlumnoServicio {
    
    static HashMap<String,Alumno> alumnos = new HashMap<>();
    Date date = new Date();
    DateFormat hourdateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String variable = hourdateFormat.format(date);
    
    @GET
    @Path("/listar")
    public HashMap<String,Alumno> listar() throws IOException{
        
        Logger info = Logger.getInstance(variable, "INFO");
        Logger listar = Logger.getInstance(variable, "Listar Alumnos");
        Archivo guardar = new Archivo();
        guardar.guardarArchivo(Logger.logger);
        return alumnos;
    }
    
    @GET
    @Path("/crear") 
    public Alumno crearAlumno(
            @QueryParam("matricula") String matricula,
            @QueryParam("nombre") String nombre,
            @QueryParam("promedio") double promedio) throws IOException{
        
        Alumno alumno = new Alumno();        
        //No aceptar matrículas repetidas.
        if (alumnos.containsKey(matricula)) {
            Logger error = Logger.getInstance(variable, "ERROR");
            Archivo guardar = new Archivo();
            guardar.guardarArchivo(Logger.logger);
            throw new RuntimeException("La matricula ya esta registrada");
        }
        else{
            //MATRICULA - String (MAx. 10 caracteres)
            if (matricula.length() <= 10) {
            
            System.out.println("La matrícula ingresada es correcta");
            Logger debug = Logger.getInstance(variable, "DEBUG");
            Archivo guardar = new Archivo();
            guardar.guardarArchivo(Logger.logger);
            //El promedio debe de ser menor o igual que 100 y mayor que 0
            if (promedio > 0 && promedio <= 100) {
                System.out.println("El promedio ingresado es correcto.");
                Logger debug1 = Logger.getInstance(variable, "DEBUG");
                Archivo guardar1 = new Archivo();
                guardar1.guardarArchivo(Logger.logger);
                
                //Se guardan los valores de los alumnos
                alumno.setMatricula(matricula);
                alumno.setNombre(nombre);
                alumno.setPromedio(promedio);
                Logger info = Logger.getInstance(variable, "INFO");
                Logger crear = Logger.getInstance(variable, "Crear Alumno");
                Archivo guardar2 = new Archivo();
                guardar2.guardarArchivo(Logger.logger);

                alumnos.put(matricula,alumno);               
                
            }           
            else{
                System.out.println("El promedio debe ser mayor a 0 y menor que 100.");
                Logger error = Logger.getInstance(variable, "ERROR");
                Archivo guardar3 = new Archivo();
                guardar3.guardarArchivo(Logger.logger);
        
            }            
        }else{
            System.out.println("El numero de caracteres de la matricula debe ser de maximo 10 caracteres.");
           
            Logger error = Logger.getInstance(variable, "ERROR");
            Archivo guardar = new Archivo();
            guardar.guardarArchivo(Logger.logger);
        }
    }   
        
        return alumno;
    }
    
    @GET
    @Path("/eliminar")
    public String eliminarAlumno(@QueryParam("matricula") String matricula) throws IOException{
        
        if (!alumnos.containsKey(matricula)) {
            Logger error = Logger.getInstance(variable, "ERROR");
            Archivo guardar = new Archivo();
            guardar.guardarArchivo(Logger.logger);
            return "no existe matricula";
        }
        
        alumnos.remove(matricula);
        Logger info = Logger.getInstance(variable, "INFO");
        Logger eliminar = Logger.getInstance(variable, "Eliminar Alumno");
        Archivo guardar = new Archivo();
        guardar.guardarArchivo(Logger.logger);
        return "Se elimino alumno";
        
    }
    
}
