/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.Imovel;
import br.com.curso.model.Locador;
import br.com.curso.model.TipoImovel;
import static br.com.curso.utils.Conversao.valorDinheiro;
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
public class ImovelDAO implements GenericDAO {
    
       private Connection conexao;
    
    public ImovelDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }
    @Override
    public Boolean cadastrar(Object objeto) {
        Imovel oImovel = (Imovel)objeto;
        boolean retorno=false;
        if(oImovel.getIdImovel()==0){
            retorno = this.inserir(oImovel);
        }else{
            retorno = this.alterar(oImovel);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Imovel oImovel = (Imovel)objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into imovel (idimovel ,descricao ,rua, numero, bairro, valoraluguel, taxaadministracao, idtipoimovel, idlocador) values ( nextVal('imovel_idimovel'),?,?,?,?,?,?,?,?)";
        try{
          stmt = conexao.prepareStatement(sql);
          
          stmt.setString(1, oImovel.getDescricao());
          stmt.setString(2, oImovel.getRua());
          stmt.setString(3, oImovel.getNumero());
          stmt.setString(4, oImovel.getBairro());
          stmt.setDouble(5, oImovel.getValorAluguel());
          stmt.setDouble(6, oImovel.getTaxaAdministracao());
          stmt.setInt(7, oImovel.getTipoImovel().getIdTipoImovel());
          stmt.setInt(8, oImovel.getLocador().getIdLocador());
          stmt.execute();
          conexao.commit();
          return true;
        }catch (Exception ex){
            try{
            System.out.println("Problemas ao cadastrar a Imovel! Erro:" + ex.getMessage());
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
        Imovel oImovel = (Imovel)objeto;
        PreparedStatement stmt = null;
        String sql = "update imovel set descricao=?,rua=?,numero=?,bairro=?,valoraluguel=?,taxaadministracao=?,idtipoimovel=?,idlocador=? where idimovel =?";
        try{
          stmt = conexao.prepareStatement(sql);
          stmt.setString(1, oImovel.getDescricao());
          stmt.setString(2, oImovel.getRua());
          stmt.setString(3, oImovel.getNumero());
          stmt.setString(4, oImovel.getBairro());
          stmt.setDouble(5, oImovel.getValorAluguel());
          stmt.setDouble(6, oImovel.getTaxaAdministracao());
          stmt.setInt(7, oImovel.getTipoImovel().getIdTipoImovel());
          stmt.setInt(8, oImovel.getLocador().getIdLocador());
          stmt.setInt(9, oImovel.getIdImovel());
          stmt.execute();
          conexao.commit();
          return  true;
        } catch (Exception ex){
            try{
                System.out.println("Problemas ao alterar a Imovel! Erro:" +ex.getMessage());
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
        int idImovel = numero;
        PreparedStatement stmt = null;
        
        String sql = "delete from imovel where idimovel=?";
        try{
            stmt=conexao.prepareStatement(sql);
            stmt.setInt(1, idImovel);
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            System.out.println("Problemas ao excluir a Imovel! Erro:" +ex.getMessage());
            try{
                conexao.rollback();
            }catch (Exception e){
                System.out.println("Erro rolback"+ e.getMessage());
                e.printStackTrace();
            }
            return  false;
        }
    }

    @Override
    public Object carregar(int numero) {
         int idImovel = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Imovel oImovel = null;
        String sql = "select * from imovel where idimovel=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idImovel);
            rs=stmt.executeQuery();
            while (rs.next()){
                oImovel = new Imovel();
                oImovel.setIdImovel(rs.getInt("idImovel"));
                oImovel.setDescricao(rs.getString("descricao"));
                oImovel.setRua(rs.getString("rua"));
                oImovel.setNumero(rs.getString("numero"));
                oImovel.setBairro(rs.getString("bairro"));
                oImovel.setValorAluguel(rs.getDouble("valoraluguel"));
                oImovel.setTaxaAdministracao(rs.getDouble("taxaadministracao"));
                
                TipoImovelDAO oTipoImovelDAO = new TipoImovelDAO();
                oImovel.setTipoImovel((TipoImovel) oTipoImovelDAO.carregar(rs.getInt("idtipoimovel")));
                
                LocadorDAO oLocadorDAO = new LocadorDAO();
                oImovel.setLocador((Locador) oLocadorDAO.carregar(rs.getInt("idlocador")));
            }
            return oImovel;
        }catch (Exception ex) {
            System.out.println("Problemas ao carregar Imovel! Erro:"+ex.getMessage());
            return false;
        }
    } 
    
    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from imovel order by idimovel";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Imovel oImovel = new Imovel();
                oImovel.setIdImovel(rs.getInt("idImovel"));
                oImovel.setDescricao(rs.getString("descricao"));
                oImovel.setRua(rs.getString("rua"));
                oImovel.setNumero(rs.getString("numero"));
                oImovel.setBairro(rs.getString("bairro"));
                oImovel.setValorAluguel(rs.getDouble("valorAluguel"));
                oImovel.setTaxaAdministracao(rs.getDouble("taxaAdministracao"));
                
                TipoImovelDAO oTipoImovelDAO = null;
                try{
                    oTipoImovelDAO = new TipoImovelDAO();
                }catch(Exception ex){
                    System.out.println("Erro ao buscar Tipo Imovel " + ex.getMessage());
                    ex.printStackTrace();
                }
                 oImovel.setTipoImovel((TipoImovel) oTipoImovelDAO.carregar(rs.getInt("idTipoImovel")));
                 
                 LocadorDAO oLocadorDAO = null;
                try{
                    oLocadorDAO = new LocadorDAO();
                }catch(Exception ex){
                    System.out.println("Erro ao buscar Locador " + ex.getMessage());
                    ex.printStackTrace();
                }
                 oImovel.setLocador((Locador) oLocadorDAO.carregar(rs.getInt("idLocador")));
                 resultado.add(oImovel);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar imóveis! Erro: " + ex.getMessage());
        } 
        return resultado;
       
    }
    
    public String carregarJson(int numero) {
        int idImovel = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String strJson = "";
        String sql = "Select * from imovel where IDIMOVEL = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idImovel);
            rs = stmt.executeQuery();
            while(rs.next()){
                strJson += "{\"idImovel\":"+rs.getInt("idimovel")+","
                        + "\"descricao\":\""+rs.getString("descricao")+"\","
                        + "\"rua\":\""+rs.getString("rua")+"\","
                        + "\"numero\":\""+rs.getInt("numero")+"\","
                        + "\"bairro\":\""+rs.getString("bairro")+"\","
                        + "\"valorAluguel\":\""+rs.getInt("valoraluguel")+"\","
                        + "\"taxaAdministracao\":\""+rs.getInt("taxaadministracao")+"\","
                        + "\"idTipoImovel\":\""+rs.getInt("idtipoImovel")+"\","
                        + "\"idLocador\":\""+rs.getInt("idlocador")+"\"}";           
            }
             
        }catch (Exception e){
            System.out.println("Problemas ao Carregar Tipo Imovel! Erro:" + e.getMessage());
            e.printStackTrace();
        }
        return strJson;
    }
    
    public Imovel  GetInfoImovel(int idImovel){
        Imovel oImovel = new Imovel();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String sql = "Select valorAluguel, TaxaAdministracao from Imovel where idImovel  = ?";
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idImovel);
            rs = stmt.executeQuery();
            while (rs.next()){
                oImovel.setValorAluguel(rs.getDouble("VALORALUGUEL"));
                oImovel.setTaxaAdministracao(rs.getDouble("TAXAADMINISTRACAO"));
            }
        }catch(Exception ex){
            System.out.println("Problemas ao Carregar informacoes! Erro: " + ex.getMessage());
                    ex.printStackTrace();
        }
        
        return oImovel;
    }
}  
