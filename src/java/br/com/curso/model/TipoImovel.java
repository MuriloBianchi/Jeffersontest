package br.com.curso.model;

public class TipoImovel {
    private int idTipoImovel;
    private String descricao;

    public TipoImovel() {
        idTipoImovel = 0;
        descricao = "";
    }

    public TipoImovel(int idTipoImovel, String descricao) {
        this.idTipoImovel = idTipoImovel;
        this.descricao = descricao;
    }

    public int getIdTipoImovel() {
        return idTipoImovel;
    }

    public void setIdTipoImovel(int idTipoImovel) {
        this.idTipoImovel = idTipoImovel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
  
}
