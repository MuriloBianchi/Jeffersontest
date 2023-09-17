
package br.com.curso.dao;

import br.com.curso.model.ContratoLocacao;
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
         String sql = "INSERT INTO CONTRATOLOCACAO (IDCONTRATO, DATACONTRATO, DATAINICIO, DATAFINAL, MESESCONTRATO, DIARECEBIMENTO, DIAPAGAMENTO, VALORTOTALCONTRATO, VALORRECEBIDO, VALORDESCONTOS, VALORPAGO, VALORJUROSMULTARECEBIDO, VALORJUROSMULTAPAGO, SALDOCONTRATO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        String sql = "INSERT INTO CONTRATOLOCACAO (IDCONTRATO, DATACONTRATO, DATAINICIO, DATAFINAL, MESESCONTRATO, DIARECEBIMENTO, DIAPAGAMENTO, VALORTOTALCONTRATO, VALORRECEBIDO, VALORDESCONTOS, VALORPAGO, VALORJUROSMULTARECEBIDO, VALORJUROSMULTAPAGO, SALDOCONTRATO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, oContratoLocacao.getIdContrato());
            stmt.setDate(2, new java.sql.Date(oContratoLocacao.getDataContrato().getTime()));
            stmt.setDate(3, new java.sql.Date(oContratoLocacao.getDataInicio().getTime()));
            stmt.setDate(4, new java.sql.Date(oContratoLocacao.getDataFinal().getTime()));
            stmt.setInt(5, oContratoLocacao.getMesesContrato());
            stmt.setInt(6, oContratoLocacao.getDiaRecebimento());
            stmt.setInt(7, oContratoLocacao.getDiaPagamento());
            stmt.setDouble(8, oContratoLocacao.getValorTotalContrato());
            stmt.setDouble(9, oContratoLocacao.getValorRecebido());
            stmt.setDouble(10, oContratoLocacao.getValorDescontos());
            stmt.setDouble(11, oContratoLocacao.getValorPago());
            stmt.setDouble(12, oContratoLocacao.getValorJurosMultaRecebido());
            stmt.setDouble(13, oContratoLocacao.getValorJurosMultaPago());
            stmt.setDouble(14, oContratoLocacao.getSaldoContrato());
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
                resultado.add(oContratoLocacao);
            }
        }catch(Exception e){
            System.out.println("Problemas ao listar contrato! Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return resultado;
    }
    
}
