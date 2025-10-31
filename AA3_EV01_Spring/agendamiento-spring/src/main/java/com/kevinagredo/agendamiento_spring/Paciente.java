package com.kevinagredo.agendamiento_spring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Esta clase es el MODELO (la Entidad).
 * Representa la tabla "pacientes_java" en la base de datos.
 * Basado en el DER y la HU-ASE-003.
 */
@Entity // 1. Le dice a Spring que esta clase es una tabla de BD
@Table(name = "pacientes_java") // 2. Le dice el nombre exacto de la tabla
public class Paciente {

    @Id // 3. Marca este campo como la Clave Primaria (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Le dice a MySQL que es Autoincremental
    private int id;

    private String nombreCompleto;
    private String numeroDocumento;
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