/* * Archivo: AA4_EV03_React_Frontend/src/pages/DashboardAsesor.jsx
 * Descripcion: Dashboard del Asesor, con 4 botones de navegación [cite: 617-627].
 */

import { Link } from 'react-router-dom'; // Para navegar
import styles from './DashboardAsesor.module.css';

// Recreamos los botones del mockup como Links
function DashboardAsesor() {
  return (
    <div className={styles.dashboardContainer}>
      <h1 className={styles.title}>Menú Principal</h1>
      
      <div className={styles.menuGrid}>
        
        {/* Botón 1: Registrar Nuevo Paciente */}
        <Link to="/asesor/gestionar-pacientes" className={styles.menuItem}>
          <div className={styles.menuIcon}></div>
          <span className={styles.menuText}>Registrar Nuevo Paciente</span>
        </Link>
        
        {/* Botón 2: Gestionar Pacientes (Reusamos la misma vista) */}
        <Link to="/asesor/gestionar-pacientes" className={styles.menuItem}>
          <div className={styles.menuIcon}></div>
          <span className={styles.menuText}>Gestionar Pacientes</span>
        </Link>
        
        {/* Botón 3: Agendar Nueva Cita */}
        <Link to="/asesor/agendar-cita" className={styles.menuItem}>
          <div className={styles.menuIcon}></div>
          <span className={styles.menuText}>Agendar Nueva Cita</span>
        </Link>
        
        {/* Botón 4: Consultar Citas */}
        <Link to="/asesor/consultar-citas" className={styles.menuItem}>
          <div className={styles.menuIcon}></div>
          <span className={styles.menuText}>Consultar Citas</span>
        </Link>
        
      </div>
    </div>
  );
}

export default DashboardAsesor;