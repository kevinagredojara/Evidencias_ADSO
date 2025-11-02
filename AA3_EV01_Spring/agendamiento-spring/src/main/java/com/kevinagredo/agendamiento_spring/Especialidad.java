/* * Archivo: AA3_EV01_Spring/agendamiento-spring/src/main/java/com/kevinagredo/agendamiento_spring/Especialidad.java
 * (Actualizado con Lombok)
 */
package com.kevinagredo.agendamiento_spring;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.util.Set;

// Anotaciones de Lombok
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "especialidades")
// --- Anotaciones de Lombok ---
@Data 
@NoArgsConstructor
@AllArgsConstructor
// -----------------------------
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    [cite_start]@Column(name = "nombre_especialidad", nullable = false, unique = true) // [cite: 366]
    private String nombre;

    @Positive
    [cite_start]@Column(name = "duracion_consulta_minutos", nullable = false) // [cite: 367]
    private int duracionConsultaMinutos;

    [cite_start]@Column(nullable = false) // [cite: 368]
    private boolean activa = true;
    
    // Omitimos la relación por simplicidad
    // @OneToMany(mappedBy = "especialidad")
    // private Set<ProfesionalSalud> profesionales;
}