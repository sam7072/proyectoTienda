package ModeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String bd = "tienda";
    private static String user = "root";
    private static String pass = "password.1";
    private static String ruta = "jdbc:mysql://172.30.255.34:3306/"+bd;
    
    private Connection conn;
    
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
        
    public void Conectar() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(ruta, user, pass);
            if(this.conn != null){
                System.out.println("Conectado");
            } else{
                System.out.println("Error al conectar");
            }
        } catch (Exception e) {
    }
    }
    public void Deconectar() throws Exception{
        try {
            if(this.conn != null){
                if(this.conn.isClosed() != true) {
                    this.conn.close();
                }
            }
        } catch (Exception e) {
        }
    }
}
