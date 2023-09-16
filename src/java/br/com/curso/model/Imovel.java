package br.com.curso.model;

public class Imovel {
    private int idImovel;
    private String descricao;
    private String rua;
    private String numero;
    private String bairro;
    private double valorAluguel;
    private double taxaAdministracao;

    public Imovel() {
        idImovel = 0;
        descricao = "";
        rua = "";
        numero = "";
        bairro = "";
        valorAluguel = 0;
        taxaAdministracao = 0;
    }

    public Imovel(int idImovel, String descricao, String rua, String numero, String bairro, double valorAluguel, double taxaAdministracao) {
        this.idImovel = idImovel;
        this.descricao = descricao;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.valorAluguel = valorAluguel;
        this.taxaAdministracao = taxaAdministracao;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public double getTaxaAdministracao() {
        return taxaAdministracao;
    }

    public void setTaxaAdministracao(double taxaAdministracao) {
        this.taxaAdministracao = taxaAdministracao;
    }
    
    
    
    
    
    
}
