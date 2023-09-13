package br.com.curso.model;

import br.com.curso.utils.Conversao;
import java.util.Date;

public class ParcelaPagar {
    private int idParcelaPagar;
    private Date dataVencimento;
    private Date dataPagamento;
    private double valorDescontos;
    private double valorPagar;
    private double valorPago;
    private double valorJurosMulta;
    private String situacao;

    public ParcelaPagar() {
       idParcelaPagar = 0;
       dataVencimento = Conversao.dataAtual();
       dataPagamento = Conversao.dataAtual();
       valorDescontos = 0;
       valorPagar = 0;
       valorPago = 0;
       valorJurosMulta = 0;
       situacao = "";
    }

    public ParcelaPagar(int idParcelaPagar, Date dataVencimento, Date dataPagamento, double valorDescontos, double valorPagar, double valorPago, double valorJurosMulta, String situacao) {
        this.idParcelaPagar = idParcelaPagar;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.valorDescontos = valorDescontos;
        this.valorPagar = valorPagar;
        this.valorPago = valorPago;
        this.valorJurosMulta = valorJurosMulta;
        this.situacao = situacao;
    }

    public int getIdParcelaPagar() {
        return idParcelaPagar;
    }

    public void setIdParcelaPagar(int idParcelaPagar) {
        this.idParcelaPagar = idParcelaPagar;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorDescontos() {
        return valorDescontos;
    }

    public void setValorDescontos(double valorDescontos) {
        this.valorDescontos = valorDescontos;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
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
