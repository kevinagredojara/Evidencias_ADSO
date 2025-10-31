package com.kevinagredo.agendamiento_spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta es la interfaz del REPOSITORIO (el nuevo DAO).
 * Al extender JpaRepository, Spring Boot automáticamente nos da
 * todos los métodos CRUD (save, findAll, findById, delete)
 * ¡No necesitamos escribir ningún código SQL o JDBC!
 * * Esto cumple con el Indicador 1 (Framework) y 2 (Data Storage).
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    // <Paciente, Integer> significa: "Maneja objetos Paciente, donde la PK es un Integer"

    // El cuerpo está vacío a propósito. Spring hace todo el trabajo.
}