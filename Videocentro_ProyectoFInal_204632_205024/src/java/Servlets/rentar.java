/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import dao.Videojuegos;
import interfaces.IPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetosNegocio.ArticuloED;
import objetosNegocio.Cliente;
import objetosNegocio.Renta;
import objetosNegocio.Videojuego;
import objetosServicio.Fecha;
import persistencia.PersistenciaBD;

/**
 *
 * @author Jbran
 */
@WebServlet(name = "rentar", urlPatterns = {"/rentar"})
public class rentar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Rentas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<header>");
            out.println("<h1>¡Rentas!");
            out.println("</header>");
            out.println("<nav>");
            out.println(" <ul>");
            out.println("<li><a href=\"control?tarea=rentar\">¡Rentar un videojuego!</a></li>");
            out.println(" <li><a href=\"control?tarea=devolver\">¡Devolver un videojuego!</a></li>");
            out.println("</ul>");
            out.println("</nav>");
            IPersistencia crud = new PersistenciaBD();
            List<Cliente> listaClientes = crud.consultarClientes();
            List<ArticuloED> listaVideojuegos = crud.consultarVideojuegosDisponibles();
            Renta renta = new Renta();

            for (ArticuloED listaVideojuego : listaVideojuegos) {
                if (listaVideojuego.getArticulo().getNumCatalogo().equalsIgnoreCase(request.getParameter("numCatalogo"))) {
                    renta.setArticulo(listaVideojuego.getArticulo());
                }
            }

            for (Cliente listaCliente : listaClientes) {
                if (listaCliente.getNumCredencial().equalsIgnoreCase(request.getParameter("numCredencial"))) {
                    renta.setCliente(listaCliente);
                }

            }

            Fecha fecha = new Fecha();
            renta.setFechaRenta(fecha);

            renta.setTiempoRenta(Integer.parseInt(request.getParameter("tiempoRenta")));
            crud.rentarVideojuego(renta);
            
            out.println("<article>");
            out.println("<h1> ¡Rentado correctamente! </h1>");
            out.println("</article>");
            out.println("<footer> <h5>Todos los derechos reservados.</h5>\n" +
"            <h6>Podría interesarte: <a href=\"https://ideasnuevas.net/wp"
                    + "-content/uploads/2016/08/Wallpapersxl-Perritos-Bonitos-"
                    + "Seguro-Que-Estabas-Esperando-Otro-Fondo-De-Perros-Pues-Ya"
                    + "-No-Tienes-276709-1440x1080.jpg\">Contenido vital que todos d"
                    + "eben ver.</a></h6> </footer>");
            
            out.println("</body>");

            out.println("</html>");  
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
