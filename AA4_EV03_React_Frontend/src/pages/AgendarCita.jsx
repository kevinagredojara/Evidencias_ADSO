/* * Archivo: AA4_EV03_React_Frontend/src/pages/AgendarCita.jsx
 * [cite_start]Descripcion: Asistente (wizard) de 4 pasos para agendar citas [cite: 644-767].
 * (Versión corregida del error de sintaxis en la línea 118)
 */

import { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Importar useNavigate
import BotonAccion from '../components/BotonAccion.jsx';
import styles from './AgendarCita.module.css';
import { mockPacientes } from '../data/mockData.js'; // Usamos pacientes simulados

function AgendarCita() {
  // 1. Estado para controlar el paso actual del asistente
  const [step, setStep] = useState(1);
  
  // 2. Estado para guardar la selección
  const [selectedPaciente, setSelectedPaciente] = useState(null);
  const [selectedEspecialidad, setSelectedEspecialidad] = useState('');
  const [selectedProfesional, setSelectedProfesional] = useState('');
  const [selectedFecha, setSelectedFecha] = useState('');
  const [selectedHora, setSelectedHora] = useState('');

  // Hook para navegación
  const navigate = useNavigate();

  // 3. Funciones para navegar entre pasos
  const nextStep = () => setStep(prev => prev + 1);
  const prevStep = () => setStep(prev => prev - 1);
  const goToStep = (stepNumber) => setStep(stepNumber);

  // Renderizado del Paso 1: Buscar Paciente
  const renderStep1 = () => (
    <div>
      <h3>Paso 1 de 4: Buscar y Seleccionar Paciente</h3>
      <div className={styles.inputGroup}>
        <label>Buscar Paciente (Documento):</label>
        <input type="text" placeholder="123456789" />
      </div>
      <p>Resultados (Simulados):</p>
      <div className={styles.pacienteList}>
        {mockPacientes.map(p => (
          <div key={p.id} className={styles.pacienteItem}>
            <span>{p.nombres} {p.apellidos} ({p.documento})</span>
            <BotonAccion onClick={() => {
              setSelectedPaciente(p);
              nextStep();
            }}>
              Seleccionar
            </BotonAccion>
          </div>
        ))}
      </div>
    </div>
  );

  // Renderizado del Paso 2: Seleccionar Profesional
  const renderStep2 = () => (
    <div>
      <h3>Paso 2 de 4: Seleccionar Especialidad y Profesional</h3>
      <p>Agendando para: <strong>{selectedPaciente?.nombres} {selectedPaciente?.apellidos}</strong></p>
      
      <div className={styles.inputGroup}>
        <label>Especialidad:</label>
        <select onChange={(e) => setSelectedEspecialidad(e.target.value)}>
          <option value="">Seleccione...</option>
          <option value="Medicina General">Medicina General</option>
          <option value="Odontología">Odontología</option>
        </select>
      </div>
      <div className={styles.inputGroup}>
        <label>Profesional:</label>
        <select onChange={(e) => setSelectedProfesional(e.target.value)}>
          <option value="">Seleccione...</option>
          <option value="Natalia Ackermann">Natalia Ackermann</option>
          <option value="Luis Martinez">Luis Martinez</option>
        </select>
      </div>
      <div className={styles.stepActions}>
        <BotonAccion onClick={prevStep}>Anterior</BotonAccion>
        <BotonAccion onClick={nextStep}>Siguiente</BotonAccion>
      </div>
    </div>
  );

  // Renderizado del Paso 3: Seleccionar Fecha y Hora
  const renderStep3 = () => (
    <div>
      <h3>Paso 3 de 4: Seleccionar Fecha y Hora de la Cita</h3>
      <p>Profesional: <strong>{selectedProfesional}</strong></p>
      <div className={styles.inputGroup}>
        <label>Seleccione Día:</label>
        <input type="date" onChange={(e) => setSelectedFecha(e.target.value)} />
      </div>
      <p>Horas Disponibles (Simuladas):</p>
      <div className={styles.horasGrid}>
        {['08:00 AM', '08:20 AM', '08:40 AM', '09:00 AM'].map(hora => (
          <BotonAccion key={hora} onClick={() => {
            setSelectedHora(hora);
            nextStep();
          }}>
            {hora}
          </BotonAccion>
        ))}
      </div>
      <div className={styles.stepActions}>
        <BotonAccion onClick={prevStep}>Anterior</BotonAccion>
      </div>
    </div>
  );

  // Renderizado del Paso 4: Confirmar Cita
  const renderStep4 = () => (
    <div>
      <h3>Paso 4 de 4: Confirmar Detalles de la Cita</h3>
      <div className={styles.confirmDetails}>
        <p><strong>Paciente:</strong> {selectedPaciente?.nombres} {selectedPaciente?.apellidos}</p>
        <p><strong>Profesional:</strong> {selectedProfesional}</p>
        <p><strong>Especialidad:</strong> {selectedEspecialidad}</p>
        <p><strong>Fecha:</strong> {selectedFecha}</p>
        <p><strong>Hora:</strong> {selectedHora}</p>
      </div>
      <div className={styles.stepActions}>
        {/*
          *
          * INICIO DE LA CORRECCIÓN
          *
          */}
        <BotonAccion onClick={prevStep}>Anterior</BotonAccion>
        {/*
          *
          * FIN DE LA CORRECCIÓN
          * (La etiqueta de cierre era </Lia> y se cambió por </BotonAccion>)
          *
          */}
        
        <BotonAccion onClick={() => {
          alert('¡Cita Confirmada y Agendada! (Simulación)');
          // Llevamos al dashboard
          navigate('/asesor/dashboard');
        }}>
          Confirmar y Agendar Cita
        </BotonAccion>
      </div>
    </div>
  );

  // Función principal de renderizado
  const renderCurrentStep = () => {
    switch (step) {
      case 1: return renderStep1();
      case 2: return renderStep2();
      case 3: return renderStep3();
      case 4: return renderStep4();
      default: return renderStep1();
    }
  };

  return (
    <div className={styles.wizardContainer}>
      <h1 className={styles.pageTitle}>Agendar Nueva Cita Médica</h1>
      <div className={styles.stepContent}>
        {renderCurrentStep()}
      </div>
    </div>
  );
}

export default AgendarCita;