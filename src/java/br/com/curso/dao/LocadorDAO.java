/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.Locador;
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
public class LocadorDAO implements GenericDAO{
    
       private Connection conexao;
    
    public LocadorDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }
    
    @Override
    public Boolean cadastrar(Object objeto) {
      Locador oLocador = (Locador) objeto;
      boolean retorno = false;
      if(oLocador.getIdLocador() == 0){
          retorno = inserir(oLocador);
    } else{
          retorno = alterar(oLocador);
      }
      return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
      Locador oLocador = (Locador)objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into Locador ( nome, cpfcnpj) values (?,?)";
        try{
          stmt = conexao.prepareStatement(sql);
          stmt.setString(1, oLocador.getNome());
          stmt.setString(2, oLocador.getCpfCnpj());
          stmt.execute();
          conexao.commit();
          return true;
        }catch (Exception ex){
            try{
            System.out.println("Problemas ao cadastrar a Veiculo! Erro:" + ex.getMessage());
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
       Locador oLocador = (Locador)objeto;    
        PreparedStatement stmt = null;
        String sql = "update locador set nome=?, cpfcnpj=? where idlocador=?";
        try{
          stmt = conexao.prepareStatement(sql);
          stmt.setString(1, oLocador.getNome());
          stmt.setString(2, oLocador.getCpfCnpj());
          stmt.setInt(3, oLocador.getIdLocador());
          stmt.execute();
          conexao.commit();
          return  true;
        } catch (Exception ex){
            try{
                System.out.println("Problemas ao alterar a Veiculo! Erro:" +ex.getMessage());
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
         int idLocador = numero;
        PreparedStatement stmt = null;
        String sql = "delete from locador where idlocador=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idLocador);
            stmt.execute();
            conexao.commit ();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao excluir despesa!erro: " + e.getMessage());
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
        int idLocador = numero;
        PreparedStatement stmt = null; 
        ResultSet rs = null;
        Locador oLocador = null;
        String sql = "Select * from locador where idLocador = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idLocador);
            rs = stmt.executeQuery();
            while(rs.next()){
                oLocador = new Locador();
                oLocador.setIdLocador(rs.getInt("idLocador"));
                oLocador.setNome(rs.getString("nome"));
                oLocador.setCpfCnpj(rs.getString("cpfCnpj"));
                  
            }
        }catch (Exception e){
            System.out.println("Problemas ao carregar Locador!Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return oLocador;
    }

    @Override
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<>();
        Locador oLocador = null;
        String sql = "select * from  Locador";
         try{
             stmt = conexao.prepareStatement(sql);
             rs = stmt.executeQuery();
             while(rs.next()){
                oLocador = new Locador();
                oLocador.setIdLocador(rs.getInt("idLocador"));
                oLocador.setNome(rs.getString("nome"));
                 oLocador.setCpfCnpj(rs.getString("cpfCnpj"));
                resultado.add(oLocador);               
             }
         }catch(Exception e){
             System.out.println("Porblemas ao listar locador!Erro: " + e.getMessage());
             e.printStackTrace();
         }
          return resultado;
    }
    
    
    public String listarJSON(){
        String strJson="";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<>();
        Locador Locador = null;
        String sql = "select * from locador";
        try{
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            strJson = "[";
            int i = 0;
            while(rs.next()){
                if (i>0) strJson+=",";
                strJson += "{\"idLocador\"}:"+rs.getInt("idlocador")+","
                        + "\"nome\":\""+rs.getString("nome")+"\","
                        + "\"cpfCnpj\":\""+rs.getString("cpfcnpj")+"\",";
                
                i++;             
            }
            strJson += "]";
        }catch (Exception e){
            System.out.println("Problemas ao listar locador! Erro:" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println(strJson);
        return strJson;
    }
}


