package com.kevinagredo.agendamiento_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Esta clase es el CONTROLADOR (reemplaza al Servlet).
 * Maneja las peticiones del navegador y las conecta con las Vistas.
 */
@Controller // 1. Le dice a Spring que esta clase maneja tráfico web
public class PacienteController {

    // 2. Inyección de Dependencias: Spring nos "inyecta" automáticamente
    // una instancia de nuestro Repositorio.
    @Autowired
    private PacienteRepository pacienteRepository;

    /**
     * 3. Manejador GET (reemplaza a doGet)
     * Se ejecuta cuando alguien visita la página principal ("/")
     * * @param model Es un objeto que Spring nos da para pasar datos a la vista
     * @return El nombre del archivo HTML (la plantilla) que se debe mostrar
     */
    @GetMapping("/")
    public String verPaginaDeInicio(Model model) {

        // 4. Pedimos al repositorio TODOS los pacientes (reemplaza a leerTodosLosPacientes())
        model.addAttribute("listaPacientes", pacienteRepository.findAll());

        // 5. Añadimos un objeto Paciente vacío para que el formulario lo llene
        model.addAttribute("paciente", new Paciente());

        // 6. Le decimos que renderice el archivo "gestionPacientes.html"
        return "gestionPacientes";
    }

    /**
     * 7. Manejador POST (reemplaza a doPost)
     * Se ejecuta cuando el formulario HTML envía datos a "/registrar"
     * * @param paciente Spring automáticamente toma los datos del formulario
     * y los convierte en un objeto Paciente.
     * @return Una redirección a la página principal.
     */
    @PostMapping("/registrar")
    public String registrarNuevoPaciente(@ModelAttribute Paciente paciente) {

        // 8. Le decimos al repositorio que guarde el objeto Paciente (reemplaza a crearPaciente())
        pacienteRepository.save(paciente);

        // 9. Redireccionamos a la raíz ("/"). Esto ejecuta el método verPaginaDeInicio() de nuevo.
        return "redirect:/";
    }
}