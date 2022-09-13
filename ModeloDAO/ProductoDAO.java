package ModeloDAO;

import Modelo.Productos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAO extends Conexion {

    public void Eliminar(int id_producto) throws Exception {
        try {
            this.Conectar();
            String query = "Delete from productos where id_producto=?";
            PreparedStatement stm = this.getConn().prepareStatement(query);
            stm.setInt(1, id_producto);
            stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Deconectar();
        }
    }

    public void Guardar(Productos prod) throws Exception {
        try {
            this.Conectar();
            String query = "Insert into productos (id_producto,codigo,descripcion,precio,stock) values (?,?,?,?,?)";
            PreparedStatement stm = this.getConn().prepareStatement(query);
            stm.setString(1, prod.getCodigo());
            stm.setString(2, prod.getDescripcion());
            stm.setInt(3, prod.getPrecio());
            stm.setInt(4, prod.getStock());
            stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Deconectar();
        }
    }

    public ArrayList<Productos> llenarProductos() throws Exception {
        ArrayList<Productos> lista = new ArrayList<Productos>();
        try {
            this.Conectar();
            String query = "select * from productos";
            PreparedStatement stm = this.getConn().prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Productos p = new Productos();
                p.setId_producto(rs.getInt("id_producto"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setCantidad(rs.getInt("precio"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
        } catch (Exception e) {

        } finally {
            this.Deconectar();
        }
        return lista;
    }

    public ArrayList<Productos> listarProductos() throws Exception {
        ArrayList<Productos> lista = new ArrayList<Productos>();

        try {
            this.Conectar();
            String query = "select * from productos";
            PreparedStatement stm = this.getConn().prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Productos p = new Productos();
                p.setId_producto(rs.getInt("id_producto"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setCantidad(rs.getInt("precio"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
        } catch (Exception e) {

        } finally {
            this.Deconectar();
        }
        return lista;
    }
    
    //Mëtodo Actualizar

    public void Actualizar(Productos prod) throws Exception {
        try {
            this.Conectar();
            String query = "Update productos set codigo = ?, descripcion = ?, precio=?, stock = ? where id_producto = ?";
            PreparedStatement stm = this.getConn().prepareStatement(query);
            stm.setString(1, prod.getCodigo());
            stm.setString(2, prod.getDescripcion());
            stm.setInt(3, prod.getPrecio());
            stm.setInt(4, prod.getStock());
            stm.setInt(5, prod.getId_producto());
            stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Deconectar();
        }
    }

    public Productos llenarPorID(int idBuscar) throws Exception {
        Productos p = new Productos();
        try {
            this.Conectar();
            String query = "Select * from productos where id_producto = ?";
            PreparedStatement stm = this.getConn().prepareStatement(query);
            stm.setInt(1, idBuscar);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                p.setId_producto(rs.getInt("id_producto"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setCantidad(rs.getInt("precio"));
                p.setStock(rs.getInt("stock"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Deconectar();
        }
        return p;
    }
}
