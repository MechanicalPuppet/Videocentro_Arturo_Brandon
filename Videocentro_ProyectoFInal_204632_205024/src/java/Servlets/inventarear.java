/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import interfaces.IPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetosNegocio.Videojuego;
import persistencia.PersistenciaBD;

/**
 *
 * @author R2
 */
@WebServlet(name = "inventarear", urlPatterns = {"/inventarear"})
public class inventarear extends HttpServlet {

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

            String numCatalogo = request.getParameter("numCatalogo");
            String titulo = request.getParameter("titulo");
            String genero = request.getParameter("genero");
            String clasificacion = request.getParameter("clasificacion");
            String consola = request.getParameter("consola");
            String fabricante = request.getParameter("fabricante");
            Integer version = Integer.parseInt(request.getParameter("version"));

            Videojuego juegoNuevo = new Videojuego(numCatalogo, titulo, genero, clasificacion, consola, fabricante, version);

            int existencia = Integer.parseInt(request.getParameter("existencia"));

            try {
                crud.inventariar(juegoNuevo, existencia);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Felicidades</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> El videojuego se ha inventareado correctamente </h1>");
                out.print("<br><a href=\"Bienvenido_JSP.jsp#\"><button type=\"button\">Regresar a inicio</button></a>");
                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {
                response.sendRedirect("error.html");
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
