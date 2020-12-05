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
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "obtenVideojuegoActualizar", urlPatterns = {"/obtenVideojuegoActualizar"})
public class obtenVideojuegoActualizar extends HttpServlet {

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
            
            List<Videojuego> lista = crud.consultarVideojuegos();
            Videojuego videojuego = new Videojuego(request.getParameter("numCatalogo"));
            
            
     
            
            
            for (Videojuego juego : lista) {
             
                if(juego.getNumCatalogo().equalsIgnoreCase(videojuego.getNumCatalogo())){
                   request.getSession().setAttribute("juego", juego);
                   request.getSession().setAttribute("numCatalogo", juego.getNumCatalogo());
                   request.getSession().setAttribute("clasificacion", juego.getClasificacion());
                   request.setAttribute("consola", juego.getConsola());
                   request.setAttribute("titulo",juego.getTitulo());
                   request.setAttribute("fabricante", juego.getFabricante());
                   request.setAttribute("genero",juego.getGenero());
                   request.setAttribute("version", juego.getVersion());
                
                   response.sendRedirect("capturaEditarVideojuego.jsp");
                break;
//                   RequestDispatcher rd = request.getRequestDispatcher("capturaEditarVideojuegoActualizar.jsp");
//                   rd.forward(request, response);
            
                }
                
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lo lamento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> El videojuego que has introducido no existe :( </h1>");
            out.println("<button onclick='Bienvenido.jsp'> Regresar </button>");
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