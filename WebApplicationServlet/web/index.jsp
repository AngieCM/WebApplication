<%-- 
    Document   : index
    Created on : 26-oct-2016, 13:54:04
    Author     : Angie_
--%>

<%@page import="Manejador.Alumnos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        ArrayList lista = (ArrayList) request.getAttribute("Arraylist");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>*-- ¡ Hello Alumnos ! --*</h1>

        <form method="POST" action="" >    
            <select id="seleccion" name="seleccion">

                <%
                    Alumnos aux;
                    for (int i = 0; i < lista.size(); i++) {
                        aux = (Alumnos) lista.get(i);
                %> <option value="<%=aux.getCodi()%>">   <%
                    out.println(lista.get(i).toString());%> </option>
                    <%    }
                    %> 
                <input type="submit" value="Enviar" />
            </select></form>

    </body>
</html>
