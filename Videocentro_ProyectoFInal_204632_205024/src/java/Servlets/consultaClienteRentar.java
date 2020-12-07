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
import objetosNegocio.Cliente;
import persistencia.PersistenciaBD;

/**
 *
 * @author Jbran
 */
@WebServlet(name = "consultaClienteRentar", urlPatterns = {"/consultaClienteRentar"})
public class consultaClienteRentar extends HttpServlet {

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

            List lista = crud.consultarClientes();

            Cliente c;

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta todos los clientes</title>");
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

                c = (Cliente) lista.get(i);

                out.println("<tr>"
                        + "<td>" + c.getNumCredencial() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td>" + c.getDireccion() + "</td>"
                        + "<td>" + c.getTelefono() + "</td>" + "</tr>");

            }

            out.println("<form action=\"consultaVideojuegoRentar\">");
            out.println(" <ul>");
            out.println("<li><input type=\"number\" name=\"numCredencial\" placeholder=\"Num. Catálogo cliente\"/></li>");
            out.println("<li><input type=\"submit\" value =\"Capturar id cliente\" />");
            out.println("</ul>");
            out.println("  </form>");

            

            out.println("</html>");
            request.getSession().setAttribute("clienteARentar", request.getParameter("numCredencial"));
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