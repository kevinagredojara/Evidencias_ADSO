<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="jakarta.tags.core" prefix="c_jakarta" %> 

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Pacientes (Servlet/JSP)</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        form { border: 1px solid #ccc; padding: 15px; border-radius: 8px; margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        input[type=text] { width: 300px; padding: 5px; }
        input[type=submit] { background-color: #007bff; color: white; padding: 10px 15px; border: none; border-radius: 5px; cursor: pointer; }
    </style>
</head>
<body>

    <h2>Registrar Nuevo Paciente</h2>
    <p>Basado en la HU-ASE-003 y el Mockup</p>

    <form action="pacientes" method="POST">
        <div>
            <label for="nombre">Nombre Completo:</label><br>
            <input type="text" id="nombre" name="nombre_completo" required>
        </div>
        <br>
        <div>
            <label for="documento">Número de Documento:</label><br>
            <input type="text" id="documento" name="numero_documento" required>
        </div>
        <br>
        <div>
            <label for="telefono">Teléfono de Contacto:</label><br>
            <input type="text" id="telefono" name="telefono_contacto" required>
        </div>
        <br>
        <input type="submit" value="Registrar Paciente">
    </form>

    <hr>

    <h2>Pacientes Registrados en la Base de Datos</h2>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre Completo</th>
                <th>Documento</th>
                <th>Teléfono</th>
            </tr>
        </thead>
        <tbody>
            <c_jakarta:forEach var="paciente" items="${listaPacientes}">
                <tr>
                    <td>${paciente.id}</td>
                    <td>${paciente.nombreCompleto}</td>
                    <td>${paciente.numeroDocumento}</td>
                    <td>${paciente.telefonoContacto}</td>
                </tr>
            </c_jakarta:forEach>

            <c:forEach var="paciente" items="${listaPacientes}">
                <tr>
                    <td>${paciente.id}</td>
                    <td>${paciente.nombreCompleto}</td>
                    <td>${paciente.numeroDocumento}</td>
                    <td>${paciente.telefonoContacto}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>