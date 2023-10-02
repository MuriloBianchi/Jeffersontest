package br.com.curso.model;

import br.com.curso.utils.Conversao;
import java.util.Calendar;
import java.util.Date;

public class ContratoLocacao {
    private int idContrato;
    private Date dataContrato;
    private Date dataInicio;
    private Date dataFinal;
    private int mesesContrato;
    private int diaRecebimento;
    private int diaPagamento;
    private double valorTotalContrato;
    private double valorRecebido;
    private double valorDescontos;
    private double valorPago;
    private double valorJurosMultaRecebido;
    private double valorJurosMultaPago;
    private double saldoContrato;
    private Imovel idImovel;
    private Locador idLocador;
    private Locatario idLocatario;
    private ParcelaDesconto idParcelaDesconto;
    

    public ContratoLocacao() {
        idContrato = 0;
        dataContrato = Conversao.dataAtual();
        dataInicio = Conversao.dataAtual();
        dataFinal = Conversao.dataAtual();
        mesesContrato = 0;
        diaRecebimento = 0;
        diaPagamento = 0;
        valorTotalContrato = 0;
        valorRecebido = 0;
        valorDescontos = 0;
        valorPago = 0;
        valorJurosMultaRecebido = 0;
        valorJurosMultaPago = 0;
        saldoContrato = 0;
        idImovel = new Imovel();
        idLocador = new Locador();
        idLocatario = new Locatario();
        idParcelaDesconto = new ParcelaDesconto();
    }

    public ContratoLocacao(int idContrato, Date dataContrato, Date dataInicio, Date dataFinal, int mesesContrato, int diaRecebimento, int diaPagamento, double valorTotalContrato, double valorRecebido, double valorDescontos, double valorPago, double valorJurosMultaRecebido, double valorJurosMultaPago, double saldoContrato, Imovel idImovel, Locador idLocador, Locatario idLocatario, ParcelaDesconto idParcelaDesconto) {
        this.idContrato = idContrato;
        this.dataContrato = dataContrato;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.mesesContrato = mesesContrato;
        this.diaRecebimento = diaRecebimento;
        this.diaPagamento = diaPagamento;
        this.valorTotalContrato = valorTotalContrato;
        this.valorRecebido = valorRecebido;
        this.valorDescontos = valorDescontos;
        this.valorPago = valorPago;
        this.valorJurosMultaRecebido = valorJurosMultaRecebido;
        this.valorJurosMultaPago = valorJurosMultaPago;
        this.saldoContrato = saldoContrato;
        this.idImovel = idImovel;
        this.idLocador = idLocador;
        this.idLocatario = idLocatario;
        this.idParcelaDesconto = idParcelaDesconto;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getMesesContrato() {
        return mesesContrato;
    }

    public void setMesesContrato(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    public int getDiaRecebimento() {
        return diaRecebimento;
    }

    public void setDiaRecebimento(int diaRecebimento) {
        this.diaRecebimento = diaRecebimento;
    }

    public int getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    public double getValorTotalContrato() {
        return valorTotalContrato;
    }

    public void setValorTotalContrato(double valorTotalContrato) {
        this.valorTotalContrato = valorTotalContrato;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public double getValorDescontos() {
        return valorDescontos;
    }

    public void setValorDescontos(double valorDescontos) {
        this.valorDescontos = valorDescontos;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorJurosMultaRecebido() {
        return valorJurosMultaRecebido;
    }

    public void setValorJurosMultaRecebido(double valorJurosMultaRecebido) {
        this.valorJurosMultaRecebido = valorJurosMultaRecebido;
    }

    public double getValorJurosMultaPago() {
        return valorJurosMultaPago;
    }

    public void setValorJurosMultaPago(double valorJurosMultaPago) {
        this.valorJurosMultaPago = valorJurosMultaPago;
    }

    public double getSaldoContrato() {
        return saldoContrato;
    }

    public void setSaldoContrato(double saldoContrato) {
        this.saldoContrato = saldoContrato;
    }

    public Imovel getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(Imovel idImovel) {
        this.idImovel = idImovel;
    }

    public Locador getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(Locador idLocador) {
        this.idLocador = idLocador;
    }

    public Locatario getIdLocatario() {
        return idLocatario;
    }

    public void setIdLocatario(Locatario idLocatario) {
        this.idLocatario = idLocatario;
    }

    public ParcelaDesconto getIdParcelaDesconto() {
        return idParcelaDesconto;
    }

    public void setIdParcelaDesconto(ParcelaDesconto idParcelaDesconto) {
        this.idParcelaDesconto = idParcelaDesconto;
    }
    

    public int GetMeses(){
        return CalculaMeses();
    }
    
    private int CalculaMeses(){
        
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.setTime(this.dataInicio);
        cal2.setTime(this.dataFinal);

        int anos = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
        int meses = cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);

        this.mesesContrato = (anos * 12) + meses;
        
        return this.mesesContrato;
    }
           
    
}
