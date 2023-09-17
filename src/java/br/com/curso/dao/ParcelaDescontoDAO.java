
package br.com.curso.dao;

import br.com.curso.model.ParcelaDesconto;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParcelaDescontoDAO implements GenericDAO {

     private Connection conexao;
     
     public ParcelaDescontoDAO() throws Exception{
         conexao = SingleConnection.getConnection();
     }
             
    @Override
    public Boolean cadastrar(Object objeto) {
        ParcelaDesconto oParcelaDesconto = (ParcelaDesconto) objeto;
        boolean retorno = false;
        if(oParcelaDesconto.getIdParcelaDesconto()== 0){
            retorno = inserir(oParcelaDesconto);
        }else{
            retorno = alterar(oParcelaDesconto);
        }
           return retorno;  
    }

    @Override
    public Boolean inserir(Object objeto) {
        ParcelaDesconto oParcelaDesconto = (ParcelaDesconto) objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into PARCELADESCONTO (NROPARCELA, DATALANCAMENTO, VALORDESCONTO, DESCRICAO) values (?,?,?,?)";
        try{
            stmt = conexao.prepareCall(sql);
            stmt.setInt(1, oParcelaDesconto.getNroParcela());
            stmt.setDate(2, new java.sql.Date(oParcelaDesconto.getDataLancamento().getTime()));
            stmt.setDouble(3, oParcelaDesconto.getValorDesconto());
            stmt.setString(4, oParcelaDesconto.getDescricao());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao inserir Parcela Desconto! Erro: " + e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            }catch (SQLException ex){
                System.out.println("Problemas em dar rollback! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        ParcelaDesconto oParcelaDesconto = (ParcelaDesconto) objeto;
        PreparedStatement stmt = null;
        String sql = "Update PARCELADESCONTO set NROPARCELA = ?, DATALANCAMENTO = ?, VALORDESCONTO = ?, DESCRICAO = ? where IDPARCELADESCONTO = ?";
        try{
            stmt = conexao.prepareCall(sql);
            stmt.setInt(1, oParcelaDesconto.getNroParcela());
            stmt.setDate(2, new java.sql.Date(oParcelaDesconto.getDataLancamento().getTime()));
            stmt.setDouble(3, oParcelaDesconto.getValorDesconto());
            stmt.setString(4, oParcelaDesconto.getDescricao());
            stmt.setInt(5, oParcelaDesconto.getIdParcelaDesconto());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao alterar Parcela Desconto! Erro: " + e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            }catch (SQLException ex){
                System.out.println("Problemas em dar rollback! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idParcelaDesconto = numero;
        PreparedStatement stmt = null;
        String sql = "Delete from PARCELADESCONTO where IDPARCELADESCONTO = ?";
         try{
            stmt = conexao.prepareCall(sql);
            stmt.setInt(1, idParcelaDesconto);
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao excluir Parcela Desconto! Erro: " + e.getMessage());
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
        int idParcelaDesconto = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ParcelaDesconto oParcelaDesconto = null;
        String sql = "Select DATALANCAMENTO, VALORDESCONTO, NROPARCELA, DESCRICAO from PARCELADESCONTO where IDPARCELADESCONTO = ?";
        try{
            stmt = conexao.prepareCall(sql);
            stmt.setInt(1, idParcelaDesconto);
            rs = stmt.executeQuery();
            while(rs.next()){
                oParcelaDesconto = new ParcelaDesconto();
                oParcelaDesconto.setDataLancamento(rs.getDate("DATALANCAMENTO"));
                oParcelaDesconto.setValorDesconto(rs.getDouble("VALORDESCONTO"));
                oParcelaDesconto.setNroParcela(rs.getInt("NROPARCELA"));
                oParcelaDesconto.setDescricao(rs.getString("DESCRICAO"));
            }
        }catch (Exception e){
            System.out.println("Problemas ao carregar Parceal Desconto! Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return oParcelaDesconto;
    }

    @Override
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<>();
        ParcelaDesconto oParcelaDesconto = null;
        String sql = "Select IDPARCELADESCONTO, DATALANCAMENTO, VALORDESCONTO, NROPARCELA, DESCRICAO from PARCELADESCONTO";
        try{
            stmt = conexao.prepareCall(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                oParcelaDesconto = new ParcelaDesconto();
                oParcelaDesconto.setIdParcelaDesconto(rs.getInt("IDPARCELADESCONTO"));
                oParcelaDesconto.setDataLancamento(rs.getDate("DATALANCAMENTO"));
                oParcelaDesconto.setValorDesconto(rs.getDouble("VALORDESCONTO"));
                oParcelaDesconto.setNroParcela(rs.getInt("NROPARCELA"));
                oParcelaDesconto.setDescricao(rs.getString("DESCRICAO"));
            }
        }catch (Exception e){
            System.out.println("Problemas ao carregar Parceal Desconto! Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return resultado;
    }   
}
