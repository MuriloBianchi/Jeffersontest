/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.curso.controller.contratoLocacao;
import br.com.curso.dao.ContratoLocacaoDAO;
import br.com.curso.dao.GenericDAO;
import br.com.curso.dao.ImovelDAO;
import br.com.curso.dao.LocadorDAO;
import br.com.curso.dao.LocatarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ContratoLocacaoCarregar", urlPatterns = {"/ContratoLocacaoCarregar"})
public class ContratoLocacaoCarregar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idContrato = Integer.parseInt(request.getParameter("idContrato"));      
        try { 
            
            GenericDAO dao = new ContratoLocacaoDAO();
           request.setAttribute("contratoLocacao", dao.carregar(idContrato));
            
            try{
                 ImovelDAO daoImovel = new ImovelDAO();
                 request.setAttribute("imoveis", daoImovel.listar());
            }catch(Exception ex){
                System.out.println("Erro ao Carregar Imovel! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
              
            try{
                 LocadorDAO daoLocador = new LocadorDAO();
                request.setAttribute("locadores", daoLocador.listar());
            }catch(Exception ex){
                System.out.println("Erro ao Carregar Locador! Erro: "  + ex.getMessage());
                ex.printStackTrace();
            }
           
            try{
                LocatarioDAO daoLocatario = new LocatarioDAO();
                 request.setAttribute("locatarios", daoLocatario.listar());
            }catch(Exception ex){
                System.out.println("Erro ao Carregar Locatario! Erro: " + ex.getMessage());
                ex.printStackTrace();
            } 
           
            request.getRequestDispatcher("/cadastros/contratoLocacao/contratoLocacao.jsp").forward(request, response);
        } catch (Exception e){
            System.out.println("Problemas na Servelet carregar Contrato! Erro: " + e.getMessage());
            e.printStackTrace();
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
