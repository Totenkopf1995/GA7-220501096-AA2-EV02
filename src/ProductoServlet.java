// src/ProductoServlet.java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ProductoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        String nombreProducto = request.getParameter("nombreProducto");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // Simulación de procesamiento (puedes agregar lógica de base de datos aquí)
        try {
            // Establecer una conexión a la base de datos (esto es solo un ejemplo)
            // Asegúrate de tener el controlador JDBC para PostgreSQL en tu CLASSPATH
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mi_db", "usuario", "contraseña");
            String query = "INSERT INTO productos (nombre, precio, cantidad) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nombreProducto);
            stmt.setDouble(2, precio);
            stmt.setInt(3, cantidad);
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Redirigir a la página de éxito
        response.sendRedirect("exito.jsp");
    }
}
