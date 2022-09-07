package DAO;

import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO extends Conexion {

	public boolean validarUser(Usuario user) throws Exception {
		boolean pass = false;
		try{
			this.Conectar();
			String query = "Select count(username) contar from usuarios where username = ?";
			PreparedStatement stm = this.getConn().preparedStatement (query);
			stm.setString(1, user.getUsername());
			ResultSet rs = stm.executeQuery();
			int contador = 0;
			while (rs.next()){
				contador = rs.getInt("contar");
			}
			if (contador > 0){
				pass = true;
			}
		}catch (Exception e){
			System.out.println("Error" + e.getMessage());
			e.printStackTrace();
		}finally{
			this.Deconectar();
		}
		return pass;
	}

	public boolean validarPass(Usuario user) throws Exception{
		boolean pass = false;
		try{
			this.Conectar();
			String query = "Select count(username) contar from usuarios where password = ?";
			PreparedStatement stm = this.getConn().preparedStatement(query);
			stm.setString(1,user.getPassword());
			ResultSet rs = stm.executeQuery();
			int contador = 0;
			while (rs.next()){
				contador = rs.getInt("contar");
			}
			if (contador > 0) {
				pass = true;
				
			}
		}catch (Exception e){
			System.out.println("Error" + e.getMessage());
			e.printStackTrace();
		}finally{
			this.Deconectar();
		}
		return pass;
	}

}
