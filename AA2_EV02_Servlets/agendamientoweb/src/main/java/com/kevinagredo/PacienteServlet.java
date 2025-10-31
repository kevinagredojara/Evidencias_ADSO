package com.kevinagredo; // Pertenece al mismo paquete que el DAO y Modelo

// Importaciones de Java (backend)
import java.io.IOException;
import java.util.List;

// Importaciones de Servlets (Jakarta)
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet; // <-- Anotación moderna
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * PASO 4.2.A (Indicador 1: Servlet):
 * Esta clase es el Servlet. La anotación @WebServlet le dice al servidor 
 * que cualquier petición a la URL "/pacientes" debe ser manejada por esta clase.
 * Esta es la URL que usamos en el 'action' del formulario HTML.
 */
@WebServlet("/pacientes")
public class PacienteServlet extends HttpServlet {

    // Creamos una instancia de nuestro DAO de la Fase 3.
    private PacienteDAO pacienteDAO;

    // El método init() se llama una vez cuando el servlet se carga
    public void init() {
        pacienteDAO = new PacienteDAO();
    }

    /**
     * PASO 4.2.B (Indicador 2: Método POST):
     * Este método se ejecuta cuando el formulario de 'gestionPacientes.jsp'
     * envía datos (method="POST").
     * Su trabajo es RECIBIR datos y CREAR un paciente.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Leer los parámetros del formulario HTML
        // Los nombres ("nombre_completo", "numero_documento") deben coincidir
        // con los atributos 'name' del formulario.
        String nombre = request.getParameter("nombre_completo");
        String documento = request.getParameter("numero_documento");
        String telefono = request.getParameter("telefono_contacto");

        // 2. Llamar al DAO (Fase 3) para crear el paciente
        pacienteDAO.crearPaciente(nombre, documento, telefono);

        // 3. Redireccionar (Patrón PRG: Post-Redirect-Get)
        // Esto es crucial: le decimos al navegador "Buen trabajo, ahora
        // simplemente vuelve a cargar la página /pacientes".
        // El navegador hará una nueva petición GET, que será manejada por doGet().
        response.sendRedirect("pacientes");
    }

    /**
     * PASO 4.2.C (Indicador 2: Método GET):
     * Este método se ejecuta cuando:
     * 1. El usuario visita la URL /pacientes por primera vez.
     * 2. El método doPost() redirecciona a esta URL.
     * Su trabajo es LEER datos y MOSTRAR la página JSP.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Llamar al DAO (Fase 3) para obtener la lista de TODOS los pacientes
        List<Paciente> listaPacientes = pacienteDAO.leerTodosLosPacientes();

        // 2. "Poner" la lista en la petición.
        // Esto la hace disponible para que el archivo JSP la pueda leer.
        request.setAttribute("listaPacientes", listaPacientes);

        // 3. Reenviar (Forward) la petición al archivo JSP
        // Esto "pega" los datos de la lista en el archivo JSP y lo
        // envía al navegador del usuario como una sola página HTML.
        request.getRequestDispatcher("gestionPacientes.jsp").forward(request, response);
    }
}