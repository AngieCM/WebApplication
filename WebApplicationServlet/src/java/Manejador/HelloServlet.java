/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angie_
 */
@WebServlet(name = "HelloServlet", urlPatterns = {"/HelloServlet"})
public class HelloServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");//Acentos.
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        ArrayList<Alumnos> lista = new ArrayList<Alumnos>();//Lista Alumnos.
        MysqlConnection msq = new MysqlConnection();//Conexion con BD SQL.
        Connection c = msq.conectar();//Conexion.
        ResultSet rs = msq.exQuery(c, "Select * from alumno");//Consulta a la BD.

        try {
            //Mientras hace la consulta en la BD, va creando un objeto Alumno con sus respectivas variables.
            while (rs.next()) {
                Alumnos alum = new Alumnos(rs.getInt("codi"), rs.getString("nom"));
                lista.add(alum);//Agrega a la lista de Alumnos.
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("Arraylist", (ArrayList) lista);//Solicita la edicion del Arraylist de Alumno.
        RequestDispatcher a = request.getRequestDispatcher("/index.jsp");//Solicitud desde .jsp
        a.forward(request, response);//Al coger la solicitud da la respuesta.
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");//Trata los caracteres con acentos.
        //Variable codigo parseada como String recogida con el parametro "seleccion" del documento index.jsp 
        String codigo = (String) request.getParameter("seleccion");
        MysqlConnection msq = new MysqlConnection();//Conexion a BD.
        Connection c = msq.conectar();//Conexion.
        //Consulta con Inner Join para juntar todos los datos del alumno que estan en cada tabla. 
        ResultSet rs = msq.exQuery(c, "SELECT alumno.nom as nomAlumno, asignatura.nom as nomAsig, tutoria.nom as nomTuto from alumno"
                + " inner JOIN tutoriaalumno on tutoriaalumno.codiAlumno=alumno.codi "
                + "inner join tutoria on tutoria.codi=tutoriaalumno.codiTutoria "
                + "inner JOIN asignatura on asignatura.codi=tutoria.codiAsignatura "
                + "WHERE alumno.codi=" + codigo );

        try {
            Alumnos alumn = new Alumnos();//Creo un objeto tipo Alumnos

            //Mientras va buscando el codigo de la consulta, enseña los datos del alumno.
            while (rs.next()) {
                alumn.setNom(rs.getString("nomAlumno"));
                alumn.setCodi(Integer.parseInt(codigo));
                alumn.setAsignaturas(rs.getString("nomAsig"));
                alumn.setTutorias(rs.getString("nomTuto"));
            }

            request.setAttribute("aux", alumn);//Solicita la edicion del aux de Alumno.
            RequestDispatcher a = request.getRequestDispatcher("/newjsp.jsp");//Solicitud del .jsp
            a.forward(request, response);//Al coger la solicitud da la respuesta.

//            PrintWriter out = response.getWriter();//Imprime lo que recoge como respuesta.
//            try {
//                //Resultado de la pagina final al seleccionar un alumno especifico en el formulario.
//                out.println("<!DOCTYPE html>");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title> --* Alumnos *-- </title>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println("<h1> ---> Nombre Alumno : " + alumn.getNom() + "</h1>");//Obtengo el nombre.
//                out.println("<h2> - Codigo : " + alumn.getCodi() + "</h2>");//Obtengo el codigo.
//                out.println("<p> - Asignaturas : " + alumn.getAsignaturas() + "</p>");//Obtengo la asignatura.
//                out.println("<p> - Tutorias : " + alumn.getTutorias() + "</p>");//Obtengo las tutorias.
//                out.println("</body>");
//                out.println("</html>");
//            } finally {
//                out.close();
//            }
        } catch (SQLException ex) {
            Logger.getLogger(HelloServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
