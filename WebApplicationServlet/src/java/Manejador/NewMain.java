/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angie_
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Clase de Prueba si hacia la conexion.
        ArrayList<Alumnos> lista = new ArrayList<Alumnos>();//Lista de Alumnos.
        MysqlConnection msq = new MysqlConnection();//Conexion con la BD SQL.
        Connection c = msq.conectar();//Conexion.
        ResultSet rs = msq.exQuery(c, "Select * from alumno");//Consulta en la BD.

        try {
            while (rs.next()) {
                //Objeto de clase alumno donde se guarda el objeto con las 2 variables.
                Alumnos alum = new Alumnos(rs.getInt("codi"), rs.getString("nom"));
                lista.add(alum);//Agrega a la lista de alumno.
            }
        } catch (SQLException ex) {//Tratamiento de errores.
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Imprime la lista desde el inicio hasta su ultimo dato.
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }

    }

}
