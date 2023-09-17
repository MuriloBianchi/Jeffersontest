
package br.com.curso.dao;

import br.com.curso.model.ParcelaReceber;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParcelaReceberDAO implements GenericDAO {

     private Connection conexao;
     
     public ParcelaReceberDAO() throws Exception{
         conexao = SingleConnection.getConnection();
     }
    
    @Override
    public Boolean cadastrar(Object objeto) {
        ParcelaReceber oParcelaReceber = (ParcelaReceber) objeto;
        boolean retorno = false;
        if(oParcelaReceber.getNroParcela() == 0){
            retorno = inserir(oParcelaReceber);
        }else{
            retorno = alterar(oParcelaReceber);
        }
           return retorno;  
    }

    @Override
    public Boolean inserir(Object objeto) {
        ParcelaReceber oParcelaReceber = (ParcelaReceber) objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into ParcelaReceber (DATAVENCIMENTO, DATARECEBIMENTO, VALORPARCELA, VALORRECEBIDO, VALORJUROSMULTA, SITUACAO) values (?,?,?,?,?,?)";
        try{
            stmt = conexao.prepareCall(sql);
            stmt.setDate(1, new java.sql.Date(oParcelaReceber.getDataVencimento().getTime()));
            stmt.setDate(2, new java.sql.Date(oParcelaReceber.getDataRecebimento().getTime()));
            stmt.setDouble(3, oParcelaReceber.getValorParcela());
            stmt.setDouble(4, oParcelaReceber.getValorRecebido());
            stmt.setDouble(5, oParcelaReceber.getValorJurosMulta());
            stmt.setString(6, oParcelaReceber.getSituacao());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao cadastrar Parcela Receber! Erro: " + e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            }catch (SQLException ex){
                System.out.println("Problemas ao executar rollback! " + ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        ParcelaReceber oParcelaReceber = (ParcelaReceber) objeto;
        PreparedStatement stmt = null;
        String sql = "Update PARCELARECEBER set DATAVENCIMENTO = ?, DATARECEBIMENTO = ?, VALORPARCELA = ?, VALORRECEBIDO = ?, VALORJUROSMULTA = ?, SITUACAO = ? where NROPARCELA = ?";
        try{
            stmt = conexao.prepareCall(sql);
            stmt.setDate(1, new java.sql.Date(oParcelaReceber.getDataVencimento().getTime()));
            stmt.setDate(2, new java.sql.Date(oParcelaReceber.getDataRecebimento().getTime()));
            stmt.setDouble(3, oParcelaReceber.getValorParcela());
            stmt.setDouble(4, oParcelaReceber.getValorRecebido());
            stmt.setDouble(5, oParcelaReceber.getValorJurosMulta());
            stmt.setString(6, oParcelaReceber.getSituacao());
            stmt.setInt(7, oParcelaReceber.getNroParcela());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao Alterar Parcela Receber! Erro: " + e.getMessage());
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
    public Boolean excluir(int numero) {
        int idParcelaReceber = numero;
        PreparedStatement stmt = null;
        String sql = "Delete from PARCELARECEBER where NROPARCELA = ?";
        try{
            stmt = conexao.prepareCall(sql);
            stmt.setInt(1, idParcelaReceber);
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao excluir Parcela Receber! Erro: " + e.getMessage());
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
        int idParcelaReceber = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ParcelaReceber oParcelaReceber = null;
        String sql = "Select DATAVENCIMENTO, DATARECEBIMENTO, VALORPARCELA, VALORRECEBIDO, VALORJUROSMULTA, SITUACAO from PARCELARECEBER where NROPARCELA = ?";
        try{
            stmt = conexao.prepareCall(sql);
            stmt.setInt(1, idParcelaReceber);
            rs = stmt.executeQuery();
            while(rs.next()){
                oParcelaReceber = new ParcelaReceber();
                oParcelaReceber.setNroParcela(rs.getInt("NROPARCELA"));
                oParcelaReceber.setDataVencimento(rs.getDate("DATAVENCIMENTO"));
                oParcelaReceber.setDataRecebimento(rs.getDate("DATARECEBIMENTO"));
                oParcelaReceber.setValorParcela(rs.getDouble("VALORPARCELA"));
                oParcelaReceber.setValorRecebido(rs.getDouble("VALORRECEBIDO"));
                oParcelaReceber.setValorJurosMulta(rs.getDouble("VALORJUROSMULTA"));
                oParcelaReceber.setSituacao(rs.getString("SITUACAO"));
            }
        }catch (Exception e){
            System.out.println("Problemas ao Carregar Parcela Receber! Erro : " + e.getMessage());
            e.printStackTrace();
        }
        return oParcelaReceber;
    }

    @Override
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<>();
        ParcelaReceber oParcelaReceber = null;
        String sql = "Select NROPARCELA, DATAVENCIMENTO, DATARECEBIMENTO, VALORPARCELA, VALORRECEBIDO, VALORJUROSMULTA, SITUACAO from PARCELARECEBER";
        try{
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
             while(rs.next()){
                oParcelaReceber = new ParcelaReceber();
                oParcelaReceber.setNroParcela(rs.getInt("NROPARCELA"));
                oParcelaReceber.setDataVencimento(rs.getDate("DATAVENCIMENTO"));
                oParcelaReceber.setDataRecebimento(rs.getDate("DATARECEBIMENTO"));
                oParcelaReceber.setValorParcela(rs.getDouble("VALORPARCELA"));
                oParcelaReceber.setValorRecebido(rs.getDouble("VALORRECEBIDO"));
                oParcelaReceber.setValorJurosMulta(rs.getDouble("VALORJUROSMULTA"));
                oParcelaReceber.setSituacao(rs.getString("SITUACAO"));
                resultado.add(oParcelaReceber);
            }
        }catch (Exception e){
            System.out.println("Problemas ao Listar Parcela Receber! Erro : " + e.getMessage());
            e.printStackTrace();
        }
        return resultado;
    }   
}
