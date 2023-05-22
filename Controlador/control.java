package Controlador;

import Modelo.Productos;
import ModeloDAO.ProductoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/control")
public class control extends HttpServlet {

    ProductoDAO prodDAO;


    public control() {
        super();
        prodDAO = new ProductoDAO();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ruta = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("productos")) {
            ruta = "./vista/home.jsp";
            try {
                request.setAttribute("base", prodDAO.llenarProductos());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("nuevo")) {
            ruta = "./vista/registro.jsp";
            try {
          
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("eliminar")) {
            ruta = "./vista/home.jsp";
            try {
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                prodDAO.Eliminar(idEliminar);
                request.setAttribute("base", prodDAO.llenarProductos());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("actualizar")) {
            ruta = "./vista/registro.jsp";
            try {
                int idActualizar = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("base", prodDAO.llenarPorID(idActualizar));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher(ruta);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ID = request.getParameter("txtID");

        Productos prod = new Productos();

        if (ID == null || ID.isEmpty()) {
            try {
                prodDAO.Guardar(prod);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                prod.setId_producto(Integer.parseInt(ID));
                prodDAO.Actualizar(prod);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(request.getContextPath() + "/control?action=productos");
    }
}
