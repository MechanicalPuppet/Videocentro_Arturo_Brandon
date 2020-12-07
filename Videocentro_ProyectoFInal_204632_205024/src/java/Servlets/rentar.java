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
            out.println("<title>Consulta todos los clientes</title>");
            out.println("</head>");
            out.println("<body>");
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
            for (int i = 0; i < listaVideojuegos.size(); i++) {
                if(listaVideojuegos.get(i).getArticulo().getNumCatalogo().equalsIgnoreCase((String)request.getSession().getAttribute("VideojuegoARentar"))){
                   renta.setArticulo(listaVideojuegos.get(i).getArticulo());
                }
            }
            for (int i = 0; i < listaClientes.size(); i++) {
                if(listaClientes.get(i).getNumCredencial().equalsIgnoreCase((String)request.getSession().getAttribute("clienteARentar"))){
                   renta.setCliente(listaClientes.get(i));
                }
            }
            
//            Fecha fecha = new Fecha((java.sql.Date)request.getSession().getAttribute("fechaRenta"));
                Fecha fecha = new Fecha();
            renta.setFechaRenta(fecha);
            
            renta.setTiempoRenta((int) request.getSession().getAttribute("tiempoRenta"));
            
            crud.rentarVideojuego(renta);
            
            
            
             out.println("<h1> ¡Rentado correctamente! </h1>");
             out.println("</body>");
            
            
//            for (ArticuloED listaVideojuego : listaVideojuegos) {
//                if(listaVideojuego.getArticulo().getNumCatalogo().equalsIgnoreCase((String)request.getSession().getAttribute("numCatalogo"))){
//                    
//                }
//            }
            
//            Renta renta = new Renta(request.getSession().getAttribute("numCredencial"), , fechaRenta, 0);
            
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