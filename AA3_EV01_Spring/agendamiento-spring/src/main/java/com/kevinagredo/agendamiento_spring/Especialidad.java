/* * Archivo: AA3_EV01_Spring/agendamiento-spring/src/main/java/com/kevinagredo/agendamiento_spring/Especialidad.java
 * (Versión final y limpia)
 */
package com.kevinagredo.agendamiento_spring;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

// Anotaciones de Lombok
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "especialidades")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nombre_especialidad", nullable = false, unique = true)
    private String nombre;

    @Positive
    @Column(name = "duracion_consulta_minutos", nullable = false)
    private int duracionConsultaMinutos;

    @Column(nullable = false)
    private boolean activa = true;
    
    // Nota: Omitimos la relación @OneToMany
}