/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite_cod;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author slorenzorodriguez
 */
public class Delete {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/Doctor Mantequilla/Documents/NetBeansProjects/test2.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Borrar un alumno de la tabla especificando su id
     *
     * @param id
     */
    public boolean delete(int id) {
        boolean dTable = false;
        String sql = "DELETE FROM alumnos WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // establecer los parametros
            pstmt.setInt(1, id);
            // ejecutar la consulta delete
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos eliminados con éxito");
            dTable = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "El id no exste o no tiene el formato adecuado, debe ser un int");
            dTable = false;

        }
        return dTable;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Delete app = new Delete();
        // borrar una linea estableciendo su id, en este caso el 3
        app.delete(3);

    }

}
