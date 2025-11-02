/* * Archivo: AA4_EV03_React_Frontend/src/App.jsx
 * Descripcion: Componente raíz que renderiza el manejador de rutas.
 */

// 1. Importar el enrutador que creamos
import AppRouter from './navigation/AppRouter.jsx';

function App() {
  // 2. Renderizar el enrutador
  return (
    <AppRouter />
  );
}

export default App;