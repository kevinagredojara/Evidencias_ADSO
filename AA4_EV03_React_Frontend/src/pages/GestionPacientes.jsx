/* * Archivo: AA4_EV03_React_Frontend/src/pages/GestionPacientes.jsx
 * Descripcion: Página para Registrar y Gestionar Pacientes.
 */

import FormularioPaciente from '../components/FormularioPaciente.jsx';
import styles from './GestionPacientes.module.css';

function GestionPacientes() {
  return (
    <div className={styles.pageContainer}>
      <h1 className={styles.pageTitle}>Registrar Nuevo Paciente</h1>
      <p className={styles.pageSubtitle}>
        Diligencie todos los campos para crear un nuevo paciente en el sistema.
      </p>
      
      {/* Renderizamos el componente de formulario */}
      <FormularioPaciente />
      
      {/* Aquí, en una implementación real, iría también la tabla
         de "Resultados de la Búsqueda" del mockup[cite: 649], 
         pero para esta actividad nos centramos en el registro. */}
    </div>
  );
}

export default GestionPacientes;