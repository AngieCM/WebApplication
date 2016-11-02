package Manejador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Angie_
 */
public class MysqlConnection {

    public String bd = "db_data_access";//Nombre de la BD.
    public String login = "root";
    public String password = "";
    public String url = "jdbc:mysql://localhost/" + bd;//Enlace donde se encuentra la BD.

    /**
     * Constructor vacio.
     */
    public MysqlConnection() {

    }

    /**
     * Metodo que me conecta con la BD
     *
     * @return el link
     */
    public Connection conectar() {
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.login, this.password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }

    /**
     * Metodo que con la
     *
     * @param c conexion que ejecuta y
     * @param sql coge un parametro sql.
     * @return
     */
    public ResultSet exQuery(Connection c, String sql) {
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("¡ ExecuteQuery ejecutado !");
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public void closeConnection() {
//        try {
//            conn.close();
//            System.out.println("Conexión cerrada");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Fallo al cerrar la conexión");
//        }
//    }
//     public void connectToAndQueryDatabase(String username, String password) throws SQLException {
//     
//     Connection con = DriverManager.getConnection( "jdbc:myDriver:myDatabase",
//     username, password);
//     
//     Statement stmt = con.createStatement(); ResultSet rs =
//     stmt.executeQuery("SELECT a, b, c FROM Table1");
//     
//     while (rs.next()) { int x = rs.getInt("a"); String s = rs.getString("b");
//     float f = rs.getFloat("c"); } }
//     
//    private Connection conn = null;
//    private String url = "jdbc:mysql://localhost:3306/sql_local001";
//    private String user = "alumno";
//    private String password = "alumno";
//
//    public Connection doConnection() {
//        try {
//            conn = DriverManager.getConnection(url, user, password);
//            if (conn != null) {
//                System.out.println("Conectado a " + conn.toString());
//            }
//            return conn;
//        } catch (SQLException e) {
//            System.out.println("Conexión no válida url, usuario o clave incorrecta ");
//            if (e.Number == 18456) { // invalid login
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public void printRs(ResultSet rs) {
//        try {
//            while (rs.next()) {
//                System.out.println(rs.getString(1)+" - "+ rs.getString(2));
//                System.out.println(rs.getString("codi") + " - " + rs.getString("nom"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void exQueryPS(Connection c, int codi) {
//        try {
//            String query = "SELECT codi,nom FROM alumne WHERE codi=?";
//            PreparedStatement prepstmt = c.prepareStatement(query);
//            prepstmt.setInt(1, codi);
//            ResultSet rs = prepstmt.executeQuery();
//
//            //Can't use ResultSet after close prepared statement, we have to print or fill object here...
//            this.printRs(rs);
//
//            prepstmt.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void exQueryRB(Connection c, String sql1, String sql2) {
//        try {
//            c.setAutoCommit(false);
//            Statement st = c.createStatement();
//            st.executeUpdate(sql1);
//            st.executeUpdate(sql2);
//            c.commit();
//            System.out.println("ExecuteQuery ejecutado.");
//        } catch (SQLException e) {
//            try {
//                c.rollback();
//                System.out.println("Rollback ejecutado.");
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//                System.out.println("Error: Rollback no ejecutado");
//            }
//        }
//    }
}
