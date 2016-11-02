<%-- 
    Document   : newjsp
    Created on : 26-oct-2016, 21:01:29
    Author     : Angie_
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Manejador.Alumnos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Alumnos aux = (Alumnos) request.getAttribute("aux");%>
<!DOCTYPE html>
<html>
    <%
        ArrayList lista = (ArrayList) request.getAttribute("Arraylist");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page Alumnos</title>
    </head>
    <body>
        <%
            //Alumnos aux;
            //for (int i = 0; i < lista.size(); i++) {
            //        aux = (Alumnos) lista.get(i); %>
        <h1> ---> Nombre Alumno : <%out.print(aux.getNom());%></h1>
        <h2> - Codigo : <%out.print(aux.getCodi());%></h2>
        <p> - Asignaturas : <%out.print(aux.getAsignaturas());%></p>
        <p> - Tutorias : <%out.print(aux.getTutorias());%></p>
    </body>
</html>
