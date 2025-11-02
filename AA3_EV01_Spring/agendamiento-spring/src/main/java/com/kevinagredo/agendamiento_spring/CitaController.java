/* * Archivo: AA3_EV01_Spring/agendamiento-spring/src/main/java/com/kevinagredo/agendamiento_spring/CitaController.java
 * (Nuevo archivo para gestionar citas)
 */
package com.kevinagredo.agendamiento_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    /*
     * HU-ASE-009: Visualizar Citas Gestionadas [cite: 237]
     * Endpoint: GET /api/citas
     */
    @GetMapping
    public List<Cita> obtenerTodasLasCitas() {
        return citaRepository.findAll();
    }

    /*
     * HU-ASE-006: Asignar Cita Médica [cite: 235]
     * Endpoint: POST /api/citas
     * NOTA: Este es un DTO (Data Transfer Object) simplificado.
     * En un proyecto real, la lógica de negocio estaría en un @Service.
     */
    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        // Aquí faltaría la lógica de validación de disponibilidad (HU-ASE-005)
        // Por ahora, solo creamos la cita.
        Cita nuevaCita = citaRepository.save(cita);
        return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
    }

    /*
     * HU-ASE-008: Cancelar Cita Asignada [cite: 237]
     * Endpoint: PATCH /api/citas/{id}/cancelar
     */
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Cita> cancelarCita(@PathVariable Long id) {
        return citaRepository.findById(id)
                .map(cita -> {
                    cita.setEstado("Cancelada"); // Actualiza solo el estado
                    Cita citaCancelada = citaRepository.save(cita);
                    return new ResponseEntity<>(citaCancelada, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // HU-ASE-007 (Modificar) sería un PUT similar al de PacienteController.
}