/* * Archivo: AA3_EV01_Spring/agendamiento-spring/src/main/java/com/kevinagredo/agendamiento_spring/PacienteController.java
 * (Versión corregida con 'Long' en lugar de 'Integer' en los @PathVariable)
 */
package com.kevinagredo.agendamiento_spring;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes") 
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    /*
     * HU-ASE-003: Registrar Nuevo Paciente
     * Endpoint: POST /api/pacientes
     */
    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@Valid @RequestBody Paciente paciente) {
        Paciente nuevoPaciente = pacienteRepository.save(paciente);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
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
     *
     * CORRECCIÓN 1: Se cambió @PathVariable Integer id por @PathVariable Long id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPacientePorId(@PathVariable Long id) {
        return pacienteRepository.findById(id)
                .map(paciente -> new ResponseEntity<>(paciente, HttpStatus.OK)) 
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    }

    /*
     * HU-ASE-004: Actualizar Datos de Paciente
     * Endpoint: PUT /api/pacientes/{id}
     *
     * CORRECCIÓN 2: Se cambió @PathVariable Integer id por @PathVariable Long id
     */
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Long id, @Valid @RequestBody Paciente detallesPaciente) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setNombres(detallesPaciente.getNombres());
                    paciente.setApellidos(detallesPaciente.getApellidos());
                    paciente.setEmail(detallesPaciente.getEmail());
                    paciente.setTelefonoContacto(detallesPaciente.getTelefonoContacto());
                    
                    Paciente pacienteActualizado = pacienteRepository.save(paciente);
                    return new ResponseEntity<>(pacienteActualizado, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /*
     * Servicio para eliminar un paciente
     * Endpoint: DELETE /api/pacientes/{id}
     *
     * CORRECCIÓN 3: Se cambió @PathVariable Integer id por @PathVariable Long id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarPaciente(@PathVariable Long id) {
        if (!pacienteRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pacienteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}