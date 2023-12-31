/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.curso.controller.contratoLocacao;

import br.com.curso.dao.ContratoLocacaoDAO;
import br.com.curso.dao.ImovelDAO;
import br.com.curso.dao.LocadorDAO;
import br.com.curso.dao.LocatarioDAO;
import br.com.curso.dao.ParcelaPagarDAO;
import br.com.curso.dao.ParcelaDescontoDAO;
import br.com.curso.dao.ParcelaReceberDAO;
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

/**
 *
 * @author kelvi
 */
@WebServlet(name = "ContratoLocacaoListar", urlPatterns = {"/ContratoLocacaoListar"})
public class ContratoLocacaoListar extends HttpServlet {

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
         response.setContentType("text/html;charset=iso-8859-1");
        try {
            
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
            
                        
            ParcelaDescontoDAO daoParcelaDesconto = new ParcelaDescontoDAO();
            request.setAttribute("parcelasdesconto", daoParcelaDesconto.listar());
            
            GenericDAO dao = new ContratoLocacaoDAO();
            request.setAttribute("contratos", dao.listar());
            
            request.getRequestDispatcher("/cadastros/contratoLocacao/contratoLocacao.jsp").forward(request, response);
        }catch (Exception ex){
            System.out.println("Problemas no Servelet ao Listar contratos!Erro: "+ ex.getMessage());
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
