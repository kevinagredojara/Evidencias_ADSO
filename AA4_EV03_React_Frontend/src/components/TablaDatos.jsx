/* * Archivo: AA4_EV03_React_Frontend/src/components/TablaDatos.jsx
 * Descripcion: Componente genérico para renderizar tablas de datos.
 */

import styles from './TablaDatos.module.css';

// Recibe dos props:
// - headers: Un array de strings (ej. ['Paciente', 'Fecha', 'Hora'])
// - data: Un array de objetos (ej. mockCitas)
function TablaDatos({ headers, data, renderRow }) {

  // Obtenemos las "keys" (claves) de los objetos basadas en el primer item de data
  // Esto asume que todos los objetos en 'data' tienen la misma estructura
  const keys = data.length > 0 ? Object.keys(data[0]) : [];

  return (
    <div className={styles.tableWrapper}>
      <table className={styles.table}>
        {/* Encabezados de la Tabla */}
        <thead>
          <tr>
            {headers.map((header, index) => (
              <th key={index}>{header}</th>
            ))}
            {/* Columna extra para Opciones, como en el mockup [cite: 788] */}
            <th>Opciones</th>
          </tr>
        </thead>
        
        {/* Cuerpo de la Tabla */}
        <tbody>
          {data.map((row) => (
            // Usamos el 'id' de la fila como key para React
            <tr key={row.id}>
              {/* Mapeamos las keys para renderizar las celdas */}
              {keys.map((key, index) => {
                // Omitimos el 'id' de ser renderizado en la tabla
                if (key === 'id') return null; 
                return <td key={index}>{row[key]}</td>;
              })}
              
              {/* Celda de Opciones (Simulación) */}
              <td className={styles.opcionesCell}>
                <button className={styles.opcionBtn}>Modificar</button>
                <button className={`${styles.opcionBtn} ${styles.btnCancel}`}>Cancelar</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default TablaDatos;