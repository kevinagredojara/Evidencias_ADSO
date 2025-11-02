/* * Archivo: AA4_EV03_React_Frontend/src/components/FormularioPaciente.jsx
 * Descripcion: Formulario reutilizable para crear o editar pacientes .
 */

import { useState } from 'react';
import BotonAccion from './BotonAccion.jsx';
import styles from './FormularioPaciente.module.css';

// Estado inicial del formulario
const initialState = {
  nombres: '',
  apellidos: '',
  tipoDocumento: 'CC', // Valor por defecto
  numeroDocumento: '',
  fechaNacimiento: '',
  email: '',
  telefono: '',
  direccion: ''
};

function FormularioPaciente() {
  // 1. Manejo de estado del formulario
  const [formData, setFormData] = useState(initialState);

  // 2. Manejador genérico para todos los inputs
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  // 3. Manejador del envío
  const handleSubmit = (e) => {
    e.preventDefault();
    // Requisito: "mostrarlo en un console.log"
    console.log('Datos del Paciente Registrado:', formData);
    alert('Paciente registrado. Revise la consola (F12) para ver los datos.');
    // Limpiamos el formulario
    setFormData(initialState);
  };

  return (
    <form onSubmit={handleSubmit} className={styles.formContainer}>
      <h2 className={styles.title}>Información del Paciente</h2>
      
      {/* Usamos un grid para el layout de 2 columnas */}
      <div className={styles.formGrid}>
        
        {/* Columna 1 */}
        <div className={styles.inputGroup}>
          <label htmlFor="nombres">Nombres del Paciente:</label>
          <input type="text" id="nombres" name="nombres"
            value={formData.nombres} onChange={handleChange} required />
        </div>
        
        <div className={styles.inputGroup}>
          <label htmlFor="apellidos">Apellidos del Paciente:</label>
          <input type="text" id="apellidos" name="apellidos"
            value={formData.apellidos} onChange={handleChange} required />
        </div>
        
        <div className={styles.inputGroup}>
          <label htmlFor="tipoDocumento">Tipo de Documento:</label>
          <select id="tipoDocumento" name="tipoDocumento"
            value={formData.tipoDocumento} onChange={handleChange} required >
            <option value="CC">Cédula de Ciudadanía</option>
            <option value="TI">Tarjeta de Identidad</option>
            <option value="RC">Registro Civil</option>
            <option value="CE">Cédula de Extranjería</option>
            <option value="PA">Pasaporte</option>
          </select>
        </div>
        
        <div className={styles.inputGroup}>
          <label htmlFor="numeroDocumento">Número de Documento:</label>
          <input type="text" id="numeroDocumento" name="numeroDocumento"
            value={formData.numeroDocumento} onChange={handleChange} required />
        </div>
        
        {/* Columna 2 */}
        <div className={styles.inputGroup}>
          <label htmlFor="fechaNacimiento">Fecha de Nacimiento:</label>
          <input type="date" id="fechaNacimiento" name="fechaNacimiento"
            value={formData.fechaNacimiento} onChange={handleChange} required />
        </div>
        
        <div className={styles.inputGroup}>
          <label htmlFor="email">Correo electrónico:</label>
          <input type="email" id="email" name="email"
            value={formData.email} onChange={handleChange} required />
        </div>
        
        <div className={styles.inputGroup}>
          <label htmlFor="telefono">Teléfono de Contacto:</label>
          <input type="tel" id="telefono" name="telefono"
            value={formData.telefono} onChange={handleChange} required />
        </div>
        
        <div className={styles.inputGroup}>
          <label htmlFor="direccion">Dirección:</label>
          <input type="text" id="direccion" name="direccion"
            value={formData.direccion} onChange={handleChange} required />
        </div>
      </div>
      
      {/* Botones de Acción */}
      <div className={styles.actionButtons}>
        <BotonAccion type="submit">
          Registrar Paciente
        </BotonAccion>
        {/* Simulación de botón cancelar */}
        <BotonAccion type="button" onClick={() => setFormData(initialState)}>
          Cancelar
        </BotonAccion>
      </div>
    </form>
  );
}

export default FormularioPaciente;