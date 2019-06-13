/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite_cod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author slorenzorodriguez
 */
public class Connect {

    /**
     * @param args the command line arguments
     */

 public static boolean connect() {
        boolean cConn = false;
        
        Connection conn = null;
        try {
            // establecemos parámetros de la base de datos
            String url = "jdbc:sqlite:C:/Users/Doctor Mantequilla/Documents/NetBeansProjects/cod.db";
            // creamos la conexion a la base 
            conn = DriverManager.getConnection(url);

            JOptionPane.showMessageDialog(null, "Se ha establecido la conexión de SQLite");
            cConn = true;
        } catch (SQLException e) {
            

            JOptionPane.showMessageDialog(null, "Imposible establecer conexión");
           cConn = false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                   
                }
            } catch (SQLException ex) {
               
               JOptionPane.showMessageDialog(null, "Error en la conexión");
               cConn = false;
               
            }
        }
        return cConn;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}


