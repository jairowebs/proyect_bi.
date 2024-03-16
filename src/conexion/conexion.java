package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class conexion {

    public static Connection conectar() {
        try {

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_sistema_ventas", "root", "1098658607");
            return cn;

        } catch (SQLException e) {
            System.out.println("error en la conexcion local" + e);
        }
        return null;
    }

}
