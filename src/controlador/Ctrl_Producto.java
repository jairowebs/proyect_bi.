
package controlador;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.producto;

/**
 *
* @author usuario - jairowebs
 */
public class Ctrl_Producto {
    
    
     //metodo para guardar producto
    public boolean guardar(producto objeto) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_producto values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setInt(3, objeto.getCantidad());
            consulta.setDouble(4, objeto.getPrecio());
            consulta.setString(5, objeto.getDescripcion());
            consulta.setInt(6, objeto.getPorcentajeIva());
            consulta.setInt(7, objeto.getIdCategoria());
            consulta.setInt(8, objeto.getEstado());
            
            

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("error al guardar categoria" + e);
        }
        return respuesta;
    }
    
     //metodo para registrar categoria
    public boolean existeproducto(String producto) {
        boolean respuesta = false;
        String sql = "select descripcion from tb_categoria where descripcion = '"+producto+"';";
        Statement st;
        
       
        try {
          Connection cn = conexion.conectar();
          st = cn.createStatement();
            ResultSet   rs = st.executeQuery(sql);
          while(rs.next()){
              respuesta = true;
          }
         
        
                  
        } catch (SQLException e) {
            System.out.println("error al consultar producto" + e);
        }
        return respuesta;
    }
    
}
