/* * Archivo: AA3_EV01_Spring/agendamiento-spring/src/main/java/com/kevinagredo/agendamiento_spring/Cita.java
 * (Actualizado con Lombok)
 */
package com.kevinagredo.agendamiento_spring;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// Anotaciones de Lombok
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "citas")
// --- Anotaciones de Lombok ---
@Data
@NoArgsConstructor
@AllArgsConstructor
// -----------------------------
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    [cite_start]@JoinColumn(name = "paciente_id", nullable = false) // [cite: 578]
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    [cite_start]@JoinColumn(name = "profesional_id", nullable = false) // [cite: 584]
    private ProfesionalSalud profesional;
    
    [cite_start]@Column(name = "fecha_hora_inicio_cita", nullable = false) // [cite: 596]
    private LocalDateTime fechaHoraInicio;

    [cite_start]@Column(name = "fecha_hora_fin_cita", nullable = false) // [cite: 599]
    private LocalDateTime fechaHoraFin;

    [cite_start]@Column(name = "estado_cita", nullable = false) // [cite: 604]
    private String estado; // Ej: "Programada", "Cancelada", "Realizada"
}