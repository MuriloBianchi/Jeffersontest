package br.com.curso.dao;

import br.com.curso.model.TipoImovel;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoImovelDAO implements GenericDAO {

    private Connection conexao;
    
    public TipoImovelDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }
    
    @Override
    public Boolean cadastrar(Object objeto) {
        TipoImovel oTipoImovel = (TipoImovel) objeto;
        boolean retorno = false;
        if(oTipoImovel.getIdTipoImovel() == 0){
            retorno = inserir(oTipoImovel);
        }else{
            retorno = alterar(oTipoImovel);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        TipoImovel oTipoImovel = (TipoImovel) objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into TIPOIMOVEL (IDTIPOIMOVEL, DESCRICAO) values (?,?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, oTipoImovel.getIdTipoImovel());
            stmt.setString(2, oTipoImovel.getDescricao());
            stmt.execute();
            conexao.commit();
            return true;
        }catch(Exception e){
            try{
                System.out.println("Problemas ao cadastrar Despesa! Erro: " + e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            }catch (SQLException ex){
                System.out.println("Problema ao executar rollback!" + ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        TipoImovel oTipoImovel = (TipoImovel) objeto;
        PreparedStatement stmt = null;
        String sql = "update TIPOIMOVEL set DESCRICAO = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oTipoImovel.getDescricao());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao cadastrar TipoImovel! Erro: " + e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            }catch (SQLException ex){
                System.out.println("Problemas as executar rollback! " + ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idTipoImovel = numero;
        PreparedStatement stmt = null;
        String sql = "delete from TIPOIMOVEL where IDTIPOIMOVEL = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idTipoImovel);
            stmt.execute();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao excluir Tipo Imovel! Erro: " + e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            }catch (SQLException ex){
                System.out.println("Problemas ao executar rollback!" + ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
            
    }

    @Override
    public Object carregar(int numero) {
        int idTipoImovel = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TipoImovel oTipoImovel = null;
        String sql = "Select IDTIPOIMOVEL, DESCRICAO from TIPOIMOVEL where IDTIPOIMOVEL = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idTipoImovel);
            rs = stmt.executeQuery();
            while(rs.next()){
                oTipoImovel = new TipoImovel();
                oTipoImovel.setIdTipoImovel(rs.getInt("IDTIPOIMOVEL"));
                oTipoImovel.setDescricao(rs.getString("DESCRICAO"));
            }
        }catch (Exception e){
            System.out.println("Problemas ao Carregar Tipo Imovel! Erro:" + e.getMessage());
            e.printStackTrace();
        }
        return oTipoImovel;
    }

    @Override
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<>();
        TipoImovel oTipoImovel = null;
        String sql = "Select IDTIPOIMOVEL, DESCRICAO from TIPOIMOVEL";
        try{
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                oTipoImovel = new TipoImovel();
                oTipoImovel.setIdTipoImovel(rs.getInt("IDTIPOIMOVEL"));
                oTipoImovel.setDescricao(rs.getString("DESCRICAO"));
                resultado.add(oTipoImovel);
            }
        }catch (Exception e){
            System.out.println("Problemas ao Listar Tipo Imovel! Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return resultado;     
    }
    
    public String carregarJson(int numero) {
        int idTipoImovel = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String strJson = "";
        int i = 0;
        String sql = "Select IDTIPOIMOVEL, DESCRICAO from TIPOIMOVEL where IDTIPOIMOVEL = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idTipoImovel);
            rs = stmt.executeQuery();
            while(rs.next()){
                if (i>0) strJson+=",";
                strJson+= "{\"idTipoImovel\":" + rs.getInt("IDTIPOIMOVEL") + ", \"descricao\":\"" + rs.getString("DESCRICAO") + "\"}";
                i++;
            }
             
        }catch (Exception e){
            System.out.println("Problemas ao Carregar Tipo Imovel! Erro:" + e.getMessage());
            e.printStackTrace();
        }
        return strJson;
    }

    
}
