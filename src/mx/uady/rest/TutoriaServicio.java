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
import static mx.uady.rest.AlumnoServicio.alumnos;
import static mx.uady.rest.ProfesorServicio.profesores;

/**
 *
 * @author ER
 */
@Path ("/tutorias")
public class TutoriaServicio {
    
    ProfesorServicio profesor = new ProfesorServicio();
    AlumnoServicio alumno = new AlumnoServicio();
    Profesor pro = new Profesor();
    Alumno alu = new Alumno();
    
    //String idProfesor = profesor.getId();
    //String matriculaAlumno = alumno.getMatricula();
    
    private static HashMap<String,Tutoria> tutorias = new HashMap<>();
    
    Date date = new Date();
    DateFormat hourdateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String variable = hourdateFormat.format(date);
    
    @GET
    @Path("/listar")
    public HashMap<String,Tutoria> listar() throws IOException{
        Logger info = Logger.getInstance(variable, "INFO");
        Logger listar = Logger.getInstance(variable, "Listar Tutorias");
        Archivo guardar = new Archivo();
        guardar.guardarArchivo(Logger.logger);
        
        return tutorias;
    }
    
    @GET
    @Path("/crear") 
    public Tutoria crearTutoria(
            @QueryParam("idprofesor") String idProfesor,
            @QueryParam("matricula") String matriculaAlumno,
            @QueryParam("diatutoria") String diaTutoria) throws IOException{
        
       
        Tutoria tutoria = new Tutoria();    
    
        if (tutorias.containsKey(diaTutoria)) {
            Logger error = Logger.getInstance(variable, "ERROR");
            Archivo guardar = new Archivo();
            guardar.guardarArchivo(Logger.logger);
            throw new RuntimeException("La tutoria ya esta registrada");
        }
     
        
        else{
            if(tutorias.containsKey(diaTutoria.equals("sabado")) ||tutorias.containsKey(diaTutoria.equals("domingo"))){
                System.out.println("Ese dia no esta disponible");
            
            }
            if (profesores.containsKey(idProfesor)) {
                Logger debug = Logger.getInstance(variable, "DEBUG");
                Archivo guardar = new Archivo();
                guardar.guardarArchivo(Logger.logger);
                //throw new RuntimeException("El ID del profesor si esta registrada");
                if (alumnos.containsKey(matriculaAlumno)) {
                    Logger debug1 = Logger.getInstance(variable, "DEBUG");
                    Archivo guardar1 = new Archivo();
                    guardar1.guardarArchivo(Logger.logger);
                    
                    tutoria.setDiaTutoria(diaTutoria);
                    tutoria.setIdProfesor(idProfesor);
                    tutoria.setMatriculaAlumno(matriculaAlumno);
                    Logger info = Logger.getInstance(variable, "INFO");
                    Logger crear = Logger.getInstance(variable, "Crear Tutoria");
                    Archivo guardar2 = new Archivo();
                    guardar2.guardarArchivo(Logger.logger);

                    tutorias.put(diaTutoria, tutoria);
                    //throw new RuntimeException("La matricula si esta registrada");
  
                }
                else{
                    System.out.println("La matricula del alumno no existe!");
                    Logger error1 = Logger.getInstance(variable, "ERROR");
                    Archivo guardar2 = new Archivo();
                    guardar2.guardarArchivo(Logger.logger);


                }  
                    
            }
            else{
                System.out.println("El Id del profesor no existe!");
                Logger error = Logger.getInstance(variable, "ERROR");
                Archivo guardar3 = new Archivo();
                guardar3.guardarArchivo(Logger.logger);
            }    
                        
        }
                
        return tutoria;
    }
    
    @GET
    @Path("/eliminar")
    public String eliminarTutoria(@QueryParam("diatutoria") String diaTutoria) throws IOException{
        
        if (!tutorias.containsKey(diaTutoria)) {
            Logger error = Logger.getInstance(variable, "ERROR");
            Archivo guardar = new Archivo();
            guardar.guardarArchivo(Logger.logger);
            return "No existe la tutoria";
        }
        
        tutorias.remove(diaTutoria);
        Logger info = Logger.getInstance(variable, "INFO");
        Logger eliminar = Logger.getInstance(variable, "Eliminar Tutoria");
        Archivo guardar = new Archivo();
        guardar.guardarArchivo(Logger.logger);
        return "Se elimino la tutoria";
    }
    
}