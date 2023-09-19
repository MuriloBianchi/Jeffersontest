
package br.com.curso.controller.tipoImovel;

import br.com.curso.dao.GenericDAO;
import br.com.curso.dao.TipoImovelDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TipoImovelCarregar", urlPatterns = {"/TipoImovelCarregar"})
public class TipoImovelCarregar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=iso-8859-1");
            int idTipoImovel = Integer.parseInt(request.getParameter("idTipoImovel"));
            try{
                GenericDAO dao = new TipoImovelDAO();
                request.setAttribute("tipoImovel", dao.carregar(idTipoImovel));
                request.getRequestDispatcher("/cadastros/tipoImovel/tipoImovel.jsp").forward(request, response);
            }catch (Exception ex){
                System.out.println("Problemas na Servelet Carregar Tipo Imovel! Erro: " + ex.getMessage());
                ex.printStackTrace();
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