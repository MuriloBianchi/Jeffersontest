
package br.com.curso.dao;

import br.com.curso.model.ParcelaPagar;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParcelaPagarDAO implements GenericDAO {

     private Connection conexao;
    
     public ParcelaPagarDAO() throws Exception{
         conexao = SingleConnection.getConnection();
     }
     
    @Override
    public Boolean cadastrar(Object objeto) {
        ParcelaPagar oParcelaPagar = (ParcelaPagar) objeto;
        boolean retorno = false;
        if(oParcelaPagar.getIdParcelaPagar() == 0){
            retorno = inserir(oParcelaPagar);
        }else{
            retorno = alterar(oParcelaPagar);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        ParcelaPagar oParcelaPagar = (ParcelaPagar) objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into PARCELAPAGAR (DATAVENCIMENTO, DATAPAGAMENTO, VALORDESCONTOS, VALORPAGAR, VALORPAGO, VALORJUROSMULTA, SITUACAO) values (?,?,?,?,?,?,?)";
        try{
            stmt = conexao.prepareCall(sql);
            stmt.setDate(1, new java.sql.Date(oParcelaPagar.getDataVencimento().getTime()));
            stmt.setDate(2, new java.sql.Date(oParcelaPagar.getDataPagamento().getTime()));
            stmt.setDouble(3, oParcelaPagar.getValorDescontos());
            stmt.setDouble(4, oParcelaPagar.getValorPagar());
            stmt.setDouble(5, oParcelaPagar.getValorPago());
            stmt.setDouble(6, oParcelaPagar.getValorJurosMulta());
            stmt.setString(7, oParcelaPagar.getSituacao());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao cadastrar Parcela Paga! Erro: " + e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            }catch (SQLException ex){
                System.out.println("Problemas no rollback! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        ParcelaPagar oParcelaPagar = (ParcelaPagar) objeto;
        PreparedStatement stmt = null;
        String sql = "Update PARCELAPAGAR set DATAVENCIMENTO = ?, DATAPAGAMENTO = ?, VALORDESCONTOS = ?, VALORPAGAR = ?, VALORPAGO = ?, VALORJUROSMULTA = ?, SITUACAO = ? where IDPARCELAPAGAR = ?";
        try{
            stmt = conexao.prepareCall(sql);
            stmt.setDate(1, new java.sql.Date(oParcelaPagar.getDataVencimento().getTime()));
            stmt.setDate(2, new java.sql.Date(oParcelaPagar.getDataPagamento().getTime()));
            stmt.setDouble(3, oParcelaPagar.getValorDescontos());
            stmt.setDouble(4, oParcelaPagar.getValorPagar());
            stmt.setDouble(5, oParcelaPagar.getValorPago());
            stmt.setDouble(6, oParcelaPagar.getValorJurosMulta());
            stmt.setString(7, oParcelaPagar.getSituacao());
            stmt.setInt(8, oParcelaPagar.getIdParcelaPagar());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao Alterar Parcela Pagar! Erro: " + e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            }catch (SQLException ex){
                System.out.println("Probelemas em dar rollback! Erro : "+ ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idParcelaPagar = numero;
        PreparedStatement stmt = null;
        String sql = "Delete from PARCELAPAGAR where IDPARCELAPAGAR = ?";
        try{
             stmt = conexao.prepareCall(sql);
             stmt.setInt(1, idParcelaPagar);
             stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao excluir Parcela Pagar! Erro: " + e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            }catch (SQLException ex){
                System.out.println("Problemas no rollback! Erro: " +ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        int idParcelaPagar = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ParcelaPagar oParcelaPagar = null;
        String sql = "select DATAVENCIMENTO, DATAPAGAMENTO, VALORDESCONTOS, VALORPAGAR, VALORPAGO, VALORJUROSMULTA, SITUACAO from PARCELAPAGAR where IDPARCELAPAGAR = ?";
        try{
             stmt = conexao.prepareCall(sql);
             stmt.setInt(1, idParcelaPagar);
             rs = stmt.executeQuery();
             while(rs.next()){
                 oParcelaPagar = new ParcelaPagar();
                 oParcelaPagar.setIdParcelaPagar(rs.getInt("IDPARCELAPAGAR"));
                 oParcelaPagar.setDataVencimento(rs.getDate("DATAVENCIMENTO"));
                 oParcelaPagar.setDataPagamento(rs.getDate("DATAPAGAMENTO"));
                 oParcelaPagar.setValorDescontos(rs.getDouble("VALORDESCONTOS"));
                 oParcelaPagar.setValorPagar(rs.getDouble("VALORPAGAR"));
                 oParcelaPagar.setValorPago(rs.getDouble("VALORPAGO"));
                 oParcelaPagar.setValorJurosMulta(rs.getDouble("VALORJUROSMULTA"));
                 oParcelaPagar.setSituacao(rs.getString("SITUACAO"));
             }
        }catch (Exception e){
            System.out.println("Problemas ao Carregar Parcela Pagar! Erro: " + e.getMessage());
           e.printStackTrace();
        }
         return oParcelaPagar;
    }

    @Override
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<>();
        ParcelaPagar oParcelaPagar = null;
        String sql = "Select IDPARCELAPAGAR, DATAVENCIMENTO, DATAPAGAMENTO, VALORDESCONTOS, VALORPAGAR, VALORPAGO, VALORJUROSMULTA, SITUACAO from PARCELAPAGAR";
        try{
             stmt = conexao.prepareCall(sql);
             rs = stmt.executeQuery();
             while(rs.next()){
                 oParcelaPagar = new ParcelaPagar();
                 oParcelaPagar.setIdParcelaPagar(rs.getInt("IDPARCELAPAGAR"));
                 oParcelaPagar.setDataVencimento(rs.getDate("DATAVENCIMENTO"));
                 oParcelaPagar.setDataPagamento(rs.getDate("DATAPAGAMENTO"));
                 oParcelaPagar.setValorDescontos(rs.getDouble("VALORDESCONTOS"));
                 oParcelaPagar.setValorPagar(rs.getDouble("VALORPAGAR"));
                 oParcelaPagar.setValorPago(rs.getDouble("VALORPAGO"));
                 oParcelaPagar.setValorJurosMulta(rs.getDouble("VALORJUROSMULTA"));
                 oParcelaPagar.setSituacao(rs.getString("SITUACAO"));
                 resultado.add(oParcelaPagar);
             }
        }catch (Exception e){
            System.out.println("Problemas ao Carregar Parcela Pagar! Erro: " + e.getMessage());
           e.printStackTrace();
        }
         return resultado;
    }  
}
