import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// El nombre de la clase "PacienteDAO" debe coincidir exactamente con el nombre del archivo
public class PacienteDAO {

    /**
     * 1. CREAR (Inserción)
     */
    public void crearPaciente(String documento, String nombre, String telefono) {
        String sqlInsert = "INSERT INTO pacientes_java (numero_documento, nombre_completo, telefono_contacto) VALUES (?, ?, ?)";

        // try-with-resources
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {

            pstmt.setString(1, documento);
            pstmt.setString(2, nombre);
            pstmt.setString(3, telefono);

            pstmt.executeUpdate();
            System.out.println("Paciente creado exitosamente.");

        } catch (SQLException e) {
            System.err.println("Error al crear el paciente: " + e.getMessage());
        }
    }

    /**
     * 2. LEER (Consulta)
     */
    public void leerPaciente(String documento) {
        String sqlSelect = "SELECT * FROM pacientes_java WHERE numero_documento = ?";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sqlSelect)) {

            pstmt.setString(1, documento);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Paciente encontrado:");
                    System.out.println("  ID: " + rs.getInt("id"));
                    System.out.println("  Documento: " + rs.getString("numero_documento"));
                    System.out.println("  Nombre: " + rs.getString("nombre_completo"));
                    System.out.println("  Teléfono: " + rs.getString("telefono_contacto"));
                } else {
                    System.out.println("No se encontró paciente con el documento: " + documento);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al leer el paciente: " + e.getMessage());
        }
    }

    /**
     * 3. ACTUALIZAR (Actualización)
     */
    public void actualizarPaciente(String documento, String nuevoTelefono) {
        String sqlUpdate = "UPDATE pacientes_java SET telefono_contacto = ? WHERE numero_documento = ?";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

            pstmt.setString(1, nuevoTelefono);
            pstmt.setString(2, documento);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Teléfono del paciente " + documento + " actualizado exitosamente.");
            } else {
                System.out.println("No se encontró paciente para actualizar.");
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar el paciente: " + e.getMessage());
        }
    }

    /**
     * 4. ELIMINAR (Eliminación)
     */
    public void eliminarPaciente(String documento) {
        String sqlDelete = "DELETE FROM pacientes_java WHERE numero_documento = ?";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {

            pstmt.setString(1, documento);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Paciente " + documento + " eliminado exitosamente.");
            } else {
                System.out.println("No se encontró paciente para eliminar.");
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar el paciente: " + e.getMessage());
        }
    }
}