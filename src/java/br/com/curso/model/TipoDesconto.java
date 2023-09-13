package br.com.curso.model;

public class TipoDesconto {
    private int idTipoDesconto;
    private String descricao;

    public TipoDesconto() {
        idTipoDesconto = 0;
        descricao = "";
    }

    public TipoDesconto(int idTipoDesconto, String descricao) {
        this.idTipoDesconto = idTipoDesconto;
        this.descricao = descricao;
    }

    public int getIdTipoDesconto() {
        return idTipoDesconto;
    }

    public void setIdTipoDesconto(int idTipoDesconto) {
        this.idTipoDesconto = idTipoDesconto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
       
}

