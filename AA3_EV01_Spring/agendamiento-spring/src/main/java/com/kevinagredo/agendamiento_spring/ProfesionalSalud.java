/* * Archivo: AA3_EV01_Spring/agendamiento-spring/src/main/java/com/kevinagredo/agendamiento_spring/ProfesionalSalud.java
 * (Actualizado con Lombok)
 */
package com.kevinagredo.agendamiento_spring;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

// Anotaciones de Lombok
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "profesionales_salud")
// --- Anotaciones de Lombok ---
@Data
@NoArgsConstructor
@AllArgsConstructor
// -----------------------------
public class ProfesionalSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombres; [cite_start]// Asumido de User [cite: 352]
    
    @NotBlank
    private String apellidos; [cite_start]// Asumido de User [cite: 353]

    @NotBlank
    [cite_start]@Column(name = "numero_registro_prof", nullable = false, unique = true) // [cite: 360]
    private String registroProfesional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;

    // Omitimos la relación por simplicidad
    // @OneToMany(mappedBy = "profesional")
    // private Set<Cita> citasAtendidas;
}