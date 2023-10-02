package br.com.curso.model;

public class Locador {
    private int idLocador;
    private String nome;
    private String cpfCnpj;

    public Locador() {
        idLocador = 0;
        nome = "";
        cpfCnpj = "";
    }

    public Locador(int idLocador, String nome, String cpfCnpj) {
        this.idLocador = idLocador;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
    }

    public Locador(int idLocador) {
        this.idLocador = idLocador;
    }

    public int getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(int idLocador) {
        this.idLocador = idLocador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    
    
    
    
}
