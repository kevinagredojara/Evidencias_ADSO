package com.kevinagredo.agendamiento_spring; // Aseguramos el paquete correcto con guion bajo

// Imports de Persistencia (JPA)
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// IMPORTS NUEVOS (AÑADIDOS PARA AA3-EV02)
// Estos imports habilitan las anotaciones de validación
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Esta clase es el MODELO (la Entidad).
 * Representa la tabla "pacientes_java" en la base de datos.
 * Basado en el DER y la HU-ASE-003.
 *
 * (Indicador 3 y 4: Estándar de codificación y comentarios)
 */
@Entity
@Table(name = "pacientes_java")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // --- VALIDACIONES AÑADIDAS (REQUISITO AA3-EV02) ---

    /**
     * Validación: El campo no puede estar vacío (nulo o solo espacios).
     * Validación: Debe tener entre 3 y 50 caracteres.
     */
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombreCompleto;

    /**
     * Validación: El campo no puede estar vacío.
     * Validación: Asegura que solo se ingresen números (usando una Expresión Regular).
     * Validación: Debe tener entre 5 y 15 dígitos.
     */
    @NotBlank(message = "El documento no puede estar vacío")
    @Pattern(regexp = "^[0-9]+$", message = "El documento solo debe contener números")
    @Size(min = 5, max = 15, message = "El documento debe tener entre 5 y 15 dígitos")
    private String numeroDocumento;
    
    /**
     * Validación: El campo no puede estar vacío.
     * Validación: Debe tener entre 7 y 15 dígitos.
     */
    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(min = 7, max = 15, message = "El teléfono debe tener entre 7 y 15 dígitos")
    private String telefonoContacto;

    // --- Getters y Setters ---
    // Spring los usa para leer y escribir los datos.

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public String getTelefonoContacto() {
        return telefonoContacto;
    }
    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
}