package br.com.curso.model;

import br.com.curso.utils.Conversao;
import java.util.Date;

public class ParcelaDesconto {
    private int idParcelaDesconto;
    private int nroParcela;
    private Date dataLancamento;
    private double valorDesconto;
    private String descricao;
    private TipoDesconto idTipoDesconto;

    public ParcelaDesconto() {
        idParcelaDesconto = 0;
        nroParcela = 0;
        dataLancamento = Conversao.dataAtual();
        valorDesconto = 0;
        descricao = "";
        idTipoDesconto = new TipoDesconto();
    }

    public ParcelaDesconto(int idParcelaDesconto, int nroParcela, Date dataLancamento, double valorDesconto, String descricao, TipoDesconto idTipoDesconto) {
        this.idParcelaDesconto = idParcelaDesconto;
        this.nroParcela = nroParcela;
        this.dataLancamento = dataLancamento;
        this.valorDesconto = valorDesconto;
        this.descricao = descricao;
        this.idTipoDesconto = idTipoDesconto;
    }

    public int getIdParcelaDesconto() {
        return idParcelaDesconto;
    }

    public void setIdParcelaDesconto(int idParcelaDesconto) {
        this.idParcelaDesconto = idParcelaDesconto;
    }

    public int getNroParcela() {
        return nroParcela;
    }

    public void setNroParcela(int nroParcela) {
        this.nroParcela = nroParcela;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoDesconto getIdTipoDesconto() {
        return idTipoDesconto;
    }

    public void setIdTipoDesconto(TipoDesconto idTipoDesconto) {
        this.idTipoDesconto = idTipoDesconto;
    }

    
    
    
    
    
    
}
