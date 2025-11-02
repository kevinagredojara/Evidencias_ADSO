/* * Archivo: AA4_EV03_React_Frontend/src/main.jsx
 * Descripcion: Punto de entrada de la aplicación React. Renderiza el componente App.
 */

import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';

// Importamos nuestros estilos globales
import './index.css'; 

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
);