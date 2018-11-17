/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uady.rest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ER
 */
public class Archivo {
    
    public void guardarArchivo(ArrayList logger) throws IOException {
        String ruta = "C:\\Users\\A16016772\\Documents\\NetBeansProjects\\Proyecto 2\\RESTejemplo\\Arquitectura de Software - Proyecto 2\\Logger.txt\\";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            for (Object dato : logger) {
                bw.write((String) dato);
                bw.newLine();
            }
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            for (Object dato : logger) {
                bw.write((String) dato);
                bw.newLine();
            }
        }
        bw.close();
    }
    
}
