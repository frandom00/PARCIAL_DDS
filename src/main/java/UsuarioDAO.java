import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {



        private Connection conn;

        public static Connection newConnection() {
            Connection conn = null;
            try {
                String connectionUrl = "jdbc:mysql://localhost:3306/pelismania";
                conn = DriverManager.getConnection(connectionUrl, "root", "");

                // Do something with the Connection
                //System.out.println("Conexi�n realizada");

                return conn;

            } catch (SQLException ex) {

                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                return null;
            }
        }

        public int insert(String nombre, String contra, int suscri, int plata) {
            // INSERT INTO `usuarios` (`id_usuario`, `nombre`, `contrasena`, `id_suscricpcion`, `plata`) VALUES (NULL, 'anastacio', 'wasredtfyguh', '2', '55');
            String consulta = "INSERT INTO `usuarios` (`id_usuario`, `nombre`, `contrasena`, `id_suscricpcion`, `plata`) VALUES (NULL, '" + nombre + "','" + contra + "','" + suscri + "','" + plata + "');";

            try {
                this.conn = newConnection();
                // Ejecuci�n
                PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
                // execute the preparedstatement
                stmt.executeUpdate();
                // obtener �ltimo id generado
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next())
                    return generatedKeys.getInt(1);
                else
                    return 0;


            } catch (SQLException ex) {

                // handle any errors
                System.out.println("Error en Insert");
                return 0;
            }

        }

    public static void cambiarDineroyModo(Usuario usuario) {
        Connection con;
        // definir valores
        int modoNuevo = usuario.miSuscripcion.getInt();
        int dineroNuevo = usuario.money;

        // cambiar los campos con update
        String hola = "UPDATE `usuarios` SET `plata` = '" + dineroNuevo + "' WHERE `nombre` = '" + usuario.nombre + "';";
        String hola2 = "UPDATE `usuarios` SET `id_suscricpcion` = '" + modoNuevo + "' WHERE `nombre` = '" + usuario.nombre + "';";
        try {
            con = newConnection();
            // Ejecuci�n
            PreparedStatement stmt = con.prepareStatement(hola, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement stmt2 = con.prepareStatement(hola2, Statement.RETURN_GENERATED_KEYS);
            // execute the preparedstatement
            stmt.executeUpdate();
            stmt2.executeUpdate();
            // obtener �ltimo id generado
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            ResultSet generatedKeys2 = stmt2.getGeneratedKeys();



        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Insert");

        }


    }

}
