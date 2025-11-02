/* * Archivo: AA4_EV03_React_Frontend/src/pages/Login.jsx
 * Descripcion: Página de inicio de sesión. Simula la autenticación.
 */

import { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Hook para navegar
import BotonAccion from '../components/BotonAccion.jsx';
import styles from './Login.module.css';

// Basado en el mockup [cite: 608-616]
function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate(); // Inicializa el hook

  // Manejador del envío del formulario
  const handleLogin = (e) => {
    e.preventDefault(); // Evita que la página se recargue
    console.log('Iniciando sesión con:', { email, password });
    
    // Simulación de autenticación:
    // No validamos, solo redirigimos al dashboard del asesor.
    navigate('/asesor/dashboard');
  };

  return (
    <div className={styles.loginContainer}>
      <form className={styles.loginForm} onSubmit={handleLogin}>
        <h1 className={styles.title}>Medical Integral</h1>
        <h2 className={styles.subtitle}>Iniciar Sesión</h2>
        
        <div className={styles.inputGroup}>
          <label htmlFor="email">Email o Documento</label>
          <input 
            type="text" 
            id="email" 
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className={styles.inputField}
          />
        </div>
        
        <div className={styles.inputGroup}>
          <label htmlFor="password">Contraseña</label>
          <input 
            type="password" 
            id="password" 
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className={styles.inputField}
          />
        </div>
        
        <div className={styles.options}>
          <a href="#" className={styles.forgotPassword}>¿Olvidó su contraseña?</a>
        </div>
        
        <BotonAccion type="submit">
          Iniciar Sesión
        </BotonAccion>
        
        <p className={styles.footerNote}>
          Pacientes nuevos: Su cuenta de usuario será creada por un Asesor de
          Servicio en la IPS al momento de solicitar su primera cita.
        </p>
      </form>
    </div>
  );
}

export default Login;