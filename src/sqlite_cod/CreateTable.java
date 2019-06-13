/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite_cod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author slorenzorodriguez
 */
public class CreateTable {

    /**
     * Crear nueva tabla en la base de datos
     *
     */
    public static boolean createNewTable() {
        boolean newtable = false;
// Parametros de conexión;

        String url = "jdbc:sqlite:C:/Users/Doctor Mantequilla/Documents/NetBeansProjects/test2.db";

        // Consulta sql para crear una tabla; le damos los parametros que queramos que tenga.
        String sql = "CREATE TABLE IF NOT EXISTS alumnos (\n"
                + "	id integer PRIMARY KEY,\n" //asiganada id como PRIMARY KEY
                + "	nombre text NOT NULL,\n"
                + "	apellido text NOT NULL,\n"
                + "	telefono integer \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // crear nueva tabla
            stmt.execute(sql);
            newtable = true;
            JOptionPane.showMessageDialog(null, "Nueva tabla creada con éxito.");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al crear nueva tabla");
            newtable = false;
        }
        return newtable;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }

}
