/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uady.rest;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ER
 */
public class Logger {
    
    public static ArrayList<String> logger = new ArrayList<>();
    
    private static Logger instance ;
    
    public static Logger getInstance(String variable, String opcion) throws IOException{
        if (instance == null) {
            instance = new Logger();
            String dato1 = "[" + variable + "]" + ": " + " Creando Movimiento... ";
            System.out.println(dato1);
            logger.add(dato1);
            String dato2 = "[" + variable + "]" + ": " + instance.msg(opcion);
            System.out.println(dato2);
            logger.add(dato2);
        } else {
            String dato3 = "[" + variable + "]" + ": " + " - Movimiento Existente! -";
            System.out.println(dato3);
            logger.add(dato3);
            String dato4 = "[" + variable + "]" + ": " + instance.msg(opcion);
            System.out.println(dato4);
            logger.add(dato4);
        }
        
        return instance;        
    }
    
    private String msg(String opcion) {
        String mensaje = "";
        switch (opcion) {
            case "DEBUG":
               mensaje = debug();
               break;
           
            case "INFO":
               mensaje = info();
               break;
           
            case "ERROR":
               mensaje = error();
               break;
            case "Crear Alumno":
                mensaje = crearAlumno();
                break;
                
            case "Eliminar Alumno":
                mensaje = eliminarAlumno();
                break;
                
            case "Crear Profesor":
                mensaje = crearProfesor();
                break;
            case "Eliminar Profesor":
                mensaje = eliminarProfesor();
                break;
                
            case "Listar Alumnos":
                mensaje = listarAlumnos();
                break;
                
            case "Listar Profesores":
                mensaje = listarProfesores();
                break;
            
            case "Crear Tutoria":
                mensaje = crearTutoria();
                break;
            
            case "Eliminar Tutoria":
                mensaje = eliminarTutoria();
                break;
                
             case "Listar Tutorias":
                mensaje = listarTutorias();
                break;
        }
        return mensaje;
   }
    //DEBUG
    private String debug(){
        String mensaje = "DEBUG: Se ha ejecutado una operacion... ";
        return mensaje;
    }   
    //INFO
    private String info(){
        String mensaje = "INFO: Se ha ejecutado un metodo en el sistema... ";
        return mensaje;
    }    
    //ERROR
    public String error (){
        String mensaje = "ERROR: Ha ocurrido un error en el sistema! ";
        return mensaje;
    }
    
    public String crearAlumno(){
        String mensaje = "Metodo Crear Alumno.";
        return mensaje;
    
    }
    
    public String eliminarAlumno(){
        String mensaje = "Metodo Eliminar Alumno.";
        return mensaje;
    
    }
    
    public String crearProfesor(){
        String mensaje = "Metodo Crear Profesor.";
        return mensaje;
    
    }
    
    public String eliminarProfesor(){
        String mensaje = "Metodo Eliminar Profesor.";
        return mensaje;
    
    }
    
    public String listarAlumnos(){
        String mensaje = "Metodo Listar Alumnos.";
        return mensaje;
    
    }
    
    public String listarProfesores(){
        String mensaje = "Metodo Listar Profesores.";
        return mensaje;
    
    }
    
    public String crearTutoria(){
        String mensaje = "Metodo Crear Tutoria.";
        return mensaje;
    
    }
    
    public String eliminarTutoria(){
        String mensaje = "Metodo Eliminar Tutoria.";
        return mensaje;
    
    }
    
    public String listarTutorias(){
        String mensaje = "Metodo Listar Tutorias.";
        return mensaje;
    
    }
}