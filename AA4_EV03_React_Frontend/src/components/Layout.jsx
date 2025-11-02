/* * Archivo: AA4_EV03_React_Frontend/src/components/Layout.jsx
 * Descripcion: Componente de maquetación principal. Incluye el encabezado
 * y el contenedor para el contenido de la página (children).
 */

import { Link } from 'react-router-dom';
import styles from './Layout.module.css';

// 'children' es una prop especial de React que renderiza lo que sea
// que esté "dentro" de este componente.
function Layout({ children }) {
  return (
    <div className={styles.appContainer}>
      {/* Encabezado basado en los mockups [cite: 619, 631, 646] */}
      <header className={styles.header}>
        <div className={styles.logoContainer}>
          {/* Logo - Usamos un Link para volver al dashboard */}
          <Link to="/asesor/dashboard" className={styles.logoLink}>
            <span className={styles.logoText}>Medical Integral</span>
          </Link>
        </div>
        
        {/* Información de usuario (simulada) */}
        <nav className={styles.userNav}>
          <span className={styles.userName}>Esteban Restrepo</span>
          <a href="#" className={styles.navLink}>Mi Perfil</a>
          {/* Link para "Cerrar Sesión" que nos lleva al Login */}
          <Link to="/" className={styles.navLink}>Cerrar Sesión</Link>
        </nav>
      </header>
      
      {/* Contenedor principal donde se renderizará cada página */}
      <main className={styles.mainContent}>
        {children}
      </main>
    </div>
  );
}

export default Layout;