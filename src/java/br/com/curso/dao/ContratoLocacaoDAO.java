
package br.com.curso.dao;

import br.com.curso.model.ContratoLocacao;
import br.com.curso.model.Imovel;
import br.com.curso.model.Locador;
import br.com.curso.model.Locatario;
import br.com.curso.model.ParcelaDesconto;
import br.com.curso.model.ParcelaPagar;
import br.com.curso.model.ParcelaReceber;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContratoLocacaoDAO implements GenericDAO {

    private Connection conexao;
    
    public ContratoLocacaoDAO() throws Exception{
         conexao = SingleConnection.getConnection();
     }
    
    @Override
    public Boolean cadastrar(Object objeto) {
        ContratoLocacao oContratoLocacao = (ContratoLocacao) objeto;
        boolean retorno = false;
        if (oContratoLocacao.getIdContrato() == 0) {
            retorno = inserir(oContratoLocacao);
        } else {
            retorno = alterar(oContratoLocacao);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
         ContratoLocacao oContratoLocacao = (ContratoLocacao) objeto;
         PreparedStatement stmt = null;
         String sql = "INSERT INTO CONTRATOLOCACAO (IDCONTRATO, DATACONTRATO, DATAINICIO, DATAFINAL, MESESCONTRATO, DIARECEBIMENTO, DIAPAGAMENTO, VALORTOTALCONTRATO, VALORRECEBIDO, VALORDESCONTOS, VALORPAGO, VALORJUROSMULTARECEBIDO, VALORJUROSMULTAPAGO, SALDOCONTRATO, IDIMOVEL, IDLOCADOR, IDLOCATARIO, NROPARCELA, IDPARCELAPAGAR, IDPARCELADESCONTO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         try{
             stmt = conexao.prepareCall(sql);
             stmt.setDate(1, new java.sql.Date(oContratoLocacao.getDataContrato().getTime()));
            stmt.setDate(2, new java.sql.Date(oContratoLocacao.getDataInicio().getTime()));
            stmt.setDate(3, new java.sql.Date(oContratoLocacao.getDataFinal().getTime()));
            stmt.setInt(4, oContratoLocacao.getMesesContrato());
            stmt.setInt(5, oContratoLocacao.getDiaRecebimento());
            stmt.setInt(6, oContratoLocacao.getDiaPagamento());
            stmt.setDouble(7, oContratoLocacao.getValorTotalContrato());
            stmt.setDouble(8, oContratoLocacao.getValorRecebido());
            stmt.setDouble(9, oContratoLocacao.getValorDescontos());
            stmt.setDouble(10, oContratoLocacao.getValorPago());
            stmt.setDouble(11, oContratoLocacao.getValorJurosMultaRecebido());
            stmt.setDouble(12, oContratoLocacao.getValorJurosMultaPago());
            stmt.setDouble(13, oContratoLocacao.getSaldoContrato());
            stmt.setInt(14, oContratoLocacao.getIdImovel().getIdImovel());
            stmt.setInt(15, oContratoLocacao.getIdLocador().getIdLocador());
            stmt.setInt(16, oContratoLocacao.getIdLocatario().getIdLocatario());
            stmt.setInt(17, oContratoLocacao.getNroParcela().getNroParcela());
            stmt.setInt(18, oContratoLocacao.getIdParcelaPagar().getIdParcelaPagar());
            stmt.setInt(19, oContratoLocacao.getIdParcelaDesconto().getIdParcelaDesconto());
             stmt.execute();
            conexao.commit();
            return true;
         }catch(Exception e){
             try{
                 System.out.println("Problemas oa cadastrar Contrato Imovel! Erro: " + e.getMessage());
                 e.printStackTrace();
                 conexao.rollback();
             }catch(SQLException ex){
                 System.out.println("Problemas em dar rollback! Erro: " + ex.getMessage());
                 ex.printStackTrace();
             }
             return false;
         }
    }

    @Override
    public Boolean alterar(Object objeto) {
        ContratoLocacao oContratoLocacao = (ContratoLocacao) objeto;
        PreparedStatement stmt = null;
        String sql = "Update CONTRATOLOCACAO SET DATACONTRATO = ?, DATAINICIO = ?, DATAFINAL = ?, MESESCONTRATO = ?, DIARECEBIMENTO = ?, DIAPAGAMENTO = ?, VALORTOTALCONTRATO = ?, VALORRECEBIDO = ?, VALORDESCONTOS = ?, VALORPAGO = ?, VALORJUROSMULTARECEBIDO = ?, VALORJUROSMULTAPAGO = ?, SALDOCONTRATO = ?, IDIMOVEL = ?, IDLOCADOR = ?, IDLOCATARIO = ?, NROPARCELA = ?, IDPARCELAPAGAR = ?, IDPARCELADESCONTO = ? where IDCONTRATO = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(oContratoLocacao.getDataContrato().getTime()));
            stmt.setDate(2, new java.sql.Date(oContratoLocacao.getDataInicio().getTime()));
            stmt.setDate(3, new java.sql.Date(oContratoLocacao.getDataFinal().getTime()));
            stmt.setInt(4, oContratoLocacao.getMesesContrato());
            stmt.setInt(5, oContratoLocacao.getDiaRecebimento());
            stmt.setInt(6, oContratoLocacao.getDiaPagamento());
            stmt.setDouble(7, oContratoLocacao.getValorTotalContrato());
            stmt.setDouble(8, oContratoLocacao.getValorRecebido());
            stmt.setDouble(9, oContratoLocacao.getValorDescontos());
            stmt.setDouble(10, oContratoLocacao.getValorPago());
            stmt.setDouble(11, oContratoLocacao.getValorJurosMultaRecebido());
            stmt.setDouble(12, oContratoLocacao.getValorJurosMultaPago());
            stmt.setDouble(13, oContratoLocacao.getSaldoContrato());
            stmt.setInt(14, oContratoLocacao.getIdImovel().getIdImovel());
            stmt.setInt(15, oContratoLocacao.getIdLocador().getIdLocador());
            stmt.setInt(16, oContratoLocacao.getIdLocatario().getIdLocatario());
            stmt.setInt(17, oContratoLocacao.getNroParcela().getNroParcela());
            stmt.setInt(18, oContratoLocacao.getIdParcelaPagar().getIdParcelaPagar());
            stmt.setInt(19, oContratoLocacao.getIdParcelaDesconto().getIdParcelaDesconto());
            stmt.setInt(20, oContratoLocacao.getIdContrato());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception e) {
            try {
                System.out.println("Problemas ao Alterar Contrato ! Erro: " + e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            } catch (SQLException ex) {
                System.out.println("Problemas no rollback! Erro :" + ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idContratoLocacao = numero;
        PreparedStatement stmt = null;
        String sql = "Delete from CONTRATOLOCACAO where IDCONTRATO = ?";
        try{
            stmt = conexao.prepareCall(sql);
            stmt.setInt(1, idContratoLocacao);
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao excluir Contrato! Erro: " + e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            }catch (SQLException ex){
                System.out.println("Problemas no rollback! Erro :" + ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        int idContratoLocacao = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ContratoLocacao oContratoLocacao = null;
        String sql = "Select IDCONTRATO, DATACONTRATO, DATAINICIO, DATAFINAL, MESESCONTRATO, DIARECEBIMENTO, DIAPAGAMENTO, VALORTOTALCONTRATO, VALORRECEBIDO, VALORDESCONTOS, VALORPAGO, VALORJUROSMULTARECEBIDO, VALORJUROSMULTAPAGO, SALDOCONTRATO from CONTRATOLOCACAO where IDCONTRATO = ?";
        try{
            stmt = conexao.prepareCall(sql);
            stmt.setInt(1, idContratoLocacao);
            rs = stmt.executeQuery();
            while(rs.next()){
                oContratoLocacao.setIdContrato(rs.getInt("IDCONTRATO"));
                oContratoLocacao.setDataContrato(rs.getDate("DATACONTRATO"));
                oContratoLocacao.setDataInicio(rs.getDate("DATAINICIO"));
                oContratoLocacao.setDataFinal(rs.getDate("DATAFINAL"));
                oContratoLocacao.setMesesContrato(rs.getInt("MESESCONTRATO"));
                oContratoLocacao.setDiaRecebimento(rs.getInt("DIARECEBIMENTO"));
                oContratoLocacao.setDiaPagamento(rs.getInt("DIAPAGAMENTO"));
                oContratoLocacao.setValorTotalContrato(rs.getDouble("VALORTOTALCONTRATO"));
                oContratoLocacao.setValorRecebido(rs.getDouble("VALORRECEBIDO"));
                oContratoLocacao.setValorDescontos(rs.getDouble("VALORDESCONTOS"));
                oContratoLocacao.setValorPago(rs.getDouble("VALORPAGO"));
                oContratoLocacao.setValorJurosMultaRecebido(rs.getDouble("VALORJUROSMULTARECEBIDO"));
                oContratoLocacao.setValorJurosMultaPago(rs.getDouble("VALORJUROSMULTAPAGO"));
                oContratoLocacao.setSaldoContrato(rs.getDouble("SALDOCONTRATO"));
                
                ImovelDAO oImovelDAO = new ImovelDAO();
                oContratoLocacao.setIdImovel((Imovel) oImovelDAO.carregar(rs.getInt("IDIMOVEL")));
                
                LocadorDAO oLocadorDAO = new LocadorDAO();
                oContratoLocacao.setIdLocador((Locador) oLocadorDAO.carregar(rs.getInt("IDLOCADOR")));
                
                LocatarioDAO oLocatarioDAO = new LocatarioDAO();
                oContratoLocacao.setIdLocatario((Locatario) oLocatarioDAO.carregar(rs.getInt("IDLOCATARIO")));
                
                ParcelaReceberDAO oParcelaReceberDAO = new ParcelaReceberDAO();
                oContratoLocacao.setNroParcela((ParcelaReceber) oParcelaReceberDAO.carregar(rs.getInt("NROPARCELA")));
                
                ParcelaPagarDAO oParcelaPagarDAO = new ParcelaPagarDAO();
                oContratoLocacao.setIdParcelaPagar((ParcelaPagar) oParcelaPagarDAO.carregar(rs.getInt("IDPARCELAPAGAR")));
                
                ParcelaDescontoDAO oParcelaDescontoDAO = new ParcelaDescontoDAO();
                oContratoLocacao.setIdParcelaDesconto((ParcelaDesconto) oParcelaDescontoDAO.carregar(rs.getInt("IDPARCElADESCONTO")));
            }
        }catch (Exception e){
            System.out.println("Problemas ao Carregar Contrato! Erro : " + e.getMessage());
            e.printStackTrace();
        }
        return oContratoLocacao;
    }

    @Override
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<>();
        ContratoLocacao oContratoLocacao = null;
        String sql = "Select * from CONTRATOLOCACAO";
        try{
            stmt = conexao.prepareCall(sql);
             rs = stmt.executeQuery();
            while(rs.next()){
                oContratoLocacao.setIdContrato(rs.getInt("IDCONTRATO"));
                oContratoLocacao.setDataContrato(rs.getDate("DATACONTRATO"));
                oContratoLocacao.setDataInicio(rs.getDate("DATAINICIO"));
                oContratoLocacao.setDataFinal(rs.getDate("DATAFINAL"));
                oContratoLocacao.setMesesContrato(rs.getInt("MESESCONTRATO"));
                oContratoLocacao.setDiaRecebimento(rs.getInt("DIARECEBIMENTO"));
                oContratoLocacao.setDiaPagamento(rs.getInt("DIAPAGAMENTO"));
                oContratoLocacao.setValorTotalContrato(rs.getDouble("VALORTOTALCONTRATO"));
                oContratoLocacao.setValorRecebido(rs.getDouble("VALORRECEBIDO"));
                oContratoLocacao.setValorDescontos(rs.getDouble("VALORDESCONTOS"));
                oContratoLocacao.setValorPago(rs.getDouble("VALORPAGO"));
                oContratoLocacao.setValorJurosMultaRecebido(rs.getDouble("VALORJUROSMULTARECEBIDO"));
                oContratoLocacao.setValorJurosMultaPago(rs.getDouble("VALORJUROSMULTAPAGO"));
                oContratoLocacao.setSaldoContrato(rs.getDouble("SALDOCONTRATO"));
                
                ImovelDAO oImovelDAO = null;
                try{
                    oImovelDAO = new ImovelDAO();
                }catch(Exception ex){
                    System.out.println("Erro ao carregar Imovel!" + ex.getMessage());
                    ex.printStackTrace();
                }
                oContratoLocacao.setIdImovel((Imovel) oImovelDAO.carregar(rs.getInt("IDIMOVEL")));
                
                LocadorDAO oLocadorDAO = null;
                try{
                    oLocadorDAO = new LocadorDAO();
                }catch(Exception ex){
                    System.out.println("Erro ao carregar Locador!" +ex.getMessage());
                    ex.printStackTrace();
                }
                oContratoLocacao.setIdLocador((Locador) oLocadorDAO.carregar(rs.getInt("IDLOCADOR")));
                
                LocatarioDAO oLocatarioDAO = null;
                try{
                    oLocatarioDAO = new LocatarioDAO();
                }catch(Exception ex){
                    System.out.println("Erro ao carregar locatario!" + ex.getMessage());
                    ex.printStackTrace();
                }
                oContratoLocacao.setIdLocatario((Locatario) oLocatarioDAO.carregar(rs.getInt("IDLOCATARIO")));
                
                ParcelaReceberDAO oParcelaReceberDAO = null;
                try{
                    oParcelaReceberDAO = new ParcelaReceberDAO();
                }catch(Exception ex){
                    System.out.println("Erro ao carregar Parcela Receber!" +ex.getMessage());
                    ex.printStackTrace();
                }
                oContratoLocacao.setNroParcela((ParcelaReceber) oParcelaReceberDAO.carregar(rs.getInt("NROPARCELA")));
                
                ParcelaPagarDAO oParcelaPagarDAO = new ParcelaPagarDAO();
                try{
                    oParcelaPagarDAO = new ParcelaPagarDAO();
                }catch(Exception ex){
                    System.out.println("Erro ao carregar Parcela Pagar!" + ex.getMessage());
                    ex.printStackTrace();
                }
                 oContratoLocacao.setIdParcelaPagar((ParcelaPagar) oParcelaPagarDAO.carregar(rs.getInt("IDPARCELAPAGAR")));
                 
                 ParcelaDescontoDAO oParcelaDescontoDAO = null;
                 try{
                     oParcelaDescontoDAO = new ParcelaDescontoDAO();
                 }catch(Exception ex){
                     System.out.println("Erro ao carregar Parcela Desconto!" + ex.getMessage());
                     ex.printStackTrace();
                 }
                  oContratoLocacao.setIdParcelaDesconto((ParcelaDesconto) oParcelaDescontoDAO.carregar(rs.getInt("IDPARCElADESCONTO")));
                  
                  
                resultado.add(oContratoLocacao);
            }
        }catch(Exception e){
            System.out.println("Problemas ao listar contrato! Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return resultado;
    }
    
}