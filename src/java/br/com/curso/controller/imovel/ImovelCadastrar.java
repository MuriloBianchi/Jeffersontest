/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.curso.controller.imovel;

import br.com.curso.dao.ImovelDAO;
import br.com.curso.model.Imovel;
import br.com.curso.model.Locador;
import br.com.curso.model.TipoImovel;
import br.com.curso.utils.Conversao;
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
@WebServlet(name = "ImovelCadastrar", urlPatterns = {"/ImovelCadastrar"})
public class ImovelCadastrar extends HttpServlet {

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
        int idTipoImovel = Integer.parseInt(request.getParameter("tipoImovelC"));
        int idLocador = Integer.parseInt(request.getParameter("locadorC"));
        try {
                Imovel oImovel = new Imovel();
                String id = request.getParameter("idImovelC");
                if (id.length()  >  0){
                    oImovel.setIdImovel( Integer.parseInt(id));
                }else{
                    oImovel.setIdImovel(0);
                }
                oImovel.setDescricao(request.getParameter("descricaoC"));
                oImovel.setRua(request.getParameter("ruaC"));
                oImovel.setNumero(request.getParameter("numeroC"));
                oImovel.setBairro(request.getParameter("bairroC"));
                oImovel.setValorAluguel(Conversao.valorDinheiro(request.getParameter("valorAluguelC")));
                oImovel.setTaxaAdministracao(Integer.parseInt(request.getParameter("taxaAdministracaoC")));
                oImovel.setTipoImovel(new TipoImovel(idTipoImovel,""));
                oImovel.setLocador(new Locador (idLocador,"",""));
                ImovelDAO dao = new ImovelDAO();
                
                if(dao.cadastrar(oImovel)){
                    request.getRequestDispatcher("ImovelListar").forward(request, response);
                } else{
                    response.getWriter().write("0");
                }
        } catch (Exception e){
            System.out.println("Problemas no servelet Cadastrar Imovel!Erro:" + e.getMessage()); 
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
