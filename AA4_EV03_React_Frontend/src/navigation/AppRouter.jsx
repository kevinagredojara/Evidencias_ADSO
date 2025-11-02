/* * Archivo: AA4_EV03_React_Frontend/src/navigation/AppRouter.jsx
 * Descripcion: Se actualiza para usar el componente Layout en rutas protegidas.
 */

import { Routes, Route } from 'react-router-dom';

// 1. Importar el Layout
import Layout from '../components/Layout.jsx'; 

// 2. Importar las páginas
import Login from '../pages/Login.jsx';
import DashboardAsesor from '../pages/DashboardAsesor.jsx';
import GestionPacientes from '../pages/GestionPacientes.jsx';
import ConsultaCitas from '../pages/ConsultaCitas.jsx';
import AgendarCita from '../pages/AgendarCita.jsx';

function AppRouter() {
  return (
    <Routes>
      {/* Ruta de Login (sin Layout) */}
      <Route path="/" element={<Login />} />

      {/* Rutas del Asesor (envueltas en el Layout) */}
      <Route 
        path="/asesor/dashboard" 
        element={<Layout><DashboardAsesor /></Layout>} 
      />
      <Route 
        path="/asesor/gestionar-pacientes" 
        element={<Layout><GestionPacientes /></Layout>} 
      />
      <Route 
        path="/asesor/consultar-citas" 
        element={<Layout><ConsultaCitas /></Layout>} 
      />
      <Route 
        path="/asesor/agendar-cita" 
        element={<Layout><AgendarCita /></Layout>} 
      />

      <Route path="*" element={<div><h2>404: Página No Encontrada</h2></div>} />
    </Routes>
  );
}

export default AppRouter;