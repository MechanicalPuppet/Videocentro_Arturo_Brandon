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
import objetosNegocio.Videojuego;
import persistencia.PersistenciaBD;

/**
 *
 * @author Jbran
 */
@WebServlet(name = "consultarVideojuegoGenero", urlPatterns = {"/consultarVideojuegoGenero"})
public class consultarVideojuegoGenero extends HttpServlet {

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
    
        List lista = crud.consultarVideojuegos();
        
        Videojuego v;
        
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta todos los videojuegos del género"+request.getParameter("genero")+"</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("<table border=1>");
            
            
            /* TODO output your page here. You may use following sample code. */

            
            for (int i = 0; i < lista.size(); i++) {
           
            v=(Videojuego)lista.get(i);
           if(v.getGenero().toLowerCase().contains(request.getParameter("genero").toLowerCase()) || v.getGenero().equalsIgnoreCase(request.getParameter("genero"))){
            
            out.println("<tr>"
                    + "<td>" + v.getNumCatalogo()+ "</td>"
                    + "<td>" + v.getTitulo() + "</td>"
                    + "<td>" + v.getGenero() + "</td>"
                    + "<td>" + v.getConsola() + "</td>"
                    + "<td>"+ v.getFabricante() + "</td>"
                    + "<td>"+ v.getVersion() + "</td>"+"</tr>");
           }
            
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
