public class App {
    public static void main(String[] args) {

        // Creamos una instancia de nuestro DAO
        PacienteDAO pacienteDao = new PacienteDAO();
        String documentoPrueba = "123456789";

        System.out.println("--- INICIO PRUEBA CRUD ---");

        // 1. Prueba CREAR
        System.out.println("\n[Prueba 1: CREAR]");
        pacienteDao.crearPaciente(documentoPrueba, "Kevin Agredo", "3001112233");

        // 2. Prueba LEER
        System.out.println("\n[Prueba 2: LEER (después de crear)]");
        pacienteDao.leerPaciente(documentoPrueba);

        // 3. Prueba ACTUALIZAR
        System.out.println("\n[Prueba 3: ACTUALIZAR]");
        pacienteDao.actualizarPaciente(documentoPrueba, "3009998877");

        // 4. Prueba LEER (para verificar actualización)
        System.out.println("\n[Prueba 4: LEER (después de actualizar)]");
        pacienteDao.leerPaciente(documentoPrueba);

        // 5. Prueba ELIMINAR
        System.out.println("\n[Prueba 5: ELIMINAR]");
        pacienteDao.eliminarPaciente(documentoPrueba);

        // 6. Prueba LEER (para verificar eliminación)
        System.out.println("\n[Prueba 6: LEER (después de eliminar)]");
        pacienteDao.leerPaciente(documentoPrueba);

        System.out.println("\n--- FIN PRUEBA CRUD ---");
    }
}