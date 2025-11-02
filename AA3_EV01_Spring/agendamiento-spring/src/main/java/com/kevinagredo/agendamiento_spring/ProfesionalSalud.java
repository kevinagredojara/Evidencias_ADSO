/* * Archivo: AA3_EV01_Spring/agendamiento-spring/src/main/java/com/kevinagredo/agendamiento_spring/ProfesionalSalud.java
 * (Versión final y limpia)
 */
package com.kevinagredo.agendamiento_spring;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

// Anotaciones de Lombok
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "profesionales_salud")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesionalSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombres;
    
    @NotBlank
    private String apellidos;

    @NotBlank
    @Column(name = "numero_registro_prof", nullable = false, unique = true)
    private String registroProfesional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;

    // Nota: Omitimos la relación @OneToMany
}