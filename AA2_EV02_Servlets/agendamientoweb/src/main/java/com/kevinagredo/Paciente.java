package com.kevinagredo;

// Esta clase es el "Modelo". No tiene lógica, solo almacena datos.
public class Paciente {

    // Atributos (basados en la tabla pacientes_java)
    private int id;
    private String numeroDocumento;
    private String nombreCompleto;
    private String telefonoContacto;

    // Constructor vacío (requerido por algunas tecnologías)
    public Paciente() {
    }

    // Constructor para crear un objeto Paciente completo
    public Paciente(int id, String numeroDocumento, String nombreCompleto, String telefonoContacto) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.nombreCompleto = nombreCompleto;
        this.telefonoContacto = telefonoContacto;
    }

    // --- Métodos Getters y Setters ---
    // (Permiten al Servlet y al JSP leer y escribir los atributos privados)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
}