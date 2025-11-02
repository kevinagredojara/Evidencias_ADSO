/* * Archivo: AA3_EV01_Spring/agendamiento-spring/src/main/java/com/kevinagredo/agendamiento_spring/ProfesionalSaludRepository.java
 * (Nuevo archivo)
 */
package com.kevinagredo.agendamiento_spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalSaludRepository extends JpaRepository<ProfesionalSalud, Long> {
}