import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {



        private Connection conn;

        public Connection newConnection() {
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
                System.out.println("1");
                this.conn = newConnection();
                System.out.println("2");
                // Ejecuci�n
                PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
                System.out.println("3");
                // execute the preparedstatement
                stmt.executeUpdate();
                System.out.println("4");
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

        public boolean updateActivo(int idPersona) {
            String consulta = "UPDATE persona SET activo = 0 WHERE id = " + idPersona + ";";

            try {

                this.conn = newConnection();

                // Ejecuci�n
                PreparedStatement stmt = this.conn.prepareStatement(consulta);

                // execute the preparedstatement
                stmt.executeUpdate();
                return true;


            } catch (SQLException ex) {

                // handle any errors
                System.out.println("Error en Update");
                return false;
            }

        }

        public boolean delete(int idPersona) {
            String consulta = "DELETE FROM persona WHERE id = " + idPersona + ";";

            try {

                this.conn = newConnection();

                // Ejecuci�n
                PreparedStatement stmt = this.conn.prepareStatement(consulta);

                // execute the preparedstatement
                stmt.execute();
                return true;

            } catch (SQLException ex) {

                // handle any errors
                System.out.println("Error en Delete");
                return false;
            }

        }


}
