package com.kevinagredo.agendamiento_spring; // Aseguramos el paquete correcto

// IMPORTS NUEVOS (AÑADIDOS PARA AA3-EV02)
import jakarta.validation.Valid; // Habilita la validación
import org.springframework.validation.BindingResult; // Recoge los errores

// Imports existentes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Esta clase es el CONTROLADOR (reemplaza al Servlet).
 * Maneja las peticiones del navegador y las conecta con las Vistas.
 * (Indicador 3 y 4: Estándar de codificación y comentarios)
 */
@Controller
public class PacienteController {

    // Inyección de Dependencias: Spring nos "inyecta" el Repositorio
    @Autowired
    private PacienteRepository pacienteRepository;

    /**
     * Manejador GET (reemplaza a doGet)
     * Se ejecuta cuando alguien visita la página principal ("/")
     * Su trabajo es mostrar la página y la lista de pacientes existentes.
     */
    @GetMapping("/")
    public String verPaginaDeInicio(Model model) {
        
        // 1. Obtenemos todos los pacientes de la BD
        model.addAttribute("listaPacientes", pacienteRepository.findAll());
        
        // 2. Añadimos un objeto Paciente vacío para que el formulario lo llene
        model.addAttribute("paciente", new Paciente());
        
        // 3. Renderiza el archivo "gestionPacientes.html"
        return "gestionPacientes";
    }

    /**
     * Manejador POST (reemplaza a doPost)
     * MODIFICADO PARA VALIDAR (REQUISITO AA3-EV02)
     * Se ejecuta cuando el formulario HTML envía datos a "/registrar"
     */
    @PostMapping("/registrar")
    public String registrarNuevoPaciente(
            @Valid @ModelAttribute("paciente") Paciente paciente, // 1. @Valid activa la validación
            BindingResult bindingResult, // 2. Objeto que recibe los errores (si los hay)
            Model model) { // 3. Modelo para devolver datos si hay error
        
        // 4. Verificamos si hubo errores de validación (definidos en Paciente.java)
        if (bindingResult.hasErrors()) {
            // SI HAY ERRORES:
            // No guardamos nada.
            // Volvemos a cargar la página, pero Thymeleaf ahora tendrá los errores.
            
            // Volvemos a cargar la lista de pacientes (necesaria para la tabla)
            model.addAttribute("listaPacientes", pacienteRepository.findAll());
            
            // Devolvemos la vista (NO redireccionamos, para poder mostrar los errores)
            return "gestionPacientes";
        }

        // 5. SI NO HAY ERRORES (el código original):
        // Le decimos al repositorio que guarde el objeto Paciente en la BD
        pacienteRepository.save(paciente);
        
        // Redireccionamos a la raíz ("/"). Esto ejecuta el método verPaginaDeInicio() de nuevo.
        return "redirect:/";
    }
}