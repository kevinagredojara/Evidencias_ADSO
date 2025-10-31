package com.kevinagredo;

// Importamos las clases necesarias, incluyendo List y ArrayList
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    /**
     * 1. CREAR (Inserción)
     * Este método es casi idéntico al anterior. Sigue la HU-ASE-003.
     */
    public void crearPaciente(String documento, String nombre, String telefono) {
        String sqlInsert = "INSERT INTO pacientes_java (numero_documento, nombre_completo, telefono_contacto) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {

            pstmt.setString(1, documento);
            pstmt.setString(2, nombre);
            pstmt.setString(3, telefono);
            pstmt.executeUpdate();
            System.out.println("Paciente creado exitosamente (vía DAO)."); // <--- AVISO EN CONSOLA

        } catch (SQLException e) {
            System.err.println("Error al crear el paciente: " + e.getMessage());
        }
    }

    /**
     * 2. LEER (Consulta) - MODIFICADO
     * Esta es la modificación clave. Ya no imprime en consola.
     * Ahora, crea una LISTA de objetos "Paciente".
     * Esto es lo que el Servlet usará para enviar datos al JSP.
     */
    public List<Paciente> leerTodosLosPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        String sqlSelect = "SELECT * FROM pacientes_java ORDER BY nombre_completo"; // Leemos todos

        try (Connection conn = ConexionDB.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlSelect)) {

            // Iteramos sobre todos los resultados de la base de datos
            while (rs.next()) {
                // Leemos los datos de la fila actual
                int id = rs.getInt("id");
                String documento = rs.getString("numero_documento");
                String nombre = rs.getString("nombre_completo");
                String telefono = rs.getString("telefono_contacto");

                // Creamos un objeto Paciente (el Modelo) con esos datos
                Paciente paciente = new Paciente(id, documento, nombre, telefono);

                // Añadimos el objeto a nuestra lista
                pacientes.add(paciente);
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los pacientes: " + e.getMessage());
        }

        // Devolvemos la lista de pacientes (estará vacía si hay un error o no hay datos)
        return pacientes;
    }

    /**
     * 3. ACTUALIZAR (Actualización)
     * Este método no es requerido por la actividad, pero lo dejamos para integridad.
     * (El método anterior 'actualizarPaciente' sigue siendo válido)
     */
    public void actualizarPaciente(String documento, String nuevoTelefono) {
        String sqlUpdate = "UPDATE pacientes_java SET telefono_contacto = ? WHERE numero_documento = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, nuevoTelefono);
            pstmt.setString(2, documento);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el paciente: " + e.getMessage());
        }
    }

    /**
     * 4. ELIMINAR (Eliminación)
     * Este método no es requerido por la actividad, pero lo dejamos para integridad.
     * (El método anterior 'eliminarPaciente' sigue siendo válido)
     */
    public void eliminarPaciente(String documento) {
        String sqlDelete = "DELETE FROM pacientes_java WHERE numero_documento = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
            pstmt.setString(1, documento);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar el paciente: " + e.getMessage());
        }
    }
}