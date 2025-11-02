/* * Archivo: AA3_EV01_Spring/agendamiento-spring/src/main/java/com/kevinagredo/agendamiento_spring/Paciente.java
 * (Versión final y limpia)
 */
package com.kevinagredo.agendamiento_spring;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

// Anotaciones de Lombok
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "pacientes")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El tipo de documento es obligatorio")
    @Size(min = 2, max = 10)
    @Column(name = "tipo_documento", nullable = false)
    private String tipoDocumento;

    @NotBlank(message = "El número de documento es obligatorio")
    @Size(min = 5, max = 20)
    @Column(name = "numero_documento", nullable = false, unique = true)
    private String numeroDocumento;
    
    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String nombres;

    @NotBlank(message = "El apellido es obligatorio")
    @Column(nullable = false)
    private String apellidos;

    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El teléfono es obligatorio")
    @Column(name = "telefono_contacto")
    private String telefonoContacto;

    @Email(message = "Debe ser un correo válido")
    @NotBlank(message = "El email es obligatorio")
    @Column(nullable = false, unique = true)
    private String email;

    // Nota: Omitimos la relación @OneToMany a Citas por ahora
    // para simplificar la salida JSON de la API.
}