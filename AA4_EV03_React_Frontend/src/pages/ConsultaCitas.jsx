/* * Archivo: AA4_EV03_React_Frontend/src/pages/ConsultaCitas.jsx
 * Descripcion: Página para consultar citas, usa TablaDatos y mockData.
 */

import TablaDatos from '../components/TablaDatos.jsx';
import styles from './ConsultaCitas.module.css';

// 1. Importar los datos simulados
import { mockCitas } from '../data/mockData.js';

function ConsultaCitas() {
  
  // 2. Definir los encabezados (deben coincidir con el orden de mockData)
  // Omitimos 'id' ya que no lo renderizamos.
  const headers = [
    'Fecha', 
    'Hora', 
    'Paciente', 
    'Profesional', 
    'Especialidad', 
    'Estado'
  ];

  return (
    <div className={styles.pageContainer}>
      <h1 className={styles.pageTitle}>Consulta y Gestión de Citas Programadas</h1>
      
      {/* TODO: Aquí irían los filtros del mockup [cite: 772] */}
      <div className={styles.filtersContainer}>
        <p>Filtros de búsqueda (Pendiente implementación)</p>
      </div>

      <h2 className={styles.resultsTitle}>Resultados de Citas</h2>
      
      {/* 3. Renderizar la tabla pasando los datos */}
      <TablaDatos 
        headers={headers} 
        data={mockCitas} 
      />
    </div>
  );
}

export default ConsultaCitas;