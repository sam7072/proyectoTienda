package ModeloDAO;

import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO extends Conexion {

    public boolean validarUser(Usuario user) throws Exception {
        boolean pass = false;
        try {
            this.Conectar();
            String query = "Select count(username) contar from usuarios where username = ?";
            PreparedStatement stm = this.getConn().prepareStatement(query);
            stm.setString(1, user.getUsername());
            ResultSet rs = stm.executeQuery();
            int contador = 0;
            while (rs.next()) {
                contador = rs.getInt("contar");
            }
            if (contador > 0) {
                pass = true;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
        } finally {
            this.Deconectar();
        }
        return pass;
    }

    public boolean validarPass(Usuario user) throws Exception {
        boolean pass = false;
        try {
            this.Conectar();
            String query = "Select count(username) contar from usuarios where password = ?";
            PreparedStatement stm = this.getConn().prepareStatement(query);
            stm.setString(1, user.getPassword());
            ResultSet rs = stm.executeQuery();
            int contador = 0;
            while (rs.next()) {
                contador = rs.getInt("contar");
            }
            if (contador > 0) {
                pass = true;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
        } finally {
            this.Deconectar();
        }
        return pass;
    }

public boolean validarTodo(Usuario user) throws Exception {
        boolean pass = false;
        try {
            this.Conectar();
            String query = "Select count(*) contar from usuarios where password = ? and username = ?";
            PreparedStatement stm = this.getConn().prepareStatement(query);
            stm.setString(1, user.getPassword());
            stm.setString(2, user.getUsername());
            ResultSet rs = stm.executeQuery();
            int contador = 0;
            while (rs.next()) {
                contador = rs.getInt("contar");
            }
            if (contador > 0) {
                pass = true;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
        } finally {
            this.Deconectar();
        }
        return pass;
    }

public Usuario llenarUser(Usuario user) throws Exception {
        Usuario us = new Usuario();
        try {
            this.Conectar();
            String query = "Select * from usuarios where u.username = ? and u.password = ?";
            PreparedStatement stm = this.getConn().prepareStatement(query);
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                us.setUsername(rs.getString("username"));
                us.setRol(rs.getString("rol"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
        } finally {
            this.Deconectar();
        }
        return us;
    }
}
