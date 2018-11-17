/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uady.rest;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 *
 * @author eduardordgz
 */
public class Main {

    public static void main(String[] args) throws UnknownHostException {
        
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        InetAddress inet = InetAddress.getByName("localhost");
        InetSocketAddress adress = new InetSocketAddress(inet, 9000);
        Server server = new Server(adress);
        
        server.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
//        jerseyServlet.setInitParameter(
//                "jersey.config.server.provider.classnames",
//                Ejemplo.class.getCanonicalName());
        /*jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                AlumnoServicio.class.getCanonicalName());*/
        
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                ProfesorServicio.class.getCanonicalName() + "," + AlumnoServicio.class.getCanonicalName() + "," + TutoriaServicio.class.getCanonicalName());
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Error!");
            server.destroy();
            
        }
        

    }

}
