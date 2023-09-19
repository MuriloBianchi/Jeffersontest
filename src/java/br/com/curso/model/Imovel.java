/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

/**
 *
 * @author kelvi
 */
public class Imovel {
    
    private int idImovel;
    private String descricao;
    private String rua;
    private String numero;
    private String bairro;
    private double valorAluguel;
    private  double taxaAdministracao;
    private TipoImovel tipoImovel;
    private Locador locador;

    public Imovel() {
        this.idImovel=0;
        this.descricao="";
        this.rua="";
        this.numero="";
        this.bairro="";
        this.valorAluguel=0;
        this.taxaAdministracao=0;
        this.tipoImovel = new TipoImovel();
        this.locador = new Locador();
    }

    public Imovel(int idImovel, String descricao, String rua, String numero, String bairro, double valorAluguel, double taxaAdministracao, TipoImovel tipoImovel, Locador locador) {
        this.idImovel = idImovel;
        this.descricao = descricao;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.valorAluguel = valorAluguel;
        this.taxaAdministracao = taxaAdministracao;
        this.tipoImovel = tipoImovel;
        this.locador = locador;
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

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }
    
    
}
