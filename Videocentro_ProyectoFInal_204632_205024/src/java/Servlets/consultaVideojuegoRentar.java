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
import objetosNegocio.Articulo;
import objetosNegocio.ArticuloED;
import objetosNegocio.Videojuego;
import persistencia.PersistenciaBD;

/**
 *
 * @author Jbran
 */
@WebServlet(name = "consultaVideojuegoRentar", urlPatterns = {"/consultaVideojuegoRentar"})
public class consultaVideojuegoRentar extends HttpServlet {

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
         IPersistencia crud = new PersistenciaBD();

            List<ArticuloED> lista = crud.consultarVideojuegosDisponibles();

            Articulo v;

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta todos los videojuegos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav>");
            out.println(" <ul>");
            out.println("<li><a href=\"control?tarea=rentar\">¡Rentar un videojuego!</a></li>");
            out.println(" <li><a href=\"control?tarea=devolver\">¡Devolver un videojuego!</a></li>");
            out.println("</ul>");
            out.println("</nav>");
            out.println("</body>");
            out.println("<table border=1>");

            for (int i = 0; i < lista.size(); i++) {

                v = lista.get(i).getArticulo();

                out.println("<tr>"
                        + "<td>" + v.getNumCatalogo() + "</td>"
                        + "<td>" + v.getTitulo() + "</td>"
                        + "<td>" + v.getGenero() + "</td>" + "</tr>");

            }
            
            out.println("<form action=\"capturaFechaYTiempoRenta.html\">");
            out.println(" <ul>");
            out.println("<li><input type=\"number\" name=\"numCatalogo\" placeholder=\"Num. Catálogo cliente\"/></li>");
            out.println("<li><input type=\"submit\" value =\"Capturar id cliente\" />");
            out.println("</ul>");
            out.println("  </form>");

            request.getSession().setAttribute("VideojuegoARentar", request.getParameter("numCatalogo"));
//            request.getSession().setAttribute("clienteRentar", request.getSession().getAttribute("clienteARentar"));
                    
                    
                    
                    
                    
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
