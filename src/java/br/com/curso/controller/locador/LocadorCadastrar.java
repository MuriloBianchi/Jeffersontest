/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.curso.controller.locador;

import br.com.curso.dao.GenericDAO;
import br.com.curso.dao.LocadorDAO;
import br.com.curso.model.Locador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kelvi
 */
@WebServlet(name = "LocadorCadastrar", urlPatterns = {"/LocadorCadastrar"})
public class LocadorCadastrar extends HttpServlet {

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
        String mensagem = null;
        try {
                Locador oLocador = new Locador();
                String id = request.getParameter("idlocadorC");
                if (id.length()  >  0){
                    oLocador.setIdLocador( Integer.parseInt(id));
                }else{
                     oLocador.setIdLocador(0);
                }
                oLocador.setNome(request.getParameter("nomeC"));
                oLocador.setCpfCnpj(request.getParameter("cpfCnpjC"));
                
                LocadorDAO dao = new LocadorDAO();
                
                if(dao.cadastrar(oLocador)){
                    request.getRequestDispatcher("LocadorListar").forward(request, response);
                    
                } else{
                    response.getWriter().write("0");
                }
        } catch (Exception e){
            System.out.println("Problemas no servelet Cadastrar Locador!Erro:" + e.getMessage()); 
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
