import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {

    private List<Usuario> usuarios;
    public static Connection conn;

    public static Connection newConnection() {
        Connection conn = null;
        try {
            String connectionUrl = "jdbc:mysql://localhost:3306/pelismania";
            conn = DriverManager.getConnection(connectionUrl, "root", "");

            // Do something with the Connection
            //System.out.println("Conexión realizada");

            return conn;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
    }

    public static List<Usuario> listaDeUsuarios() {

        try {

            // generacion de query
            String consulta = "SELECT * FROM usuarios";

            // Conexión
            UsuariosDAO.conn = newConnection();

            // Ejecución
            Statement stmt = UsuariosDAO.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada línea retornada
            List<Usuario> usuarios = new ArrayList<>();

            while (rs.next()) {
                Usuario obj = new Usuario();

                // get nombre y contrasena
                obj.setNombre(rs.getString("nombre"));
                obj.setContrasena(rs.getString("contrasena"));

                // get susc
                //obj.setSuscripcion(rs.getInt("suscripcion"));

                // get plata
                obj.setPlata(rs.getInt("plata"));

                usuarios.add(obj);
            }

            return usuarios;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }

    public static void cambiarDineroyModo(Usuario usuario) {
        // buscar el usuario en la BD

        // definir valores
        int modoNuevo = usuario.miSuscripcion.getInt();
        int dineroNuevo = usuario.money;

        // cambiar los campos con update
    }
/*
    public static List<Usuario> selectActivas() {

        try {

            // generacion de query
            String consulta = "SELECT * FROM usuarios WHERE plata >= 5";

            // Conexión
            UsuariosDAO.conn = newConnection();

            // Ejecución
            Statement stmt = UsuariosDAO.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada línea retornada
            List<Usuario> usuarios = new ArrayList<>();

            while (rs.next()) {
                Usuario obj = new Usuario();

                // get nombre y contrasena
                obj.setNombre(rs.getString("nombre"));
                obj.setContrasena(rs.getString("contrasena"));

                // get susc
                //obj.setSuscripcion(rs.getInt("suscripcion"));

                // get plata
                obj.setPlata(rs.getInt("plata"));

                usuarios.add(obj);
            }

            return usuarios;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }*/


}