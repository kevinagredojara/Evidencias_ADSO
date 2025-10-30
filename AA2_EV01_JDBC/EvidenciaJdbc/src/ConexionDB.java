// Nombramiento de Paquetes (implícito por la carpeta src)

// Importaciones necesarias para JDBC
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Nombramiento de Clases (PascalCase)
public class ConexionDB {

    // --- INICIO DE CAMBIOS ---

    // Constantes (privadas, estáticas, en mayúsculas)
    // Ajuste la URL para usar MySQL y la BD que creó (sen_evidencias)
    private static final String URL = "jdbc:mysql://localhost:3306/sen_evidencias";

    // Use sus credenciales de MySQL (usualmente 'root' en local)
    private static final String USUARIO = "root"; // O su usuario de MySQL local
    private static final String CONTRASENA = "Meta2022"; // Su contraseña de MySQL

    // Nombramiento de Métodos (camelCase)
    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Paso 1: Registrar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Paso 2: Establecer la conexión con MySQL
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver JDBC de MySQL no encontrado.");
            System.err.println("Asegúrese de que el archivo 'mysql-connector-j-....jar' esté en la carpeta 'lib' y añadido a 'Referenced Libraries'.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos MySQL.");
            e.printStackTrace();
        }
        return conexion;
    }
    // --- FIN DE CAMBIOS ---
}