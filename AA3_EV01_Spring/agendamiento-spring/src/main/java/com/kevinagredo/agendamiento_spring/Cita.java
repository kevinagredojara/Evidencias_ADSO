/* * Archivo: AA3_EV01_Spring/agendamiento-spring/src/main/java/com/kevinagredo/agendamiento_spring/Cita.java
 * (Versión final y limpia)
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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesional_id", nullable = false)
    private ProfesionalSalud profesional;
    
    @Column(name = "fecha_hora_inicio_cita", nullable = false)
    private LocalDateTime fechaHoraInicio;

    @Column(name = "fecha_hora_fin_cita", nullable = false)
    private LocalDateTime fechaHoraFin;

    @Column(name = "estado_cita", nullable = false)
    private String estado; // Ej: "Programada", "Cancelada", "Realizada"
}