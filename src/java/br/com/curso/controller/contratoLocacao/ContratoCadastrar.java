
package br.com.curso.controller.contratoLocacao;
import br.com.curso.dao.ContratoLocacaoDAO;
import br.com.curso.model.ContratoLocacao;
import br.com.curso.model.Imovel;
import br.com.curso.model.Locador;
import br.com.curso.model.Locatario;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ContratoCadastrar", urlPatterns = {"/ContratoCadastrar"})
public class ContratoCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("\"text/html;charset=iso-8859-1");
            int idImovel = Integer.parseInt(request.getParameter("Imovel"));
            int idLocador = Integer.parseInt(request.getParameter("Locador"));
            int idLocatario = Integer.parseInt(request.getParameter("Locatario"));
            
            try{
                
                ContratoLocacao oContrato = new ContratoLocacao();
                String id = request.getParameter("idContrato");
                if(id == null){
                      oContrato.setIdContrato(0);
                }else{
                   oContrato.setIdContrato(Integer.parseInt(id));
                }
              
                oContrato.setDataContrato(Date.valueOf(request.getParameter("DataContrato")));
                oContrato.setDataInicio(Date.valueOf(request.getParameter("DataInicio")));
                oContrato.setDataFinal(Date.valueOf(request.getParameter("DataFinal")));
                oContrato.setDiaRecebimento(Integer.parseInt(request.getParameter("DiaRecebimento")));
                oContrato.setDiaPagamento(Integer.parseInt(request.getParameter("DiaPagamento")));
                oContrato.setMesesContrato(Integer.parseInt(request.getParameter("MesesContrato")));
                oContrato.setValorTotalContrato(Integer.parseInt(request.getParameter("ValorTotal")));
                oContrato.setValorRecebido(Double.parseDouble(request.getParameter("ValorRecebido")));
                oContrato.setValorDescontos(Double.parseDouble(request.getParameter("ValorDesconto")));
                oContrato.setValorPago(Double.parseDouble(request.getParameter("ValorPago")));
                oContrato.setValorJurosMultaRecebido(Double.parseDouble(request.getParameter("ValorJurosMultaRecebido")));
                oContrato.setValorJurosMultaPago(Double.parseDouble(request.getParameter("ValorJurosMultaPago")));
                oContrato.setSaldoContrato(Double.parseDouble(request.getParameter("SaldoContrato")));
                oContrato.setIdImovel(new Imovel(idImovel));
                oContrato.setIdLocador(new Locador(idLocador));
                oContrato.setIdLocatario(new Locatario(idLocatario));
           
                ContratoLocacaoDAO dao  = new ContratoLocacaoDAO();
                
                if(dao.cadastrar(oContrato)){
                     request.getRequestDispatcher("ContratoLocacaoListar").forward(request, response);
                }else{
                     response.getWriter().write("0");
                }
                
            }catch(Exception ex){
                System.out.println("Erro ao cadastrar Contrato! Erro: " + ex.getMessage());
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
