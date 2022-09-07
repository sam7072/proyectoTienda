package Modelos;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public Producto ConsultaPorCodigo(int codigoProducto) {
        Producto producto = new Producto();
        con = cn.Conexion();
        String consulta = "SELECT * FROM productos WHERE id_producto = " + codigoProducto;

        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while(rs.next()){
                producto.setIdproducto(rs.getInt("id_prodcuto"));
                producto.setCodigo(rs.getString("codigo"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getString("precio"));
                producto.setStock(rs.getString("stock"));
                               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }

    public int Agregar(Producto producto) {
        int r = 0;
        con = cn.Conexion();
        String sentencia = "INSERT INTO productos (codigo, descripcion, precio, stock) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sentencia);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getPrecio());
            ps.setString(4, producto.getStock());
            ps.executeUpdate();

        } catch (Exception e) {

        }

        return r;

    }

    public List Listar() {
        String consulta = "SELECT * FROM productos";
        List<Producto> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdproducto(rs.getInt("id_prodcuto"));
                producto.setCodigo(rs.getString("codigo"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getString("precio"));
                producto.setStock(rs.getString("stock"));
                lista.add(producto);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

}
