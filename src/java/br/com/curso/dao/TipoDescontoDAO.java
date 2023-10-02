/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;


import br.com.curso.model.TipoDesconto;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelvi
 */
public class TipoDescontoDAO implements GenericDAO {
     private Connection conexao;
    
    public TipoDescontoDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }
    
    @Override
    public Boolean cadastrar(Object objeto) {
      TipoDesconto oTipoDesconto = (TipoDesconto) objeto;
      boolean retorno = false;
      if(oTipoDesconto.getIdTipoDesconto() == 0){
          retorno = inserir(oTipoDesconto);
    } else{
          retorno = alterar(oTipoDesconto);
      }
      return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
      TipoDesconto oTipoDesconto = (TipoDesconto)objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into TipoDesconto (idTipoDesconto,descricao) values (nextVal('sq_contrato'),?)";
        try{
          stmt = conexao.prepareStatement(sql);
          stmt.setString(1, oTipoDesconto.getDescricao());
          stmt.execute();
          conexao.commit();
          return true;
        }catch (Exception ex){
            try{
            System.out.println("Problemas ao cadastrar a TipoDesconto! Erro:" + ex.getMessage());
            ex.printStackTrace();
              conexao.rollback();
          }catch(SQLException e){
                System.out.println("Erro"+ e.getMessage());
                e.printStackTrace();
          }
            return false;
       }
    }

    @Override
    public Boolean alterar(Object objeto) {
       TipoDesconto oTipoDesconto = (TipoDesconto)objeto;    
        PreparedStatement stmt = null;
        String sql = "update tipoDesconto set descricao=? where idtipodesconto=?";
        try{
          stmt = conexao.prepareStatement(sql);
          stmt.setString(1, oTipoDesconto.getDescricao());
          stmt.setInt(2, oTipoDesconto.getIdTipoDesconto());
          stmt.execute();
          conexao.commit();
          return  true;
        } catch (Exception ex){
            try{
                System.out.println("Problemas ao alterar a TipoDesconto! Erro:" +ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            }catch (SQLException e){
                System.out.println("Erro:" +e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
         int idTipoDesconto = numero;
        PreparedStatement stmt = null;
        String sql = "delete from tipoDesconto where idtipodesconto=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idTipoDesconto);
            stmt.execute();
            conexao.commit ();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao excluir TipoDesconto! erro: " + e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            }catch (SQLException ex){
                System.out.println("Problemas ao executar rollback" + ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }
    

    @Override
    public Object carregar(int numero) {
        int idTipoDesconto = numero;
        PreparedStatement stmt = null; 
        ResultSet rs = null;
        TipoDesconto oTipoDesconto = null;
        String sql = "Select * from tipoDesconto where idTipoDesconto = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idTipoDesconto);
            rs = stmt.executeQuery();
            while(rs.next()){
                oTipoDesconto = new TipoDesconto();
                oTipoDesconto.setIdTipoDesconto(rs.getInt("idTipoDesconto"));
                oTipoDesconto.setDescricao(rs.getString("descricao"));
                
                  
            }
        }catch (Exception e){
            System.out.println("Problemas ao carregar Locatario! Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return oTipoDesconto;
    }

    @Override
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<>();
        TipoDesconto oTipoDesconto = null;
        String sql = "select * from TipoDesconto Order By IdTipoDesconto";
         try{
             stmt = conexao.prepareStatement(sql);
             rs = stmt.executeQuery();
             while(rs.next()){
                oTipoDesconto = new TipoDesconto();
                oTipoDesconto.setIdTipoDesconto(rs.getInt("idTipoDesconto"));
                oTipoDesconto.setDescricao(rs.getString("descricao"));
                 
                resultado.add(oTipoDesconto);               
             }
         }catch(Exception e){
             System.out.println("Problemas ao listar TipoDesconto! Erro: " + e.getMessage());
             e.printStackTrace();
         }
          return resultado;
    }
    
    
    public String CarregarJSON(int numero){
        String strJson="";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from tipoDesconto where IDTIPODESCONTO = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, numero);
            rs = stmt.executeQuery();
            while(rs.next()){
                strJson += "{\"idTipoDesconto\":"+rs.getInt("IDTIPODESCONTO")+",\"descricao\":\""+rs.getString("DESCRICAO")+"\"}";           
            }
        }catch (Exception e){
            System.out.println("Problemas ao listar TipoDesconto! Erro:" + e.getMessage());
            e.printStackTrace();
        }
        return strJson;
    }
}
