/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jbran
 */
@WebServlet(name = "control", urlPatterns = {"/control"})
public class control extends HttpServlet {

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
         String tareaSeleccionada= request.getParameter("tarea");
         
         if(tareaSeleccionada.equals("agregarVideojuego")){
            response.sendRedirect("capturaVideojuego.html");
        } else if (tareaSeleccionada.equals("editarVideojuego")){
            response.sendRedirect("capturaClaveVideojuegoActualizar.jsp");
            
        } else if (tareaSeleccionada.equals("eliminarVideojuego")){
            response.sendRedirect("capturaClaveVideojuegoEliminar.jsp");
        } else if (tareaSeleccionada.equals("consultarVideojuegos")){
            response.sendRedirect("consultarVideojuegos");
        } else if (tareaSeleccionada.equals("consultarVideojuegosTitulo")){
            response.sendRedirect("capturaConsultarVideojuegoTitulo.html");
        } else if (tareaSeleccionada.equals("consultarVideojuegosGenero")){
            response.sendRedirect("capturaConsultarVideojuegoGenero.html");
            
        } else if (tareaSeleccionada.equals("agregarCliente")){
            response.sendRedirect("capturaCliente.html");
        } else if (tareaSeleccionada.equals("editarCliente")){
            response.sendRedirect("capturaCredencialClienteActualizar.jsp");
        } else if (tareaSeleccionada.equals("eliminarCliente")){
            response.sendRedirect("eliminaCliente.html");
        } else if (tareaSeleccionada.equals("consultarCliente")){
            response.sendRedirect("consultaCliente.html");
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
