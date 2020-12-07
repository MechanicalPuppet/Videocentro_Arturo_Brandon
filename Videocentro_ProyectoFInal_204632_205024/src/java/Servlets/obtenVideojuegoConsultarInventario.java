/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import interfaces.IPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetosNegocio.ArticuloED;
import objetosNegocio.Videojuego;
import persistencia.PersistenciaBD;

/**
 *
 * @author R2
 */
@WebServlet(name = "obtenVideojuegoConsultarInventario", urlPatterns = {"/obtenVideojuegoConsultarInventario"})
public class obtenVideojuegoConsultarInventario extends HttpServlet {

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
            IPersistencia crud = new PersistenciaBD();

            List<ArticuloED> lista = crud.consultarInventarioVideojuegos();
            String numCatalogo = request.getParameter("numCatalogo");
            ArticuloED juego = null;
            
            

            for (ArticuloED articulo : lista) {

                if (articulo.getArticulo().getNumCatalogo().equalsIgnoreCase(numCatalogo)) {
                    juego = articulo;
                }

            }

            if (juego != null) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Consulta de inventario</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("</body>");

                out.println("<ul>"
                        + "<li>" + "Num.Catálago: " + juego.getArticulo().getNumCatalogo() + "</li>"
                        + "<li>" + "Título: " + juego.getArticulo().getTitulo() + "</li>"
                        + "<li>" + "Existencia: " + juego.getExistencia() + "</li>"
                        + "<li>" + "Disponibilidad: " + juego.getDisponibilidad() + "</li>" + "</ul>");
                
                out.print("<br><a href=\"Bienvenido_JSP.jsp#\"><button type=\"button\">Regresar a inicio</button></a>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Lo lamento</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> El videojuego que has introducido no existe o no se ha inventareado:( </h1>");
                out.print("<br><a href=\"Bienvenido_JSP.jsp#\"><button type=\"button\">Regresar</button></a>");
                out.println("</body>");
                out.println("</html>");
            }
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
