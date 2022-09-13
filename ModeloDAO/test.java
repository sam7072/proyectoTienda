/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

/**
 *
 * @author Oscar Castro
 */
public class test {
    public static void main(String[] args) {
        try {
            Conexion c = new Conexion();
            c.Conectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
