/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.Locatario;
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
public class LocatarioDAO implements GenericDAO {
       private Connection conexao;
    
    public LocatarioDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }
    
    @Override
    public Boolean cadastrar(Object objeto) {
      Locatario oLocatario = (Locatario) objeto;
      boolean retorno = false;
      if(oLocatario.getIdLocatario() == 0){
          retorno = inserir(oLocatario);
    } else{
          retorno = alterar(oLocatario);
      }
      return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
      Locatario oLocatario = (Locatario)objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into Locatario (idLocatario,nome, cpfcnpj) values (nextVal('sq_contrato'),?,?)";
        try{
          stmt = conexao.prepareStatement(sql);
          stmt.setString(1, oLocatario.getNome());
          stmt.setString(2, oLocatario.getCpfCnpj());
          stmt.execute();
          conexao.commit();
          return true;
        }catch (Exception ex){
            try{
            System.out.println("Problemas ao cadastrar a Locatario! Erro:" + ex.getMessage());
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
       Locatario oLocatario = (Locatario)objeto;    
        PreparedStatement stmt = null;
        String sql = "update locatario set nome=?, cpfcnpj=? where idlocatario=?";
        try{
          stmt = conexao.prepareStatement(sql);
          stmt.setString(1, oLocatario.getNome());
          stmt.setString(2, oLocatario.getCpfCnpj());
          stmt.setInt(3, oLocatario.getIdLocatario());
          stmt.execute();
          conexao.commit();
          return  true;
        } catch (Exception ex){
            try{
                System.out.println("Problemas ao alterar a Locatario! Erro:" +ex.getMessage());
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
         int idLocatario = numero;
        PreparedStatement stmt = null;
        String sql = "delete from locatario where idlocatario=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idLocatario);
            stmt.execute();
            conexao.commit ();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao excluir Locatario!erro: " + e.getMessage());
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
        int idLocatario = numero;
        PreparedStatement stmt = null; 
        ResultSet rs = null;
        Locatario oLocatario = null;
        String sql = "Select * from locatario where idLocatario = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idLocatario);
            rs = stmt.executeQuery();
            while(rs.next()){
                oLocatario = new Locatario();
                oLocatario.setIdLocatario(rs.getInt("idLocatario"));
                oLocatario.setNome(rs.getString("nome"));
                oLocatario.setCpfCnpj(rs.getString("cpfCnpj"));
                  
            }
        }catch (Exception e){
            System.out.println("Problemas ao carregar Locatario! Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return oLocatario;
    }

    @Override
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<>();
        Locatario oLocatario = null;
        String sql = "select * from Locatario order by idlocatario";
         try{
             stmt = conexao.prepareStatement(sql);
             rs = stmt.executeQuery();
             while(rs.next()){
                oLocatario = new Locatario();
                oLocatario.setIdLocatario(rs.getInt("idLocatario"));
                oLocatario.setNome(rs.getString("nome"));
                 oLocatario.setCpfCnpj(rs.getString("cpfCnpj"));
                resultado.add(oLocatario);               
             }
         }catch(Exception e){
             System.out.println("Porblemas ao listar Locatario! Erro: " + e.getMessage());
             e.printStackTrace();
         }
          return resultado;
    }
    
    
    public String CarregarJSON(int numero){
        String strJson="";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from locatario where IDLOCATARIO = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, numero);
            rs = stmt.executeQuery();
            while(rs.next()){
                strJson += "{\"idLocatario\":"+rs.getInt("idlocatario")+","
                        + "\"nome\":\""+rs.getString("nome")+"\","
                        + "\"cpfCnpj\":\""+rs.getString("cpfcnpj")+"\"}";           
            }
        }catch (Exception e){
            System.out.println("Problemas ao listar locatario! Erro:" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println(strJson);
        return strJson;
    }
}
