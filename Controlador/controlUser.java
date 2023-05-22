package Controlador;

import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "controlUser", urlPatterns = {"/controlUser"})
public class controlUser extends HttpServlet {
    
    UsuarioDAO usuarioDAO;
    HttpSession session;
    
    public controlUser() {
        super();
        usuarioDAO = new UsuarioDAO();
    }
    
    private RequestDispatcher rd;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String ruta = "";
        String action = request.getParameter("action");
         if (action.equalsIgnoreCase("validar")) {
            ruta = "./vista/home.jsp";
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.validar(request, response, ruta);
        } else if (action.equalsIgnoreCase("cerrar")) {
            ruta = "index.jsp";
            try {
                HttpSession sesion = request.getSession();
                sesion.invalidate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    protected void login(HttpServletRequest request, HttpServletResponse response, String ruta)
            throws ServletException, IOException {
        
        rd = request.getRequestDispatcher(ruta);
        rd.forward(request, response);
    }
    
    protected void validar(HttpServletRequest request, HttpServletResponse response, String ruta)
            throws ServletException, IOException {
        
        Usuario user = new Usuario();
        user.setUsername(request.getParameter("txtUser"));
        user.setPassword(request.getParameter("txtPass"));
        try {
            if (usuarioDAO.validarUser(user)) {
                if (usuarioDAO.validarPass(user)) {
                    if (usuarioDAO.validarTodo(user)) {
                        session = request.getSession(true);        
                        Usuario base = new Usuario();
                        base = usuarioDAO.llenarUser(user);
                        session.setAttribute("NOMBRE", base.getUsername());
                        session.setAttribute("ROL", base.getRol());
                        rd = request.getRequestDispatcher(ruta);
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("msjTodo", "Credenciales incorrectas");
                        rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    request.setAttribute("msjPass", "Contraseña incorrecta");
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            } else {
                request.setAttribute("msjUser", "Usuario incorrecto");
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
        }
    }

    //Cerrar sesión
    protected void cerrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().removeAttribute("username");
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
