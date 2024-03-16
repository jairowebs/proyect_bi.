
package controlador;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author usuario
 */
public class Ctrl_Usuario {
    
    //METODO PARA INICIAR SESION
    public boolean loginUser(Usuario objeto){
        
        boolean respuesta = false;
                
        Connection cn = conexion.conectar(); 
        String sql = "select usuario,password from tb_usuario where usuario ='"+ objeto.getUsuario()+"' and password = '" +objeto.getPassword() + "'";
        Statement st;
        
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
                    
                    while(rs.next()){
                        respuesta = true ;
                    }
            
        }catch  (SQLException e){
            System.out.println("error al iniciar sesion");
            JOptionPane.showMessageDialog(null,"error al iniciar sesion");
        }
        return respuesta;
    }
    
}
