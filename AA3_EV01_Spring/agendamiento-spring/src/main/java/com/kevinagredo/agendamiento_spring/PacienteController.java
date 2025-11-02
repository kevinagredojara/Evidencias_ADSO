/* * Archivo: AA3_EV01_Spring/agendamiento-spring/src/main/java/com/kevinagredo/agendamiento_spring/PacienteController.java
 * (Totalmente modificado para ser @RestController)
 */
package com.kevinagredo.agendamiento_spring;

import jakarta.validation.Valid; // Para activar las validaciones
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes") // Define la URL base para este controlador
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    /*
     * HU-ASE-003: Registrar Nuevo Paciente [cite: 235]
     * Endpoint: POST /api/pacientes
     * Cuerpo (Body): JSON con datos del paciente
     */
    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@Valid @RequestBody Paciente paciente) {
        // @Valid activa las validaciones que pusimos en la entidad
        Paciente nuevoPaciente = pacienteRepository.save(paciente);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED); // Retorna 201 Created
    }

    /*
     * Servicio para listar todos los pacientes (Útil para HU-ASE-004)
     * Endpoint: GET /api/pacientes
     */
    @GetMapping
    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }

    /*
     * Servicio para obtener un paciente por ID (Útil para HU-ASE-004)
     * Endpoint: GET /api/pacientes/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPacientePorId(@PathVariable Long id) {
        return pacienteRepository.findById(id)
                .map(paciente -> new ResponseEntity<>(paciente, HttpStatus.OK)) // Retorna 200 OK
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Retorna 404 Not Found
    }

    /*
     * HU-ASE-004: Actualizar Datos de Paciente [cite: 235]
     * Endpoint: PUT /api/pacientes/{id}
     * Cuerpo (Body): JSON con datos actualizados
     */
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Long id, @Valid @RequestBody Paciente detallesPaciente) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    // Actualiza los campos (esto se debe hacer en un Servicio en un proyecto real)
                    paciente.setNombres(detallesPaciente.getNombres());
                    paciente.setApellidos(detallesPaciente.getApellidos());
                    paciente.setEmail(detallesPaciente.getEmail());
                    paciente.setTelefonoContacto(detallesPaciente.getTelefonoContacto());
                    // ... actualizar otros campos
                    Paciente pacienteActualizado = pacienteRepository.save(paciente);
                    return new ResponseEntity<>(pacienteActualizado, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /*
     * Servicio para eliminar un paciente
     * Endpoint: DELETE /api/pacientes/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarPaciente(@PathVariable Long id) {
        if (!pacienteRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pacienteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna 204 No Content
    }
}