package br.com.curso.model;

import br.com.curso.utils.Conversao;
import java.util.Date;

public class ParcelaReceber {
    private int nroParcela;
    private Date dataVencimento;
    private Date dataRecebimento;
    private double valorParcela;
    private double valorRecebido;
    private double valorJurosMulta;
    private String situacao;

    public ParcelaReceber() {
        nroParcela = 0;
        dataVencimento = Conversao.dataAtual();
        dataRecebimento = Conversao.dataAtual();
        valorParcela = 0;
        valorRecebido = 0;
        valorJurosMulta = 0;
        situacao = "";
    }

    public ParcelaReceber(int nroParcela, Date dataVencimento, Date dataRecebimento, double valorParcela, double valorRecebido, double valorJurosMulta, String situacao) {
        this.nroParcela = nroParcela;
        this.dataVencimento = dataVencimento;
        this.dataRecebimento = dataRecebimento;
        this.valorParcela = valorParcela;
        this.valorRecebido = valorRecebido;
        this.valorJurosMulta = valorJurosMulta;
        this.situacao = situacao;
    }

    public int getNroParcela() {
        return nroParcela;
    }

    public void setNroParcela(int nroParcela) {
        this.nroParcela = nroParcela;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public double getValorJurosMulta() {
        return valorJurosMulta;
    }

    public void setValorJurosMulta(double valorJurosMulta) {
        this.valorJurosMulta = valorJurosMulta;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
    
}
