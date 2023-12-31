package br.com.curso.controller.tipoImovel;

import br.com.curso.dao.TipoImovelDAO;
import br.com.curso.model.TipoImovel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TipoImovelCadastrar", urlPatterns = {"/TipoImovelCadastrar"})
public class TipoImovelCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        try{
            TipoImovel oTipoImovel = new TipoImovel();
            
              String id = request.getParameter("idtipoimovelC");
            if (id.length()  >  0){

                oTipoImovel.setIdTipoImovel( Integer.parseInt(id));
            }else{
                 oTipoImovel.setIdTipoImovel(0);
            }

            oTipoImovel.setDescricao(request.getParameter("descricaoC"));
            TipoImovelDAO dao = new TipoImovelDAO();
            
            if (dao.cadastrar(oTipoImovel)){
                request.getRequestDispatcher("TipoImovelListar").forward(request, response);
            }else{
                response.getWriter().write("0");
            }
        }catch (Exception ex){
            System.out.println("Problemas na Servlet Cadastrar Tipo Imovel! Erro: " + ex.getMessage());
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
