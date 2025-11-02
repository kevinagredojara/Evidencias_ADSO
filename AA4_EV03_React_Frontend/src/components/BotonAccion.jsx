/* * Archivo: AA4_EV03_React_Frontend/src/components/BotonAccion.jsx
 * Descripcion: Componente reutilizable para botones principales.
 */

// Usaremos CSS Modules para estilos encapsulados
import styles from './BotonAccion.module.css';

// Recibe props: 'children' (el texto del botón) y 'onClick' (la función a ejecutar)
function BotonAccion({ children, onClick }) {
  return (
    <button className={styles.boton} onClick={onClick}>
      {children}
    </button>
  );
}

export default BotonAccion;